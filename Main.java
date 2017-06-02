
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.time.LocalDateTime;
import java.lang.ClassNotFoundException;

public class  Main
{
   private String loged_id = "";
   private Motorista m;
   private Cliente c;
   private Viagem v;
   private double x;
   private double y;
   private double distancia;
   private double cmpDistancia;
   private double tempoEstimado;
   private boolean flagInicial;
   
   
   public void main()
   {
     String[] s1 ={"Registar","Login","Estatisticas"};
     String[] sc ={"Ver Perfil","Chamar Taxi mais proximo","Chamar taxi X","Classificar Motorista","Alterar Password"};
     String[] sm ={"Ver Perfil","Inserir Veiculo","Associar a Veiculo","Registar Viagem (Cliente)","Alterar Password","Calcular Preço de Viagem","Ficar Disponivel","Ficar Indisponivel"};
     String[] se ={"Total Facturado por Taxi entre (id_taxi,date,date)","Total Facturado por Empresa entre(empresa,date,date)",
                   "Top 10 Clientes","Top 5 motoristas com mais desvios"};
     
         /* Motorista 1 Teste (sem file de espera) */
     ArrayList<Viagem> hv1 = new ArrayList<Viagem>();
     ArrayList<Viagem> fe1 = new ArrayList<Viagem>();
     CarroLigeiro cl1 = new CarroLigeiro(1, "marca1", "modelo1", 70.50, 4.50, 100, 4, hv1, fe1);
     Motorista m1 = new Motorista("m1@gmail.com", "m1", "123", "Rua 1", "01.01.1970", cl1, 2.00, 2.00, 100, 100, 0.00, false);
     
     /* Motorista 2 Teste (sem file de espera) */
     ArrayList<Viagem> hv2 = new ArrayList<Viagem>();
     ArrayList<Viagem> fe2 = new ArrayList<Viagem>();
     CarroLigeiro cl2 = new CarroLigeiro(2, "marca2", "modelo2", 65.00, 4.30, 100, 4, hv2, fe2);
     Motorista m2 = new Motorista("m2@gmail.com", "m2", "123", "Rua 2", "02.02.1980", cl2, 0.00, 0.00, 100, 100, 0.00, false);
     
     /* Motorista 3 Teste (sem file de espera) */
     ArrayList<Viagem> hv3 = new ArrayList<Viagem>();
     ArrayList<Viagem> fe3 = new ArrayList<Viagem>();
     CarroDe9Lugares c9l1 = new CarroDe9Lugares(3, "marca3", "modelo3", 61.40, 3.20, 100, 9, hv3, fe3);
     Motorista m3 = new Motorista("m3@gmail.com", "m3", "123", "Rua 3", "03.03.1975", c9l1, 0.00, 0.00, 100, 100, 0.00, false);
     
     /* Motorista 4 Teste (sem file de espera) */
     ArrayList<Viagem> hv4 = new ArrayList<Viagem>();
     ArrayList<Viagem> fe4 = new ArrayList<Viagem>();
     Moto mc1 = new Moto(4, "marca4", "modelo4", 78.00, 2.95, 100, 1, hv4, fe4);
     Motorista m4 = new Motorista("m4@gmail.com", "m4", "123", "Rua 4", "04.04.1967", mc1, 0.00, 0.00, 100, 100, 0.00, false);
     
     /* Cliente 1 Teste*/
     ArrayList<Viagem> hv5 = new ArrayList<Viagem>();
     
     Cliente c1 = new Cliente("c1@gmail.com", "c1", "123", "Rua 5", "02.05.1988", 0.00, 0.00, hv5);

     /* Cliente 2 Teste*/
     ArrayList<Viagem> hv6 = new ArrayList<Viagem>();
     Cliente c2 = new Cliente("c2@gmail.com", "c2", "123", "Rua 6", "19.09.1978", 0.00, 0.00, hv6);     
     
     /* Cliente 3 Teste*/
     ArrayList<Viagem> hv7 = new ArrayList<Viagem>();
     Cliente c3 = new Cliente("c3@gmail.com", "c3", "123", "Rua 7", "30.11.1992", 0.00, 0.00, hv7);

     /* Cliente 4 Teste*/
     ArrayList<Viagem> hv8 = new ArrayList<Viagem>();
     Cliente c4 = new Cliente("c4@gmail.com", "c4", "123", "Rua 8", "13.02.1984", 0.00, 0.00, hv8); 
                   
     Menu menui = new Menu(s1);
     Menu menuc = new Menu(sc);
     Menu menum = new Menu(sm);
     Menu menue = new Menu(se);
     UMeR umer = new UMeR();
     //Utilizador utl_act; 
     Scanner s = new Scanner(System.in);
     int taxi_ids=0;
     char utl='0';
     int e_flag=0;
     String ch;
    
     try
      {
       umer=umer.ler("out.ser");// n esta a funcionar
      }
      catch(IOException e)
      {
          e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
          e.printStackTrace();
        }
//      try
//      {
//          registaMotoristaTeste(umer, m1);
//          registaMotoristaTeste(umer, m2);
//          registaMotoristaTeste(umer, m3);
//          registaMotoristaTeste(umer, m4);
//          registaClienteTeste(umer, c1);
//          registaClienteTeste(umer, c2);
//          registaClienteTeste(umer, c3);
//          registaClienteTeste(umer, c4);
//      }
//      catch(RegisterException e)
//      {
//          System.out.println("\f");
//          System.out.println(e.getMessage());
//          try
//          {
//              Thread.sleep(2000);
//          }
//          catch(InterruptedException e1){Thread.currentThread().interrupt();}
//      }
     do
     {

      menui.executa();   
      switch(menui.getOpcao())
      {
         
          case 1:System.out.println("\f");
                 try
                 {
                   taxi_ids=regista(umer,taxi_ids);
                 }
                 catch(RegisterException e)
                 {
                   System.out.println("\f");
                   System.out.println(e.getMessage());
                   try
                   {
                     Thread.sleep(2000);
                   }
                   catch(InterruptedException e1){Thread.currentThread().interrupt();}
                 }
                 break;
         
          case 2: System.out.println("\f");
                 try
                 {
                  utl=login(umer);
                 }
                 catch(LoginException e)
                 {
                   System.out.println("\f");
                   System.out.println(e.getMessage());
                     try
                    {
                      Thread.sleep(2000);
                    }
                   catch(InterruptedException e1){Thread.currentThread().interrupt();}
                   e_flag=1;
                 }
                 if(e_flag == 0)
                 {
                     if(utl=='M')
                     {
                        
                        do
                        { 
                          menum.executa();
                          switch(menum.getOpcao())
                          { 
                             case 1: 
                                     System.out.println("\f");
                                     verPerfil(utl,umer);
                                     System.out.println("Pressione a tecla 'q' para voltar ao menú anterior.");
                                     while(s.next().charAt(0) != 'q')
                                     {
                                         ;
                                     }
                                     break;
                             case 5:System.out.println("\f");
                                    System.out.println("Introduza nova Password");
                                    ch=s.next();
                                    umer.getHashMapMotoristas().get(this.loged_id).changePassword(ch);
                                    break;
                             case 7:
                                    System.out.println("Introduza as suas coordenadas:");
                                    System.out.print("x ");
                                    ch = s.next();
                                    umer.getHashMapMotoristas().get(this.loged_id).setX(Double.parseDouble(ch));
                                    System.out.print("y ");
                                    ch = s.next();
                                    umer.getHashMapMotoristas().get(this.loged_id).setY(Double.parseDouble(ch));
                                    umer.getHashMapMotoristas().get(this.loged_id).ficarDisponivel();
                                    break;
                                    
                             case 8:umer.getHashMapMotoristas().get(this.loged_id).ficarIndisponivel();
                                    break;
                          }
                        }while(menum.getOpcao()!=0);
                     }
                     if(utl=='C')
                     {
                         do
                         {
                           menuc.executa();
                           switch(menuc.getOpcao())
                           {
                             case 1:System.out.println("\f"); 
                                    verPerfil(utl,umer);
                                    System.out.println("Pressione qualquer tecla+Enter para Voltar ao Menu");
                                    s.next().charAt(0); 
                                    break;
                                    
                             case 2:
                                    Cliente c = umer.getHashMapClientes().get(this.loged_id);
                                    Viagem v = new Viagem();
                                    Motorista m = new Motorista();       
                                    double x = c.getX(); double y = c.getY();
                                    double distancia = 0;
                                    double cmpDistancia = 0;
                                    boolean flagInicial = true;  
                                    Iterator it = umer.getHashMapMotoristas().entrySet().iterator();
                                    
                                    while (it.hasNext()) {
                                        Map.Entry me = (Map.Entry)it.next();
                                        m = (Motorista) me.getValue();
                                        
                                        /* verifica se um motorista está de serviço */
                                        if (m.getEstaDisponivel())
                                        {  
                                            if (flagInicial)
                                            {
                                                cmpDistancia = v.calcularDistancia(x, y, m.getX(), m.getY());
                                                distancia = cmpDistancia;
                                                it.remove(); 
                                                flagInicial = false;
                                            } else {
                                                cmpDistancia = v.calcularDistancia(x, y, m.getX(), m.getY());
                                                if (distancia > cmpDistancia)
                                                {
                                                    distancia = cmpDistancia;
                                                }
                                                it.remove(); 
                                            }
                                        }
                                    }
                                    
                                    /* distância entre o cliente e o táxi mais próximo já calculada */
                                    v.setDistanciaTaxiCliente(distancia);
                                    
                                    /* calcular a distância total da viagem (taxi-cliente + destino desejado) */
                                    System.out.println("Introduza as coordenadas de destino");
                                    System.out.print("x "); ch = s.next(); x = Double.parseDouble(ch); 
                                    System.out.print("y "); ch = s.next(); y = Double.parseDouble(ch); 
                                    v.setDistanciaDaViagem(distancia + v.calcularDistancia(x, y, c.getX(), c.getY()));
                                    
                                    /* calcular o tempo estimado da viagem */
                                    tempoEstimado = (v.getDistanciaDaViagem() * 60)/m.getTaxi().getVelocidadeMedia();
                                    v.setTempoEstimado(tempoEstimado);
                                    
                                    /* calcular preço da viagem */
                                    v.setPrecoDaViagem(m.getTaxi().getPrecoBase()*v.getDistanciaDaViagem());
                                    
                                    /* classificar o motorista */
                                    System.out.println("\f");
                                    System.out.print("Classificação do motorista(0-100) ");
                                    ch=s.next();
                                    v.setClassificacaoDaViagem(Integer.parseInt(ch));
                                    
                                    /* verificar se o motorista tem fila de espera */
                                    if (m.getTaxi().getFilaDeEspera() == null) 
                                    {
                                        c.registarViagem(v);
                                        m.registarViagem(v);
                                        m.setX(x); m.setY(y);
                                        System.out.println("\f");
                                        verViagem(v);
                                        System.out.println("Pressione a tecla 'q' para voltar ao menú anterior.");
                                    } else {
                                        m.inserirNaFilaDeEspera(v);
                                        LocalDateTime ldt = m.getTaxi().getFilaDeEspera().get(0).getData();
                                    }
                                    
                                    while(s.next().charAt(0) != 'q')
                                    {
                                        ;
                                    }
                                    
                                    break;
                                    
                             case 3:
                                    c = umer.getHashMapClientes().get(this.loged_id);
                                    System.out.println("\f");                                        
                                    System.out.print("Introduza o id do motorista ");
                                    ch=s.next();
                                    v = new Viagem();
                                    m = new Motorista(umer.getHashMapMotoristas().get(ch));       
                                    x = c.getX();
                                    y = c.getY();
                                    distancia = 0;
                                    flagInicial = true;
                                    distancia = v.calcularDistancia(x, y, m.getX(), m.getY());
                                    v.setDistanciaTaxiCliente(distancia);
                                    System.out.println("Introduza as coordenadas de destino");
                                    System.out.print("x ");
                                    ch = s.next();
                                    x = Double.parseDouble(ch);
                                    System.out.print("y ");
                                    ch = s.next();
                                    y = Double.parseDouble(ch);
                                    v.setDistanciaDaViagem(distancia + v.calcularDistancia(x, y, c.getX(), c.getY()));
                                    tempoEstimado = (v.getDistanciaDaViagem() * 60)/m.getTaxi().getVelocidadeMedia();
                                    v.setTempoEstimado(tempoEstimado);
                                    v.setPrecoDaViagem(m.getTaxi().getPrecoBase()*v.getDistanciaDaViagem());
                                    System.out.println("\f");
                                    System.out.print("Classificação do motorista(0-100) ");
                                    ch=s.next();
                                    v.setClassificacaoDaViagem(Integer.parseInt(ch));
                                    c.registarViagem(v);
                                    m.registarViagem(v);
                                    m.setX(x); m.setY(y);
                                    System.out.println("\f");
                                    verViagem(v);
                                    System.out.println("Pressione a tecla 'q' para voltar ao menú anterior.");
                                    while(s.next().charAt(0) != 'q')
                                    {
                                        ;
                                    }

                                    break;                                    
                             case 4:
                                    System.out.println("\f");
                                    System.out.print("Classificação do motorista(0-100) ");
                                    ch=s.next();
                                    //v.setClassificacaoDaViagem(Integer.parseInt(ch));
                                    //umer.updateDaViagem();
                                    break;
                                    
                             case 5:System.out.println("\f");
                                    System.out.println("Introduza nova Password");
                                    ch=s.next();
                                    umer.getHashMapClientes().get(this.loged_id).changePassword(ch);
                                    break;
                                    
                             case 6:
                                    c = umer.getHashMapClientes().get(this.loged_id);
                                    System.out.println("\f");
                                    System.out.println("Histórico de viagens");
                                    System.out.println("--------------------");
                                    c.imprimirHistoricoDeViagens();
                                    System.out.println("Pressione a tecla 'q' para voltar ao menú anterior.");
                                    while(s.next().charAt(0) != 'q')
                                    {
                                        ;
                                    }
                          }
                        }while(menuc.getOpcao()!=0);
                     }
                 }
                 break;
                 
                 case 3:
                       do
                       {
                         menue.executa();
                         switch(menue.getOpcao())
                         {
                           case 1:
                                  break;
                         }
                       }while(menue.getOpcao()!=0);
                         
          }
      }while(menui.getOpcao()!=0);
     
      try
     {
      umer.gravar("out.ser"); //n esta a funcionar
     } 
     catch(IOException e)
     {
         e.printStackTrace();
     }
   }
   
