package threads;

public class Loader implements Runnable{
    private String message;

    public Loader(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
        try{
            for(int i=0;i<6;i++){
                System.out.print(".");
                Thread.sleep(300);
            }
        }
        catch (InterruptedException e) {

        }
        System.out.println("Done.");
    }
}
