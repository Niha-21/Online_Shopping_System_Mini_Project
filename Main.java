import java.io.*;
import java.lang.*;
import java.util.*;
class Admin
{
String user,pass,item;
double price;
Admin()
{
}
void enter(String user,String pass)
{
  this.user=user;
  this.pass=pass; 
}
void display()
{
  System.out.println("pass:"+pass);
}
}


class Account extends Admin
{
int ano;
double bal;
String name;
Account(String name,int ano,double bal)
{
    this.name=name;
    this.ano=ano;
    this.bal=bal;
}
void shop(double total)
{
    bal=bal-total;
}
void display()
{
 System.out.println("Account Holder:"+name);
 System.out.println("Account No:"+ano);
 System.out.println("Balance"+bal);
}
    
}

class Customer extends Admin
{
String address,phone;
Customer(){}
Customer(String address,String phone)
{
  this.address=address;
  this.phone=phone;
}
void display()
{
  System.out.println("Address:"+address);
  System.out.println("Phone:"+phone);
} 
}

class Shopping extends Admin
{
int nop,flag=0;
String q[];
double cost[],total=0;
void addCart(String []a,double cost[],int nop)
{
  this.nop=nop;
  q=new String[nop];  
  this.cost=new double[nop];  
  if(nop!=0)
  flag=1;
  
  for(int i=0;i<nop;i++)
  {
  this.q[i]=a[i];
  this.cost[i]=cost[i];
  }
}
double bill()
{
    for(int i=0;i<nop;i++)
    total=total+cost[i];
    System.out.println("Total :"+"\t"+total);
    return total;
}
void display()
{
  if(flag==0)
    System.out.println("No items...!");
    else  {  
  System.out.println("Products purchased are:");
  System.out.println("NO. ITEMS     PRICE");
  for(int i=0;i<q.length;i++)
  {
  System.out.println((i+1)+".  "+q[i]+"      "+cost[i]);
  }
    }
} 
}

class order 
{
    void orderstatus()
    {
        System.out.println("Order Placed..!");
    }
}

class order_details extends order
{
    void exit()
    {
        System.out.println("Press 0 to exit");
    }
}

class Main
{
public static void main(String args[])
{
    int choice,count=0,qq;
    String s1,s2,go=" ",choice1="";
    int val;
    Scanner sc=new Scanner(System.in);
    Admin s[]=new Admin[5];
    Account a[]=new Account[5];
    // order o=new order();
    order_details od=new order_details();
    Shopping shop=new Shopping();
    Customer c=new Customer();
   
    String[] grains={"Wheat","jowar","bajra"};
    String[] books={"OOPM ","DS","DSGT"};
    String[] f={"Table","Chair","Shelf"};
    String list[]=new String[10];
    double gcost[]={500,600,590};
    double bcost[]={100,200.50,175.50};
    double fcost[]={1005,1000,1000};
    double cost[]=new double[10],b,total=0;
    int option,fcount=0;
                      
    do{
      System.out.println("1.Create Account:"+"\n"+"2.Authenticate and Shop"+"\n"+"3.Place Order"+"\n"+"4.Order Status");
      System.out.print("Enter choice:");
      choice=sc.nextInt();  
    switch(choice)
    {
    case 1: //system
          System.out.print("Enter the username :"+"\n");
          s1=sc.next();
          System.out.print("Enter the password :"+"\n");
          s2=sc.next();
          s[count]=new Admin();
          s[count].enter(s1,s2);
          
          //customer
          System.out.println("Enter your name :");
          s1=sc.next();
          System.out.println("Enter your account no :");
          qq=sc.nextInt();
          System.out.println("Enter Balance :");
          b=sc.nextDouble();
          a[count]=new Account(s1,qq,b);
          count++;
          break;
        
      
    case 2: //authenticate and shop
          try{
          System.out.println("Enter username and password:");
          s1=sc.next();
          s2=sc.next();
          for(int i=0;i<5;i++)
          if(s1.equals(s[i].user) && s2.equals(s[i].pass))      
          {
            System.out.println("Successfully Authenticated  ..!");
            
            do{
                      System.out.println("Enter choice:");
                      System.out.println("1.Grains:");
                      System.out.println("2.Books:");
                      System.out.println("3.Furniture:");
                      option=sc.nextInt();  
                    switch(option)
                    {
                      case 1: 
                       System.out.println("What you want:");
                          System.out.println("1.Wheat");
                          System.out.println("2.Bajra");
                          System.out.println("3.Jowar");
                        do{
                          val=sc.nextInt();
                          if(val<4)
                          {
                          
                          go=sc.next();
                          list[fcount]=grains[val-1];
                          cost[fcount]=gcost[val-1];
                          fcount++;
                          }
                        }while(go.equals("y"));  
                        
                          break;
                        
                      
                      case 2: 
                          System.out.println("What you want:");
                          System.out.println("1.OOPM");
                          System.out.println("2.DS");
                          System.out.println("3.DSGT");
                        do{
                          val=sc.nextInt();
                          if(val<4)
                          {
                          
                             go=sc.next();
                             list[fcount]=books[val-1];
                             cost[fcount]=bcost[val-1];
                             fcount++;
                          }
                        }while(go.equals("y"));  
                        
                          break;
                          
                      case 3: 
                
                          System.out.println("What you want:");
                          System.out.println("1.Table");
                          System.out.println("2.Chair");
                          System.out.println("3.Shelf");
                        do{
                          val=sc.nextInt();
                          if(val<4)
                          {
                          
                          list[fcount]=f[val-1];
                          cost[fcount]=fcost[val-1];
                            go=sc.next();
                            fcount++;
                          }
                        }while(go.equals("y"));  
                        
                        break;
                    }
                    }while(option!=0);
                     
                    
            System.out.println("Add to cart ? [y/n]"); 
          
            choice1=sc.next();
            if(choice1.equals("y"))
            {
                shop.addCart(list,cost,fcount);
                shop.display();
                total=shop.bill();
            }
            else
            {
                System.out.println("Items cancelled ...!!"); 
                break;
            }
              }
              }
              catch(Exception e)
              {}
            break;  
    
    case 3://place order
            int ano;
            String add,p;
            System.out.println("Address :");
            add=sc.next();
            System.out.println("Phone :");
            p=sc.next();
            c=new Customer(add,p);
            System.out.println("Enter AC no:");
            ano=sc.nextInt();
            for(int i=0;i<5;i++)
            {
                if(a[i].ano==ano)
                {
                a[i].shop(total);
                a[i].display();
                break;
                }
            }
            break;
            
    case 4://final
            od.orderstatus();
            
            shop.display();
            c.display();
            od.exit();
            break;
    }
    }while(choice!=0);
  
} 
}
















































