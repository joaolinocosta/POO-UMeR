import java.util.*;



public class Cliente extends Utilizador
{
    private List<Viagem> historicoDeViagens;
    
    public Cliente()
    {
        super();
        this.historicoDeViagens = new ArrayList<Viagem>();
    }
    
    
    public Cliente(String pEmail, String pNome, String pPassword, String pMorada, String pDataDeNascimento, double pX, double pY,List<Viagem> pHistoricoDeViagens)
    {
        super(pEmail, pNome, pPassword,pMorada,pDataDeNascimento,pX,pY);
        this.historicoDeViagens = new ArrayList<Viagem>(pHistoricoDeViagens);
    }
    
    
    public Cliente(Cliente c)
    {
        super(c.getEmail(),c.getNome(),c.getPassword(),c.getMorada(),c.getDataDeNascimento(),c.getX(),c.getY());
        this.historicoDeViagens = c.getHistoricoDeViagens();
    }
    
   
    public List<Viagem> getHistoricoDeViagens()      { return this.historicoDeViagens; }
    public void setHistoricoDeViagens(List<Viagem> l) {this.historicoDeViagens =l;}
    
    
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
        
        Cliente c = (Cliente) o;
        return  this.historicoDeViagens.equals(c.getHistoricoDeViagens());
    }
    
    
    public String toString()
    {
        StringBuilder string =  new StringBuilder(super.toString());
        string.append("HistoricoDeViagens: "); string.append(this.historicoDeViagens.toString()+"\n");
        
        return string.toString();
    }
    
    
    public Cliente clone()
    {
        return new Cliente(this);
    }
    /*
     public void chamarUmTaxiPorId(int Taxi_id) throws MotoristaExcepcoes
    {
        Motorista m = new Motorista();
        Viagem v = new Viagem();
        
        if (procuraCliente(pCliente)){
            pCliente.setX(pX);
            pCliente.setY(pY);
        
            m = procuraMotoristaPorKey(email);
            if (m != null) {
                if (!m.getEstaDisponivel()) {
                    throw new MotoristaExcepcoes ("O motorista nao esta disponivel!");
                } else {
                    v.setDistanciaTaxiCliente(v.calcularUmaDistancia(pCliente.getX(), pCliente.getY(), m.getX(), m.getY()));
                    System.out.println("Introduza as coordenadas de destino: ");
                    Scanner teclado = new Scanner(System.in);
                }
            }
        }
    }
    */
   
     
    public void chamaTaxiMaisProximo(Map<String,Motorista> m) throws NoMotoristaException
    {
       // m.entrySet().stream().filter(m1 -> m1.getValue().getEstaDisponivel() == true).forEach();
       HashMap<Double,Motorista> map = new HashMap<Double,Motorista>(); 
       Collection<Motorista> mot = m.values();
       mot.removeIf((Motorista m1) -> m1.getEstaDisponivel() == false);
       
       
       for(Iterator it = mot.iterator();it.hasNext();)
       {
           Motorista tmp = (Motorista)it.next();
           map.put(tmp.calculaDistancia(this.getX(),this.getY()),tmp);
       }
       
       if(map.keySet().isEmpty()) {throw new NoMotoristaException("Nenhum Motorista Disponivel");}
       double minv = Collections.min(map.keySet()); 
       Motorista m1 = map.get(minv);
       m1.setEstaDisponivel(false);
       m1.registarViagem(this);
       m1.moveTaxi(this.getX(),this.getY());
    }
}
