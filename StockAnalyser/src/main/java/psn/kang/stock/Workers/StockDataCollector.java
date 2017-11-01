package psn.kang.stock.Workers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockDataCollector implements Runnable {

    private static final int MAX_PARSER_THREADCOUNT = 4;
    private static int threadCount = 0;
    private static Object lockObj = new Object();
    private static Object lockObjThreadPool = new Object();
    private ExecutorService parserThreadPool;
    private ExecutorService getParserThreadPool(){
        synchronized (lockObjThreadPool){
            if(parserThreadPool != null){
                return parserThreadPool;
            }
            parserThreadPool = Executors.newFixedThreadPool(MAX_PARSER_THREADCOUNT);
            return parserThreadPool;
        }
    }

    public StockDataCollector(String stockCode){
        this.stockCode = stockCode;
        increaseThreadCount();
    }
    private String stockCode;

    public void run() {
        try {
            System.out.println("Start to get stock data code is " + stockCode);
            // Get the stock data from api
            String stockResponse = getStockResponse();
            StockDataParser parser = new StockDataParser();
            parser.setStockDataString(stockResponse);
            Object stockData = parser.ParseStockData();
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
    private String getStockResponse(){
        return "{\"resultcode\":\"200\",\"reason\":\"SUCCESSED!\",\"result\":[{\"data\":{\"gid\":\"sh601009\",\"increPer\":\"9.91\",\"increase\":\"43.99\",\"name\":\"南京银行\",\"todayStartPri\":\"8.26\",\"yestodEndPri\":\"8.26\",\"nowPri\":\"8.37\",\"todayMax\":\"8.55\",\"todayMin\":\"8.25\",\"competitivePri\":\"8.37\",\"reservePri\":\"8.38\",\"traNumber\":\"34501453\",\"traAmount\":\"290889560\",\"buyOne\":\"10870\",\"buyOnePri\":\"8.37\",\"buyTwo\":\"177241\",\"buyTwoPri\":\"8.36\",\"buyThree\":\"92600\",\"buyThreePri\":\"8.35\",\"buyFour\":\"87200\",\"buyFourPri\":\"8.34\",\"buyFive\":\"113700\",\"buyFivePri\":\"8.42\",\"sellOne\":\"47556\",\"sellOnePri\":\"8.38\",\"sellTwo\":\"103057\",\"sellTwoPri\":\"8.39\",\"sellThree\":\"186689\",\"sellThreePri\":\"8.40\",\"sellFour\":\"49000\",\"sellFourPri\":\"8.41\",\"sellFive\":\"214535\",\"sellFivePri\":\"15.21\",\"date\":\"2012-12-11\",\"time\":\"15:03:06\",},\"dapandata\":{},\"gopicture\":{\"minurl\":\"http://image.sinajs.cn/newchart/min/n/sh601009.gif\",\"dayurl\":\"http://image.sinajs.cn/newchart/daily/n/sh601009.gif\",\"weekurl\":\"http://image.sinajs.cn/newchart/weekly/n/sh601009.gif\",\"monthurl\":\"http://image.sinajs.cn/newchart/monthly/n/sh601009.gif\"}}]}";
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
