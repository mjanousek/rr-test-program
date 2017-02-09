package cz.janousek;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final TestProgram p = new TestProgram();
        p.start();
        p.join();
    }
}
