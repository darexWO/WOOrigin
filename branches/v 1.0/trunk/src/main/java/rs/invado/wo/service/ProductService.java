package rs.invado.wo.service;


import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.invado.wo.dao.ocp.OcpProizvodHome;
import rs.invado.wo.dao.ocp.OcpVrAtrProizvodHome;
import rs.invado.wo.dao.prod.ProdPpRabatStavkaHome;
import rs.invado.wo.dao.wo.WoArtikliNaAkcijiHome;
import rs.invado.wo.domain.ocp.OcpKlasifikacijaProizvoda;
import rs.invado.wo.domain.ocp.OcpProizvod;
import rs.invado.wo.domain.ocp.OcpVrAtrProizvod;
import rs.invado.wo.domain.prod.ProdPpRabatStavka;
import rs.invado.wo.domain.uz.UzStanjeZalihaSkladista;
import rs.invado.wo.domain.wo.WoArtikliNaAkciji;
import rs.invado.wo.domain.wo.WoParametri;
import rs.invado.wo.domain.wo.WoPartnerSetting;
import rs.invado.wo.dto.CompanySetting;
import rs.invado.wo.dto.Proizvodi;
import rs.invado.wo.util.WoConfigSingleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
@Transactional
public class ProductService {

    @Autowired
    private OcpProizvodHome ocpProizvodHome;
    @Autowired
    private OcpVrAtrProizvodHome ocpVrAtrProizvodHome;
    @Autowired
    private WoArtikliNaAkcijiHome woArtikliNaAkcijiHome;
    @Autowired
    private ProdPpRabatStavkaHome prodPpRabatStavkaHome;


    /* za sada imamo četiri različita tipa akcije prodaje proizvoda i to:
       AKCIJA
       RASPRODAJA
       NOVO
       AKTUELNO
      za svaku vrstu akcije postoji konstanta u servis klasi koja se proselđuje u skladu
      sa odabranom akcijom na stranici. Za sve vrste akcije se pozva jedna metoda ali se
      svaki put prenosi različita vrenost za konkretnu akciju.
    */

