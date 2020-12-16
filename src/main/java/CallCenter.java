import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {

    public ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    int callMax = 5;
    int iterationsMax = 5;
    int iterations = 1;

    public void workATC() {
        try {
            while (iterations != iterationsMax) {
                for (int i = 1; i < (callMax + 1); i++) {
                    String call = "запрос " + iterations + "/" + i;
                    queue.add(call);
                    System.out.printf("%s добавил в очередь %s\n", Thread.currentThread().getName(), call);
                }
                iterations++;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void workProfy() {
        try {
            while (true) {
                Thread.sleep(3000);
                if (queue.isEmpty()) {
                    break;
                } else {
                    System.out.printf("!!!%s обработал %s\n", Thread.currentThread().getName(), queue.poll());
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

}

//    public void workProfy() {
//        try {
//            while (true) {
//                Thread.sleep(3000);
//                if (queue.isEmpty()) {
//                    break;
//                } else {
//                    System.out.printf("%s обработал %s\n", Thread.currentThread().getName(), queue.poll());
//                }
//            }
//        } catch (
//                Exception e) {
//            e.printStackTrace();
//        }
//    }




//
//public void workProfy() {
//        try {
//        while (true) {
//        Thread.sleep(3000);
//        System.out.printf("%s обработал %s\n", Thread.currentThread().getName(), queue.poll());
//        if (queue.isEmpty()) {
//        break;
//        }
//        }
//        } catch (
//        Exception e) {
//        e.printStackTrace();
//        }
//        }
