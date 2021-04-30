package booths;

import java.util.ArrayList;

public class RightShift {

   public static void shiftRight(ArrayList<Integer> A , ArrayList<Integer> Q,String Qreg)
   {
      A.add(0,A.get(0));
      Q.add(0,A.get(A.size()-1));
      Qreg =Integer.toString( Q.get(Q.size()-1));
      A.remove(A.size()-1);
      Q.remove(Q.size()-1);
   }
}

