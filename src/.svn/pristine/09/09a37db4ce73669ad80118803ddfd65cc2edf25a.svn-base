package rs.invado.wo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import rs.invado.wo.dao.ocp.OcpProizvodHome;
import rs.invado.wo.dao.prod.ProdCenovnikHome;
import rs.invado.wo.dao.prod.ProdNacinPlacanjaHome;
import rs.invado.wo.dao.wo.WoParametriHome;
import rs.invado.wo.dao.wo.WoRezervacijaHome;
import rs.invado.wo.dao.wo.WoSetPoNacinPlacanjaHome;
import rs.invado.wo.domain.ocp.OcpProizvod;
import rs.invado.wo.domain.prod.ProdNacinPlacanja;
import rs.invado.wo.domain.wo.WoParametri;
import rs.invado.wo.domain.wo.WoPartnerSetting;
import rs.invado.wo.domain.wo.WoRezervacija;
import rs.invado.wo.domain.wo.WoSetPoNacinPlacanja;
import rs.invado.wo.dto.CompanySetting;
import rs.invado.wo.dto.User;
import rs.invado.wo.service.AppInitService;
import rs.invado.wo.service.LogOnService;
import rs.invado.wo.service.ProductService;
import rs.invado.wo.util.WOException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.fail;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml",
        "classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class OcpProizvodHomeTest {

    @Autowired
    private OcpProizvodHome ocpProizvodDAO;
    @Autowired
    private ProdCenovnikHome prodCenovnikDAO;
    @Autowired
    private ProductService ps;
    @Autowired
    private LogOnService logOnService;
    @Autowired
    private AppInitService appInitService;
    @Autowired
    private WoRezervacijaHome woRezervacijaDAO;
    @Autowired
    private ProdNacinPlacanjaHome prodNacinPlacanjaDAO;
    @Autowired
    private WoParametriHome woParametriDAO;
    @Autowired
    private WoSetPoNacinPlacanjaHome woSetPoNacinPlacanjaDao;

    /*@PersistenceContext
    private EntityManager entityManager;    */

    @Test
    public void test() {
        fail("Not yet implemented");
    }


    @Test
    public void findPoBrandHashCena() {
        WoPartnerSetting wpsc = new WoPartnerSetting();
        wpsc.setIdCenovnik(18);
        wpsc.setIdKlasaCene(18);
        wpsc.setOrganizacionaJedinica(19);
        Map<Integer, BigDecimal> m = prodCenovnikDAO.findCeneMapped(wpsc);
        int i = 0;
        // Proizvodi p = ocpProizvodDAO.findProizvodiZaBrend("0101", m, 0, 10);
        //List<OcpProizvod> p = ocpProizvodDAO.findProizvodiByName("iverica opleme", m, 0, 200);
        //List<OcpProizvod> p = ocpProizvodDAO.findProizvodiNaAkciji("AKCIJA", m);
        /* for (OcpProizvod item : p.getProizvodList()) {
        System.out.println(item.getProizvod() + " Proizvod " + item.getNazivProizvoda() + item.getDodatniNaziv() + " " + item.getCena()
                + " tipa " + item.getTipAkcije() + " " + item.getDezenIstruktira() + " " + item.getProizvodjac());
        /*for (OcpVrAtrProizvod vra : item.getVrAtrProizvod())
      System.out.println(vra.getId().getAtribut() +" "+vra.getVrednost());*/
    }


    @Test
    public void testProductService() {
        Integer oj = new Integer(19);
        CompanySetting cs = appInitService.initApp();
        try {
            User user = logOnService.logOn("nikola", "nikolab", cs, oj);


            Map<Integer, BigDecimal> m = prodCenovnikDAO.findCeneMapped(user.getWoPartnerSetting().get(0));
            //Proizvodi proizvodi = ps.getProizvodiZaBrend("0101", m, 0, 10) ;
            //Proizvodi proizvodi = ps.getProzivodiNaAkciji("AKTUELNO", m, 0, 100);
            /*Proizvodi proizvodi = ps.getProizvodiZaBrend("0101", m, 0, 50, (WoParametri)cs.getKompanijskiParametri().get(oj),
           user.getWoPartnerSetting(), cs.getTrasportnaPakovanja());*/
            //List<String> proizvodi = ps.findProizvodByFullName("iverica");

            /*Proizvodi proizvodi = ps.getFilterProizvodi("0101", "iverica", m, 0, 1000, cs.getKompanijskiParametri().get(oj),
          user.getWoPartnerSetting(), cs.getTrasportnaPakovanja()); */
            /*Proizvodi proizvodi = ps.getProzivodiNaAkciji("IZDVOJENA_AKCIJA", m, 0, 50, cs.getKompanijskiParametri().get(oj),
           user.getWoPartnerSetting(), cs.getTrasportnaPakovanja());*/
            OcpProizvod ocpProizvod = ps.getProizvodById(29645, m, cs.getKompanijskiParametri().get(oj), user.getWoPartnerSetting(),
                    cs.getTrasportnaPakovanja());
            BigDecimal narucenaKolicina = new BigDecimal("10");
            BigDecimal cena = new BigDecimal("0.357");
            BigDecimal id = new BigDecimal(323942);
            WoRezervacija woRezervacija = new WoRezervacija();
            woRezervacija.setId(id);
            /*woRezervacija.setAkcija("");
       if (ocpProizvod.getTipAkcije() != null && ocpProizvod.getTipAkcije().equals(ProductService.PROIZVODI_NA_AKCIJI))
           woRezervacija.setAkcija("D");
       woRezervacija.setCena(cena);
       woRezervacija.setDatumivreme(Calendar.getInstance().getTime());
       woRezervacija.setIdjedinicemere(ocpProizvod.getJedinicaMere().getIdJediniceMere());
       woRezervacija.setIdSkladista(ocpProizvod.getMaticnoSkladiste());
       woRezervacija.setKolicina(narucenaKolicina);
       woRezervacija.setPoslovniPartner(user.getWoPartnerSetting().get(0).getPoslovniPartner());
       woRezervacija.setProizvod(ocpProizvod.getProizvod());
       woRezervacija.setStatusRezervacije(1);
       woRezervacija.setSessionid("181818181");
       woRezervacija.setRabat((ps.getRabatZaProizvod(ocpProizvod.getProizvod(), user.getWoPartnerSetting().get(0).getPoslovniPartner(), oj)).getRabat());
       if (woRezervacija.getRabat() == null)
           woRezervacija.setRabat(new BigDecimal(0));*/
            woRezervacijaDAO.merge(woRezervacija);


            OcpProizvod item = ocpProizvod;
            //for (OcpProizvod item : proizvodi.getProizvodList()) {
            System.out.println(" Proizvod je " + item.getProizvod() + " Raspolozivo za  "
                    + item.getRaspolozivo().doubleValue()
                    + " sa pakovanjem od " + item.getKolicinaPoPakovanju()
                    + " u skladist "
                    + item.getMaticnoSkladiste()
                    + " aternativno " + item.getKolUAltJM().doubleValue()
                    + " jm osn je " + item.getJedinicaMere().getSkracenaOznaka()
                    + "i alt jem je " + item.getJedinicaMereAltRef().getSkracenaOznaka()
                    + " sa cenom " + item.getCena());
            //System.out.println("proizvod je "+item);
            /*for (OcpVrAtrProizvod vra : item.getVrAtrProizvod())
          System.out.println(vra.getId().getAtribut() +" "+vra.getVrednost());*/
            //}

        } catch (WOException e) {
            System.out.println((e.getMessage()));
        }
    }

    @Test
    public void testLogOn() {
        Integer oj = new Integer(19);
        CompanySetting cs = appInitService.initApp();
        try {
            User user = logOnService.logOn("vera", "vera", cs, oj);
            System.out.println(" kornisk je identifiovan " + user.getWoUser().getNickname());
            for (WoPartnerSetting partnerSetting : user.getWoPartnerSetting())
                System.out.println(" za partnera " + partnerSetting.getPoslovniPartner() + " imamo " + partnerSetting.getIdSkladista());
            Iterator it = user.getCeneProizvoda().entrySet().iterator();
            /*while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                System.out.println(" cenovnik sadrži sledeće " + pairs.getKey() + " = " + pairs.getValue());
                it.remove(); // avoids a ConcurrentModificationException
            }     */

        } catch (WOException e) {
            System.out.println((e.getMessage()));
        }

    }

    @Test
    public void testServise() {
        CompanySetting cs = appInitService.initApp();
        System.out.println(" prosao je init ");
        Iterator it = cs.getKompanijaKorisnikMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Kompanije " + pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
       /*
        it = cs.getKompanijskiParametri().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Parametri " + pairs.getKey() + " = " + pairs.getValue());
            Iterator it1 = ((WoParametri)pairs.getValue()).getWoSetPoNacinPlacanja().iterator();
            while(it1.hasNext())
                System.out.println("PLACANJE JE "+ ((WoSetPoNacinPlacanja)it1.next()).getProdNacinPlacanja().getNaziv());
            it.remove(); // avoids a ConcurrentModificationException
        }

        it = cs.getMeni().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Meni " + pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

        it = cs.getFilterPrviNivo().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Prvi Nivo " + pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

        it = cs.getFilterDrugiNivo().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Drugi Nivo " + pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        */
        it = cs.getDownloadTip().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Tipovi D " + pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

        it = cs.getDownloadFilesZaTip().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(" Tipovi D Fajlovi " + pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
            //Iterator it1 = pairs.getValue().entrySet().iterator();
            //Map.Entry pairs1 = (Map.Entry)
        }

    }

    @Test
    public void nekiTest() {

        BigDecimal bd = new BigDecimal(3.556);
        System.out.println(bd.divide(new BigDecimal(1.0), BigDecimal.ROUND_FLOOR));
    }

    @Test
    public void nekiNoviTest() {

        MathContext mc = new MathContext(1);

        BigDecimal obj_0 = new BigDecimal(.050),
                obj_1 = new BigDecimal(40.022);
        System.out.println("obj_0 value : " + obj_0);
        System.out.println("method generated " +
                "result : " + obj_0.round(mc));

        System.out.println("obj_1 value : " + obj_1);
        System.out.println("method generated result" +
                " : " + obj_1.round(mc));

        obj_0 = new BigDecimal(0.1220);
        obj_1 = new BigDecimal(.636);

        System.out.println("\nobj_0 value : " + obj_0);
        System.out.println("method generated result" +
                " : " + obj_0.round(mc));

        System.out.println("obj_1 value : " + obj_1);
        System.out.println("method generated result" +
                " : " + obj_1.round(mc));

        obj_0 = new BigDecimal(5.0);
        obj_1 = new BigDecimal(-1.0);

        System.out.println("\nobj_0 value : " + obj_0);
        System.out.println("method generated result" +
                " : " + obj_0.round(mc));

        System.out.println("obj_1 value : " + obj_1);
        System.out.println("method generated result" +
                " : " + obj_1.round(mc));

    }
    
    @Test
    public void nacnPlacanjaTest(){
       
        WoParametri woParametri = woParametriDAO.findById(new Integer(2));
        if (woParametri == null) System.out.println("nema parametara jbt");
        ProdNacinPlacanja prodNacinPlacanja = prodNacinPlacanjaDAO.findById("CAS");
        WoSetPoNacinPlacanja  woSetPoNacinPlacanja = new WoSetPoNacinPlacanja();
        woSetPoNacinPlacanja.setParametri(woParametri);
        woSetPoNacinPlacanja.setProdNacinPlacanja(prodNacinPlacanja);
        woSetPoNacinPlacanja.setIdVdSkldok(new Integer(163));
        woSetPoNacinPlacanja.setVrstastavke(new Integer(25));
        woSetPoNacinPlacanja.setIdVdFindok(new Integer(500));
        woSetPoNacinPlacanjaDao.persist(woSetPoNacinPlacanja);

        
    }

}
