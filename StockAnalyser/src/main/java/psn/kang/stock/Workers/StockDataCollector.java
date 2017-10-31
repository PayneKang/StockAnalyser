package psn.kang.stock.Workers;

public class StockDataCollector implements Runnable {

    private static int threadCount = 0;
    private static Object lockObj = new Object();

    public StockDataCollector(String stockCode){
        this.stockCode = stockCode;
        increaseThreadCount();
    }
    private String stockCode;

    public void run() {
        try {
            System.out.println("Stock code is " + stockCode);
            //Thread.sleep(20);
            // Get the stock data from api
            // Parse the data
            // Store data
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            decreaseThreadCount();
            System.out.println("current thread count:" + getThreadCount());
        }
    }
    public static void increaseThreadCount(){
        synchronized (lockObj){
            threadCount ++;
        }
    }
    public static void decreaseThreadCount(){
        synchronized (lockObj){
            threadCount --;
        }
    }
    public static int getThreadCount(){
        synchronized (lockObj){
            return threadCount;
        }
    }
}
