package bo.testigos_del_bitcoin.betsports.models;

public class CanjearPremioActivity {
    private String primerPremioId;

    public CanjearPremioActivity(String primerPremioId){
        super();
        this.primerPremioId = primerPremioId;
    }
    public String getPrimerPremioId(){
        return primerPremioId;
    }

    public void setPrimerPremioId(String primerPremioId) {
        this.primerPremioId = primerPremioId;
    }
}
