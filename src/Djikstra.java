import java.util.ArrayList;

public class Djikstra {
    public static void main(String args[]){
        Djikstra object = new Djikstra(new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } },
                0, 8);

        object.printPath();
    }

    int[][] graph;
    int start;
    int end;

    PriorityStack mid = new PriorityStack();
    PriorityStack done = new PriorityStack();




    Djikstra(int[][] graph, int start, int end){
        this.start = start;
        this.end = end;

        int val = graph.length;
        for(int i = 0 ; i<val ; i++){                              // adding points to the mid priority stack at start
            mid.points.add(new Points(i, i==start?0:Integer.MAX_VALUE, start));    //distance to start point set to 0
        }
        mid.reShuffle();

        while(mid.peep().value!=end){                          //stop when the topmost element is the end.

            Points temp = mid.pop();
            done.points.add(temp);

            for(int i = 0 ; i < val ; i++){                 //all points to be visited hence popping the top most element
                if(graph[temp.value][i]!=0 && !done.contains(i)){
                    mid.compare(i, graph[temp.value][i] + temp.distance , temp.value);          //comparing the distances, and replacing if smaller  // effective distance
                }
            }
        }

        done.points.add(mid.pop());
    }


    void printPath(){
        ArrayList<Points> output = new ArrayList<>();
        Points mid = done.points.get(getIndex( this.end , done.points));
        output.add(mid);
        while(mid.fromValue != start){
            mid = done.points.get(getIndex(mid.fromValue , done.points));
            output.add(mid);
        }

        output.add(done.points.get(getIndex(start , done.points)));

        for(int i = output.size()-1 ; i >= 0 ; i--){
            System.out.print(output.get(i).value + (i!=0?" -> ":"") );
        }
        System.out.println("\nTotal distance : " + done.points.get(done.points.size() - 1).distance);
    }

    int getIndex(int value, ArrayList<Points> list){
        int j = 0;
        for (Points mid : list ) {
            if(mid.value == value)
                return j;
            j++;
        }
        return -1;
    }
}


class Points{
    Points(int value, int distance, int fromValue){
        this.value =  value;
        this.distance = distance;
        this.fromValue = fromValue;
    }
    int value;
    int distance;
    int fromValue;
}



class PriorityStack{
    ArrayList<Points> points;
    PriorityStack(){
        this.points = new ArrayList<>();
    }

    Points pop(){
        Points mid = points.get(0);
        points.remove(0);
        return mid;
    }
    Points peep(){
        return points.get(0);
    }
    int getSize(){
        return this.points.size();
    }


    void compare(int value, int distance, int fromValue){           //for replacing if effective distance is smaller
        Points mid = null;
        int j = 0;
        for (Points i : this.points) {
            if(value == i.value){
                mid = i;
                break;
            }
            j++;
        }
        if(distance < mid.distance){
            this.points.set(j , new Points(value, distance, fromValue));
            reShuffle();
        }
    }


    void reShuffle(){             //shuffle according to priority
        for(int i = 0 ; i< this.points.size() ; i++){
            for(int j = 0 ; j<this.points.size() -1 ; j++){
                if(this.points.get(j).distance>this.points.get(j+1).distance){
                    Points mid = this.points.get(j);
                    this.points.set(j, this.points.get(j+1));
                    this.points.set(j+1, mid);
                }
            }
        }
    }

    boolean contains(int value){
        if(this.points.size() == 0){
            return false;
        }
        for (Points mid: points) {
            if(mid.value == value)
                return true;
        }
        return false;
    }
}