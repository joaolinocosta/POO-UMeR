import java.util.*;


public class CarroDe9Lugares extends Veiculo
{
    private List<Viagem> filaDeEspera;

    public CarroDe9Lugares()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public CarroDe9Lugares(String marca1,String modelo1,double pVelocidadeMedia, double pPrecoBase ,int pFactorDeFiabilidade,
                           int pCapacidade, List<Viagem> pHistoricoDeViagens, List<Viagem> pFilaDeEspera)
    {
        super(marca1,modelo1,pVelocidadeMedia, pPrecoBase ,pFactorDeFiabilidade,pCapacidade,pHistoricoDeViagens);
        this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public CarroDe9Lugares(CarroDe9Lugares c9l)
    {
        super(c9l.getMarca(),c9l.getModelo(),c9l.getVelocidadeMedia(),c9l.getPrecoBase(),c9l.getFactorDeFiabilidade(),c9l.getCapacidade(),c9l.getHistoricoDeViagens());
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