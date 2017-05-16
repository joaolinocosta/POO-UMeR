import java.util.*;


public class CarroLigeiro extends Veiculo
{
    private List<Viagem> filaDeEspera;


    public CarroLigeiro()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public CarroLigeiro(String marca1,String modelo1,double pVelocidadeMedia, double pPrecoBase ,int pFactorDeFiabilidade,
                         int pCapacidade, List<Viagem> pHistoricoDeViagens, List<Viagem> pFilaDeEspera)
    {
        super(marca1,modelo1,pVelocidadeMedia, pPrecoBase ,pFactorDeFiabilidade, pCapacidade,pHistoricoDeViagens);
        this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public CarroLigeiro(CarroLigeiro cl)
    {
        super(cl.getMarca(),cl.getModelo(),cl.getVelocidadeMedia(),cl.getPrecoBase(),cl.getFactorDeFiabilidade(),cl.getCapacidade(),cl.getHistoricoDeViagens());
        this.filaDeEspera = cl.getFilaDeEspera();
    }
    

    public List<Viagem> getFilaDeEspera() { return this.filaDeEspera; }
    public void setFilaDeEspera(List<Viagem> l){this.filaDeEspera = l;}
    
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        else
        {
            CarroLigeiro cl =(CarroLigeiro)o ;
            
            return this.filaDeEspera.equals(cl.getFilaDeEspera())
                   && super.equals(cl);
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
    
    public CarroLigeiro clone()
    {
        return new CarroLigeiro(this);
    }
}