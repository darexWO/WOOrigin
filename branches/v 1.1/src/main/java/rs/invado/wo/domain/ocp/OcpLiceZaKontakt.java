package rs.invado.wo.domain.ocp;

// Generated Dec 9, 2012 6:19:17 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OcpLiceZaKontakt generated by hbm2java
 */
@Entity
@Table(name = "OCP_LICE_ZA_KONTAKT", schema = "DAREX")
public class OcpLiceZaKontakt implements java.io.Serializable {

	private OcpLiceZaKontaktId id;
	private OcpPoslovniPartner ocpPoslovniPartner;
	private String ime;
	private String prezime;
	private String primedba;
	private String funkcija;
	private String wousername;
	private String wopassword;
	private BigDecimal wousernivo;
	private Set ocpKontaktiLicas = new HashSet(0);

	public OcpLiceZaKontakt() {
	}

	public OcpLiceZaKontakt(OcpLiceZaKontaktId id,
			OcpPoslovniPartner ocpPoslovniPartner, String ime, String prezime) {
		this.id = id;
		this.ocpPoslovniPartner = ocpPoslovniPartner;
		this.ime = ime;
		this.prezime = prezime;
	}

	public OcpLiceZaKontakt(OcpLiceZaKontaktId id,
			OcpPoslovniPartner ocpPoslovniPartner, String ime, String prezime,
			String primedba, String funkcija, String wousername,
			String wopassword, BigDecimal wousernivo, Set ocpKontaktiLicas) {
		this.id = id;
		this.ocpPoslovniPartner = ocpPoslovniPartner;
		this.ime = ime;
		this.prezime = prezime;
		this.primedba = primedba;
		this.funkcija = funkcija;
		this.wousername = wousername;
		this.wopassword = wopassword;
		this.wousernivo = wousernivo;
		this.ocpKontaktiLicas = ocpKontaktiLicas;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "poslovniPartner", column = @Column(name = "POSLOVNI_PARTNER#", nullable = false, precision = 7, scale = 0)),
			@AttributeOverride(name = "rbr", column = @Column(name = "RBR", nullable = false, precision = 4, scale = 0)) })
	public OcpLiceZaKontaktId getId() {
		return this.id;
	}

	public void setId(OcpLiceZaKontaktId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSLOVNI_PARTNER#", nullable = false, insertable = false, updatable = false)
	public OcpPoslovniPartner getOcpPoslovniPartner() {
		return this.ocpPoslovniPartner;
	}

	public void setOcpPoslovniPartner(OcpPoslovniPartner ocpPoslovniPartner) {
		this.ocpPoslovniPartner = ocpPoslovniPartner;
	}

	@Column(name = "IME", nullable = false, length = 20)
	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	@Column(name = "PREZIME", nullable = false, length = 30)
	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Column(name = "PRIMEDBA", length = 2000)
	public String getPrimedba() {
		return this.primedba;
	}

	public void setPrimedba(String primedba) {
		this.primedba = primedba;
	}

	@Column(name = "FUNKCIJA", length = 100)
	public String getFunkcija() {
		return this.funkcija;
	}

	public void setFunkcija(String funkcija) {
		this.funkcija = funkcija;
	}

	@Column(name = "WOUSERNAME", length = 100)
	public String getWousername() {
		return this.wousername;
	}

	public void setWousername(String wousername) {
		this.wousername = wousername;
	}

	@Column(name = "WOPASSWORD", length = 100)
	public String getWopassword() {
		return this.wopassword;
	}

	public void setWopassword(String wopassword) {
		this.wopassword = wopassword;
	}

	@Column(name = "WOUSERNIVO", precision = 22, scale = 0)
	public BigDecimal getWousernivo() {
		return this.wousernivo;
	}

	public void setWousernivo(BigDecimal wousernivo) {
		this.wousernivo = wousernivo;
	}

	@OneToMany(targetEntity=OcpKontaktiLica.class, fetch = FetchType.LAZY, mappedBy = "ocpLiceZaKontakt")
	public Set getOcpKontaktiLicas() {
		return this.ocpKontaktiLicas;
	}

	public void setOcpKontaktiLicas(Set ocpKontaktiLicas) {
		this.ocpKontaktiLicas = ocpKontaktiLicas;
	}

}