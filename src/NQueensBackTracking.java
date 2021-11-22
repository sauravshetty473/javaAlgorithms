import java.util.ArrayList;
import java.util.Arrays;

public class NQueensBackTracking {
    ArrayList<int[]> outputSets = new ArrayList();                              //column number is the index and corresponding row number, in which its present

    int Number;

    public static void main(String args[]){

        NQueensBackTracking nQueensBackTracking = new NQueensBackTracking(8);

        nQueensBackTracking.decide(new int[nQueensBackTracking.Number], -1, -1);

        System.out.println("The size of set is : " +nQueensBackTracking.outputSets.size());
        for (int[] i: nQueensBackTracking.outputSets) {
            System.out.println(Arrays.toString(i));
        }
    }

    NQueensBackTracking(int Number){
        this.Number = Number;
    }

    private Boolean BoundingFunction(int[] columnOccupant, int currentColumn, int currentRow){

        for(int i = 0 ; i< currentColumn ; i++){
            if (columnOccupant[i] == currentRow || Math.abs(columnOccupant[i] - currentRow) == Math.abs(currentColumn - i)) {         //row and column matching
                return false;
            }
        }
        return true;
    }


    private void decide(int[] columnOccupant, int currentColumn, int currentRow){
        Boolean decision = currentColumn == -1 || BoundingFunction(columnOccupant.clone(), currentColumn, currentRow);
        if(decision){
            if(currentColumn+1==Number){
                int[] mid = columnOccupant.clone();
                mid[currentColumn] = currentRow;

                outputSets.add(mid.clone());
            }
            else {
                for(int i = 0 ; i < Number ; i++){
                    int[] mid = columnOccupant.clone();
                    if( currentColumn != -1){
                        mid[currentColumn] = currentRow;
                    }
                    decide(mid, currentColumn+1, i);
                }
            }
        }
    }
}
