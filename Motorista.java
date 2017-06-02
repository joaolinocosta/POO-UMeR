import java.util.*;
import java.io.Serializable;


public class Motorista extends Utilizador implements Serializable 
{ 
    private Veiculo taxi;
    private double grauDeCumprimentoDoHorario;
    private double classificacaoDoMotorista;
    private ArrayList<Viagem> historicoDeViagens;
    private double totalKms;
    private boolean estaDisponivel;
    
    
    public Motorista()
    {
        super();
        this.taxi = new CarroLigeiro();
        this.grauDeCumprimentoDoHorario = 100;
        this.classificacaoDoMotorista = 100;
        this.historicoDeViagens = new ArrayList<Viagem>();
        this.totalKms = 0;
        this.estaDisponivel = false;
    }

    
    public Motorista(String pEmail,
                    String pNome,
                    String pPassword,
                    String pMorada,
                    String pDataDeNascimento,
                    Veiculo Taxi, 
                    double pX, 
                    double pY, 
                    double pGrauDeCumprimentoDoHorario, 
                    double pClassificacaoDoMotorista, 
                    //ArrayList<Viagem> pHistoricoDeViagens, 
                    double pTotalKms, 
                    boolean pEstaDisponivel)
    {
        super(pEmail,pNome,pPassword,pMorada,pDataDeNascimento,pX,pY);
        this.taxi = Taxi;
        this.grauDeCumprimentoDoHorario = pGrauDeCumprimentoDoHorario;
        this.classificacaoDoMotorista = pClassificacaoDoMotorista;
        this.historicoDeViagens = new ArrayList<Viagem>();
        this.totalKms = pTotalKms; 
        this.estaDisponivel = pEstaDisponivel;
    }
    
    
    public Motorista(Motorista m)
    {
        super(m.getEmail(),m.getNome(),m.getPassword(),m.getMorada(),m.getDataDeNascimento(),m.getX(),m.getY());
        this.taxi = m.getTaxi();
        this.grauDeCumprimentoDoHorario = m.getGrauDeCumprimentoDoHorario();
        this.classificacaoDoMotorista = m.getClassificacaoDoMotorista();
        this.historicoDeViagens = m.getHistoricoDeViagens();
        this.totalKms = m.getTotalKms();
        this.estaDisponivel = m.getEstaDisponivel();
    }
    
    
    public Veiculo getTaxi()                            { return this.taxi;                     }
    public double getGrauDeCumprimentoDoHorario()     { return this.grauDeCumprimentoDoHorario; }
    public double getClassificacaoDoMotorista()       { return this.classificacaoDoMotorista;   }
    public ArrayList<Viagem> getHistoricoDeViagens()  { return this.historicoDeViagens;         }
    public double getTotalKms()                       { return this.totalKms;                   }
    public boolean getEstaDisponivel()                { return this.estaDisponivel;             }
    
    public void setTaxi(Veiculo v) { this.taxi = v;}
    public void setGrauDeCumormentoDoHorario(double g) { this.grauDeCumprimentoDoHorario = g;}
    public void setClassificacaoDoMotorista(double c) {this. classificacaoDoMotorista = c;}
    public void setHistoricoDeViagens(ArrayList<Viagem> l) {this. historicoDeViagens = l;}
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
        return this.taxi.equals(m.getTaxi())
            && this.grauDeCumprimentoDoHorario == m.getGrauDeCumprimentoDoHorario()
            && this.classificacaoDoMotorista == m.getClassificacaoDoMotorista()
            && this.historicoDeViagens.equals(m.getHistoricoDeViagens())
            && this.totalKms == m.getTotalKms()
            && this.estaDisponivel == m.getEstaDisponivel();
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder(super.toString()); 
        System.out.println("DADOS DO MOTORISTA");
        System.out.println("------------------------------------------------------------");        
        string.append("Grau de cumprimento do horário      |   "); string.append(this.grauDeCumprimentoDoHorario); string.append("\n");
        string.append("Classificação do motorista          |   "); string.append(this.classificacaoDoMotorista); string.append("\n");
        string.append("Histórico de viagens                |   "); string.append(this.historicoDeViagens.toString()); string.append("\n");
        string.append("Número total de kms                 |   "); string.append(this.totalKms); string.append("\n");
        string.append("O taxista está disponível?          |   "); string.append(this.estaDisponivel); string.append("\n");
        string.append(this.taxi.toString()); string.append("\n");
        
       return string.toString();
    }
    
    
    public Motorista clone ()
    {
        return new Motorista(this);
    }
    
    public void ficarDisponivel()
    {
        setEstaDisponivel(true);
        
       
    }
    
    public void ficarIndisponivel()
    {
        setEstaDisponivel(false);
    }
    
    public double calculaDistancia(double x,double y)
    {
        double distancia = Math.sqrt(Math.pow((this.getX() -x), (double) 2) + Math.pow((this.getY() - y), 2));
        
        return distancia;
    }
    
    public double calculaTempoViagem(double dis)
    {
        return dis/this.taxi.getVelocidadeMedia();
    }
    
    public double calculaPrecoViagem(double dis)
    {
        return dis*this.taxi.getPrecoBase();
    }
    
    public void registarViagem(Viagem v)
    {
        this.historicoDeViagens.add(v);
    }
    
    public void associaVeiculo(int id,HashMap<Integer,Veiculo> hm)
    {
        setTaxi(hm.get(id));
    }
    
    public void inserirVeiculo(HashMap<Integer,Veiculo> hm)
    {
     int id;
     String marca,modelo;
     double vm,pb;
     int c;
     String tipo;
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Qual o tipo de veiculo a inserir (9Lugares/Ligeiro/Moto)");
     tipo=sc.next();
     System.out.println("Marca do Veiculo");
     marca = sc.next();
     System.out.println("Modelo do Veiculo");
     modelo=sc.next();
     System.out.println("Velocidade Media");
     vm= sc.nextDouble();
     System.out.println("Preço Base por Km");
     pb=sc.nextDouble();
     System.out.println("Capacidade do Veiculo");
     c=sc.nextInt();
     
     Veiculo v=null;
     if(tipo.equals("9Lugares")) v = new CarroDe9Lugares(-1,marca,modelo,vm,pb,10,c,new ArrayList<Viagem>(),new ArrayList<Viagem>());
     else if(tipo.equals("Ligeiro")) v = new CarroLigeiro(-1,marca,modelo,vm,pb,10,c,new ArrayList<Viagem>(),new ArrayList<Viagem>());
     else if (tipo.equals("Moto"))v = new Moto(-1,marca,modelo,vm,pb,10,c,new ArrayList<Viagem>(),new ArrayList<Viagem>());
     else {System.out.println("Tipo do Veiculo desconhecido insira de novo"); return;}
     
     hm.put(v.getId(),v);
    }
    
    public void moveTaxi(double x,double y)
    {
        double d = calculaDistancia(x,y);
        this.setX(x); this.setY(y);
        this.totalKms+=d;
    }
    
    public void inserirNaFilaDeEspera (Viagem v)
    {
        this.getTaxi().esperaViagem(v);
    }
}
