import java.util.*;
import java.lang.Math;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


public class UMeR implements Serializable
{
    private Map<String, Motorista> hashMapMotoristas;
    private Map<String, Cliente> hashMapClientes;
    private Map<Integer, Veiculo> hashMapVeiculos;
    private Map<String, Empresa> hashMapEmpresas;
    
    public UMeR()
    {
        this.hashMapMotoristas = new HashMap<String, Motorista>();
        this.hashMapClientes = new HashMap<String, Cliente>();
        this.hashMapVeiculos = new HashMap<Integer, Veiculo>();
        this.hashMapEmpresas = new HashMap<String, Empresa>();
    }
    
    
    public UMeR(Map<String, Motorista> pHashMapMotoristas, 
                Map<String, Cliente> pHashMapClientes, 
                Map<Integer, Veiculo> hashMapVeiculos, 
                Map<String, Empresa> pHashMapEmpresas)
    {
        this.hashMapMotoristas = new HashMap<String, Motorista>(hashMapMotoristas);
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
    
    
    public Map<String, Motorista> getHashMapMotoristas()   { return this.hashMapMotoristas;   }
    public Map<String, Cliente> getHashMapClientes()        { return this.hashMapClientes;     }
    public Map<Integer, Veiculo> getHashMapVeiculos()       { return this.hashMapVeiculos;     }
    public Map<String, Empresa> getHashMapEmpresas()        { return this.hashMapEmpresas;     }
    
    public void setHashMapMotoristas(Map<String,Motorista> m) {this.hashMapMotoristas = m;}
    public void setHashMapClientes(Map<String,Cliente> c) {this.hashMapClientes = c;}
    public void setHashMapVeiculos(Map<Integer,Veiculo> v) {this.hashMapVeiculos = v;}
    public void setHashMapEmpresas(Map<String,Empresa> e) {this.hashMapEmpresas = e;}
      
    
    public UMeR clone() 
    { 
        return new UMeR(this); 
    }
     
    
    public void insereMotorista(Motorista pMotorista) 
    { 
        this.hashMapMotoristas.put(pMotorista.getEmail(), pMotorista); 
    }
        
    public Motorista procuraMotoristaPorKey(String email)
    {
        Motorista m = null;
        
        if (this.hashMapMotoristas.containsKey(email)) {
            m = new Motorista();
            m = this.hashMapMotoristas.get(email);
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
    
    public void chamarUmTaxiPorId(Cliente pCliente, double pX, double pY, String email) throws MotoristaExcepcoes
    {
        Motorista m = new Motorista();
        Viagem v = new Viagem();
        
        if (procuraCliente(pCliente)) {
            pCliente.setX(pX);
            pCliente.setY(pY);
        
            m = procuraMotoristaPorKey(email);
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
    
   public void gravar(String file) throws IOException
   {
       ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(file));
       oss.writeObject(this);
       oss.flush();
       oss.close();
   }
   
    public void ler(String file) throws IOException
   {
       try
       {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        UMeR res = (UMeR) ois.readObject();
        ois.close();
       }
       catch(FileNotFoundException e)
       { 
           e.printStackTrace();
       }
       catch (ClassNotFoundException e)
       {
           e.printStackTrace();
       }
   }
}