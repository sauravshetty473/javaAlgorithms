package OSSS;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;


class ProducerConsumer{


    static class BucketList{
        int maxSize = 3;

        ArrayList<String> bucket = new ArrayList<>();
        public Semaphore mutex = new Semaphore(1);
        public void access(String name){
            try {
                System.out.println(name + " is trying to acquire bucket");
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Producer extends Thread {
        int number = 1;
        BucketList bucketList;
        Producer(BucketList bucketList){
            this.bucketList = bucketList;
        }

        void produce() throws InterruptedException {
            if(bucketList.bucket.size() >= bucketList.maxSize) {
                System.out.println("Cannot produce more, The bucket is full!!");


                int mid = new Random().nextInt(500);
                Thread.sleep(mid);
                bucketList.mutex.release();

                return;
            }
            bucketList.bucket.add("Product " + number);
            System.out.println("Producer produces Product " + number);
            number ++;


            int mid = new Random().nextInt(500);
            Thread.sleep(mid);
            bucketList.mutex.release();
        }

        @Override
        public void run() {

            while (true){
                bucketList.access("Producer");

                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Consumer extends Thread {
        BucketList bucketList;
        Consumer(BucketList bucketList){
            this.bucketList = bucketList;
        }

        void consume() throws InterruptedException {
            if(bucketList.bucket.size() == 0) {
                System.out.println("Nothing to consume, the bucket is empty!!");
                int mid = new Random().nextInt(500);
                Thread.sleep(mid);
                bucketList.mutex.release();

                return;
            }
            var midBucket = bucketList.bucket.remove(0);
            System.out.println("Consumer consumes " + midBucket);

            int mid = new Random().nextInt(500);
            Thread.sleep(mid);
            bucketList.mutex.release();
        }

        @Override
        public void run() {
            while (true){
                bucketList.access("Consumer");
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    static void run() throws InterruptedException {
        BucketList bucketList = new BucketList();
        Producer producer = new Producer(bucketList);
        Consumer consumer = new Consumer(bucketList);

        producer.start();
        Thread.sleep(4000);
        consumer.start();
    }
}
