import java.util.*;
import java.lang.Math;


public class UMeR
{
    private HashMap<Integer, Motorista> hashMapMotoristas;
    private HashMap<String, Cliente> hashMapClientes;
    private HashMap<Integer, Veiculo> hashMapVeiculos;
    private HashMap<String, Empresa> hashMapEmpresas;
    
    
    public UMeR()
    {
        this.hashMapMotoristas = new HashMap<Integer, Motorista>();
        this.hashMapClientes = new HashMap<String, Cliente>();
        this.hashMapVeiculos = new HashMap<Integer, Veiculo>();
        this.hashMapEmpresas = new HashMap<String, Empresa>();
    }
    
    
    public UMeR(HashMap<Integer, Motorista> pHashMapMotoristas, 
                HashMap<String, Cliente> pHashMapClientes, 
                HashMap<Integer, Veiculo> hashMapVeiculos, 
                HashMap<String, Empresa> pHashMapEmpresas)
    {
        this.hashMapMotoristas = new HashMap<Integer, Motorista>(hashMapMotoristas);
        this.hashMapClientes = new HashMap<String, Cliente>(hashMapClientes);
        this.hashMapVeiculos = new HashMap<Integer, Veiculo>(hashMapVeiculos);
        this.hashMapEmpresas = new HashMap<String, Empresa>(pHashMapEmpresas);
    }
    
    
    public UMeR(UMeR u)
    {
        this.hashMapMotoristas = u.getHashMapMotoristas();
        this.hashMapClientes = u.getHashMapClientes();
        this.hashMapVeiculos = u.getHashMapVeiculos();
        this.hashMapEmpresas = u.getHashMapEmpresas();
    }
    
    
    public HashMap<Integer, Motorista> getHashMapMotoristas()   { return this.hashMapMotoristas;   }
    public HashMap<String, Cliente> getHashMapClientes()        { return this.hashMapClientes;     }
    public HashMap<Integer, Veiculo> getHashMapVeiculos()       { return this.hashMapVeiculos;     }
    public HashMap<String, Empresa> getHashMapEmpresas()        { return this.hashMapEmpresas;     }
      
    
    public UMeR clone() 
    { 
        return new UMeR(this); 
    }
     
    
    public void insereMotorista(Motorista pMotorista) 
    { 
        this.hashMapMotoristas.put(pMotorista.getIdTaxi(), pMotorista); 
    }
        
    public Motorista procuraMotoristaPorKey(int pIdTaxi)
    {
        Motorista m = null;
        
        if (this.hashMapMotoristas.containsKey(pIdTaxi)) {
            m = new Motorista();
            m = this.hashMapMotoristas.get(pIdTaxi);
        }
        
        return m;
    }
    
    
    public void insereCliente(Cliente pCliente) 
    {
        this.hashMapClientes.put(pCliente.getEmail(), pCliente);
    }
    
    public boolean procuraCliente(Cliente pCliente)
    {
        return this.hashMapClientes.containsKey(pCliente.getEmail());
    }
    
    public void chamarUmTaxiPorId(Cliente pCliente, double pX, double pY, int pIdTaxi) throws MotoristaExcepcoes
    {
        Motorista m = new Motorista();
        Viagem v = new Viagem();
        
        if (procuraCliente(pCliente)) {
            pCliente.setX(pX);
            pCliente.setY(pY);
        
            m = procuraMotoristaPorKey(pIdTaxi);
            if (m != null) {
                if (!m.getEstaDisponivel()) {
                    throw new MotoristaExcepcoes ("O motorista nao esta disponivel!");
                } else {
                    v.setDistanciaTaxiCliente(v.calcularUmaDistancia(pCliente.getX(), pCliente.getY(), m.getX(), m.getY()));
                    System.out.println("Introduza as coordenadas de destino: ");
                    Scanner teclado = new Scanner(System.in);
                }
            }
            
        }
    }
    
    public void insereVeiculo(Veiculo pVeiculo)
    {
        this.hashMapVeiculos.put(pVeiculo.getFactorDeFiabilidade(), pVeiculo);
    }
    
    public boolean procuraVeiculo(Veiculo pVeiculo)
    {
        return this.hashMapVeiculos.containsValue(pVeiculo);
    }
    
    
    public void insereEmpresa(Empresa pEmpresa)
    {
        this.hashMapEmpresas.put(pEmpresa.getNome(), pEmpresa);
    }
    
    public boolean procuraEmpresa(Empresa pEmpresa)
    {
        return this.hashMapEmpresas.containsKey(pEmpresa);
    }    
}
