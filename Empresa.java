import java.util.*;
import java.io.Serializable;


public class Empresa implements Serializable
{
    private String nome;
    private Map <String,Motorista> Motoristas;
    private Map <String,Cliente> clientes;
    private List<Veiculo> veiculos;


    public Empresa()
    {
        this.nome = "Empty";
        this.Motoristas = new HashMap<String,Motorista>();
        this.clientes = new HashMap <String,Cliente>();
        this.veiculos = new ArrayList <Veiculo>();
    }
    
    
    public Empresa(String pNome, Map<String,Motorista> pHashMapMotoristas, Map<String,Cliente> pClientes, List<Veiculo> pVeiculo)
    {
       this.nome = pNome;
       this.Motoristas = new HashMap<String,Motorista> (pHashMapMotoristas);
       this.clientes = new HashMap<String,Cliente> (pClientes);
       this.veiculos = new ArrayList<Veiculo> (pVeiculo);
    }
   
    
    public Empresa(Empresa e)
    {
        this.nome = e.getNome();
        this.Motoristas = e.getHashMapMotoristas();
        this.clientes = e.getClientes();
        this.veiculos = e.getVeiculos();
    }
    
    
    public String getNome()                             { return this.nome;         }
    public Map<String,Motorista> getHashMapMotoristas()  { return this.Motoristas;   }
    public Map<String,Cliente> getClientes()             { return this.clientes;     }
    public List<Veiculo>  getVeiculos()            { return this.veiculos;     }
    
    public void setNome(String n) {this.nome=n;}
    public void setHashMapMotoristas(Map<String,Motorista> m) {this.Motoristas = m;}
    public void setHashMapClientes(Map<String,Cliente> c) {this.clientes = c;}
    public void setVeiculos(List<Veiculo> l) {this.veiculos = l;}
  
    public Empresa clone()
    {
        return new Empresa(this);
    }
}
