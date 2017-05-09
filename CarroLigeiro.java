import java.util.*;


public class CarroLigeiro extends Veiculo
{
    private ArrayList<Viagem> filaDeEspera;



    public CarroLigeiro()
    {
         super();
         this.filaDeEspera = new ArrayList<Viagem>();
    }
    
    
    public CarroLigeiro(Veiculo pVeiculo, ArrayList<Viagem> pFilaDeEspera)
    {
        super(pVeiculo);
        this.filaDeEspera = new ArrayList<Viagem>(pFilaDeEspera);
    }
    
    public CarroLigeiro(CarroLigeiro cl)
    {
        super(cl);
        this.filaDeEspera = cl.getFilaDeEspera();
    }
    

    public ArrayList<Viagem> getFilaDeEspera() { return this.filaDeEspera; }
    
    
    public CarroLigeiro clone()
    {
        return new CarroLigeiro(this);
    }
}