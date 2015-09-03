package rs.invado.wo.domain.wo;

// Generated Dec 11, 2012 10:59:44 PM by Hibernate Tools 3.4.0.CR1

import rs.invado.wo.domain.ocp.OcpPoslovniPartner;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * WoPartnerSetting generated by hbm2java
 */
@Entity
@Table(name = "WO_PARTNER_SETTINGS", schema = "DAREX")
@SequenceGenerator(   name = "woparametri_seq",
        sequenceName = "WO_ID_SEQ", allocationSize = 1)
public class WoPartnerSetting implements java.io.Serializable {


    private BigDecimal id;
    private OcpPoslovniPartner poslovniPartner;
    private int idSkladista;
    private int organizacionaJedinica;
    private int idCenovnik;
    private int idKlasaCene;
    private Byte prioritetSkladista;
    private Integer kfl;
    private int woKompanijaKorisnik;
    private String napomena;
    private String emailAddress;
    private Integer  receiveConfirm;

    public WoPartnerSetting() {
    }


    public WoPartnerSetting(BigDecimal id, OcpPoslovniPartner poslovniPartner, int idSkladista, int organizacionaJedinica, int idCenovnik,
                            int idKlasaCene, Byte prioritetSkladista, Integer kfl) {
        this.id = id;
        this.poslovniPartner = poslovniPartner;
        this.idSkladista = idSkladista;
        this.organizacionaJedinica = organizacionaJedinica;
        this.idCenovnik = idCenovnik;
        this.idKlasaCene = idKlasaCene;
        this.prioritetSkladista = prioritetSkladista;
        this.kfl = kfl;
    }



    @Id
    @Column(name="ID", nullable=false, unique=true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "woparametri_seq")
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POSLOVNI_PARTNER#", referencedColumnName = "POSLOVNI_PARTNER#", insertable = true, updatable = true)
    public OcpPoslovniPartner getPoslovniPartner() {
        return this.poslovniPartner;
    }

    public void setPoslovniPartner(OcpPoslovniPartner poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }


    @Column(name="ID_SKLADISTA", nullable=false, precision=3, scale=0)
    public int getIdSkladista() {
        return this.idSkladista;
    }

    public void setIdSkladista(int idSkladista) {
        this.idSkladista = idSkladista;
    }


    @Column(name="ORGANIZACIONA_JEDINICA#", nullable=false, precision=5, scale=0)
    public int getOrganizacionaJedinica() {
        return this.organizacionaJedinica;
    }

    public void setOrganizacionaJedinica(int organizacionaJedinica) {
        this.organizacionaJedinica = organizacionaJedinica;
    }


    @Column(name="ID_CENOVNIK", nullable=false, precision=5, scale=0)
    public int getIdCenovnik() {
        return this.idCenovnik;
    }

    public void setIdCenovnik(int idCenovnik) {
        this.idCenovnik = idCenovnik;
    }


    @Column(name="ID_KLASA_CENE", nullable=false, precision=2, scale=0)
    public int getIdKlasaCene() {
        return this.idKlasaCene;
    }

    public void setIdKlasaCene(int idKlasaCene) {
        this.idKlasaCene = idKlasaCene;
    }


    @Column(name="PRIORITET_SKLADISTA", precision=2, scale=0)
    public Byte getPrioritetSkladista() {
        return this.prioritetSkladista;
    }

    public void setPrioritetSkladista(Byte prioritetSkladista) {
        this.prioritetSkladista = prioritetSkladista;
    }


    @Column(name="KFL", precision=7, scale=0)
    public Integer getKfl() {
        return this.kfl;
    }

    public void setKfl(Integer kfl) {
        this.kfl = kfl;
    }

    @Column(name = "ID_KOMPANIJA_KORISNIK")
    public int getWoKompanijaKorisnik() {
        return woKompanijaKorisnik;
    }

    public void setWoKompanijaKorisnik(int woKompanijaKorisnik) {
        this.woKompanijaKorisnik = woKompanijaKorisnik;
    }

    @Column(name = "NAPOMENA", nullable = true)
    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Column(name = "EMAILADDRESS")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name = "RECEIVECONFIRM")
    public Integer getReceiveConfirm() {
        return receiveConfirm;
    }

    public void setReceiveConfirm(Integer receiveConfirm) {
        this.receiveConfirm = receiveConfirm;
    }
}
