import java.util.*;


public class Cliente extends Utilizador
{
    private double x;
    private double y;
    private ArrayList<Viagem> historicoDeViagens;
    
    

    public Cliente()
    {
        super();
        this.x = 0.00;
        this.y = 0.00;
        this.historicoDeViagens = new ArrayList<Viagem>();
    }
    
    
    public Cliente(String pEmail, String pNome, String pPassword, String pMorada, String pDataDeNascimento, double pX, double pY,ArrayList<Viagem> pHistoricoDeViagens)
    {
        super(pEmail, pNome, pPassword,pMorada,pDataDeNascimento);
        this.x = pX;
        this.y = pY;
        this.historicoDeViagens = new ArrayList<Viagem>(pHistoricoDeViagens);
    }
    
    
    public Cliente(Cliente c)
    {
        super(c);
        this.x = c.getX();
        this.y = c.getY();
        this.historicoDeViagens = c.getHistoricoDeViagens();
    }
    
    
    public double getX()                             { return this.x;                  }
    public double getY()                             { return this.y;                  }
    public ArrayList<Viagem> getHistoricoDeViagens() { return this.historicoDeViagens; }
    
    public void setX(double pX)  { this.x = pX; }
    public void setY(double pY)  { this.y = pY; }
    
    
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
        return this.x == c.getX()
            && this.y == c.getY()
            && this.historicoDeViagens == c.getHistoricoDeViagens();
    }
    
    
    public String toString()
    {
        StringBuilder string =  new StringBuilder();   
        string.append("x:"); string.append(this.x); 
        string.append("y:"); string.append(this.y);
        string.append("HistoricoDeViagens: "); string.append(this.historicoDeViagens.toString());
        
        return string.toString();
    }
    
    
    public Cliente clone()
    {
        return new Cliente(this);
    }
}
