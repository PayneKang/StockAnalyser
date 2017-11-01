package psn.kang.stock.Workers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutorService;

public class StockDataParser  {
    private String stockDataString;

    public String getStockDataString() {
        return stockDataString;
    }

    public void setStockDataString(String stockDataString) {
        this.stockDataString = stockDataString;
    }

    public Object ParseStockData() {
        try {
            System.out.println("开始解析股票数据");
            JSONObject obj = new JSONObject(this.getStockDataString());
            JSONArray result = (JSONArray) obj.get("result");
            int resultLength = result.length();
            StringBuffer sb = new StringBuffer();
            sb.append("resultcode = " + obj.get("resultcode"));
            sb.append("\r\nreason = " + obj.get("reason"));
            for(int i = 0 ; i < resultLength; i++){
                JSONObject stockInfo = (JSONObject)result.get(i);
                JSONObject stockData = (JSONObject)stockInfo.get("data");
                JSONObject stockDapandata = (JSONObject)stockInfo.get("dapandata");
                JSONObject stockGopicture = (JSONObject)stockInfo.get("gopicture");
                sb.append("\r\n stock result [ "+i+" ]");
                sb.append("\r\n    stockData");
                sb.append("\r\n        gid = " + stockData.get("gid"));
                sb.append("\r\n        increPer = " + stockData.get("increPer"));
                sb.append("\r\n        increase = " + stockData.get("increase"));
                sb.append("\r\n        name = " + stockData.get("name"));
                sb.append("\r\n        todayStartPri = " + stockData.get("todayStartPri"));
                sb.append("\r\n        yestodEndPri = " + stockData.get("yestodEndPri"));
                sb.append("\r\n        nowPri = " + stockData.get("nowPri"));
                sb.append("\r\n        todayMax = " + stockData.get("todayMax"));
                sb.append("\r\n        todayMin = " + stockData.get("todayMin"));
                sb.append("\r\n        competitivePri = " + stockData.get("competitivePri"));
                sb.append("\r\n        reservePri = " + stockData.get("reservePri"));
                sb.append("\r\n        traNumber = " + stockData.get("traNumber"));
                sb.append("\r\n        traAmount = " + stockData.get("traAmount"));
                sb.append("\r\n        buyOne = " + stockData.get("buyOne"));
                sb.append("\r\n        buyOnePri = " + stockData.get("buyOnePri"));
                sb.append("\r\n        buyTwo = " + stockData.get("buyTwo"));
                sb.append("\r\n        buyTwoPri = " + stockData.get("buyTwoPri"));
                sb.append("\r\n        buyThree = " + stockData.get("buyThree"));
                sb.append("\r\n        buyThreePri = " + stockData.get("buyThreePri"));
                sb.append("\r\n        buyFour = " + stockData.get("buyFour"));
                sb.append("\r\n        buyFourPri = " + stockData.get("buyFourPri"));
                sb.append("\r\n        buyFive = " + stockData.get("buyFive"));
                sb.append("\r\n        buyFivePri = " + stockData.get("buyFivePri"));
                sb.append("\r\n        sellOne = " + stockData.get("sellOne"));
                sb.append("\r\n        sellOnePri = " + stockData.get("sellOnePri"));
                sb.append("\r\n        sellTwo = " + stockData.get("sellTwo"));
                sb.append("\r\n        sellTwoPri = " + stockData.get("sellTwoPri"));
                sb.append("\r\n        sellThree = " + stockData.get("sellThree"));
                sb.append("\r\n        sellThreePri = " + stockData.get("sellThreePri"));
                sb.append("\r\n        sellFour = " + stockData.get("sellFour"));
                sb.append("\r\n        sellFourPri = " + stockData.get("sellFourPri"));
                sb.append("\r\n        sellFive = " + stockData.get("sellFive"));
                sb.append("\r\n        sellFivePri = " + stockData.get("sellFivePri"));
                sb.append("\r\n        date = " + stockData.get("date"));
                sb.append("\r\n        time = " + stockData.get("time"));
                sb.append("\r\n    dapandata");
                sb.append("\r\n    gopicture");
                sb.append("\r\n        minurl = " + stockGopicture.get("minurl"));
                sb.append("\r\n        dayurl = " + stockGopicture.get("dayurl"));
                sb.append("\r\n        weekurl = " + stockGopicture.get("weekurl"));
                sb.append("\r\n        monthurl = " + stockGopicture.get("monthurl"));
            }
            System.out.println(sb.toString());
            System.out.println("解析股票数据成功");
            return null;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
