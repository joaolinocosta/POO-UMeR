import java.util.*;


public class CarroDe9Lugares extends Veiculo
{
    private List<Viagem> filaDeEspera;

    public CarroDe9Lugares()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public CarroDe9Lugares(int id1,String marca1,String modelo1,double pVelocidadeMedia, double pPrecoBase ,int pFactorDeFiabilidade,
                           int pCapacidade, List<Viagem> pHistoricoDeViagens, List<Viagem> pFilaDeEspera)
    {
        super(id1,marca1,modelo1,pVelocidadeMedia, pPrecoBase ,pFactorDeFiabilidade,pCapacidade,pHistoricoDeViagens, pFilaDeEspera);
        //this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public CarroDe9Lugares(CarroDe9Lugares c9l)
    {
        super(c9l.getId(),c9l.getMarca(),c9l.getModelo(),c9l.getVelocidadeMedia(),c9l.getPrecoBase(),c9l.getFactorDeFiabilidade(),c9l.getCapacidade(),c9l.getHistoricoDeViagens(), c9l.getFilaDeEspera());
        this.filaDeEspera = c9l.getFilaDeEspera();
    }
    

    public List<Viagem> getFilaDeEspera() { return this.filaDeEspera; }
    public void setFilaDeEspera(List<Viagem> l) {this.filaDeEspera = l;}
    
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        else
        {
            CarroDe9Lugares c =(CarroDe9Lugares)o ;
            
            return this.filaDeEspera.equals(c.getFilaDeEspera())
                   && super.equals(c);
        }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder(super.toString());
        
        for(Viagem v:filaDeEspera)
        {
            s.append(v.toString());
        }
        return s.toString();
    }
    
    public CarroDe9Lugares  clone()
    {
        return new CarroDe9Lugares(this);
    }
}