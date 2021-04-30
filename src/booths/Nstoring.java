package booths;
import java.util.*;

public class Nstoring {
    Scanner sc = new Scanner(System.in);
    int count,newcount;
    int Mbinary,Qbinary;
    ArrayList<Integer> A = new ArrayList<Integer>();             //accumulator
    ArrayList<Integer> M = new ArrayList<Integer>();             //divisor
    ArrayList<Integer> Q = new ArrayList<Integer>();             //dividend
    ArrayList<Integer> Mminus = new ArrayList<Integer>();
    int Qi ,Mi;



    Nstoring()
    {
        System.out.println("Enter the dividend");
        Qi = sc.nextInt();
        System.out.println("Enter the divisor");
        Mi = sc.nextInt();

        Qbinary = d2b.calculateabs(Qi);
        Mbinary = d2b.calculateabs(Mi);
        count = Math.max(Comp2s.nofdigits(Mbinary), Comp2s.nofdigits(Qbinary));
        count++;
        newcount = count;


        A = Comp2s.addExtrabits(count, 0);

        this.M = Comp2s.addExtrabits(count , Math.abs(Mi));
        this.Mminus = Comp2s.calculate(count , Math.abs(Mi));
        this.Q =Comp2s.addExtrabits(count , Math.abs(Qi));



        System.out.printf(count+"   ");
        System.out.println(this.A + "     " + this.Q+"     Initialisation" );
        while(count>0)
        {


            switch (A.get(0)) {
                case 0 -> {
                    this.Q.add(0);
                    this.A.add(this.Q.get(0));
                    this.A.remove(0);
                    this.Q.remove(0);
                    System.out.println("    " + this.A + "     " + this.Q + "     left shift AQ");
                    this.A = booths.add(A, this.Mminus);
                    System.out.println("    " + this.A + "     " + this.Q + "     A-M");
                }
                case 1 -> {
                    this.Q.add(0);
                    this.A.add(this.Q.get(0));
                    this.A.remove(0);
                    this.Q.remove(0);
                    System.out.println("    " + this.A + "     " + this.Q + "     left shift AQ");
                    this.A = booths.add(A, this.M);
                    System.out.println("    " + this.A + "     " + this.Q + "     A+M");
                }
            }

            if (this.A.get(0) == 1){
                this.Q.set(this.Q.size() - 1, 0);
                System.out.println("    " +this.A + "     " + this.Q+"     Q[0] = 0" );
            }
            else {
                this.Q.set(this.Q.size() - 1, 1);
                System.out.println("    " +this.A + "     " + this.Q+"     Q[0] = 1" );
            }
            count--;
            System.out.println("\n"+count + "   " +this.A + "     " + this.Q + "     decrementing C");
        }

        if (this.A.get(0) == 1) {
            booths.add(this.A, this.M);
        }




        System.out.print("Remainder is: " + Nstoring.interpret(this.A) +"      and Quotient is: "+ Nstoring.interpret(this.Q));
    }


    Nstoring(int count)
    {
        System.out.println("Enter the dividend");
        Qi = sc.nextInt();
        System.out.println("Enter the divisor");
        Mi = sc.nextInt();

        Qbinary = d2b.calculateabs(Qi);
        Mbinary = d2b.calculateabs(Mi);

        newcount = count;


        A = Comp2s.addExtrabits(count, 0);

        this.M = Comp2s.addExtrabits(count , Math.abs(Mi));
        this.Mminus = Comp2s.calculate(count , Math.abs(Mi));
        this.Q =Comp2s.addExtrabits(count , Math.abs(Qi));



        System.out.printf(count+"   ");
        System.out.println(this.A + "     " + this.Q+"     Initialisation" );
        while(count>0)
        {


            switch (A.get(0)) {
                case 0 -> {
                    this.Q.add(0);
                    this.A.add(this.Q.get(0));
                    this.A.remove(0);
                    this.Q.remove(0);
                    System.out.println("    " + this.A + "     " + this.Q + "     left shift AQ");
                    this.A = booths.add(A, this.Mminus);
                    System.out.println("    " + this.A + "     " + this.Q + "     A-M");
                }
                case 1 -> {
                    this.Q.add(0);
                    this.A.add(this.Q.get(0));
                    this.A.remove(0);
                    this.Q.remove(0);
                    System.out.println("    " + this.A + "     " + this.Q + "     left shift AQ");
                    this.A = booths.add(A, this.M);
                    System.out.println("    " + this.A + "     " + this.Q + "     A+M");
                }
            }

            if (this.A.get(0) == 1){
                this.Q.set(this.Q.size() - 1, 0);
                System.out.println("    " +this.A + "     " + this.Q+"     Q[0] = 0" );
            }
            else {
                this.Q.set(this.Q.size() - 1, 1);
                System.out.println("    " +this.A + "     " + this.Q+"     Q[0] = 1" );
            }
            count--;
            System.out.println("\n"+count + "   " +this.A + "     " + this.Q + "     decrementing C");
        }

        if (this.A.get(0) == 1) {
            booths.add(this.A, this.M);
        }




        System.out.print("Remainder is: " + Nstoring.interpret(this.A) +"      and Quotient is: "+ Nstoring.interpret(this.Q));
    }




    public static int interpret(ArrayList<Integer> A)
    {
        int result=0;
        for(int i=0;i<=A.size()-1;i++)
        {
            result += Math.pow(2,A.size()-1-i)*A.get(i);
        }
        return result;
    }
}
