import java.util.*;


public class Moto extends Veiculo
{
    private List<Viagem> filaDeEspera;

    public Moto()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public Moto(int id1,String marca1,String modelo1,double pVelocidadeMedia, double pPrecoBase ,int pFactorDeFiabilidade,
                int pCapacidade, List<Viagem> pHistoricoDeViagens,List<Viagem> pFilaDeEspera)
    {
        super(id1,marca1,modelo1,pVelocidadeMedia,pPrecoBase ,pFactorDeFiabilidade, pCapacidade,pHistoricoDeViagens, pFilaDeEspera);
        //this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public Moto(Moto m)
    {
        super(m.getId(),m.getMarca(),m.getModelo(),m.getVelocidadeMedia(),m.getPrecoBase(),m.getFactorDeFiabilidade(),m.getCapacidade(),m.getHistoricoDeViagens(), m.getFilaDeEspera());
        this.filaDeEspera = m.getFilaDeEspera();
    }
    

    public List<Viagem> getFilaDeEspera() { return this.filaDeEspera; }
    public void setFilaDeEspera(List<Viagem> l){this.filaDeEspera = l;}
    
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        else
        {
            Moto m =(Moto)o ;
            
            return this.filaDeEspera.equals(m.getFilaDeEspera())
                   && super.equals(m);
        }
    }
    
    
    public String toString()
    {
      StringBuilder s= new StringBuilder(super.toString());
        
        for(Viagem v:filaDeEspera)
        {
            s.append(v.toString()+"\n");
      }
      
      return s.toString();
    }
    
    public Moto  clone()
    {
        return new Moto(this);
    }
}