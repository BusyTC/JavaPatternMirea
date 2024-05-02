package practice_4;

public class Main {
    public static void main(String[] args){
        MyExecutorService executorService = new MyExecutorService(1);
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));

        executorService.shutdown();
    }
}
