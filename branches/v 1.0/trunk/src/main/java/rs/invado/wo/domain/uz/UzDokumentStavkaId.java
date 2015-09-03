package rs.invado.wo.domain.uz;

// Generated Jan 1, 2013 5:03:16 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UzDokumentStavkaId generated by hbm2java
 */
@Embeddable
public class UzDokumentStavkaId implements java.io.Serializable {

	private String idDokumenta;
	private int idVd;
	private short rbStavke;

	public UzDokumentStavkaId() {
	}

	public UzDokumentStavkaId(String idDokumenta, short idVd, short rbStavke) {
		this.idDokumenta = idDokumenta;
		this.idVd = idVd;
		this.rbStavke = rbStavke;
	}

	@Column(name = "ID_DOKUMENTA", nullable = false, length = 30)
	public String getIdDokumenta() {
		return this.idDokumenta;
	}

	public void setIdDokumenta(String idDokumenta) {
		this.idDokumenta = idDokumenta;
	}

	@Column(name = "ID_VD", nullable = false, precision = 3, scale = 0)
	public int getIdVd() {
		return this.idVd;
	}

	public void setIdVd(int idVd) {
		this.idVd = idVd;
	}

	@Column(name = "RB_STAVKE", nullable = false, precision = 3, scale = 0)
	public short getRbStavke() {
		return this.rbStavke;
	}

	public void setRbStavke(short rbStavke) {
		this.rbStavke = rbStavke;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UzDokumentStavkaId))
			return false;
		UzDokumentStavkaId castOther = (UzDokumentStavkaId) other;

		return ((this.getIdDokumenta() == castOther.getIdDokumenta()) || (this
				.getIdDokumenta() != null && castOther.getIdDokumenta() != null && this
				.getIdDokumenta().equals(castOther.getIdDokumenta())))
				&& (this.getIdVd() == castOther.getIdVd())
				&& (this.getRbStavke() == castOther.getRbStavke());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdDokumenta() == null ? 0 : this.getIdDokumenta()
						.hashCode());
		result = 37 * result + this.getIdVd();
		result = 37 * result + this.getRbStavke();
		return result;
	}

}