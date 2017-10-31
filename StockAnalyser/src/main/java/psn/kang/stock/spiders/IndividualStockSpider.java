package psn.kang.stock.spiders;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import psn.kang.stock.Workers.StockDataCollector;
import psn.kang.stock.dataAccess.StockMapper;
import psn.kang.stock.dataAccess.dalEntities.StockBaseInfoDal;
import psn.kang.utils.MybatisUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IndividualStockSpider {

    private static final int MAX_THREAD_COUNT = 10;
    public static void main(String[] args) {
        // Start to get individual stock data
        System.out.print("开始进行个股信息抓取");
        // Get all stock list
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(true);
        StockMapper mapper = session.getMapper(StockMapper.class);
        List<StockBaseInfoDal> allStock = mapper.getAllActivitedStock();
        session.close();
        // Loop and get individual for all stocks
        // Create thread pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
        // Start Loop
        for(StockBaseInfoDal stock:allStock) {
            while(StockDataCollector.getThreadCount() > MAX_THREAD_COUNT){
                try {
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            StockDataCollector collector = new StockDataCollector(stock.getCode());
            fixedThreadPool.execute(collector);
        }
        // End Loop
        System.out.println("Finished");
    }
}
