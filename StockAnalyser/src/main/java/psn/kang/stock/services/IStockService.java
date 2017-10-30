package psn.kang.stock.services;

import psn.kang.stock.models.StockBaseInfo;

import java.util.List;

public interface IStockService {
    List<StockBaseInfo> getAllStocks();
}
