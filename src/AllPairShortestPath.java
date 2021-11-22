import java.util.ArrayList;
import java.util.Arrays;

class AllPairShortestPath
{
    public static int INF = Integer.MAX_VALUE, size;

    void decide(int graph[][])
    {
        size = graph.length;
        int[][] dist = new int[size][size];
        ArrayList<Integer>[][] path = new ArrayList[size][size];
        int i, j, k;

        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++){
                path[i][j] = new ArrayList<Integer>(Arrays.asList(i, j));

                dist[i][j] = graph[i][j];
            }


        for (k = 0; k < size; k++)
        {
            for (i = 0; i < size; i++)
            {
                for (j = 0; j < size; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j] &&   (dist[i][k]!=INF && dist[k][j]!=INF)   ){
                        dist[i][j] = dist[i][k] + dist[k][j];

                        ArrayList<Integer> mid = (ArrayList<Integer>) path[i][k].clone();
                        mid.remove(mid.size()-1);
                        mid.addAll(path[k][j]);
                        path[i][j] = mid;
                    }
                }
            }
        }
        printSolution(dist,path);
    }

    void printSolution(int dist[][], ArrayList<Integer> path[][])
    {
        System.out.println("the shortest distances between every pair of vertices\n");
        for (int i = 0; i< size; ++i)
        {
            for (int j = 0; j< size; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(padString(Integer.toString(dist[i][j]), 10));
            }
            System.out.println();
        }

        System.out.println("\n\n\nthe path for shortest distance\n");
        for (int i = 0; i< size; ++i)
        {
            for (int j = 0; j< size; ++j)
            {
                System.out.print(padString(path[i][j].toString(), 20));
            }
            System.out.println();
        }
    }

    public static void main (String[] args)
    {
            int graph[][] = {
                    {0  ,   3, INF,   3},
                    {INF  ,   0,   2,   2},
                    {1, INF,   0,   5},
                    {INF, INF,   8,   0},
        };


        AllPairShortestPath a = new AllPairShortestPath();

        a.decide(graph);
    }


    public static String padString(String input, int padding){
        int mid = input.length();
        for(int i = 0 ; i < (padding - mid) ; i++){
            input += ' ';
        }
        return input;
    }
}
