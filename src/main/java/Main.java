public class Main {

    public static void main(String[] args) throws InterruptedException {

        CallCenter callCenter = new CallCenter();

        Thread atc = new Thread(null, callCenter::workATC, "АТС");

        Thread profy1 = new Thread(null, callCenter::workProfy, "Специалист 1");

        Thread profy2 = new Thread(null, callCenter::workProfy, "Специалист 2");

        Thread profy3 = new Thread(null, callCenter::workProfy, "Специалист 3");

        atc.start();

        profy1.start();
        profy2.start();
        profy3.start();

        atc.join();
        profy1.join();
        profy2.join();
        profy2.join();

    }
}
