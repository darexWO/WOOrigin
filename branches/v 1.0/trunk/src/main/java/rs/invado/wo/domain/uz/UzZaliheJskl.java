package rs.invado.wo.domain.uz;
// Generated Jan 1, 2013 5:03:16 PM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UzZaliheJskl generated by hbm2java
 */
@Entity
@Table(name="UZ_ZALIHE_JSKL"
    ,schema="DAREX"
)
public class UzZaliheJskl  implements java.io.Serializable {


     private UzZaliheJsklId id;
     private Date datumIVremePrvePromene;
     private BigDecimal kolicinaNaJskl;
     private int proizvod;
     private String idNivoaKvaliteta;
     private short idJediniceMere;
     private Integer kontrolniBroj;
     private BigDecimal kolicinaPoPovezu;
     private BigDecimal kolicinaUTransportu;
     private BigDecimal kolicinaUPickListi;
     private Integer pakovanjaUPickListi;
     private Integer vlasnikPp;
     private String serijskiBroj;
     private Short vrstaProizvoda;
     private Byte pozicija;
     private String idpalete;

    public UzZaliheJskl() {
    }

	
    public UzZaliheJskl(UzZaliheJsklId id, Date datumIVremePrvePromene, BigDecimal kolicinaNaJskl, int proizvod, String idNivoaKvaliteta, short idJediniceMere) {
        this.id = id;
        this.datumIVremePrvePromene = datumIVremePrvePromene;
        this.kolicinaNaJskl = kolicinaNaJskl;
        this.proizvod = proizvod;
        this.idNivoaKvaliteta = idNivoaKvaliteta;
        this.idJediniceMere = idJediniceMere;
    }
    public UzZaliheJskl(UzZaliheJsklId id, Date datumIVremePrvePromene, BigDecimal kolicinaNaJskl, int proizvod, String idNivoaKvaliteta, short idJediniceMere, Integer kontrolniBroj, BigDecimal kolicinaPoPovezu, BigDecimal kolicinaUTransportu, BigDecimal kolicinaUPickListi, Integer pakovanjaUPickListi, Integer vlasnikPp, String serijskiBroj, Short vrstaProizvoda, Byte pozicija, String idpalete) {
       this.id = id;
       this.datumIVremePrvePromene = datumIVremePrvePromene;
       this.kolicinaNaJskl = kolicinaNaJskl;
       this.proizvod = proizvod;
       this.idNivoaKvaliteta = idNivoaKvaliteta;
       this.idJediniceMere = idJediniceMere;
       this.kontrolniBroj = kontrolniBroj;
       this.kolicinaPoPovezu = kolicinaPoPovezu;
       this.kolicinaUTransportu = kolicinaUTransportu;
       this.kolicinaUPickListi = kolicinaUPickListi;
       this.pakovanjaUPickListi = pakovanjaUPickListi;
       this.vlasnikPp = vlasnikPp;
       this.serijskiBroj = serijskiBroj;
       this.vrstaProizvoda = vrstaProizvoda;
       this.pozicija = pozicija;
       this.idpalete = idpalete;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idJediniceSkladistenja", column=@Column(name="ID_JEDINICE_SKLADISTENJA", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="redniBrojJskl", column=@Column(name="REDNI_BROJ_JSKL", nullable=false, precision=6, scale=0) ) } )
    public UzZaliheJsklId getId() {
        return this.id;
    }
    
    public void setId(UzZaliheJsklId id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DATUM_I_VREME_PRVE_PROMENE", nullable=false, length=7)
    public Date getDatumIVremePrvePromene() {
        return this.datumIVremePrvePromene;
    }
    
    public void setDatumIVremePrvePromene(Date datumIVremePrvePromene) {
        this.datumIVremePrvePromene = datumIVremePrvePromene;
    }

    
    @Column(name="KOLICINA_NA_JSKL", nullable=false, precision=15, scale=3)
    public BigDecimal getKolicinaNaJskl() {
        return this.kolicinaNaJskl;
    }
    
    public void setKolicinaNaJskl(BigDecimal kolicinaNaJskl) {
        this.kolicinaNaJskl = kolicinaNaJskl;
    }

    
    @Column(name="PROIZVOD#", nullable=false, precision=7, scale=0)
    public int getProizvod() {
        return this.proizvod;
    }
    
    public void setProizvod(int proizvod) {
        this.proizvod = proizvod;
    }

    
    @Column(name="ID_NIVOA_KVALITETA", nullable=false, length=2)
    public String getIdNivoaKvaliteta() {
        return this.idNivoaKvaliteta;
    }
    
    public void setIdNivoaKvaliteta(String idNivoaKvaliteta) {
        this.idNivoaKvaliteta = idNivoaKvaliteta;
    }

    
    @Column(name="ID_JEDINICE_MERE", nullable=false, precision=3, scale=0)
    public short getIdJediniceMere() {
        return this.idJediniceMere;
    }
    
    public void setIdJediniceMere(short idJediniceMere) {
        this.idJediniceMere = idJediniceMere;
    }

    
    @Column(name="KONTROLNI_BROJ", precision=5, scale=0)
    public Integer getKontrolniBroj() {
        return this.kontrolniBroj;
    }
    
    public void setKontrolniBroj(Integer kontrolniBroj) {
        this.kontrolniBroj = kontrolniBroj;
    }

    
    @Column(name="KOLICINA_PO_POVEZU", precision=22, scale=0)
    public BigDecimal getKolicinaPoPovezu() {
        return this.kolicinaPoPovezu;
    }
    
    public void setKolicinaPoPovezu(BigDecimal kolicinaPoPovezu) {
        this.kolicinaPoPovezu = kolicinaPoPovezu;
    }

    
    @Column(name="KOLICINA_U_TRANSPORTU", precision=18, scale=3)
    public BigDecimal getKolicinaUTransportu() {
        return this.kolicinaUTransportu;
    }
    
    public void setKolicinaUTransportu(BigDecimal kolicinaUTransportu) {
        this.kolicinaUTransportu = kolicinaUTransportu;
    }

    
    @Column(name="KOLICINA_U_PICK_LISTI", precision=18, scale=3)
    public BigDecimal getKolicinaUPickListi() {
        return this.kolicinaUPickListi;
    }
    
    public void setKolicinaUPickListi(BigDecimal kolicinaUPickListi) {
        this.kolicinaUPickListi = kolicinaUPickListi;
    }

    
    @Column(name="PAKOVANJA_U_PICK_LISTI", precision=8, scale=0)
    public Integer getPakovanjaUPickListi() {
        return this.pakovanjaUPickListi;
    }
    
    public void setPakovanjaUPickListi(Integer pakovanjaUPickListi) {
        this.pakovanjaUPickListi = pakovanjaUPickListi;
    }

    
    @Column(name="VLASNIK_PP", precision=7, scale=0)
    public Integer getVlasnikPp() {
        return this.vlasnikPp;
    }
    
    public void setVlasnikPp(Integer vlasnikPp) {
        this.vlasnikPp = vlasnikPp;
    }

    
    @Column(name="SERIJSKI_BROJ", length=20)
    public String getSerijskiBroj() {
        return this.serijskiBroj;
    }
    
    public void setSerijskiBroj(String serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    
    @Column(name="VRSTA_PROIZVODA#", precision=3, scale=0)
    public Short getVrstaProizvoda() {
        return this.vrstaProizvoda;
    }
    
    public void setVrstaProizvoda(Short vrstaProizvoda) {
        this.vrstaProizvoda = vrstaProizvoda;
    }

    
    @Column(name="POZICIJA", precision=2, scale=0)
    public Byte getPozicija() {
        return this.pozicija;
    }
    
    public void setPozicija(Byte pozicija) {
        this.pozicija = pozicija;
    }

    
    @Column(name="IDPALETE", length=50)
    public String getIdpalete() {
        return this.idpalete;
    }
    
    public void setIdpalete(String idpalete) {
        this.idpalete = idpalete;
    }




}

