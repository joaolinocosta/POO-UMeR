
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Teste
{
   private String loged_id="";
   
   public void main()
   {
     String[] s1 ={"Registar","Login","Estatisticas"};
     String[] sc ={"Ver Perfil","Chamar Taxi mais proximo","Chamar taxi X","Classificar Motorista","Alterar Password"};
     String[] sm ={"Ver Perfil","Inserir Veiculo","Associar a Veiculo","Registar Viagem (Cliente)","Alterar Password","Calcular Preço de Viagem","Ficar Disponivel","Ficar Indisponivel"};
     String[] se ={"Total Facturado por Taxi entre (id_taxi,date,date)","Total Facturado por Empresa entre(empresa,date,date)",
                   "Top 10 Clientes","Top 5 motoristas com mais desvios"};
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
    
  
     do
     {/*
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
      }*/
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
                        { menum.executa();
                          switch(menum.getOpcao())
                          { 
                             case 1: System.out.println("\f");
                                     verPerfil(utl,umer);
                                     System.out.println("Pressione qualquer tecla+Enter para voltar ao Menu");
                                     s.next().charAt(0);
                                     break;
                             case 5:System.out.println("\f");
                                    System.out.println("Introduza nova Password");
                                    ch=s.next();
                                    umer.getHashMapMotoristas().get(this.loged_id).changePassword(ch);
                                    break;
                             case 7:umer.getHashMapMotoristas().get(this.loged_id).ficarDisponivel();
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
                                    
                             case 2:Cliente c = umer.getHashMapClientes().get(this.loged_id);
                                    try{c.chamaTaxiMaisProximo(umer.getHashMapMotoristas());}
                                    catch(NoMotoristaException e){e.getMessage();}
                                    break;
                             
                             case 5:System.out.println("\f");
                                    System.out.println("Introduza nova Password");
                                    ch=s.next();
                                    umer.getHashMapClientes().get(this.loged_id).changePassword(ch);
                                    break;
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
     /*
      try
     {
      umer.gravar("out.ser"); //n esta a funcionar
     } 
     catch(IOException e)
     {
         e.printStackTrace();
     }*/
   }
   
   private int  regista(UMeR umer,int taxi_nr) throws RegisterException
   {
       String mail,nome="",morada;
       String password,nascimento;
       char m;
       String a;
       Scanner sc = new Scanner(System.in);
          
       System.out.print("Insira email:\n->>");
       mail=sc.next();
       System.out.print("Insira Nome\n->>");// nao da meter nome com 2 palavras
       nome=sc.next();
       System.out.print("Insira password\n->>");
       password=sc.next();
       System.out.print("Insira Morada\n->>");
       morada = sc.next();
       System.out.print("Insira Data de Nascimento\n->>");
       nascimento = sc.next();
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
              System.out.println("Opçao invalida insira M/C");
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
}