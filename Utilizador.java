import java.util.*;
import java.io.Serializable;



public abstract class Utilizador implements Serializable
{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private String dataDeNascimento;
    private double x, y;
    
    
    
    public Utilizador()
    {
        this.email = "Empty";
        this.nome = "Empty";
        this.password = "Empty";
        this.morada = "Empty";
        this.dataDeNascimento = "Empty";
        this.x=0.0;
        this.y=0.0;
    }
    
    
    public Utilizador(String pEmail, String pNome, String pPassword, String pMorada, String pDataDeNascimento,double px,double py)
    {
        this.email = pEmail;
        this.nome = pNome;
        this.password = pPassword;
        this.morada = pMorada;
        this.dataDeNascimento = pDataDeNascimento; 
        this.x=px; this.y=py;
    }
    
    
    public Utilizador(Utilizador u)
    {
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.password= u.getPassword();
        this.morada = u.getMorada();
        this.dataDeNascimento = u.getDataDeNascimento();
        this.x= u.getX();
        this.y=u.getY();
    }
    

    public String getEmail()             { return this.email;             }
    public String getNome()              { return this.nome;              }
    public String getPassword()          { return this.password;          }
    public String getMorada()            { return this.morada;            }
    public String getDataDeNascimento()  { return this.dataDeNascimento;  }
    public double getX(){ return this.x;   }
    public double getY(){ return this.y;   }
    
    public void setEmail(String e) { this.email = e;}
    public void setNome(String n) { this.nome = n;}
    public void setPassword(String p) { this.password = p;}
    public void setMorada(String m) { this.morada = m;}
    public void setDataDeNascimento(String dn) { this.dataDeNascimento = dn;}
    public void setX(double a) {this.x=a;}
    public void setY(double b) {this.x=b;}
    
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
        
        Utilizador u = (Utilizador) o;
        return this.email.equals(u.getEmail())
            && this.nome.equals(u.getNome())
            && this.password.equals(u.getPassword())
            && this.morada.equals(u.getMorada())
            && this.dataDeNascimento.equals(u.getDataDeNascimento())
            && this.x == u.getX()
            && this.y == u.getY();
    }
    
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("Email:"); string.append(this.email+"\n");
        string.append("Nome:"); string.append(this.nome+"\n");
        string.append("Password:"); string.append(this.password+"\n");
        string.append("Address:"); string.append(this.morada+"\n");
        string.append("DataDeNascimento:"); string.append(this.dataDeNascimento+"\n");
        string.append("X:"); string.append(this.x+"\n");
        string.append("Y"); string.append(this.y+"\n");
        
        return string.toString();
    }
    

    public abstract Utilizador clone();
    
    public void changePassword(String newp)
    {
        setPassword(newp);
    }
}
