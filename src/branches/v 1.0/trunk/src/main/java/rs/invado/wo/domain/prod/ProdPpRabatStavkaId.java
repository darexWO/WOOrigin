package rs.invado.wo.domain.prod;
// Generated Jan 7, 2013 9:06:09 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProdPpRabatStavkaId generated by hbm2java
 */
@Embeddable
public class ProdPpRabatStavkaId  implements java.io.Serializable {


     private int id;
     private int vrstaKlasifikacije;
     private String klasifikacija;

    public ProdPpRabatStavkaId() {
    }

    public ProdPpRabatStavkaId(int id, int vrstaKlasifikacije, String klasifikacija) {
       this.id = id;
       this.vrstaKlasifikacije = vrstaKlasifikacije;
       this.klasifikacija = klasifikacija;
    }
   


    @Column(name="ID", nullable=false, precision=7, scale=0)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="VRSTA_KLASIFIKACIJE#", nullable=false, precision=6, scale=0)
    public int getVrstaKlasifikacije() {
        return this.vrstaKlasifikacije;
    }
    
    public void setVrstaKlasifikacije(int vrstaKlasifikacije) {
        this.vrstaKlasifikacije = vrstaKlasifikacije;
    }


    @Column(name="KLASIFIKACIJA#", nullable=false, length=15)
    public String getKlasifikacija() {
        return this.klasifikacija;
    }
    
    public void setKlasifikacija(String klasifikacija) {
        this.klasifikacija = klasifikacija;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProdPpRabatStavkaId) ) return false;
		 ProdPpRabatStavkaId castOther = ( ProdPpRabatStavkaId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getVrstaKlasifikacije()==castOther.getVrstaKlasifikacije())
 && ( (this.getKlasifikacija()==castOther.getKlasifikacija()) || ( this.getKlasifikacija()!=null && castOther.getKlasifikacija()!=null && this.getKlasifikacija().equals(castOther.getKlasifikacija()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getVrstaKlasifikacije();
         result = 37 * result + ( getKlasifikacija() == null ? 0 : this.getKlasifikacija().hashCode() );
         return result;
   }   


}


