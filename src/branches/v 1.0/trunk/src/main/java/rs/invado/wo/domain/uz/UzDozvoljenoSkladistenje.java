package rs.invado.wo.domain.uz;

// Generated Jan 1, 2013 5:03:16 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UzDozvoljenoSkladistenje generated by hbm2java
 */
@Entity
@Table(name = "UZ_DOZVOLJENO_SKLADISTENJE", schema = "DAREX")
public class UzDozvoljenoSkladistenje implements java.io.Serializable {

	private UzDozvoljenoSkladistenjeId id;
	private Integer brojDelimicnoSlobodnih;
	private Integer brojUslovnoSlobodnih;
	private BigDecimal maxKapacitet;
	private Integer brojPotpunoSlobodnih;

	public UzDozvoljenoSkladistenje() {
	}

	public UzDozvoljenoSkladistenje(UzDozvoljenoSkladistenjeId id) {
		this.id = id;
	}

	public UzDozvoljenoSkladistenje(UzDozvoljenoSkladistenjeId id,
			Integer brojDelimicnoSlobodnih, Integer brojUslovnoSlobodnih,
			BigDecimal maxKapacitet, Integer brojPotpunoSlobodnih) {
		this.id = id;
		this.brojDelimicnoSlobodnih = brojDelimicnoSlobodnih;
		this.brojUslovnoSlobodnih = brojUslovnoSlobodnih;
		this.maxKapacitet = maxKapacitet;
		this.brojPotpunoSlobodnih = brojPotpunoSlobodnih;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idJediniceMere", column = @Column(name = "ID_JEDINICE_MERE", nullable = false, precision = 3, scale = 0)),
			@AttributeOverride(name = "proizvod", column = @Column(name = "PROIZVOD#", nullable = false, precision = 7, scale = 0)),
			@AttributeOverride(name = "idTipaJedSklad", column = @Column(name = "ID_TIPA_JED_SKLAD", nullable = false, precision = 4, scale = 0)) })
	public UzDozvoljenoSkladistenjeId getId() {
		return this.id;
	}

	public void setId(UzDozvoljenoSkladistenjeId id) {
		this.id = id;
	}

	@Column(name = "BROJ_DELIMICNO_SLOBODNIH", precision = 6, scale = 0)
	public Integer getBrojDelimicnoSlobodnih() {
		return this.brojDelimicnoSlobodnih;
	}

	public void setBrojDelimicnoSlobodnih(Integer brojDelimicnoSlobodnih) {
		this.brojDelimicnoSlobodnih = brojDelimicnoSlobodnih;
	}

	@Column(name = "BROJ_USLOVNO_SLOBODNIH", precision = 6, scale = 0)
	public Integer getBrojUslovnoSlobodnih() {
		return this.brojUslovnoSlobodnih;
	}

	public void setBrojUslovnoSlobodnih(Integer brojUslovnoSlobodnih) {
		this.brojUslovnoSlobodnih = brojUslovnoSlobodnih;
	}

	@Column(name = "MAX_KAPACITET", precision = 20, scale = 5)
	public BigDecimal getMaxKapacitet() {
		return this.maxKapacitet;
	}

	public void setMaxKapacitet(BigDecimal maxKapacitet) {
		this.maxKapacitet = maxKapacitet;
	}

	@Column(name = "BROJ_POTPUNO_SLOBODNIH", precision = 6, scale = 0)
	public Integer getBrojPotpunoSlobodnih() {
		return this.brojPotpunoSlobodnih;
	}

	public void setBrojPotpunoSlobodnih(Integer brojPotpunoSlobodnih) {
		this.brojPotpunoSlobodnih = brojPotpunoSlobodnih;
	}

}
