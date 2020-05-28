package app;

public class App {

    public static class  RunnableImpl implements Runnable{
        public void run (){
           for(int i =1; i <=10; i++) System.out.println("Thread 1: " +i);
         }
     }

    public static void main(String[] args) throws Exception {
        RunnableImpl thread1 = new RunnableImpl();
        Runnable thread2 = () -> {
            for(int i =1; i <=10; i++) System.out.println("Thread 2: " +i*10);
          };


        new Thread(thread1).start();
        new Thread(thread2).start();
     
    }
}