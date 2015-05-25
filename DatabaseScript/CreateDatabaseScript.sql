-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.16 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for atm_fresher
CREATE DATABASE IF NOT EXISTS `atm_fresher` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `atm_fresher`;


-- Dumping structure for table atm_fresher.account
CREATE TABLE IF NOT EXISTS `account` (
  `AccountID` int(11) NOT NULL DEFAULT '0',
  `CustID` int(11) DEFAULT NULL,
  `AccountNo` varchar(50) DEFAULT NULL,
  `ODID` int(11) DEFAULT NULL,
  `WDID` int(11) DEFAULT NULL,
  `Balance` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`AccountID`),
  KEY `FK_account_customer` (`CustID`),
  KEY `FK_account_overdraft` (`ODID`),
  KEY `FK_account_withdrawlimit` (`WDID`),
  CONSTRAINT `FK_account_overdraft` FOREIGN KEY (`ODID`) REFERENCES `overdraft` (`ODID`),
  CONSTRAINT `FK_account_withdrawlimit` FOREIGN KEY (`WDID`) REFERENCES `withdrawlimit` (`WDID`),
  CONSTRAINT `FK_account_customer` FOREIGN KEY (`CustID`) REFERENCES `customer` (`CustID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.atm
CREATE TABLE IF NOT EXISTS `atm` (
  `ATMID` int(11) NOT NULL DEFAULT '0',
  `Branch` varchar(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ATMID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.card
CREATE TABLE IF NOT EXISTS `card` (
  `CardNo` varchar(16) NOT NULL DEFAULT '',
  `Status` varchar(30) DEFAULT NULL,
  `AccountID` int(11) DEFAULT NULL,
  `PIN` varchar(6) DEFAULT NULL,
  `StartDate` datetime DEFAULT NULL,
  `ExpiredDate` datetime DEFAULT NULL,
  `Attempt` int(11) DEFAULT NULL,
  PRIMARY KEY (`CardNo`),
  KEY `FK_card_account` (`AccountID`),
  CONSTRAINT `FK_card_account` FOREIGN KEY (`AccountID`) REFERENCES `account` (`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.config
CREATE TABLE IF NOT EXISTS `config` (
  `ConfigID` int(11) DEFAULT NULL,
  `DateModified` datetime DEFAULT NULL,
  `MinWithdraw` decimal(10,0) DEFAULT NULL,
  `MaxWithdraw` decimal(10,0) DEFAULT NULL,
  `NumPerPage` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `CustID` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Addr` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CustID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.log
CREATE TABLE IF NOT EXISTS `log` (
  `LogID` int(11) NOT NULL DEFAULT '0',
  `LogTypeID` int(11) DEFAULT NULL,
  `ATMID` int(11) DEFAULT NULL,
  `CardNo` varchar(16) DEFAULT NULL,
  `LogDate` datetime DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  `Details` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LogID`),
  KEY `FK_log_card` (`CardNo`),
  KEY `FK_log_atm` (`ATMID`),
  KEY `FK_log_logtype` (`LogTypeID`),
  CONSTRAINT `FK_log_card` FOREIGN KEY (`CardNo`) REFERENCES `card` (`CardNo`),
  CONSTRAINT `FK_log_atm` FOREIGN KEY (`ATMID`) REFERENCES `atm` (`ATMID`),
  CONSTRAINT `FK_log_logtype` FOREIGN KEY (`LogTypeID`) REFERENCES `logtype` (`LogTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.logtype
CREATE TABLE IF NOT EXISTS `logtype` (
  `LogTypeID` int(11) NOT NULL DEFAULT '0',
  `Description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`LogTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.money
CREATE TABLE IF NOT EXISTS `money` (
  `MoneyID` int(11) NOT NULL DEFAULT '0',
  `MoneyValue` decimal(10,0) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MoneyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.overdraft
CREATE TABLE IF NOT EXISTS `overdraft` (
  `ODID` int(11) NOT NULL DEFAULT '0',
  `Value` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ODID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `StockID` int(11) NOT NULL DEFAULT '0',
  `MoneyID` int(11) DEFAULT NULL,
  `ATMID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`StockID`),
  KEY `FK_stock_atm` (`ATMID`),
  KEY `FK_stock_money` (`MoneyID`),
  CONSTRAINT `FK_stock_money` FOREIGN KEY (`MoneyID`) REFERENCES `money` (`MoneyID`),
  CONSTRAINT `FK_stock_atm` FOREIGN KEY (`ATMID`) REFERENCES `atm` (`ATMID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table atm_fresher.withdrawlimit
CREATE TABLE IF NOT EXISTS `withdrawlimit` (
  `WDID` int(11) NOT NULL DEFAULT '0',
  `Value` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`WDID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
