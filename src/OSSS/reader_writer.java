package OSSS;

import java.util.Random;
import java.util.concurrent.Semaphore;

class ReaderWriter{

    public static void run(){

        File file = new File();
        Reader reader1 = new Reader(file, "Reader 1");
        Reader reader2 = new Reader(file, "Reader 2");
        Reader reader3 = new Reader(file, "Reader 3");

        Writer writer1 = new Writer(file, "Writer 1");
        Writer writer2 = new Writer(file, "Writer 2");


        reader1.start();
        reader2.start();
        reader3.start();
        writer1.start();
        writer2.start();

    }


    static class File{
        public Semaphore reads = new Semaphore(10);
        public Semaphore writes = new Semaphore(1);
    }

    static class Reader extends Thread{

        File file;
        String name;
        Reader(File file, String name){
            this.file = file;
            this.name = name;
        }

        void read(){
            try {
                file.reads.acquire();
                while (file.writes.availablePermits()>0){
                    System.out.println(name + " Cannot read, someone is writing !!");
                    Thread.sleep(400);
                }     // cannot read when a writer is writing
                var mid = new Random().nextInt(500);
                System.out.println(name + " is Reading !! for " + mid + " seconds");
                Thread.sleep(mid);

                file.reads.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            while (true){

                try {
                    //var mid = new Random().nextInt(500);
                    Thread.sleep(2000);
                }
                catch (Exception e){

                }

                try {
                    read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Writer extends Thread{
        File file;
        String name;

        Writer(File file, String name){
            this.file = file;
            this.name = name;
        }


        void write(){
            try {
                file.writes.acquire();        // only one writer can write at a time
                var mid = new Random().nextInt(500);
                while(file.reads.availablePermits()!=10){
                    System.out.println(name + " Cannot write, someone is reading !!");
                    Thread.sleep(400);
                }    //if at least one reader is reading, writer cannot write
                System.out.println(name + " is Writing !! for " + mid + " seconds");
                Thread.sleep(mid);

                file.writes.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            while (true){
                try {
                    //var mid = new Random().nextInt(500);
                    Thread.sleep(1000);
                }
                catch (Exception e){

                }

                try {
                    write();
                }
                catch (Exception e){

                }

        }
    }}
}