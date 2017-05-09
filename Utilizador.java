import java.util.*;



public abstract class Utilizador
{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private String dataDeNascimento;
    
    
    
    public Utilizador()
    {
        this.email = "Empty";
        this.nome = "Empty";
        this.password = "Empty";
        this.morada = "Empty";
        this.dataDeNascimento = "Empty";
    }
    
    
    public Utilizador(String pEmail, String pNome, String pPassword, String pMorada, String pDataDeNascimento)
    {
        this.email = pEmail;
        this.nome = pNome;
        this.password = pPassword;
        this.morada = pMorada;
        this.dataDeNascimento = pDataDeNascimento; 
    }
    
    
    public Utilizador(Utilizador u)
    {
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.password= u.getPassword();
        this.morada = u.getMorada();
        this.dataDeNascimento = u.getDataDeNascimento();
    }
    

    public String getEmail()             { return this.email;             }
    public String getNome()              { return this.nome;              }
    public String getPassword()          { return this.password;          }
    public String getMorada()            { return this.morada;            }
    public String getDataDeNascimento()  { return this.dataDeNascimento;  }
    
    
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
            && this.dataDeNascimento.equals(u.getDataDeNascimento());
    }
    
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("Email:"); string.append(this.email);
        string.append("Nome:"); string.append(this.nome);
        string.append("Password:"); string.append(this.password);
        string.append("Address:"); string.append(this.morada);
        string.append("DataDeNascimento:"); string.append(this.dataDeNascimento);
        
        return string.toString();
    }
    

    public abstract Utilizador clone();
}
