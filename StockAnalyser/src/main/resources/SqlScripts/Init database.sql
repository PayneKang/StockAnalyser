-- 创建新数据库
CREATE DATABASE IF NOT EXISTS `stockKPP`;
USE `stockKPP`;
-- 创建股票基础数据表
CREATE TABLE IF NOT EXISTS `StockBaseInfo` (
  `Code` varchar(10) NOT NULL PRIMARY KEY,
  `Name` varchar(10) NOT NULL,
  `Description` varchar(256),
  `LastUpdate` datetime
);