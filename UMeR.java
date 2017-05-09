import java.util.*;


public class UMeR
{
    private HashMap<Motorista, Integer> hashMapMotoristas;
    private HashMap<Cliente, String> hashMapClientes;
    private HashMap<Veiculo, Integer> hashMapVeiculos;
    private HashMap<Empresa, String> hashMapEmpresas;
    
    
    public UMeR()
    {
        this.hashMapMotoristas = new HashMap<Motorista, Integer>();
        this.hashMapClientes = new HashMap<Cliente, String>();
        this.hashMapVeiculos = new HashMap<Veiculo, Integer>();
        this.hashMapEmpresas = new HashMap<Empresa, String>();
    }
    
    
    public UMeR(HashMap<Motorista, Integer> pHashMapMotoristas, 
                HashMap<Cliente, String> pHashMapClientes, 
                HashMap<Veiculo, Integer> hashMapVeiculos, 
                HashMap<Empresa, String> pHashMapEmpresas)
    {
        this.hashMapMotoristas = new HashMap<Motorista, Integer>(hashMapMotoristas);
        this.hashMapClientes = new HashMap<Cliente, String>(hashMapClientes);
        this.hashMapVeiculos = new HashMap<Veiculo, Integer>(hashMapVeiculos);
        this.hashMapEmpresas = new HashMap<Empresa, String>(pHashMapEmpresas);
    }
    
    
    public UMeR(UMeR u)
    {
        this.hashMapMotoristas = u.getHashMapMotoristas();
        this.hashMapClientes = u.getHashMapClientes();
        this.hashMapVeiculos = u.getHashMapVeiculos();
        this.hashMapEmpresas = u.getHashMapEmpresas();
    }
    
    
    public HashMap<Motorista, Integer> getHashMapMotoristas()   { return this.hashMapMotoristas;   }
    public HashMap<Cliente, String> getHashMapClientes()        { return this.hashMapClientes;     }
    public HashMap<Veiculo, Integer> getHashMapVeiculos()       { return this.hashMapVeiculos;     }
    public HashMap<Empresa, String> getHashMapEmpresas()        { return this.hashMapEmpresas;     }
   
    
    public UMeR clone()
    {
        return new UMeR(this);
    }
    
    
    public void insereMotorista(Motorista pMotorista) 
    {
        this.hashMapMotoristas.put(pMotorista, pMotorista.getIdTaxi());
    }
    
    
    public void insereCliente(Cliente pCliente) 
    {
        this.hashMapClientes.put(pCliente, pCliente.getEmail());
    }
    
    
    public void insereVeiculo(Veiculo pVeiculo)
    {
        this.hashMapVeiculos.put(pVeiculo, pVeiculo.getFactorDeFiabilidade());
    }
    
    
    public void insereEmpresa(Empresa pEmpresa)
    {
        this.hashMapEmpresas.put(pEmpresa, pEmpresa.getNome());
    }
}
