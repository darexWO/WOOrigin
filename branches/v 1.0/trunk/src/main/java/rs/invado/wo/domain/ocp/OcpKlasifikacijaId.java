package rs.invado.wo.domain.ocp;
// Generated Dec 9, 2012 6:19:17 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OcpKlasifikacijaId generated by hbm2java
 */
@Embeddable
public class OcpKlasifikacijaId  implements java.io.Serializable {


     private int vrstaKlasifikacije;
     private String klasifikacija;

    public OcpKlasifikacijaId() {
    }

    public OcpKlasifikacijaId(int vrstaKlasifikacije, String klasifikacija) {
       this.vrstaKlasifikacije = vrstaKlasifikacije;
       this.klasifikacija = klasifikacija;
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
		 if ( !(other instanceof OcpKlasifikacijaId) ) return false;
		 OcpKlasifikacijaId castOther = ( OcpKlasifikacijaId ) other; 
         
		 return (this.getVrstaKlasifikacije()==castOther.getVrstaKlasifikacije())
 && ( (this.getKlasifikacija()==castOther.getKlasifikacija()) || ( this.getKlasifikacija()!=null && castOther.getKlasifikacija()!=null && this.getKlasifikacija().equals(castOther.getKlasifikacija()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVrstaKlasifikacije();
         result = 37 * result + ( getKlasifikacija() == null ? 0 : this.getKlasifikacija().hashCode() );
         return result;
   }   


}


