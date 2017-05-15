import java.util.*;


public class Motorista extends Utilizador
{
    private int idTaxi;
    private double x, y;
    private double grauDeCumprimentoDoHorario;
    private double classificacaoDoMotorista;
    private ArrayList<Viagem> historicoDeViagens;
    private double totalKms;
    private boolean estaDisponivel;
    
    
    public Motorista()
    {
        super();
        this.idTaxi = 0;
        this.x = 0.00;
        this.y = 0.00;
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
        super(pEmail,pNome,pPassword,pMorada,pDataDeNascimento);
        this.idTaxi = pIdTaxi;
        this.x = pX;
        this.y = pY;
        this.grauDeCumprimentoDoHorario = pGrauDeCumprimentoDoHorario;
        this.classificacaoDoMotorista = pClassificacaoDoMotorista;
        this.historicoDeViagens = new ArrayList<Viagem>();
        this.totalKms = pTotalKms; 
        this.estaDisponivel = pEstaDisponivel;
    }
    
    
    public Motorista(Motorista m)
    {
        super(m);
        this.idTaxi = m.getIdTaxi();
        this.x = m.getX();
        this.y = m.getY();
        this.grauDeCumprimentoDoHorario = m.getGrauDeCumprimentoDoHorario();
        this.classificacaoDoMotorista = m.getClassificacaoDoMotorista();
        this.historicoDeViagens = m.getHistoricoDeViagens();
        this.totalKms = m.getTotalKms();
        this.estaDisponivel = m.getEstaDisponivel();
    }
    
    
    public int getIdTaxi()                            { return this.idTaxi;                     }
    public double getX()                              { return this.x;                          }
    public double getY()                              { return this.y;                          }
    public double getGrauDeCumprimentoDoHorario()     { return this.grauDeCumprimentoDoHorario; }
    public double getClassificacaoDoMotorista()       { return this.classificacaoDoMotorista;   }
    public ArrayList<Viagem> getHistoricoDeViagens()  { return this.historicoDeViagens;         }
    public double getTotalKms()                       { return this.totalKms;                   }
    public boolean getEstaDisponivel()                { return this.estaDisponivel;             }
    
    
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
            && this.x == m.getX()
            && this.y == m.getY()
            && this.grauDeCumprimentoDoHorario == m.getGrauDeCumprimentoDoHorario()
            && this.classificacaoDoMotorista == m.getClassificacaoDoMotorista()
            && this.historicoDeViagens.equals(m.getHistoricoDeViagens())
            && this.totalKms == m.getTotalKms()
            && this.estaDisponivel == m.getEstaDisponivel();
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder(); 
        string.append("TaxiID: "); string.append(this.idTaxi); string.append("\n");
        string.append("x: "); string.append(this.x);string.append("\n");
        string.append("y: "); string.append(this.y); string.append("\n");
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
