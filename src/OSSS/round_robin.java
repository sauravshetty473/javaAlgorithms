package OSSS;

import java.util.ArrayList;

class RoundRobin    //Pre emptive
{
    static void getResult(ArrayList<Process> processes, int quantum){


        GanttChart ganttChart = new GanttChart();


        ArrayList<Process> readyQueue = new ArrayList<>();
        ArrayList<Process> endedQueue = new ArrayList<>();
        ArrayList<Process> dummy = new ArrayList<>();

        int timer = 0;
        int index = 0;
        int lastJump = -1;


        while (processes.size()!=0 || readyQueue.size()!=0){

            for(var process : processes){                        // updating readyQueue
                if(process.arrival_time - timer  <= 0 ){
                    dummy.add(process);
                }
            }

            for(var process : dummy){
                readyQueue.add(process);
                processes.remove(process);
            }

            dummy = new ArrayList<>();




            if(readyQueue.size() == 0) {
                timer += 1;
                ganttChart.ganttMids.add(new GanttMids("CPU", timer));
                continue;
            }

            if(index>readyQueue.size()-1){
                index = 0;
            }

            var mid = readyQueue.get(index);

            if (mid.burst_time >= quantum) {
                mid.burst_time -= quantum;
                if(mid.burst_time<=0){
                    endedQueue.add(mid);
                    readyQueue.remove(mid);
                }
                else{
                    index++;
                }
                timer += quantum;        // updating time
                ganttChart.ganttMids.add(new GanttMids(String.valueOf(mid.process_id), timer));
                lastJump = quantum;
            }
            else{
                int timeTaken = quantum - mid.burst_time;

                endedQueue.add(mid);
                readyQueue.remove(mid);

                timer+=timeTaken;          // updating time
                ganttChart.ganttMids.add(new GanttMids(String.valueOf(mid.process_id), timer));
                lastJump = timeTaken;
            }



            for(var process : readyQueue){             //updating waiting time
                process.waiting_time += lastJump;
            }
            if(readyQueue.contains(mid)){
                mid.waiting_time -= lastJump;
            }
        }


        ganttChart.getGanttChart();
        GanttChart.printValues(endedQueue);

    }
}
