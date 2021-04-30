import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        System.out.println("Enter the number of elements in the array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0 ; i<n; i++){
            input[i] = sc.nextInt();
        }

        System.out.println("Enter the element to be searched");
        int number = sc.nextInt();

        if(binarySearch(input, number) == -1){
            System.out.println("Not found");
        }
        else {
            System.out.println("found at " + binarySearch(input,number));
        }
    }







    public static int binarySearch(int arr[], int l, int r, int x)   //recursive
    {
        if (r >= l && l<arr.length-1) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static int binarySearch(int arr[], int x)                 //iterative
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;

            if (arr[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }
        return -1;
    }
}
