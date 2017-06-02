import java.util.*;
import java.io.Serializable;



public abstract class Veiculo implements Serializable
{
    private int id;
    private String marca;
    private String modelo;
    private double velocidadeMedia;
    private double precoBase;
    private int factorDeFiabilidade;
    private int capacidade;
    private double totalKms;
    private List<Viagem> historicoDeViagens;
    private List<Viagem> filaDeEspera;
   
    
    
    public Veiculo()
    {
        this.id=-1;
        this.marca = "";
        this.modelo = "";
        this.velocidadeMedia = 0.00;
        this.precoBase = 0.00;
        this.factorDeFiabilidade = 0;
        this.capacidade = 0;
        this.totalKms=0;
        this.historicoDeViagens = new ArrayList<Viagem>();
        this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public Veiculo(int id1,String marca1,String modelo1,double pVelocidadeMedia, double pPrecoBase ,int pFactorDeFiabilidade, int pCapacidade, List<Viagem> l, List<Viagem> fe)
    {
        this.id=id1;
        this.marca=marca1;
        this.modelo=modelo1;
        this.velocidadeMedia = pVelocidadeMedia;
        this.precoBase = pPrecoBase;
        this.factorDeFiabilidade = pFactorDeFiabilidade;
        this.capacidade = pCapacidade;
        this.totalKms=0;
        this.historicoDeViagens = new ArrayList<Viagem>(l);
        this.filaDeEspera = new ArrayList<Viagem>(fe);
    }
    
    
    public Veiculo(Veiculo v)
    {
        this.id=v.getId();
        this.marca=v.getMarca();
        this.modelo=v.getModelo();
        this.velocidadeMedia = v.getVelocidadeMedia();
        this.precoBase = v.getPrecoBase();
        this.factorDeFiabilidade = v.getFactorDeFiabilidade();
        this.capacidade = v.getCapacidade();
        this.totalKms = v.gettotalKms();
        this.historicoDeViagens = v.getHistoricoDeViagens();
        this.filaDeEspera = v.getFilaDeEspera();
    }
    
    
    public int getId(){return this.id;}
    public String getMarca() {return this.marca;}
    public String getModelo(){return this.modelo;}
    public double getVelocidadeMedia()               { return this.velocidadeMedia;     }
    public double getPrecoBase()                     { return this.precoBase;           }
    public int  getFactorDeFiabilidade()             { return this.factorDeFiabilidade; }
    public int getCapacidade()                       { return this.capacidade;          }
    public double gettotalKms(){return this.totalKms;}
    public List<Viagem> getHistoricoDeViagens()      { return this.historicoDeViagens;  }
    public List<Viagem> getFilaDeEspera()            { return this.filaDeEspera;        }
    
    public void setId(int id1) {this.id=id1;}
    public void setMarca(String marca1) {this.marca = marca1;}
    public void setModelo(String modelo1) {this.modelo = modelo1;}
    public void setVelocidadeMedia(double v) {this.velocidadeMedia = v;}
    public void setPrecoBase(double p) {this.precoBase = p;}
    public void setFactorFiabilidade(int f) {this.factorDeFiabilidade = f;}
    public void setCapacidade(int c) {this.capacidade = c;}
    public void settotalKms(double k){this.totalKms=k;}
    public void setHistoricoDeViagems(List<Viagem> l) {this.historicoDeViagens = l;}
    public void setFilaDeEspera(List<Viagem> fe)      { this.filaDeEspera = fe;    }
    
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
        return this.id== v.getId()
            && this.marca.equals(v.getMarca())
            && this.modelo.equals(v.getModelo())
            && this.velocidadeMedia == v.getVelocidadeMedia()
            && this.precoBase == v.getPrecoBase()
            && this.factorDeFiabilidade == v.getFactorDeFiabilidade()
            && this.capacidade == v.getCapacidade()
            && this.historicoDeViagens.equals(v.getHistoricoDeViagens())
            && this.filaDeEspera.equals(v.getFilaDeEspera());
    }
    
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("ID do taxi                          |   "); string.append(this.id); string.append("\n");
        string.append("Marca do automóvel                  |   "); string.append(this.marca); string.append("\n");
        string.append("Modelo do automóvel                 |   "); string.append(this.modelo); string.append("\n");
        string.append("Velocidade média                    |   "); string.append(this.velocidadeMedia); string.append("\n");
        string.append("Preco base                          |   "); string.append(this.precoBase); string.append("\n");
        string.append("Factor de fiabilidade               |   "); string.append(this.factorDeFiabilidade); string.append("\n");
        string.append("Capacidade                          |   "); string.append(this.capacidade); string.append("\n");
        string.append("Histórico de viagens                |   "); string.append(this.historicoDeViagens.toString()); string.append("\n");
        string.append("Fila de espera                      |   "); string.append(this.filaDeEspera.toString()); string.append("\n");
        
        return string.toString();
    }
    
    
    public abstract Veiculo clone();   
    
    public void esperaViagem(Viagem v)
    {
        this.filaDeEspera.add(v);
    }
    
    public void removeViagem()
    {
        this.filaDeEspera.remove(0);
    }
}
