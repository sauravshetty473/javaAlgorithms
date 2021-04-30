package booths;


public class d2b {
    int a;
    int firstcounter;
    int i=4;
    int decimal=0;
    int finale;
    String finalanswer = new String("");

    d2b(int a){
        this.a= a;
        while((int)(a/Math.pow(2,i))!=0)
        {
            i *=2;
        }
        firstcounter = i;
        System.out.println("the binary value of "+a+" is "+ calculate());
    }

    int calculate()
    {
        i--;
        decimal += (int)(a/Math.pow(2,i));
        if(i==0)
        {
            return decimal;
        }
        a = (int) (a%(Math.pow(2,i)));
        decimal *=10;
        return calculate();
    }

    public static int calculateabs(int a)
    {
        int decimal = 0;
        int i=4;
        while((int)(a/Math.pow(2,i))!=0)
        {
            i *=2;
        }
        int firstcounter = i;
        return calculatenew(i,decimal,a);
    }

    public static int calculatenew(int i,int decimal , int a)
    {

        i--;
        decimal += (int)(a/Math.pow(2,i));
        if(i==0)
        {
            return decimal;
        }
        a = (int) (a%(Math.pow(2,i)));
        decimal *=10;
        return calculatenew(i , decimal ,a);
    }
}
