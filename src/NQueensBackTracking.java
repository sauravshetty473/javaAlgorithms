import java.util.ArrayList;
import java.util.Arrays;

public class NQueensBackTracking {
    ArrayList<int[]> outputSets = new ArrayList();                              //column number is the index and corresponding row number, in which its present

    int Number;
    Boolean[] state;


    public static void main(String args[]){

        NQueensBackTracking nQueensBackTracking = new NQueensBackTracking(4);

        nQueensBackTracking.decide(new int[nQueensBackTracking.Number], -1, -1);

        for (int[] i: nQueensBackTracking.outputSets) {
            System.out.println(Arrays.toString(i));
        }
    }




    NQueensBackTracking(int Number){
        this.Number = Number;
    }


    private Boolean BoundingFunction(int[] columnOccupant, int currentColumn, int currentRow){

        for(int i = 0 ; i< currentColumn ; i++){
            if(columnOccupant[i] == currentRow){         //row and column matching
                return false;
            }

            if(Math.abs(columnOccupant[i] - currentRow) == Math.abs(currentColumn - i)){
                return false;
            }
        }
        return true;
    }


    private void decide(int[] columnOccupant, int currentColumn, int currentRow){

        if(currentColumn == -1){
            int[] mid = new int[this.Number];

            for(int i = 0 ; i<this.Number ; i++){
                decide(mid.clone(),0,i);
            }
            return;
        }

        Boolean decision = BoundingFunction(columnOccupant.clone(), currentColumn, currentRow);

        if(currentRow == Number-1 && currentColumn == Number-1)
            return;

        if(decision&&currentColumn!=Number-1){
            int[] mid = columnOccupant.clone();
            mid[currentColumn] = currentRow;

            decide(mid, currentColumn+1, 0);
        }
        else if(!decision&&currentRow!=Number-1){
            int[] mid = columnOccupant.clone();
            mid[currentColumn] = currentRow;

            decide(mid, currentColumn, currentRow+1);
        }
        else if(decision&&currentColumn==Number-1){
            int[] mid = columnOccupant.clone();
            mid[currentColumn] = currentRow;

            outputSets.add(mid.clone());
        }
    }

}
