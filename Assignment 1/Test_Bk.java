class BankAccount{
    int ba_no ;
    String ba_name ;
    int currentbalance;
    double roi;

BankAccount()
{
    System.out.println("In default constuctor");
    this.ba_no = 1651561616;
    this.ba_name = "Prakash";
    this.currentbalance = 15000;
    this.roi = 9.5;
    
}
BankAccount(int bi, String s, int cb, double ri)
{
    System.out.println("this is parameterized constuctor");
    this.ba_no = bi;
    this.ba_name = s;
    this.currentbalance = cb;
    this.roi = ri;
}

void setba_id(int bi)
{
    System.out.println("In seteba_id");
    this.ba_no = bi;
}
void setba_name(String s )
{
     System.out.println("In setba_name");
    this.ba_name = s;
}
void setcurrentbalance(int cb)
{
    System.out.println("In setcurrentbalance");
    this.currentbalance = cb;
}
void setiroi(int ri)
{
    System.out.println("In setroi");
    this.roi = ri;
}

int getba_ba()
{
    return this.ba_no;
}
String getba_name()
{
    return this.ba_name;
}
int getcurrentbalance()
{
    return this.currentbalance;
}
double  getroi()
{
    return this.roi;
}

void display()
{
   System.out.println("Account number  is "+ this.ba_no);
    System.out.println("Account holder  name  is "+ this.ba_name);
     System.out.println("currennt balance is "+ this.currentbalance);
      System.out.println("rate of interest is " + this.roi);
    System.out.println();

}
}
class Test_Bk
{
    public static void main(String args[])
    {
        BankAccount bk1;
        BankAccount bk2;
        bk1 = new BankAccount(899744566,"Rane",450000,9.3); // Parameterized
       // bk1.setba_id(001);
        //bk1.setba_name("Ranveer");
        //bk1.setcurrentbalance(55000);
        //bk1.setroi(8.8);
        //System.out.println(bk1.ba_id);
         //System.out.println(bk1.ba_name);
        //System.out.println(bk1.currentbalance);
        //System.out.println(bk1.roi);
        bk1.display();
        bk2 = new BankAccount();
        bk2.display();
        
    }
}
