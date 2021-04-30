package booths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int x;
        int choice=0;
        int tchoice =5;
        int count = 0;
        Scanner sc=new Scanner(System.in);

        do{
            System.out.println("\n\n\n---------choices-----------");
            System.out.println("press 1 to do d2b conversion");
            System.out.println("press 2 to do b2d conversion");
            System.out.println("press 3 to find 2's complement");
            System.out.println("press 4 to multiply using booths algorithm");
            System.out.println("press 5 to to perform non restoring division between two numbers");
            System.out.println("press 6 to perform restoring division between two numbers");
            System.out.println("press 7 to perform booths recoding between two numbers");
            System.out.println("press 8 to exit");

            choice= sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("enter a decimal number");
                    x = sc.nextInt();
                    new d2b(x);
                }
                case 2 -> {
                    System.out.println("enter a binary number");
                    x = sc.nextInt();
                    System.out.println("The decimal value of " + x + " is " + b2d.convertBinaryToDecimal(x));
                }
                case 3 -> {
                    System.out.println("enter a binary number");
                    x = sc.nextInt();
                    System.out.println(Comp2s.calculate(8, x));
                }
                case 4 -> {
                    System.out.println("\n\n\n-----choices-------");
                    System.out.println("0 for calculated count");
                    System.out.println("1 for given count");

                    while(tchoice!=0&&tchoice!=1)
                    {
                        tchoice = sc.nextInt();
                        switch (tchoice)
                        {
                            case 0 -> new booths();
                            case 1 -> {
                                System.out.println("Enter count");
                                count = sc.nextInt();
                                new booths(count);
                            }
                            default -> System.out.println("Not a valid input");
                        }
                    }
                    tchoice = 5;
                }
                case 5 -> {
                    System.out.println("\n\n\n-----choices-------");
                    System.out.println("0 for calculated count");
                    System.out.println("1 for given count");

                    while(tchoice!=0&&tchoice!=1)
                    {
                        tchoice = sc.nextInt();
                        switch (tchoice)
                        {
                            case 0 -> new Nstoring();
                            case 1 -> {
                                System.out.println("Enter count");
                                count = sc.nextInt();
                                new Nstoring(count);
                            }
                            default -> System.out.println("Not a valid input");
                        }
                    }
                    tchoice = 5;
                }
                case 6-> {
                    System.out.println("\n\n\n-----choices-------");
                    System.out.println("0 for calculated count");
                    System.out.println("1 for given count");

                    while(tchoice!=0&&tchoice!=1)
                    {
                        tchoice = sc.nextInt();
                        switch (tchoice)
                        {
                            case 0 -> new Storing();
                            case 1 -> {
                                System.out.println("Enter count");
                                count = sc.nextInt();
                                new Nstoring(count);
                            }
                            default -> System.out.println("Not a valid input");
                        }
                    }
                    tchoice = 5;
                }
                case 7-> System.out.println("select another option");
                case 8-> System.exit(0);
                default -> System.out.println("not a valid option");
            }
        }while(choice!=3);
    }
}


