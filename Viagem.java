import java.util.*;
import java.time.LocalDateTime;



public class Viagem
{
    private double distancia;
    private double tempoEstimado;
    private double tempoReal;
    private double precoDaViagem;
    private int classificacaoDaViagem;
    private LocalDateTime data;


    public Viagem()
    {
        this.distancia = 0.00;
        this.tempoEstimado = 0.00;
        this.tempoReal = 0.00;
        this.precoDaViagem = 0.00;
        this.classificacaoDaViagem = 0;
        this.data = LocalDateTime.now();
    }
    
    
    public Viagem(double pDistancia, double pTempoEstimado, double pTempoReal, double pPrecoDaViagem, int pClassificacaoDaViagem)
    {
        this.distancia = pDistancia;
        this.tempoEstimado = pTempoEstimado;
        this.tempoReal = pTempoReal;
        this.precoDaViagem = pPrecoDaViagem;
        this.classificacaoDaViagem = pClassificacaoDaViagem;
        this.data = LocalDateTime.now();
    }
    
    
    public Viagem(Viagem v)
    {
        this.distancia = v.getDistancia();
        this.tempoEstimado = v.getTempoEstimado();
        this.tempoReal = v.getTempoReal();
        this.precoDaViagem = v.getPrecoDaViagem();
        this.classificacaoDaViagem = v.getClassificacaoDaViagem();
        this.data = v.getData();
    }
    

    public double getDistancia()            { return this.distancia; }
    public double getTempoEstimado()        { return this.tempoEstimado; }
    public double getTempoReal()            { return this.tempoReal; }
    public double getPrecoDaViagem()        { return this.precoDaViagem; }
    public int getClassificacaoDaViagem()   { return this.classificacaoDaViagem; }
    public LocalDateTime getData()          { return this.data; }
    
    
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
        return this.distancia == v.getDistancia()
            && this.tempoEstimado == v.getTempoEstimado()
            && this.tempoReal == v.getTempoReal()
            && this.precoDaViagem == getPrecoDaViagem()
            && this.classificacaoDaViagem == v.getClassificacaoDaViagem();
    }
    
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("Distancia: "); string.append(this.distancia);
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
}