   private int  regista(UMeR umer,int taxi_nr) throws RegisterException
   {
       char m;
       String a;
       Scanner sc = new Scanner(System.in);
       Scanner sc1 = new Scanner(System.in);
          
       System.out.print("Insira email:\n->>");
       String mail=sc.nextLine();
       System.out.print("Insira Nome\n->>");// nao da meter nome com 2 palavras
       String nome=sc.nextLine();
       System.out.print("Insira password\n->>");
       String password=sc1.next();
       System.out.print("Insira Morada\n->>");
       String morada = sc.nextLine();
       System.out.print("Insira Data de Nascimento\n->>");
       String nascimento = sc.nextLine();
       System.out.print("Registar-se como Mototista(M) ou Cliente(C)\n->>");
       m=sc.next().charAt(0);
       
       if(umer.getHashMapMotoristas().containsKey(mail) || umer.getHashMapClientes().containsKey(mail))
        throw  new RegisterException("Ja existe uma conta com este Email Faca Login");
       else
       {
        if(m == 'M'|| m=='m')
        {
            Motorista novo = new Motorista(mail,nome,password,morada,nascimento
                                  ,new CarroLigeiro(),0,0,10,10,0,false);
            umer.insereMotorista(novo);
        } 
        else if(m=='C' || m=='c')
        {
            Cliente novo = new Cliente(mail,nome,password,morada,nascimento,0,0,new ArrayList<Viagem>());
            
            umer.insereCliente(novo);
        }
        else {
              System.out.println("\f");
              System.out.println("Opçao invalida insira Motorista ou Cliente");
              try
              {
                  Thread.sleep(3000);
              }
              catch(InterruptedException e){Thread.currentThread().interrupt();}
             }
       }
       
       return taxi_nr;
   }

  
   private char login(UMeR umer) throws LoginException
   {
       String email;
       String password;
       Scanner sc = new Scanner(System.in);
       char res = '0';
       
       System.out.print("Email:");
       email=sc.next();
       System.out.print("Password:");
       password = sc.next();
       
       if(umer.getHashMapMotoristas().containsKey(email))
       {
           if(umer.getHashMapMotoristas().get(email).getPassword().equals(password))
           {
             System.out.println("\f");
             System.out.println("Login bem Sucedido");
             try
             {
                  Thread.sleep(500);
             }
             catch(InterruptedException e){Thread.currentThread().interrupt();}
             res='M';
             this.loged_id=email;
           }
           else
           { 
             System.out.println("\f");
             System.out.println("Password Errada tente de novo");
             try
              {
                  Thread.sleep(2000);
              }
              catch(InterruptedException e){Thread.currentThread().interrupt();}
           }
       }
       else if(umer.getHashMapClientes().containsKey(email))
       {
           if(umer.getHashMapClientes().get(email).getPassword().equals(password))
           {
             System.out.println("\f");
             System.out.println("Login bem Sucedido");
             try
             {
                  Thread.sleep(500);
             }
             catch(InterruptedException e){Thread.currentThread().interrupt();}
             res='C';
             this.loged_id=email;
           }
           else 
           {
             System.out.println("\f");
             System.out.println("Password Errada tente de novo");
             try
              {
                  Thread.sleep(2000);
              }
              catch(InterruptedException e){Thread.currentThread().interrupt();}
           }
       }
       else throw new LoginException("Nao existe nenhuma conta com este Email");
       
       return res;
   }
   
