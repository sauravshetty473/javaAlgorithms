package booths;

import java.util.*;

public class Comp2s {
    public static ArrayList<Integer> addExtrabits(int count, int n)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ;i < count;i++)
        {
            result.add(0);
        }
        int decin = d2b.calculateabs(n);                    //made list
        int j=0;

        j = nofdigits(decin);

        for(int i = count -j ; i <count ; i++)
        {
            result.set(i , (int)(decin / (int)Math.pow(10 , count - (i +1)))%10);
        }
        return result;
    }

   public static int nofdigits(int n)
   {
      int j = 0;
       while(((int)(n/Math.pow(10,j)))!= 0)
       {
           j++;
       }
       return j;
   }
















   public static ArrayList<Integer> calculate(int count, int n){
       ArrayList<Integer> result = new ArrayList<>();


       result = addExtrabits(count, n);

       for(int i=0;i<count;i++)             //inverted
       {
           if (result.get(i) == 1) {
               result.set(i, 0);
           } else {
               result.set(i, 1);
           }
       }


       int carry = 1;
       for(int i=(count-1); i >=0;i--)
       {
           switch (result.get(i) + carry)
           {
               case 0:
                   break;
               case 1:
                   if(carry==1)
                   {
                       carry=0;
                       result.set(i , 1);
                   }
                   break;
               case 2:
                   result.set(i,0);
                   break;
           }



       }


       return  result;

   }



    public static ArrayList<Integer> calculate(int count, ArrayList<Integer> AQ){
        ArrayList<Integer> result = new ArrayList<>();


        result = AQ;

        for(int i=0;i<count;i++)             //inverted
        {
            if (result.get(i) == 1) {
                result.set(i, 0);
            } else {
                result.set(i, 1);
            }
        }


        int carry = 1;
        for(int i=(count-1); i >=0;i--)
        {
            switch (result.get(i) + carry)
            {
                case 0:
                    break;
                case 1:
                    if(carry==1)
                    {
                        carry=0;
                        result.set(i , 1);
                    }
                    break;
                case 2:
                    result.set(i,0);
                    break;
            }



        }


        return  result;

    }

}
