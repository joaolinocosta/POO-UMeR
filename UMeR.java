import java.util.*;
import java.lang.Math;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Iterator;

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
      
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Iterator <Map.Entry<String,Cliente>>  it = this.hashMapClientes.entrySet().iterator();
        
        while(it.hasNext())
        {
           s.append(it.next().getValue().toString());
        }
        return s.toString();
    }
    
    public UMeR clone() 
    { 
        return new UMeR(this); 
    }
     
    
    public void insereMotorista(Motorista pMotorista) 
    { 
        this.hashMapMotoristas.put(pMotorista.getEmail(), pMotorista.clone()); 
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
        this.hashMapClientes.put(pCliente.getEmail(), pCliente.clone());
    }
    
    public boolean procuraCliente(Cliente pCliente)
    {
        return this.hashMapClientes.containsKey(pCliente.getEmail());
    }
    
    public void insereVeiculo(Veiculo pVeiculo) 
    {
        this.hashMapVeiculos.put(pVeiculo.getFactorDeFiabilidade(), pVeiculo.clone());
    }
    
    public boolean procuraVeiculo(Veiculo pVeiculo)
    {
        return this.hashMapVeiculos.containsValue(pVeiculo);
    }
    
    
    public void insereEmpresa(Empresa pEmpresa)
    {
        this.hashMapEmpresas.put(pEmpresa.getNome(), pEmpresa.clone());
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
   
   public UMeR ler(String file) throws IOException ,ClassNotFoundException
   {
       ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
       UMeR res = (UMeR) in.readObject();
       in.close();
       return res;
   }  
   
   public double facturadoPorMotoristaEntre(Motorista m,LocalDateTime date1,LocalDateTime date2)
   {
       Motorista m1 = this.hashMapMotoristas.get(m.getEmail());
       List<Viagem> l = m1.getHistoricoDeViagens();
       l.removeIf((Viagem v2) -> v2.getData().isBefore(date1));
       l.removeIf((Viagem v3) -> v3.getData().isAfter(date2));
       
       double total=0;
       Iterator<Viagem> it = l.iterator();
       while(it.hasNext())
       {
           Viagem tmp=it.next();
           total+=tmp.getDistanciaDaViagem()*tmp.getPrecoDaViagem();
       }
       return total;
   }
   
   public double facturadoPorTaxiEntre(Veiculo v,LocalDateTime date1,LocalDateTime date2)
   {
       Veiculo v1 = this.hashMapVeiculos.get(v.getId());
       List<Viagem> l = v1.getHistoricoDeViagens();
       l.removeIf((Viagem v2) -> v2.getData().isBefore(date1));
       l.removeIf((Viagem v3) -> v3.getData().isAfter(date2));
       
       double total=0;
       Iterator<Viagem> it = l.iterator();
       while(it.hasNext())
       {
           Viagem tmp=it.next();
           total+=tmp.getDistanciaDaViagem()*tmp.getPrecoDaViagem();
       }
       return total;
   }
   
   public double facturadoPorEmpresaEntre(Empresa e,LocalDateTime date1,LocalDateTime date2)
   {
       Empresa e1 = this.hashMapEmpresas.get(e.getNome());
       Collection <Motorista> l =e1.getHashMapMotoristas().values();
    
       
       double total=0;
       Iterator<Motorista> it = l.iterator();
       while(it.hasNext())
       {
           total+=facturadoPorMotoristaEntre(it.next(),date1,date2);
       }
       return total;
   }
}