    public final static String PROIZVODI_NA_AKCIJI = "AKCIJA";
    public final static String PROIZVODI_NA_RASPRODAJI = "RASPRODAJA";
    public final static String PROIZVODI_NOVO = "NOVO";
    public final static String PROIZVODI_AKTUELNO = "AKTUELNO";
    public final static String PROIZVOD_DEKOR_MESECA = "DEKOR_MESECA";
    public final static String IZDVOJENA_AKCIJA = "IZDVOJENA_AKCIJA";
    public final static String NAJPRODAVANIJE = "NAJPRODAVANIJE";
    /*
    public class OcpCenaComparator implements Comparator<OcpProizvod> {

        @Override
        public int compare(OcpProizvod o1, OcpProizvod o2) {
            BigDecimal datarate1 = o1.getCena();
            BigDecimal datarate2 = o2.getCena();
            return datarate1.compareTo(datarate2);
        }
    }


    public void sortProizvodiByPrice(Proizvodi proizvodi){
        List<OcpProizvod> ocpProizvodList = new ArrayList<OcpProizvod>();
        for (OcpProizvod proizvod : proizvodi.getProizvodList()) {
            if (proizvod.getCena() != null) {
                ocpProizvodList.add(proizvod);
            }
        }
        proizvodi.setProizvodList(ocpProizvodList);
        OcpCenaComparator ocpCenaComparator = new OcpCenaComparator();
        Collections.sort(proizvodi.getProizvodList(), ocpCenaComparator);
    }  */
    // setovanje cena za listu proizvoda po bilo kom osnovu
    public void setTransAtrZaPro(List<OcpProizvod> lp, Map<Integer, BigDecimal> mapaCena, List<WoPartnerSetting> woPartnerSetting,
                                 Map<Integer, BigDecimal> transortnaPakovanjaProizvoda, WoParametri woParametri) {
        //Izvuci količinu po pakovanju

        Map<Integer, BigDecimal> m = mapaCena;
        List<WoArtikliNaAkciji> laa = woArtikliNaAkcijiHome.findArtikliNaAkcijiAktivno(DateUtils.truncate(new Date(), Calendar.DATE),
                woParametri);
        Map<Integer, String> laaMap = new HashMap<Integer, String>();
        for (WoArtikliNaAkciji o : laa) {
            laaMap.put((Integer) o.getOcpProizvod().getProizvod(), (String) o.getTipAkcije());
        }
        int i = 0;
        int obradjenoSkl = 0;
        for (OcpProizvod item : lp) {
            obradjenoSkl = 0;
            //Setuj porez
            item.setStopaPoreza(ocpProizvodHome.findStopaPorezaZaProizvod(woPartnerSetting.get(0).getOrganizacionaJedinica(), item.getProizvod()));
            //Setuj default pakovanja
            if (transortnaPakovanjaProizvoda != null)
                item.setKolicinaPoPakovanju(transortnaPakovanjaProizvoda.get(item.getProizvod()));
            //izračunaj raspolozivu kolicinu
            BigDecimal raspolozivaKolicina = new BigDecimal(0.0);
            for (WoPartnerSetting wps : woPartnerSetting)
                for (UzStanjeZalihaSkladista uzskl : item.getUzStanjeZalihaSkladistas()) {
                    if (uzskl.getId().getIdSkladista() == wps.getIdSkladista() &&
                            wps.getIdSkladista() != obradjenoSkl &&
                            uzskl.getKolicinaPoStanjuZ().compareTo(new BigDecimal(0.0)) == 1) {
                        raspolozivaKolicina = raspolozivaKolicina.add(uzskl.getKolicinaPoStanjuZ().subtract(uzskl.getRezervisanaKol()));
                        item.setMaticnoSkladiste(uzskl.getId().getIdSkladista());
                        obradjenoSkl = wps.getIdSkladista();
                    }

                }
            if (item.getKolicinaPoPakovanju() == null)
                item.setKolicinaPoPakovanju(new BigDecimal(1.0));
            item.setKolUAltJM(raspolozivaKolicina.divide(item.getKolicinaPoPakovanju(), 0, RoundingMode.FLOOR).intValue());
            item.setRaspolozivo(raspolozivaKolicina);
            // setuj cene

            item.setCena((BigDecimal) mapaCena.get(item.getProizvod()));

            //setuj atribute
            String dezenIStruktura = "";
            String vrAtr = null;
            for (OcpKlasifikacijaProizvoda klasifikacijaProizvoda : item.getOcpKlasifikacijaProizvoda()) {
                //parametrizuj da čita samo atribute za klasifiakciju 1
                if (klasifikacijaProizvoda.getId().getVrstaKlasifikacije() == 1) {
                    OcpVrAtrProizvod vatp = ocpVrAtrProizvodHome.findByNivoAtributa(klasifikacijaProizvoda.getId().getVrstaKlasifikacije(),
                            klasifikacijaProizvoda.getId().getKlasifikacija(), klasifikacijaProizvoda.getId().getProizvod(),
                            Integer.valueOf(WoConfigSingleton.getInstance().getAtributs()[0]));
                    if (vatp != null) dezenIStruktura = dezenIStruktura + " " + vatp.getVrednost();
                    vatp = null;
                    vatp = ocpVrAtrProizvodHome.findByNivoAtributa(klasifikacijaProizvoda.getId().getVrstaKlasifikacije(),
                            klasifikacijaProizvoda.getId().getKlasifikacija(), klasifikacijaProizvoda.getId().getProizvod(),
                            Integer.valueOf(WoConfigSingleton.getInstance().getAtributs()[1]));
                    if (vatp != null) dezenIStruktura = dezenIStruktura + " " + vatp.getVrednost();
                    vatp = null;
                    vatp = ocpVrAtrProizvodHome.findByNivoAtributa(klasifikacijaProizvoda.getId().getVrstaKlasifikacije(),
                            klasifikacijaProizvoda.getId().getKlasifikacija(), klasifikacijaProizvoda.getId().getProizvod(),
                            Integer.valueOf(WoConfigSingleton.getInstance().getAtributs()[2]));
                    if (vatp != null) item.setProizvodjac(vatp.getVrednost());
                    item.setDezenIstruktira(dezenIStruktura);
                }
            }
            //setuj tip akcije
            if (laaMap.containsKey(item.getProizvod())) {
                item.setTipAkcije(laaMap.get(item.getProizvod()).toString());

            }
        }

    }

    /*
    public Proizvodi getProizvodiZaBrend(String brendId, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize,
                                         WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting,
                                         Map<Integer, BigDecimal> transortnaPakovanjaProizvoda, CompanySetting cs,Integer oj) {

        Proizvodi proizvodi = ocpProizvodHome.findProizvodiZaBrendSorted(brendId, pageNo, pageSize, woParametri, woPartnerSetting, cs);
        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return proizvodi;
    }  */

    public Proizvodi getProizvodiZaBrendSorted(String brendId, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize,
                                               WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting,
                                               Map<Integer, BigDecimal> transortnaPakovanjaProizvoda, CompanySetting cs,Integer oj) {

        Proizvodi proizvodi = ocpProizvodHome.findProizvodiZaBrendSorted(brendId, pageNo, pageSize, woParametri, woPartnerSetting, cs);
        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return proizvodi;
    }

