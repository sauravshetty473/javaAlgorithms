package booths;
import java.util.*;

public class booths {
    int Mbinary;
    int Qbinary;
    int Qreg=0;
    int count;
    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> M = new ArrayList<Integer>();
    ArrayList<Integer> Q = new ArrayList<Integer>();
    ArrayList<Integer> Mminus = new ArrayList<Integer>();
    int nM;
    int nQ;


    booths()
    {
        System.out.println("Enter multiplicand and multiplier");
        Scanner sc = new Scanner(System.in);
        int multiplicand = sc.nextInt();
        int multiplier = sc.nextInt();
        this.Mbinary = d2b.calculateabs(Math.abs(multiplicand));                 //calculating binary equivalents

        this.Qbinary =d2b.calculateabs(Math.abs(multiplier));
        this.nM = Comp2s.nofdigits(Mbinary);
        this.nQ =Comp2s.nofdigits(Qbinary);


        int i=( nM+ 1);                   // in both case 1 must be added since M -M both needs to be calculated
        int j= ( nQ + 1 );

        this.count = Math.max(i,j);                                              //to find count


        if(multiplicand>0)
        {
            this.Mminus = Comp2s.calculate(count , Math.abs(multiplicand));
            this.M = Comp2s.addExtrabits(count , Math.abs(multiplicand));
        }
        else
        {
            this.M = Comp2s.calculate(count , Math.abs(multiplicand));
            this.Mminus = Comp2s.addExtrabits(count , Math.abs(multiplicand));
        }


        this.Q = multiplier > 0 ? Comp2s.addExtrabits(count, Math.abs(multiplier)) : Comp2s.calculate(count, Math.abs(multiplier));
        this.A = Comp2s.addExtrabits(count,0);

        int newcount = count;


        System.out.println("     "+"M"+" ".repeat(newcount*3+3)+ "A"+" ".repeat(newcount*3+3) + "Q"+" ".repeat(newcount*3+3) + "Q\u2080"+" ".repeat(3)+"Steps");

        while(count>0)
        {
            System.out.println("");
            booths.print(M,Q,A,Qreg,count,2);
            if(count==newcount){
                System.out.println("Initialisation");
            }
            else
            {
                System.out.println("decrement count");
            }



            switch (Q.get(Q.size() - 1) * 10 + Qreg) {
                case 10 -> {

                    A = add(A, Mminus);
                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("subtract M from A and store in A");
                    A.add(0, A.get(0));
                    Q.add(0, A.get(A.size() - 1));
                    Qreg = Q.get(Q.size() - 1);
                    A.remove(A.size() - 1);
                    Q.remove(Q.size() - 1);

                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("Arithmetic shift right");
                }
                case 1 -> {

                    A = add(A, M);
                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("add A to M and store in A");
                    A.add(0, A.get(0));
                    Q.add(0, A.get(A.size() - 1));
                    Qreg = Q.get(Q.size() - 1);
                    A.remove(A.size() - 1);
                    Q.remove(Q.size() - 1);

                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("Arithmetic shift right");
                }
                default -> {
                    A.add(0, A.get(0));
                    Q.add(0, A.get(A.size() - 1));
                    Qreg = Q.get(Q.size() - 1);
                    A.remove(A.size() - 1);
                    Q.remove(Q.size() - 1);

                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("Arithmetic shift right");
                }
            }
            count--;
        }


        System.out.println(" ");
        booths.print(M,Q,A,Qreg,count,2);
        System.out.println("decrement count");


        System.out.println(interpret(A,Q,newcount));

    }













