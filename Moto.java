import java.util.*;



public class Moto extends Veiculo
{
    private ArrayList<Viagem> filaDeEspera;



    public Moto()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public Moto(Veiculo pVeiculo, ArrayList<Viagem> pFilaDeEspera)
    {
        super(pVeiculo);
        this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public Moto(Moto m)
    {
        super(m);
        this.filaDeEspera = m.getFilaDeEspera();
    }
    

    public ArrayList<Viagem> getFilaDeEspera() { return this.filaDeEspera; }
    
    
    public Moto  clone()
    {
        return new Moto(this);
    }
}