    public Proizvodi getProzivodiNaAkciji(String vrstaAkcije, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize
            , WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        Proizvodi proizvodi = ocpProizvodHome.findProizvodiNaAkciji(vrstaAkcije, pageNo, pageSize, woParametri, woPartnerSetting);
        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return proizvodi;
    }

    public Proizvodi getProzivodiNaAkcijiSorted(String vrstaAkcije, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize
            , WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        Proizvodi proizvodi = ocpProizvodHome.findProizvodiNaAkcijiSorted(vrstaAkcije, pageNo, pageSize, woParametri, woPartnerSetting);
        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);
        return proizvodi;
    }
    public Proizvodi getProizvoByName(String namePattern, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize
            , WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        Proizvodi proizvodi = ocpProizvodHome.findProizvodiByName(namePattern, pageNo, pageSize
                , woParametri, woPartnerSetting);

        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return proizvodi;
    }



    public Proizvodi getFilterProizvodi(String brand, String namePattern, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize
            , WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        Proizvodi proizvodi = ocpProizvodHome.findFilterProizvodi(brand, namePattern, pageNo, pageSize
                , woParametri, woPartnerSetting);
        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return proizvodi;
    }

    public Proizvodi getFilterProizvodiSorted(String brand, String namePattern, Map<Integer, BigDecimal> cenovnik, int pageNo, int pageSize
            , WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        Proizvodi proizvodi = ocpProizvodHome.findFilterProizvodiByNamePatternsSorted(brand, getTokens(namePattern), pageNo, pageSize
                , woParametri, woPartnerSetting);
        setTransAtrZaPro(proizvodi.getProizvodList(), cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return proizvodi;
    }
    public OcpProizvod getProizvodById(int id, Map<Integer, BigDecimal> cenovnik, WoParametri woParametri,
                                       List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        OcpProizvod proizvod = ocpProizvodHome.findById(id);
        List<OcpProizvod> lp = new ArrayList<OcpProizvod>(0);
        lp.add(proizvod);
        setTransAtrZaPro(lp, cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);
        return lp.get(0);
    }

    public ProdPpRabatStavka getRabatZaProizvod(Integer proizvodId, int poslovniPartnerId, int oj) {
        List<ProdPpRabatStavka> listaRabata = (List<ProdPpRabatStavka>) prodPpRabatStavkaHome.findRabatZaProizvod(proizvodId, poslovniPartnerId, oj);
        if (listaRabata.size() != 0)
            return listaRabata.get(0);
        ProdPpRabatStavka prodPpRabatStavka = new ProdPpRabatStavka();
        prodPpRabatStavka.setRabat(new BigDecimal(0));
        return prodPpRabatStavka;
    }

    /*
    public List<OcpProizvod> findProizvodiByName(String namePattern) {
        return ocpProizvodHome.findProizvodiByName(namePattern);
    } */


    public List<OcpProizvod> getProizvoByNameSorted(String namePattern, Map<Integer, BigDecimal> cenovnik
            , WoParametri woParametri, List<WoPartnerSetting> woPartnerSetting, Map<Integer, BigDecimal> transortnaPakovanjaProizvoda) {
        List<OcpProizvod> lp = ocpProizvodHome.findProizvodiByNameSorted(namePattern, woParametri, woPartnerSetting);

        //setTransAtrZaPro(lp, cenovnik, woPartnerSetting, transortnaPakovanjaProizvoda, woParametri);

        return lp;
    }


    /*
    public List<OcpProizvod> findProizvodiByName(String namePattern, List<WoPartnerSetting> woPartnerSetting) {
        return ocpProizvodHome.findProizvodiByName(namePattern, woPartnerSetting);
    }

    public List<OcpProizvod> getProizvodiByNameAndByBrend(String namePattern, String brendId, WoParametri woParametri) {
        return ocpProizvodHome.findProizvodiByNameAndByBrand(namePattern, brendId, woParametri);
    } */

    public List<OcpProizvod> getProizvodiByNameAndByBrend(String namePattern, String brendId, WoParametri woParametri,
                                                          List<WoPartnerSetting> woPartnerSettings) {
        return ocpProizvodHome.findProizvodiByNamePatternAndByBrand(getTokens(namePattern), brendId, woParametri, woPartnerSettings);
    }

    private List<String> getTokens(String namePattern) {
        List<String> searchTokens = new ArrayList<String>();
        String[] tokens = namePattern.trim().split("\\s+");
        for (String token : tokens) {
            /*String res = "";
            for (char ch : token.toCharArray()) res += "%" + ch;
            res += "%";
            searchTokens.add(res);*/
            searchTokens.add(token);
            System.out.println("token="+token);
        }
        return searchTokens;
    }
}
