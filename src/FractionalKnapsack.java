

public class FractionalKnapsack {


    public static void main(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;

        FractionalKnapsack obj = new FractionalKnapsack(wt, val, capacity);
        obj.printConfig();

    }



    double[] config;
    int[] wt;
    int[] val;
    int capacity;
    FractionalKnapsack(int[] wt, int[] val, int capacity){


        this.wt = wt;
        this.val = val;
        this.capacity = capacity;

        config = new double[val.length];


        for(int i = 0 ; i < val.length; i++){                  //bubble sorting in decreasing order of val to wt ratio
            for(int j = 0 ; j<val.length-i-1 ; j++){
                if(val[j]/wt[j] < val[j+1]/wt[j+1]){
                    int temp = val[j];
                    val[j] = val[j+1];
                    val[j+1] = temp;

                    temp = wt[j];
                    wt[j] = wt[j+1];
                    wt[j+1] = temp;
                }
            }
        }

        int remaining = capacity;
        int i = 0;
        while (remaining != 0 && i<val.length ){
            if(wt[i]> remaining){
                config[i] = (double) remaining /wt[i];
                remaining = 0;
            }

            else{
                config[i] = 1.0;
                remaining = remaining - wt[i];
            }
            i++;
        }
    }


    void printConfig(){
        for(int i = 0 ; i< wt.length ; i++){
            System.out.println("weight : " + wt[i] + ", value : " +val[i] + ", fraction : "+ config[i]);
        }
    }
}
