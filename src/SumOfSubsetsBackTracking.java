import java.util.ArrayList;
import java.util.Arrays;

public class SumOfSubsetsBackTracking {
    ArrayList<Boolean[]> outputSets = new ArrayList();
    int[] inputSet;
    int wantedSum;
    Boolean[] state;

    public static void main(String[] args){
        SumOfSubsetsBackTracking sumOfSubsetsBackTracking = new SumOfSubsetsBackTracking(new int[]{1,2,3,4,5,6,7}, 10);

        for(Boolean[] i : sumOfSubsetsBackTracking.outputSets){
            for(int j = 0 ; j< i.length ; j++){


                if(j== 0){
                    System.out.print("[");
                }
                if(i[j]){
                    System.out.print(sumOfSubsetsBackTracking.inputSet[j]+" ");
                }
                if(j == i.length-1){
                    System.out.print("]");
                }

            }
            System.out.println();
        }
    }


    SumOfSubsetsBackTracking(int[] inputSet, int wantedSum){
        this.inputSet = inputSet;
        this.wantedSum = wantedSum;
        this.state = new Boolean[inputSet.length];
        Arrays.fill(state, false);

        int sum = 0;
        for(int i : inputSet){
            sum +=i;
        }
        decide(0,sum, wantedSum, -1, state);
    }


    private Boolean BoundingFunction(int sum, int remaining, int wantedSum, Boolean[] state){
        if(sum > wantedSum||(sum<wantedSum && remaining == 0)){
            return false;
        }
        if(sum == wantedSum){
            outputSets.add(state);
            return false;
        }
        return true;
    }


    private void decide(int sum, int remaining, int wantedSum, int from, Boolean[] state){
        if(BoundingFunction(sum,remaining,wantedSum, state.clone())||from ==-1){
            Boolean[] mid = state.clone();
            mid[from+1] = false;
            decide(sum, remaining - inputSet[from+1], wantedSum, from+1 , mid);
            mid[from+1] = true;
            decide(sum + inputSet[from+1], remaining - inputSet[from+1], wantedSum, from+1 , mid);
        }
    }
}
