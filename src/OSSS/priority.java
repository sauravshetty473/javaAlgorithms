package OSSS;


import java.util.ArrayList;

class PriorityNonPreemptive{
    public static void run(ArrayList<Process> processes){

        GanttChart ganttChart = new GanttChart();

        ArrayList<Process> readyQueue = new ArrayList<>();
        ArrayList<Process> endedQueue = new ArrayList<>();
        ArrayList<Process> dummy = new ArrayList<>();

        int timer = 0;



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
                timer +=1;
                ganttChart.ganttMids.add(new GanttMids("CPU", timer));
                continue;
            }

            var mid = readyQueue.get(0);
            for(Process i : readyQueue){
                if(mid.priority > i.priority){           //getting the shortest priority
                    mid = i;
                }
            }


            int timeTaken = mid.burst_time;

            endedQueue.add(mid);
            readyQueue.remove(mid);

            timer+=timeTaken;                                // updating time
            ganttChart.ganttMids.add(new GanttMids(String.valueOf(mid.process_id), timer));


            for(var process : readyQueue){                   //updating waiting time
                process.waiting_time += timeTaken;
            }
            if(readyQueue.contains(mid)){
                mid.waiting_time -= timeTaken;
            }
        }

        ganttChart.getGanttChart();
        GanttChart.printValues(processes);
    }
}



class PriorityPreemptive{
    public static void run(ArrayList<Process> processes){

        GanttChart ganttChart = new GanttChart();

        ArrayList<Process> readyQueue = new ArrayList<>();
        ArrayList<Process> endedQueue = new ArrayList<>();
        ArrayList<Process> dummy = new ArrayList<>();

        int timer = 0;



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
                timer +=1;
                ganttChart.ganttMids.add(new GanttMids("CPU", timer));
                continue;
            }

            var mid = readyQueue.get(0);
            for(Process i : readyQueue){
                if(mid.priority > i.priority){           //getting the smallest priority
                    mid = i;
                }
            }


            int timeTaken = 1;
            mid.burst_time --;
            if(mid.burst_time == 0 ){
                endedQueue.add(mid);
                readyQueue.remove(mid);
            }
            else{
                mid.priority++;                    //incrementing priority
            }



            timer+=1;                                // updating time
            ganttChart.ganttMids.add(new GanttMids(String.valueOf(mid.process_id), timer));


            for(var process : readyQueue){                   //updating waiting time
                process.waiting_time += timeTaken;
            }
            if(readyQueue.contains(mid)){
                mid.waiting_time -= timeTaken;
            }
        }


        ganttChart.getGanttChart();
        GanttChart.printValues(endedQueue);

    }
}