   private void verPerfil(char m,UMeR umer)
   {
       if(m=='C')
       {
           if(umer.getHashMapClientes().containsKey(this.loged_id) == false)
               System.out.println("Merda");
           
           Cliente c = umer.getHashMapClientes().get(this.loged_id);
           
           System.out.println(c.toString());
       }
       else if(m=='M')
       {
            if(umer.getHashMapMotoristas().containsKey(this.loged_id) == false)
               System.out.println("Merda");
           
           Motorista mo = umer.getHashMapMotoristas().get(this.loged_id);
           
           System.out.println(mo.toString());
           
       }
   }
   
      private void registaMotoristaTeste(UMeR umer, Motorista m) throws RegisterException
   {
       if(umer.getHashMapMotoristas().containsKey(m.getEmail()))
       {
           throw  new RegisterException("Já existe um utilizador registado com o mesmo email. Tente novamente.");
       } else {
            umer.insereMotorista(m);
       }
   }
   
   private void registaClienteTeste(UMeR umer, Cliente c) throws RegisterException
   {
       if(umer.getHashMapClientes().containsKey(c.getEmail()))
       {
           throw  new RegisterException("Já existe um utilizador registado com o mesmo email. Tente novamente.");
       } else {
            umer.insereCliente(c);
       }
   }
   
      private void verViagem(Viagem v)
   {
       System.out.println(v.toString());
   }
}