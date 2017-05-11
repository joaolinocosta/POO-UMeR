import java.util.*;
//11

public class CarroDe9Lugares extends Veiculo
{
    private ArrayList<Viagem> filaDeEspera;



    public CarroDe9Lugares()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public CarroDe9Lugares(Veiculo pVeiculo, ArrayList<Viagem> pFilaDeEspera)
    {
        super(pVeiculo);
        this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public CarroDe9Lugares(CarroDe9Lugares c9l)
    {
        super(c9l);
        this.filaDeEspera = c9l.getFilaDeEspera();
    }
    

    public ArrayList<Viagem> getFilaDeEspera() { return this.filaDeEspera; }
    
    
    public CarroDe9Lugares  clone()
    {
        return new CarroDe9Lugares(this);
    }
}
