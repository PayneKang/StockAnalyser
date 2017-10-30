package psn.kang.stock.spiders;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import psn.kang.stock.dataAccess.StockMapper;
import psn.kang.stock.dataAccess.dalEntities.StockBaseInfoDal;
import psn.kang.utils.FileUtils;
import psn.kang.utils.MybatisUtils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempMain {
    private static String tempDataFile = "Data/TempData.txt";
    private static String stockBaseDataFile = "Data/StockList.csv";
    public static void main(String[] args){
        System.out.println("支持输入两个参数，第一个参数为临时源文件的路径，第二个参数为解析后存储文件的值");
        initFilePath(args);
        String path = TempMain.class.getClassLoader().getResource("").getPath();
        tempDataFile = path + tempDataFile;
        stockBaseDataFile = path + stockBaseDataFile;
        String stockString = FileUtils.ReadAllText(tempDataFile);
        String[] lines = stockString.split("\r\n");
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(true);
        StockMapper mapper = session.getMapper(StockMapper.class);
        String pattern = "([\\s\\S]{2,4}) ([0-9]{6})";
        Pattern r = Pattern.compile(pattern);
        for(String line : lines){
            if(line == null)
                continue;
            if(line.equals(""))
                continue;
            Matcher match = r.matcher(line);
            if(!match.find())
                continue;
            StockBaseInfoDal newObj = new StockBaseInfoDal();
            newObj.setCode(match.group(2));
            newObj.setName(match.group(1));
            newObj.setDescription("");
            newObj.setLastUpdate(new Date());
            mapper.InserNewStockBaseInfo(newObj);
        }
        session.close();
        return;
    }
    private static void initFilePath(String[] args){
        if(args == null)
            return;
        if(args.length == 0)
            return;
        tempDataFile = args[0];
        if(args.length < 2)
            return;
        stockBaseDataFile = args[1];
    }
}
