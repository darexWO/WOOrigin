package rs.invado.wo.domain.uz;

// Generated Jan 1, 2013 5:03:16 PM by Hibernate Tools 3.4.0.CR1

import rs.invado.wo.domain.ocp.OcpProizvod;

import javax.persistence.*;

/**
 * UzDozvPakovanja generated by hbm2java
 */

@SqlResultSetMapping(name = "transportnaPakovanja", entities = {@EntityResult(entityClass = UzDozvPakovanja.class, fields = {
        @FieldResult(name = "id.proizvodRef", column = "PROIZVOD_REF"),
        @FieldResult(name = "id.kolPoPakovanju", column = "KOL_PO_PAKOVANJU")})})
@NamedNativeQuery(name = "findTransportnaPakovanja", query = "  select distinct proizvod_ref, kol_po_pakovanju "
        + " from uz_dozv_pakovanja "
        + " where transportno = :parametar"
        + " and rownum < 10 ", resultSetMapping = "transportnaPakovanja")

@Entity
@Table(name = "UZ_DOZV_PAKOVANJA", schema = "DAREX")
public class UzDozvPakovanja implements java.io.Serializable {

    private UzDozvPakovanjaId id;
    //private OcpProizvod ocpProizvod;

    public UzDozvPakovanja() {
    }

    public UzDozvPakovanja(UzDozvPakovanjaId id) {
        this.id = id;

    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "vrstaPakovanjaRef", column = @Column(name = "VRSTA_PAKOVANJA_REF", precision = 8, scale = 0)),
            @AttributeOverride(name = "kolPoPakovanju", column = @Column(name = "KOL_PO_PAKOVANJU", precision = 18, scale = 3)),
            @AttributeOverride(name = "maxKolPoPakovanju", column = @Column(name = "MAX_KOL_PO_PAKOVANJU", precision = 18, scale = 3)),
            @AttributeOverride(name = "transportno", column = @Column(name = "TRANSPORTNO", length = 2)),
            @AttributeOverride(name = "proizvodRef", column = @Column(name = "PROIZVOD_REF", precision = 8, scale = 0))})
    public UzDozvPakovanjaId getId() {
        return this.id;
    }

    public void setId(UzDozvPakovanjaId id) {
        this.id = id;
    }
      /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROIZVOD_REF", referencedColumnName = "PROIZVOD#", insertable = false, updatable = false, nullable = false)
    public OcpProizvod getOcpProizvod() {
        return ocpProizvod;
    }

    public void setOcpProizvod(OcpProizvod ocpProizvod) {
        this.ocpProizvod = ocpProizvod;
    }*/
}