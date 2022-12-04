public class ocher {
    static String info = " is going";

    public static void main(String[] args) {
        Thread thread = new Thread(new Producer());
        Thread run = new Thread(new Producer());
        thread.start();
        run.start();
    }
}

class Producer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (ocher.info) {  // блокируем доступ к ресурсу info.
                System.out.println(this.getName() + ocher.info);
            }
            try {
                Thread.sleep(10); // засыпаем на 10 миллисекунд - этого более чем достаточно, чтобы второй поток взял ресурс и воспользовался им.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}