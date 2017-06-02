import java.util.*;
import java.time.LocalDateTime;
import java.lang.Math;


public class Viagem
{
    private double distanciaDaViagem;
    private double distanciaTaxiCliente;
    private double tempoEstimado;
    private double tempoReal;
    private double precoDaViagem;
    private int classificacaoDaViagem;
    private LocalDateTime data;


    public Viagem()
    {
        this.distanciaDaViagem = 0.00;
        this.distanciaTaxiCliente = 0.00;
        this.tempoEstimado = 0.00;
        this.tempoReal = 0.00;
        this.precoDaViagem = 0.00;
        this.classificacaoDaViagem = 0;
        this.data = LocalDateTime.now();
    }
    
    
    public Viagem(double pDistanciaDaViagem, double pDistanciaTaxiCliente, double pTempoEstimado, double pTempoReal, double pPrecoDaViagem, int pClassificacaoDaViagem)
    {
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
        this.distanciaDaViagem = v.getDistanciaDaViagem();
        this.distanciaTaxiCliente = v.getDistanciaTaxiCliente();
        this.tempoEstimado = v.getTempoEstimado();
        this.tempoReal = v.getTempoReal();
        this.precoDaViagem = v.getPrecoDaViagem();
        this.classificacaoDaViagem = v.getClassificacaoDaViagem();
        this.data = v.getData();
    }
    
    
    public double getDistanciaDaViagem()    { return this.distanciaDaViagem;        }
    public double getDistanciaTaxiCliente() { return this.distanciaTaxiCliente;     }
    public double getTempoEstimado()        { return this.tempoEstimado;            }
    public double getTempoReal()            { return this.tempoReal;                }
    public double getPrecoDaViagem()        { return this.precoDaViagem;            }
    public int getClassificacaoDaViagem()   { return this.classificacaoDaViagem;    }
    public LocalDateTime getData()          { return this.data;                     }
    
    public void setDistanciaDaViagem(double pD) {this.distanciaDaViagem = pD; }
    public void setDistanciaTaxiCliente(double pDistanciaTaxiCliente) { this.distanciaTaxiCliente = pDistanciaTaxiCliente; }
    public void setTempoEstimado(double time) {this.tempoEstimado = time; }
    public void setTempoReal(double tr) {this.tempoReal = tr; }
    public void setPrecoDaViagem(double pv) {this.precoDaViagem = pv; }
    public void setClassificacaoDaViagem(int c) {this.classificacaoDaViagem = c; }
    
    
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
        return this.distanciaDaViagem == v.getDistanciaDaViagem()
            && this.distanciaTaxiCliente == v.getDistanciaTaxiCliente()
            && this.tempoEstimado == v.getTempoEstimado()
            && this.tempoReal == v.getTempoReal()
            && this.precoDaViagem == getPrecoDaViagem()
            && this.classificacaoDaViagem == v.getClassificacaoDaViagem();
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();     
        string.append("Distância da viagem                  |   "); string.append(this.distanciaDaViagem); string.append("\n");
        string.append("Distância entre o taxi e o cliente   |   "); string.append(this.distanciaTaxiCliente); string.append("\n");
        string.append("Tempo estimado                       |   "); string.append(this.tempoEstimado); string.append("\n");
        string.append("Tempo real                           |   "); string.append(this.tempoReal); string.append("\n");
        string.append("Preço da viagem                      |   "); string.append(this.precoDaViagem); string.append("\n");
        string.append("Classificação da viagem              |   "); string.append(this.classificacaoDaViagem); string.append("\n");
        string.append("Data                                 |   "); string.append(this.data.toString()); string.append("\n");
        
        return string.toString();
    }
    
    public Viagem clone()
    {
        return new Viagem(this);
    }
    
    
    public double calcularDistancia(double xInicial, double yInicial, double xFinal, double yFinal)
    {
        double distancia = Math.sqrt(Math.pow((xInicial-xFinal), 2) + Math.pow((yInicial-yFinal),2));
        return distancia;
        
    }
}
