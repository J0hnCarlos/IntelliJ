
/**
 * This class attempts to erase characters echoed to the console.
 * Sourced from http://www.cse.chalmers.se/edu/year/2018/course/TDA602/Eraserlab/pwdmasking.html
 * Has a slight bug in that there is a single asterisk displayed at start 
 */

class MaskingThread extends Thread {
    private volatile boolean stop;
    private char echochar = '*';

    /**
     * @param prompt The prompt displayed to the user
     */
    public MaskingThread(String prompt) {
        System.out.print(prompt);
    }

    /**
     * Begin masking until asked to stop.
     */
    public void run() {

        int priority = Thread.currentThread().getPriority();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        try {
            stop = true;
            while (stop) {
                System.out.print("\010" + echochar);
                try {
                    // attempt masking at this rate
                    Thread.sleep(1);
                } catch (InterruptedException iex) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } finally { // restore the original priority
            Thread.currentThread().setPriority(priority);
        }
    }

    /**
     * Instruct the thread to stop masking.
     */
    public void stopMasking() {
        this.stop = false;
    }
}