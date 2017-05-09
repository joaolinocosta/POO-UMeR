import java.util.*;


public class Empresa
{
    private String nome;
    private HashMap<Motorista, Integer> hashMapMotoristas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Veiculo> veiculos;


    public Empresa()
    {
        this.nome = "Empty";
        this.hashMapMotoristas = new HashMap<Motorista, Integer>();
        this.clientes = new ArrayList <Cliente>();
        this.veiculos = new ArrayList <Veiculo>();
    }
    
    
    public Empresa(String pNome, HashMap<Motorista, Integer> pHashMapMotoristas, ArrayList<Cliente> pClientes, ArrayList<Veiculo> pVeiculo)
    {
       this.nome = pNome;
       this.hashMapMotoristas = new HashMap<Motorista, Integer> (pHashMapMotoristas);
       this.clientes = new ArrayList<Cliente> (pClientes);
       this.veiculos = new ArrayList<Veiculo> (pVeiculo);
    }
   
    
    public Empresa(Empresa e)
    {
        this.nome = e.getNome();
        this.hashMapMotoristas = e.getHashMapMotoristas();
        this.clientes = e.getClientes();
        this.veiculos = e.getVeiculos();
    }
    
    
    public String getNome()                             { return this.nome;         }
    public HashMap<Motorista, Integer> getHashMapMotoristas()  { return this.hashMapMotoristas;   }
    public ArrayList<Cliente> getClientes()             { return this.clientes;     }
    public ArrayList<Veiculo>  getVeiculos()            { return this.veiculos;     }
  
    public Empresa clone()
    {
        return new Empresa(this);
    }
}
