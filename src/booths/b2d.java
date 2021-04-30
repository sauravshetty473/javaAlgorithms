package booths;
import java.util.ArrayList;

public class b2d {

    public static int convertBinaryToDecimal(long num)
    {
        int decimalNumber = 0, i = 0;
        long remainder;
        while (num != 0)
        {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNumber;
    }



    public static int convertBinaryToDecimal(ArrayList<Integer> input)
    {
        int result = 0;
        for(int i = 0 ; i < input.size() ; i++)
        {
            result += Math.pow(2 , input.size()-1-i)*input.get(i);
        }

        return result;
    }
}