    booths(int count)                      //if we know count
    {
        System.out.println("Enter multiplicand and multiplier");
        Scanner sc = new Scanner(System.in);
        int multiplicand = sc.nextInt();
        int multiplier = sc.nextInt();
        this.Mbinary = d2b.calculateabs(Math.abs(multiplicand));                 //calculating binary equivalents

        this.Qbinary =d2b.calculateabs(Math.abs(multiplier));
        this.nM = Comp2s.nofdigits(Mbinary);
        this.nQ =Comp2s.nofdigits(Qbinary);


        int i=( nM+ 1);                   // in both case 1 must be added since M -M both needs to be calculated
        int j= ( nQ + 1 );

        this.count = count;


        if(multiplicand>0)
        {
            this.Mminus = Comp2s.calculate(count , Math.abs(multiplicand));
            this.M = Comp2s.addExtrabits(count , Math.abs(multiplicand));
        }
        else
        {
            this.M = Comp2s.calculate(count , Math.abs(multiplicand));
            this.Mminus = Comp2s.addExtrabits(count , Math.abs(multiplicand));
        }


        this.Q = multiplier > 0 ? Comp2s.addExtrabits(count, Math.abs(multiplier)) : Comp2s.calculate(count, Math.abs(multiplier));
        this.A = Comp2s.addExtrabits(count,0);

        int newcount = count;


        System.out.println("     "+"M"+" ".repeat(newcount*3+3)+ "A"+" ".repeat(newcount*3+3) + "Q"+" ".repeat(newcount*3+3) + "Q\u2080"+" ".repeat(3)+"Steps");

        while(count>0)
        {
            System.out.println("");
            booths.print(M,Q,A,Qreg,count,2);
            if(count==newcount){
                System.out.println("Initialisation");
            }
            else
            {
                System.out.println("decrement count");
            }



            switch (Q.get(Q.size() - 1) * 10 + Qreg) {
                case 10 -> {

                    A = add(A, Mminus);
                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("subtract M from A and store in A");
                    A.add(0, A.get(0));
                    Q.add(0, A.get(A.size() - 1));
                    Qreg = Q.get(Q.size() - 1);
                    A.remove(A.size() - 1);
                    Q.remove(Q.size() - 1);

                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("Arithmetic shift right");
                }
                case 1 -> {

                    A = add(A, M);
                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("add A to M and store in A");
                    A.add(0, A.get(0));
                    Q.add(0, A.get(A.size() - 1));
                    Qreg = Q.get(Q.size() - 1);
                    A.remove(A.size() - 1);
                    Q.remove(Q.size() - 1);

                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("Arithmetic shift right");
                }
                default -> {
                    A.add(0, A.get(0));
                    Q.add(0, A.get(A.size() - 1));
                    Qreg = Q.get(Q.size() - 1);
                    A.remove(A.size() - 1);
                    Q.remove(Q.size() - 1);

                    booths.print(M, Q, A, Qreg, count, 1);
                    System.out.println("Arithmetic shift right");
                }
            }
            count--;
        }


        System.out.println(" ");
        booths.print(M,Q,A,Qreg,count,2);
        System.out.println("decrement count");


        System.out.println(interpret(A,Q,newcount));


    }





    public static ArrayList<Integer> add(ArrayList<Integer> first , ArrayList<Integer> second)
    {

        int carry = 0;

        for(int i=first.size()-1 ; i>=0 ;i--)
        {

            switch (carry + first.get(i) + second.get(i))                       //not to modify second
            {

                case 1:


                    if(carry==1)
                    {
                        carry=0;
                        first.set(i ,1);
                    }
                    else
                    {
                        first.set(i ,1);
                    }
                    break;
                case 2:

                   if(carry==0)
                   {
                       carry =1;
                       first.set(i,0);
                   }
                   else
                   {
                       first.set(i, 0);
                   }

                    break;
                default:
            }
        }
        return first;
    }



    public static int interpret(ArrayList<Integer> A , ArrayList<Integer> Q , int count)
    {
        ArrayList<Integer> AQ = new ArrayList<Integer>();
        AQ.addAll(A);
        AQ.addAll(Q);
        switch (AQ.get(0)) {
            case 0:
                return b2d.convertBinaryToDecimal(AQ);
            case 1:
                AQ = Comp2s.calculate(2 * count, AQ);
                return -b2d.convertBinaryToDecimal(AQ);
        }
        return 0;
    }



    public static void print(ArrayList<Integer> M, ArrayList<Integer> Q, ArrayList<Integer> A, int Qreg , int count,int packet)
    {
        switch (packet) {
            case 1 -> {
                System.out.printf("     ");
                System.out.printf(M + "    ");
                System.out.printf(A + "    ");
                System.out.printf(Q + "    ");
                System.out.printf(Qreg + "    ");
            }
            case 2 -> {
                System.out.printf(count + "    ");
                System.out.printf(M + "    ");
                System.out.printf(A + "    ");
                System.out.printf(Q + "    ");
                System.out.printf(Qreg + "    ");
            }
        }
    }
}
