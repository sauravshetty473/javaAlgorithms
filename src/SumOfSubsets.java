import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class SumOfSubsets {                         //dynamic approach

    public static void main(String[] args){

        SumOfSubsets sumOfSubsets = new SumOfSubsets(new ArrayList<Integer>(Arrays.asList(1,23,4,5,6,10,7,8,9,44)), 10);

        for(ArrayList i : sumOfSubsets.getSets()){
            System.out.println(i);
        }
    }



    ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
    int finalSum;
    ArrayList<Integer> inputSet;



    SumOfSubsets(ArrayList<Integer> inputSet, int finalSum){
        this.finalSum = finalSum;
        this.inputSet = inputSet;
    }


    public ArrayList<ArrayList<Integer>> getSets(){
        fillSets(0, inputSet, new ArrayList<>(), true);
        return sets;
    }



    private void fillSets(int sumSoFar, ArrayList<Integer> remaining, ArrayList<Integer> additionOrder, boolean FirstTime){
        if(!FirstTime){
            if(sumSoFar == finalSum){
                for(ArrayList<Integer> i : sets){
                    if(additionOrder.size() == i.size()){
                        if(Sort(i).equals(Sort(additionOrder))){
                            return;
                        }
                    }
                }
                sets.add(additionOrder);
                return;
            }

            if(sumSoFar > finalSum || remaining.size() == 0){
                return;
            }
        }


        for(int i : remaining){
            ArrayList<Integer> mid = (ArrayList) remaining.clone();
            mid.remove(Integer.valueOf(i));
            ArrayList<Integer> secMid = (ArrayList) additionOrder.clone();
            secMid.add(i);
            fillSets(sumSoFar + i, mid, secMid, false);
        }
    }

    private ArrayList<Integer> Sort(ArrayList<Integer> input){

        for(int i = 0 ; i<input.size() ; i++){
            for(int j = 0 ; j < i ; j++){
                if(input.get(j)> input.get(j+1)){
                    int temp = input.get(j);
                    input.set(j, input.get(j+1));
                    input.set(j+1,temp);
                }
            }
        }
        return input;
    }
}
