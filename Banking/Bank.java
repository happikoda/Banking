import java.lang.*;
import java.util.*;
import java.io.Console;
class Bank
{
  int Pin;
  String Name;
  double balance;
  void createacc(int ac)
  {
    Console p=System.console();
    System.out.println("Enter your name : ");
    Scanner g=new Scanner(System.in);
    Name=g.nextLine();
    System.out.print("Enter your pin and do not share it with anyone :");
    char[] pass=p.readPassword();
    String ff=new String(pass);
    Pin=Integer.parseInt(ff);
    System.out.print("Add Money: Y/N");
    char s=g.next().charAt(0);
    if(s=='Y'|| s=='y')
    add();
    else
    balance=0;
    System.out.println();
    System.out.print("Account Created Successfully your Account No : "+ ac+"\n");
   }
   void withdraw()
   {
     Scanner g=new Scanner(System.in);
     System.out.println("Enter amount to be withdraw : ");
    double as=g.nextDouble();
     if(as>0)
     {
     balance=balance-as;
     System.out.println("Current Balance "+balance);
     }
     else
     System.out.println("Not sufficient fund");

   }
   void add()
   {

     Scanner g=new Scanner(System.in);
     System.out.println("Enter amount to be add : ");
     balance+=g.nextDouble();
     System.out.println("Successfully added");
   }

   void display(int i)
   {
     System.out.println();
     System.out.println(Name+"  Account No. "+ i );
     System.out.println();


     System.out.print("Balance : "+ balance +" INR");

     System.out.println();

   }
   void fundtransfer(double amount, Bank p,int c,int top)
  {
    if(c<=top)
    {
    if(amount>0 && balance>0)
    {
    p.balance+=amount;
    balance-=amount;
    System.out.println("Transaction Successfully");

  }
  else
  System.out.print("0 and negative values not accepted or Insuffiecient fund ");
  }
  else
  System.out.print("beneficiary account not exist ");



  }
}
class Main
{
  public static void main(String args[])
  {
     int top=0;

    Scanner g=new Scanner(System.in);
    Bank Cust[]=new Bank[100];
    for(int i=0;i<100;i++)
    Cust[i]=new Bank();
    while(true)
    {
      System.out.println();
      System.out.println("1.Create");
      System.out.println("2.Add");
      System.out.println("3.Display");
      System.out.println("4.Fund Transfer");
      System.out.println("5.Withdraw");
      System.out.println("6.Exit");
      int ch=g.nextInt();
      switch(ch)
      {
        case 1:

              Cust[top].createacc(top);
              top++;
              break;

         case 2:
                System.out.print("Enter your Account Number : ");
                int d=g.nextInt();
                System.out.print("Enter your Pin : ");
                int p=g.nextInt();
                if(Cust[d].Pin==p)
                 Cust[d].add();
                 else
                 System.out.print("Wrong Info input");
                 break;
          case 3 :
                      System.out.print("Enter your Account Number : ");
                int f=g.nextInt();
                System.out.print("Enter your Pin : ");
                int t=g.nextInt();
                if(Cust[f].Pin==t)
                 Cust[f].display(f);
                 else
                 System.out.print("Wrong Info input");
                 break;
            case 4:
                 System.out.print("Enter your Account Number : ");
                  d=g.nextInt();
                System.out.print("Enter your Pin : ");
                  p=g.nextInt();
                  System.out.print("Enter Beneficiary Account No. ");
                  int c=g.nextInt();
                 System.out.print("Enter amount to be send : ");
                  double rs=g.nextDouble();
                if(Cust[d].Pin==p)
                 Cust[d].fundtransfer(rs,Cust[c],c,top);
                 else
                 System.out.print("Wrong info input");
                 break;
            case 5:
              System.out.print("Enter your Account Number : ");
                int k=g.nextInt();
                System.out.print("Enter your Pin : ");
                int l=g.nextInt();
                if(Cust[k].Pin==l)
                 Cust[k].withdraw();
                 else
                 System.out.print("Wrong info input");
                 break;

            default :
              System.exit(0);

      }


    }



  }
}
