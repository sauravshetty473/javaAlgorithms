import java.util.Scanner;




public class MinMax {

    public static void main(String[] args) {
        System.out.println("Enter the number of elements in the array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0 ; i<n; i++){
            input[i] = sc.nextInt();
        }

        //int[] output = minMax(input, 0, input.length-1);
        int[] output = iterativeMinMax(input);

        System.out.println("Minimum is " + output[0]);

        System.out.println("Maximum is " + output[1]);
    }


    //0 min, 1 max
    public static int[] minMax(int[] input, int i, int j){
        if(j==i){
            return new int[]{input[i], input[i]};
        }
        if(j-i == 1){
            if(input[i] < input[j]){
                return new int[]{input[i], input[j]};
            }
            else {
                return new int[]{input[j],input[i]};
            }
        }

        int left_right = (j-i) % 2 == 0 ?i + (j-i) / 2 : i + (j-i - 1) / 2;
        int right_left =  (j-i) % 2 == 0 ?i + (j-i) /2 +1 : i + (j-i + 1) / 2;

        return new int[]{Math.min(minMax(input, i, left_right)[0], minMax(input, right_left, j)[0]),
                Math.max(minMax(input, i, left_right)[1], minMax(input, right_left, j)[1])

        };
    }


    public static int[] iterativeMinMax(int[] input){
        int min = 0;
        int max = 0;

        for(int mid : input){
            if(mid<min){
                min = mid;
            }
            if(mid>max){
                max = mid;
            }
        }
        return new int[]{min, max};
    }
}
