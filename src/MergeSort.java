import java.util.ArrayList;


public class MergeSort {

    public static void main(String[] args) {
        int[] input = new int[]{0,6,7,5,8,-1,-3,-8};
        MergeSort mergeSort = new MergeSort(input);

        for(int i : mergeSort.sort()){
            System.out.println(i);
        }
    }



    ArrayList<Integer> input = new ArrayList();

    MergeSort(int[] input){
        for (int i : input) {
            this.input.add(i);
        }
    }


    public ArrayList<Integer> sort(){
        return sort(input, 0 , input.size()-1);
    }

    private ArrayList<Integer> sort(ArrayList<Integer> input, int i, int j){


        if(j==i){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(input.get(i));
            return temp;
        }
        if(j-i == 1){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((input.get(i) < input.get(j))?input.get(i):input.get(j));
            temp.add((input.get(i) < input.get(j))?input.get(j):input.get(i));

            return temp;
        }

        int left_right = (j-i) % 2 == 0 ?i + (j-i) / 2 : i + (j-i - 1) / 2;
        int right_left =  (j-i) % 2 == 0 ?i + (j-i) /2 +1 : i + (j-i + 1) / 2;


        ArrayList<Integer> temp = new ArrayList<>();

        ArrayList<Integer> left = sort(input, i, left_right);
        ArrayList<Integer> right = sort(input, right_left, j);

        while(left.size()!=0 && right.size()!=0){
            if(left.get(0) > right.get(0)){
                temp.add(right.remove(0));
            }
            else{
                temp.add(left.remove(0));
            }
        }
        temp.addAll(left);
        temp.addAll(right);

        return temp;
    }

}
