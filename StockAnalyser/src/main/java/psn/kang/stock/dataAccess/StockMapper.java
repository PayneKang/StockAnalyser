package psn.kang.stock.dataAccess;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import psn.kang.stock.dataAccess.dalEntities.StockBaseInfoDal;

import java.util.List;

public interface StockMapper {
    @Insert("Insert into StockBaseInfo(Code,Name,Description,LastUpdate) values(#{code},#{name},#{description},#{lastUpdate})")
    void InserNewStockBaseInfo(StockBaseInfoDal newObject);
    @Select("Select Code,Name,Description,LastUpdate from StockBaseInfo where code like 'cz%' or code like 'sh%'")
    List<StockBaseInfoDal> getAllActivitedStock();
}
