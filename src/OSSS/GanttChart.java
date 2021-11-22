package OSSS;
import java.util.ArrayList;

public class GanttChart {
    ArrayList<GanttMids> ganttMids = new ArrayList<>();

    void getGanttChart(){
        System.out.println("\nGantt Chart\n");
        System.out.print("|0>");

        for(var i : ganttMids){
            System.out.print(Padding.padRight(i.value, 3) + "|" + i.time + ">");
        }
        System.out.println("\n\n");
    }

    public static void printValues(ArrayList<Process> processes){
        int padLength = 15;
        System.out.println(Padding.padRight("Process ID", padLength)+
                Padding.padRight("Burst time", padLength)+
                Padding.padRight("Waiting time", padLength)+
                Padding.padRight("TurnAround time", padLength)
        );

        for(var process : processes){
            System.out.println(Padding.padRight(String.valueOf(process.process_id), padLength)+
                    Padding.padRight(String.valueOf(process.const_burst_time), padLength)+
                    Padding.padRight(String.valueOf(process.waiting_time), padLength)+
                    Padding.padRight(String.valueOf(process.waiting_time + process.const_burst_time), padLength)
            );
        }


        if(processes.size() == 0) return;
        float avgWaitingTime = 0;
        float avgTurnAroundTime = 0;

        for(var i : processes){
            avgWaitingTime+= i.waiting_time;
            avgTurnAroundTime += (i.waiting_time + i.const_burst_time);
        }

        avgWaitingTime = avgWaitingTime/processes.size();
        avgTurnAroundTime = avgTurnAroundTime/processes.size();

        System.out.println("\nAverage waiting time is : " + avgWaitingTime + "\nAverage turnaround time is : " + avgTurnAroundTime);
    }
}


class GanttMids{
    String value;
    int time;

    GanttMids(String value, int time){
        this.value = value;
        this.time = time;

    }
}