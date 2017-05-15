
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
   public void main()
   {
     String[] s1 = {"Registar","Login"};
     String[] sc ={"Ver Perfil","Chamar Taxi mais proximo","Chamar taxi X","Classificar Motorista"};
     String[] sm ={"Ver Perfil","Inserir Veiculo","Associar a Veiculo"};
     Menu menui = new Menu(s1);
     Menu menuc = new Menu(sc);
     Menu menum = new Menu(sm);
     UMeR umer = new UMeR();
     int taxi_ids=0;
     char utl='0';
     int e_flag=0;
    
    
  
     do
     {
      try
      {
       umer.ler("out.ser");// n esta a funcionar
      }
      catch(IOException e)
      {
          e.printStackTrace();
      }
      menui.executa();      
      switch(menui.getOpcao())
      {
        
         
          case 1:try
                 {
                   taxi_ids=regista(umer,taxi_ids);
                 }
                 catch(RegisterException e)
                 {
                     System.out.println(e.getMessage());
                 }
                 break;
         
          case 2:try
                 {
                  utl=login(umer);
                 }
                 catch(LoginException e)
                 {
                     System.out.println(e.getMessage());
                     e_flag=1;
                 }
                 if(e_flag == 0)
                 {
                     if(utl=='M')
                     {
                         menum.executa();
                         switch(menum.getOpcao())
                         {
                             case 1: verPerfil(utl);
                                    break;
                         }
                     }
                     if(utl=='C')
                     {
                         menuc.executa();
                         switch(menuc.getOpcao())
                         {
                             case 1: verPerfil(utl);
                                    break;
                         }
                     }
                 }
                 break;
          
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
       String mail,nome,morada;
       String password,nascimento;
       char m;
       Scanner sc = new Scanner(System.in);
          
       System.out.print("Insira email:\n->>");
       mail=sc.next();
       System.out.print("Insira Nome\n->>");
       nome = sc.next();
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
                                  ,taxi_nr++,0,0,10,10,0,false);
            
            umer.getHashMapMotoristas().put(mail,novo);
        } 
        else if(m=='C' || m=='c')
        {
            Cliente novo = new Cliente(mail,nome,password,morada,nascimento,0,0,new ArrayList<Viagem>());
            
            umer.getHashMapClientes().put(mail,novo);
        }
        else System.out.println("Opçao invalida insira M/C");
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
             System.out.println("Login bem Sucedido");
             res='M';
           }
           else System.out.println("Password Errada tente de novo");
       }
       else if(umer.getHashMapClientes().containsKey(email))
       {
           if(umer.getHashMapClientes().get(email).getPassword().equals(password))
           {
               System.out.println("Login bem Sucedido");
               res='C';
           }
           else System.out.println("Password Errada tente de novo");
       }
       else throw new LoginException("Nao existe nenhuma conta com este Email");
       
       return res;
   }
   
   private void verPerfil(char m)
   {
       if(m=='C')
       {
           
       }
       else if(m=='M')
       {
           
       }
   }  
}