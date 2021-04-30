import java.util.ArrayList;
import java.util.Arrays;

class TravellingSalesMan{


    public static void main(String args[]){
        TravellingSalesMan travellingSalesPerson = new TravellingSalesMan(
                new int[][] {
                        {0, 10, 15, 20},
                        {10, 0, 35, 25},
                        {15, 35, 0, 30},
                        {20, 25, 30, 0}
                }
        );

        travellingSalesPerson.findPath();
    }

    int[][] graph;

    TravellingSalesMan(int[][] graph){
        this.graph = graph;
    }

    public void findPath(){
        ArrayList<Integer> mid = new ArrayList<>();
        for(int i = 1 ; i< graph.length; i++){
            mid.add(i);
        }
        ArrayList output = totalDistance(mid, 0);

        if((int)output.get(0) == -1){
            System.out.println("no path exists");
            return;
        }

        boolean done = false;
        System.out.println("Total distance : " + output.get(0));

        for(int i : (ArrayList<Integer>)output.get(1)){

            System.out.print("("+i + ")");
            if(i!=0 || !done){
                System.out.print(" -> ");
            }
            if(!done && i ==0)
                done = true;
        }
    }





    private ArrayList totalDistance(ArrayList<Integer> remaining, int from){                                       //return the list of (distance and list of path)


        if(remaining.size() == 2){
            ArrayList mid = new ArrayList();

            if(!(graph[remaining.get(0)][remaining.get(1)] == 0||(graph[remaining.get(0)][0] == 0 && graph[remaining.get(1)][0] == 0)||(graph[from][remaining.get(0)] == 0 && graph[from][remaining.get(1)] == 0))){
                if(graph[from][remaining.get(0)] == 0 || graph[remaining.get(1)][0] == 0){
                    mid.add(graph[from][remaining.get(1)] + graph[remaining.get(0)][0] + graph[remaining.get(1)][remaining.get(0)]);
                    mid.add( new ArrayList<Integer>(Arrays.asList(from,remaining.get(1),remaining.get(0), 0)));

                }
                else if(graph[from][remaining.get(1)] == 0 || graph[remaining.get(0)][0] == 0){
                    mid.add(graph[from][remaining.get(0)] + graph[remaining.get(1)][0] + graph[remaining.get(1)][remaining.get(0)]);
                    mid.add(new ArrayList<Integer>(Arrays.asList(from,remaining.get(0),remaining.get(1), 0)));

                }
                else if(graph[from][remaining.get(0)]+graph[remaining.get(1)][0] > graph[from][remaining.get(1)] +graph[remaining.get(0)][0]){
                    mid.add(graph[from][remaining.get(1)] + graph[remaining.get(0)][0] + graph[remaining.get(1)][remaining.get(0)]);       //adding the distance
                    mid.add(new ArrayList<Integer>(Arrays.asList(from,remaining.get(1),remaining.get(0), 0)));         //adding the path

                }
                else {
                    mid.add(graph[from][remaining.get(0)] + graph[remaining.get(1)][0]+ graph[remaining.get(1)][remaining.get(0)]);
                    mid.add(new ArrayList<Integer>(Arrays.asList(from,remaining.get(0),remaining.get(1), 0)));
                }
            }
            else {
                mid.add(-1);
            }
            return mid;
        }

        int newDist = Integer.MAX_VALUE;        //to find the minimum distance
        int fromDist = 0;
        ArrayList finalMid = null;

        for(int i : remaining){
            ArrayList<Integer> newRemaining = new ArrayList<>();
            for(int j : remaining){
                if(i!=j){
                    newRemaining.add(j);
                }
            }

            ArrayList mid = totalDistance(newRemaining, i);              //imp

            if((int)mid.get(0)!=-1 && ((int)mid.get(0) + graph[from][i])< newDist && graph[from][i]!=0){              //if not equals -1 i.e no path break and also smaller
                fromDist = graph[from][i];
                finalMid = mid;
                newDist = (int)mid.get(0) + graph[from][i];
            }
        }

        if(finalMid == null)
            return new ArrayList<Integer>(Arrays.asList(-1));

        //modifying the child root

        ArrayList resultMid = new ArrayList();
        resultMid.add((int)finalMid.get(0) + fromDist);
        ArrayList resultPath = new ArrayList();
        resultPath.add(from);
        resultPath.addAll((ArrayList)finalMid.get(1));
        resultMid.add(resultPath);

        return resultMid;
    }
}
