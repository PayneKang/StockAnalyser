package psn.kang.stock.dataAccess;

import org.apache.ibatis.annotations.Insert;
import psn.kang.stock.dataAccess.dalEntities.StockBaseInfoDal;

public interface StockMapper {
    @Insert("Insert into StockBaseInfo(Code,Name,Description,LastUpdate) values(#{code},#{name},#{description},#{lastUpdate})")
    void InserNewStockBaseInfo(StockBaseInfoDal newObject);
}
