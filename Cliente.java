import java.util.*;



public class Cliente extends Utilizador
{
    private List<Viagem> historicoDeViagens;
    
    public Cliente()
    {
        super();
        this.historicoDeViagens = new ArrayList<Viagem>();
    }
    
    
    public Cliente(String pEmail, String pNome, String pPassword, String pMorada, String pDataDeNascimento, double pX, double pY,List<Viagem> pHistoricoDeViagens)
    {
        super(pEmail, pNome, pPassword,pMorada,pDataDeNascimento,pX,pY);
        this.historicoDeViagens = new ArrayList<Viagem>(pHistoricoDeViagens);
    }
    
    
    public Cliente(Cliente c)
    {
        super(c.getEmail(),c.getNome(),c.getPassword(),c.getMorada(),c.getDataDeNascimento(),c.getX(),c.getY());
        this.historicoDeViagens = c.getHistoricoDeViagens();
    }
    
   
    public List<Viagem> getHistoricoDeViagens()      { return this.historicoDeViagens; }
    public void setHistoricoDeViagens(List<Viagem> l) {this.historicoDeViagens =l;}
    
    
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        } 
        
        if (o == null) {
            return false;
        }
        
        if (getClass() != o.getClass()) {
            return false;
        }
        
        Cliente c = (Cliente) o;
        return  this.historicoDeViagens.equals(c.getHistoricoDeViagens());
    }
    
    
    public String toString()
    {
        StringBuilder string =  new StringBuilder(super.toString());
        string.append("HistoricoDeViagens: "); string.append(this.historicoDeViagens.toString()+"\n");
        
        return string.toString();
    }
    
    
    public Cliente clone()
    {
        return new Cliente(this);
    }

    public void registarViagem(Viagem v)
    {
        this.historicoDeViagens.add(v);
    }
    
    public void imprimirHistoricoDeViagens()
    {
        StringBuilder string =  new StringBuilder();
        string.append(this.historicoDeViagens.toString()); string.append("\n");
        System.out.println(string);
    }
}
