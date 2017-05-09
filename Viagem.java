import java.util.*;
import java.time.LocalDateTime;



public class Viagem
{
    double xInicial, yInicial, xFinal, yFinal;
    private double distanciaDaViagem;
    private double distanciaTaxiCliente;
    private double tempoEstimado;
    private double tempoReal;
    private double precoDaViagem;
    private int classificacaoDaViagem;
    private LocalDateTime data;


    public Viagem()
    {
        this.xInicial = 0.00; this.yInicial = 0.00;
        this.xFinal = 0.00; this.yFinal = 0.00;
        this.distanciaDaViagem = 0.00;
        this.distanciaTaxiCliente = 0.00;
        this.tempoEstimado = 0.00;
        this.tempoReal = 0.00;
        this.precoDaViagem = 0.00;
        this.classificacaoDaViagem = 0;
        this.data = LocalDateTime.now();
    }
    
    
    public Viagem(double pXInicial, double pYInicial, 
                  double pXFinal, double pYFinal, 
                  double pDistanciaDaViagem,
                  double pDistanciaTaxiCliente,
                  double pTempoEstimado, 
                  double pTempoReal, 
                  double pPrecoDaViagem, 
                  int pClassificacaoDaViagem)
    {
        this.xInicial = pXInicial; this.yInicial = pYInicial;
        this.xFinal = pXFinal; this.yFinal = pYFinal;
        this.distanciaDaViagem = pDistanciaDaViagem;
        this.distanciaTaxiCliente = pDistanciaTaxiCliente;
        this.tempoEstimado = pTempoEstimado;
        this.tempoReal = pTempoReal;
        this.precoDaViagem = pPrecoDaViagem;
        this.classificacaoDaViagem = pClassificacaoDaViagem;
        this.data = LocalDateTime.now();
    }
    
    
    public Viagem(Viagem v)
    {
        this.xInicial = getXInicial(); this.yInicial = getYInicial();
        this.xFinal = getXFinal(); this.yFinal = getYFinal();    
        this.distanciaDaViagem = v.getDistanciaDaViagem();
        this.distanciaTaxiCliente = v.getDistanciaTaxiCliente();
        this.tempoEstimado = v.getTempoEstimado();
        this.tempoReal = v.getTempoReal();
        this.precoDaViagem = v.getPrecoDaViagem();
        this.classificacaoDaViagem = v.getClassificacaoDaViagem();
        this.data = v.getData();
    }
    
    
    public double getXInicial()             { return this.xInicial;                 }
    public double getYInicial()             { return this.yInicial;                 }
    public double getXFinal()               { return this.xFinal;                   }
    public double getYFinal()               { return this.yFinal;                   } 
    public double getDistanciaDaViagem()    { return this.distanciaDaViagem;        }
    public double getDistanciaTaxiCliente() { return this.distanciaTaxiCliente;     }
    public double getTempoEstimado()        { return this.tempoEstimado;            }
    public double getTempoReal()            { return this.tempoReal;                }
    public double getPrecoDaViagem()        { return this.precoDaViagem;            }
    public int getClassificacaoDaViagem()   { return this.classificacaoDaViagem;    }
    public LocalDateTime getData()          { return this.data;                     }
    
    public void setXInicial(double pXInicial)                         { this.xInicial = pXInicial;       }
    public void setYInicial(double pYInicial)                         { this.yInicial = pYInicial;       }
    public void setXFinal(double pXFinal)                             { this.xFinal = pXFinal;           }
    public void setYFinal(double pYFinal)                             { this.yFinal = pYFinal;           }
    public void setDistanciaTaxiCliente(double pDistanciaTaxiCliente) { this.distanciaTaxiCliente = pDistanciaTaxiCliente; }
    
    
    public boolean equals(Object o)
    {
        if(this==o) {
            return true;
        }
        
        if (o == null) {
            return false;
        }
        
        if (getClass() != o.getClass()) {
            return false;
        }
        
        Viagem v = (Viagem) o;       
        return this.xInicial == v.getXInicial()
            && this.yInicial == v.getYInicial()
            && this.xFinal == v.getXFinal()
            && this.yFinal == v.getYFinal()
            && this.distanciaDaViagem == v.getDistanciaDaViagem()
            && this.distanciaTaxiCliente == v.getDistanciaTaxiCliente()
            && this.tempoEstimado == v.getTempoEstimado()
            && this.tempoReal == v.getTempoReal()
            && this.precoDaViagem == getPrecoDaViagem()
            && this.classificacaoDaViagem == v.getClassificacaoDaViagem();
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("xInicial: "); string.append(this.xInicial);
        string.append("yInicial: "); string.append(this.yInicial);
        string.append("xFinal: "); string.append(this.xFinal);        
        string.append("yFinal: "); string.append(this.yFinal);        
        string.append("DistanciaDaViagem: "); string.append(this.distanciaDaViagem);
        string.append("DistanciaTaxiCliente: "); string.append(this.distanciaTaxiCliente);
        string.append("TempoEstimado: "); string.append(this.tempoEstimado);
        string.append("TempoReal: "); string.append(this.tempoReal);
        string.append("PrecoDaViagem: "); string.append(this.precoDaViagem);
        string.append("ClassificacaoDaViagem: "); string.append(this.classificacaoDaViagem);
        string.append("Data:"); string.append(this.data.toString());
        
        return string.toString();
    }
    
    public Viagem clone()
    {
        return new Viagem(this);
    }
    
    
    public double calcularUmaDistancia(double pXInicial, double pYInicial, double pXFinal, double pYFinal)
    {
        double distancia = Math.sqrt(Math.pow((pXInicial - pXFinal), (double) 2) + Math.pow((pYInicial - pYFinal), 2));
        
        return distancia;
    }
}
