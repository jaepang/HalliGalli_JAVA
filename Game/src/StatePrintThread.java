public class StatePrintThread extends Thread {
    private Thread targetThread;
    private int id;

    public StatePrintThread(Thread targetThread, int id) {
        this.targetThread = targetThread;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            Thread.State state = targetThread.getState();
            System.out.println(id+" 타겟 스레드 상태: " + state);

            if (state == Thread.State.NEW) {
                targetThread.start();
            }

            if (state == Thread.State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}