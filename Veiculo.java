import java.util.*;



public abstract class Veiculo
{
    private double velocidadeMedia;
    private double precoBase;
    private int factorDeFiabilidade;
    private int capacidade;
    private ArrayList<Viagem> historicoDeViagens;
   
    
    
    public Veiculo()
    {
        this.velocidadeMedia = 0.00;
        this.precoBase = 0.00;
        this.factorDeFiabilidade = 0;
        this.capacidade = 0;
        this.historicoDeViagens = new ArrayList<Viagem>();
    }
    
    
    public Veiculo(double pVelocidadeMedia, double pPrecoBase ,int pFactorDeFiabilidade, int pCapacidade, ArrayList<Viagem> pHistoricoDeViagens)
    {
        this.velocidadeMedia = pVelocidadeMedia;
        this.precoBase = pPrecoBase;
        this.factorDeFiabilidade = pFactorDeFiabilidade;
        this.capacidade = pCapacidade;
        this.historicoDeViagens = new ArrayList<Viagem>(pHistoricoDeViagens);
    }
    
    
    public Veiculo(Veiculo v)
    {
        this.velocidadeMedia = v.getVelocidadeMedia();
        this.precoBase = v.getPrecoBase();
        this.factorDeFiabilidade = v.getFactorDeFiabilidade();
        this.capacidade = v.getCapacidade();
        this.historicoDeViagens = v.getHistoricoDeViagens();
    }
    
    
    public double getVelocidadeMedia()               { return this.velocidadeMedia;     }
    public double getPrecoBase()                     { return this.precoBase;           }
    public int  getFactorDeFiabilidade()             { return this.factorDeFiabilidade; }
    public int getCapacidade()                       { return this.capacidade;          }
    public ArrayList<Viagem> getHistoricoDeViagens() { return this.historicoDeViagens;  }
    
    
    public boolean equals(Object o)
    {
        if(this==o) {
            return true;
        }
        
        if (o == null) {
            return false;
        }
        
        if (getClass() != o.getClass()) {
            return false;
        }
            
        Veiculo v =(Veiculo) o;  
        return this.velocidadeMedia == v.getVelocidadeMedia()
            && this.precoBase == v.getPrecoBase()
            && this.factorDeFiabilidade == v.getFactorDeFiabilidade()
            && this.capacidade == v.getCapacidade()
            && this.historicoDeViagens.equals(v.getHistoricoDeViagens());
    }
    
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("VelocidadeMedia: "); string.append(this.velocidadeMedia);
        string.append("PrecoBase: "); string.append(this.precoBase);
        string.append("FactorDeFiabilidade: "); string.append(this.factorDeFiabilidade);
        string.append("Capacidade: "); string.append(this.capacidade);
        string.append("HistoricoDeViagens: "); string.append(this.historicoDeViagens.toString());
        
        return string.toString();
    }
    
    
    public abstract Veiculo clone();   
}
