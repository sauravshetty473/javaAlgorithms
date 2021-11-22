package OSSS;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //runRoundRobin();
        //runBankers();
        //runPhilosopher();
        runProducerConsumer();
        //runReaderWriter();

        //runPriority(true);
    }

    static void runReaderWriter(){
        ReaderWriter.run();
    }

    static void runBankers(){
        Bankers bankers = new Bankers();

        bankers.initializeValues();

        bankers.calculateNeed();

        bankers.isSafe();
    }

    static void runPhilosopher(){
        Philosopher.run();
    }

    static void runRoundRobin(){
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(){
            {
                process_id = 1;
                arrival_time = 2;
                burst_time = 10;
                const_burst_time = 10;
            }
        });
        processes.add(new Process(){
            {
                process_id = 2;
                arrival_time = 1;
                burst_time = 5;
                const_burst_time = 5;
            }
        });
        processes.add(new Process(){
            {
                process_id = 3;
                arrival_time = 5;
                burst_time = 8;
                const_burst_time = 8;
            }
        });




        int[] burst_time = {10, 5, 8};

        int quantum = 2;
        RoundRobin.getResult(processes, quantum);
    }

    static void runProducerConsumer() throws InterruptedException { ProducerConsumer.run();}

    static void runSJF(boolean preemptive){

        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(){
            {
                process_id = 1;
                arrival_time = 2;
                burst_time = 5;
                const_burst_time = 5;
            }
        });
        processes.add(new Process(){
            {
                process_id = 2;
                arrival_time = 0;
                burst_time = 10;
                const_burst_time = 10;
            }
        });
        processes.add(new Process(){
            {
                process_id = 3;
                arrival_time = 3;
                burst_time = 1;
                const_burst_time = 1;
            }
        });


        if(preemptive){
            SJFPreemptive.run(processes);
        }else {
            SJFNonPreemptive.run(processes);
        }
    }


    public static void runPriority(boolean preemptive){

        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(){
            {
                process_id = 1;
                arrival_time = 2;
                burst_time = 2;
                const_burst_time = 10;
                priority = 4;
            }
        });
        processes.add(new Process(){
            {
                process_id = 2;
                arrival_time = 0;
                burst_time = 5;
                const_burst_time = 5;
                priority = 5;
            }
        });
        processes.add(new Process(){
            {
                process_id = 3;
                arrival_time = 0;
                burst_time = 8;
                const_burst_time = 8;
                priority = 3;
            }
        });


        if(preemptive){
            PriorityPreemptive.run(processes);
        }else {
            PriorityNonPreemptive.run(processes);
        }
    }
}


