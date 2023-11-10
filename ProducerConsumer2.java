import java.util.concurrent.Semaphore;

public class ProducerConsumer2{

   static int theBuffer;
   static Semaphore s = new Semaphore(1);

   public static void mySleep(){
      // this function puts the thread "to sleep" for a while,
      // to simulate time spent processing 

      try{
         Thread.sleep((int)(Math.random()*1000));
      }
      catch(InterruptedException e){
         // do nothing
      }
   } // close sleep method

   public static void main(String [] args){
    
      Consumer [] c = new Consumer[5];
      Producer [] p = new Producer[5];

      for(int i = 0; i < 5; i++){
         c[i] = new Consumer(i);
         p[i] = new Producer(i);
         c[i].start();
         p[i].start();
      }
   }

   private static class Producer extends Thread{
      int i;
      public Producer(int i){
        super();
        this.i = i;
      }

      public void run(){
         while(true){
            mySleep();
            System.out.println("Producer " + i + ": attempting to acquire");
            try{
               s.acquire();
               System.out.println("Producer " + i + ": resource acquired!");
               mySleep();
               System.out.println("Producer " + i + ": theBuffer (pre)  is " + theBuffer);
               theBuffer += (int) (Math.random()*6); //producer generates random thing and sets equal to buffer
               System.out.println("Producer " + i + ": theBuffer (post) is " + theBuffer);
               System.out.println("Producer " + i + ": resource released");
               s.release();
            }
            catch(InterruptedException e){}
         }   
      }
   }

   private static class Consumer extends Thread{
      int i;
      public Consumer(int i){
         super();
         this.i = i;
      }

      public void run(){
         while(true){
            mySleep();
            System.out.println("Consumer " + i + ": attempting to acquire");
            try{
               s.acquire();
               System.out.println("Consumer " + i + ": resource acquired!");
               mySleep();
               System.out.println("Consumer " + i + ": theBuffer is " + theBuffer);
               int need = (int) (1 + Math.random()*6);
               System.out.println("Consumer " + i + ": my need is " + need);
               if (theBuffer >= need){ 
                  theBuffer -= need;
                  System.out.println("Consumer " + i + ": got what I needed!");
                  System.out.println("Consumer " + i + ": theBuffer is now " + theBuffer);
               }
               else{
                  System.out.println("Consumer " + i + ": resource unavailable");
               }
               System.out.println("Consumer " + i + ": resource released");
               s.release();
            }
            catch(InterruptedException e){}
         }
      }
   } 
} 

