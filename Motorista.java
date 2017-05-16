import java.util.*;
import java.io.Serializable;


public class Motorista extends Utilizador implements Serializable 
{ 
    private int idTaxi;
    private double grauDeCumprimentoDoHorario;
    private double classificacaoDoMotorista;
    private List<Viagem> historicoDeViagens;
    private double totalKms;
    private boolean estaDisponivel;
    
    
    public Motorista()
    {
        super();
        this.idTaxi = 0;
        this.grauDeCumprimentoDoHorario = 0;
        this.classificacaoDoMotorista = 0;
        this.historicoDeViagens = new ArrayList<Viagem>();
        this.totalKms = 0;
        this.estaDisponivel = false;
    }

    
    public Motorista(String pEmail,
                    String pNome,
                    String pPassword,
                    String pMorada,
                    String pDataDeNascimento,
                    int pIdTaxi, 
                    double pX, 
                    double pY, 
                    double pGrauDeCumprimentoDoHorario, 
                    double pClassificacaoDoMotorista, 
                    //ArrayList<Viagem> pHistoricoDeViagens, 
                    double pTotalKms, 
                    boolean pEstaDisponivel)
    {
        super(pEmail,pNome,pPassword,pMorada,pDataDeNascimento,pX,pY);
        this.idTaxi = pIdTaxi;
        this.grauDeCumprimentoDoHorario = pGrauDeCumprimentoDoHorario;
        this.classificacaoDoMotorista = pClassificacaoDoMotorista;
        this.historicoDeViagens = new ArrayList<Viagem>();
        this.totalKms = pTotalKms; 
        this.estaDisponivel = pEstaDisponivel;
    }
    
    
    public Motorista(Motorista m)
    {
        super(m.getEmail(),m.getNome(),m.getPassword(),m.getMorada(),m.getDataDeNascimento(),m.getX(),m.getY());
        this.idTaxi = m.getIdTaxi();
        this.grauDeCumprimentoDoHorario = m.getGrauDeCumprimentoDoHorario();
        this.classificacaoDoMotorista = m.getClassificacaoDoMotorista();
        this.historicoDeViagens = m.getHistoricoDeViagens();
        this.totalKms = m.getTotalKms();
        this.estaDisponivel = m.getEstaDisponivel();
    }
    
    
    public int getIdTaxi()                            { return this.idTaxi;                     }
    public double getGrauDeCumprimentoDoHorario()     { return this.grauDeCumprimentoDoHorario; }
    public double getClassificacaoDoMotorista()       { return this.classificacaoDoMotorista;   }
    public List<Viagem> getHistoricoDeViagens()  { return this.historicoDeViagens;         }
    public double getTotalKms()                       { return this.totalKms;                   }
    public boolean getEstaDisponivel()                { return this.estaDisponivel;             }
    
    public void setIdTaxi(int id) { this.idTaxi = id;}
    public void setGrauDeCumormentoDoHorario(double g) { this.grauDeCumprimentoDoHorario = g;}
    public void setClassificacaoDoMotorista(double c) {this. classificacaoDoMotorista = c;}
    public void setHistoricoDeViagens(List<Viagem> l) {this. historicoDeViagens = l;}
    public void setTotalKms(double kms) {this.totalKms  = kms;}
    public void setEstaDisponivel(boolean b) {this.estaDisponivel  = b;}
    
    
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
        
        Motorista m = (Motorista) o;
        return this.idTaxi == m.getIdTaxi()
            && this.grauDeCumprimentoDoHorario == m.getGrauDeCumprimentoDoHorario()
            && this.classificacaoDoMotorista == m.getClassificacaoDoMotorista()
            && this.historicoDeViagens.equals(m.getHistoricoDeViagens())
            && this.totalKms == m.getTotalKms()
            && this.estaDisponivel == m.getEstaDisponivel();
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder(super.toString()); 
        string.append("TaxiID: "); string.append(this.idTaxi); string.append("\n");
        string.append("GrauDeCumprimentoDoHorario: "); string.append(this.grauDeCumprimentoDoHorario); string.append("\n");
        string.append("ClassificacaoDoMotorista: "); string.append(this.classificacaoDoMotorista); string.append("\n");
        string.append("HistoricoDeViagens: "); string.append(this.historicoDeViagens.toString()); string.append("\n");
        string.append("TotalKms: "); string.append(this.totalKms); string.append("\n");
        string.append("EstaDisponivel: "); string.append(this.estaDisponivel); string.append("\n");
        
       return string.toString();
    }
    
    
    public Motorista clone ()
    {
        return new Motorista(this);
    }
}
