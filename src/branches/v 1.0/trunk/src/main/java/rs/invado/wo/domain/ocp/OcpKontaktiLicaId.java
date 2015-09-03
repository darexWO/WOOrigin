package rs.invado.wo.domain.ocp;
// Generated Dec 9, 2012 6:19:17 PM by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OcpKontaktiLicaId generated by hbm2java
 */
@Embeddable
public class OcpKontaktiLicaId  implements java.io.Serializable {


     private String broj;
     private byte idVrsteTelefonskogBroja;
     private short rbr;
     private int poslovniPartner;

    public OcpKontaktiLicaId() {
    }

    public OcpKontaktiLicaId(String broj, byte idVrsteTelefonskogBroja, short rbr, int poslovniPartner) {
       this.broj = broj;
       this.idVrsteTelefonskogBroja = idVrsteTelefonskogBroja;
       this.rbr = rbr;
       this.poslovniPartner = poslovniPartner;
    }
   


    @Column(name="BROJ", nullable=false, length=50)
    public String getBroj() {
        return this.broj;
    }
    
    public void setBroj(String broj) {
        this.broj = broj;
    }


    @Column(name="ID_VRSTE_TELEFONSKOG_BROJA", nullable=false, precision=2, scale=0)
    public byte getIdVrsteTelefonskogBroja() {
        return this.idVrsteTelefonskogBroja;
    }
    
    public void setIdVrsteTelefonskogBroja(byte idVrsteTelefonskogBroja) {
        this.idVrsteTelefonskogBroja = idVrsteTelefonskogBroja;
    }


    @Column(name="RBR", nullable=false, precision=4, scale=0)
    public short getRbr() {
        return this.rbr;
    }
    
    public void setRbr(short rbr) {
        this.rbr = rbr;
    }


    @Column(name="POSLOVNI_PARTNER#", nullable=false, precision=7, scale=0)
    public int getPoslovniPartner() {
        return this.poslovniPartner;
    }
    
    public void setPoslovniPartner(int poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OcpKontaktiLicaId) ) return false;
		 OcpKontaktiLicaId castOther = ( OcpKontaktiLicaId ) other; 
         
		 return ( (this.getBroj()==castOther.getBroj()) || ( this.getBroj()!=null && castOther.getBroj()!=null && this.getBroj().equals(castOther.getBroj()) ) )
 && (this.getIdVrsteTelefonskogBroja()==castOther.getIdVrsteTelefonskogBroja())
 && (this.getRbr()==castOther.getRbr())
 && (this.getPoslovniPartner()==castOther.getPoslovniPartner());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getBroj() == null ? 0 : this.getBroj().hashCode() );
         result = 37 * result + this.getIdVrsteTelefonskogBroja();
         result = 37 * result + this.getRbr();
         result = 37 * result + this.getPoslovniPartner();
         return result;
   }   


}


