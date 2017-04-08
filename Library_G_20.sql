CREATE TABLE `book` (
  `book_Id` varchar(10) NOT NULL DEFAULT '',
  `isbn` varchar(50) DEFAULT NULL,
  `title` varchar(80) NOT NULL DEFAULT '',
  `series` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `edition` varchar(45) DEFAULT NULL,
  `volume` varchar(45) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `author1` varchar(50) DEFAULT NULL,
  `author2` varchar(50) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `quantity` int(10) unsigned zerofill DEFAULT NULL,
  `price` double DEFAULT '0',
  `summary` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`book_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `member` (
  `member_type` varchar(20) NOT NULL DEFAULT '0',
  `member_id` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(50) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `tp` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `feedback` varchar(100) DEFAULT '',
  `psw` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`member_type`,`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `member_type` (
  `member_type` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`member_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `gui` (
  `gui_id` int(11) NOT NULL AUTO_INCREMENT,
  `gui_name` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`gui_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

INSERT INTO `gui` (`gui_id`,`gui_name`) VALUES 
 (11,'New Member Register'),
 (12,'Search  Member Data'),
 (16,'Enable Update/Delete Member'),
 (21,'Add Books'),
 (22,'Search Books'),
 (26,'Enable Update/Delete Book'),
 (31,'Lend Books'),
 (32,'Receive Books'),
 (41,'User Accounts Manage'),
 (42,'Manage Lend Book Options'),
 (43,'Give Permissions to other users'),
 (51,'Login without entering username'),
 (99,'');

CREATE TABLE `lend_days_fine` (
  `member_type` varchar(20) NOT NULL DEFAULT '',
  `lend_days` int(11) NOT NULL DEFAULT '0',
  `max_book` int(11) NOT NULL DEFAULT '0',
  `fine` double NOT NULL DEFAULT '0',
   PRIMARY KEY (`member_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `lend_return` (
  `member_type` varchar(20) NOT NULL DEFAULT '',
  `member_id` varchar(10) NOT NULL DEFAULT '',
  `book_id` varchar(10) NOT NULL DEFAULT '',
  `lend_date` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  `should_return_date` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  `return_date` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  PRIMARY KEY (`member_id`,`book_id`,`lend_date`,`member_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `fine` (
  `member_type` varchar(20) NOT NULL DEFAULT '',
  `member_id` varchar(10) NOT NULL DEFAULT '',
  `book_id` varchar(10) NOT NULL DEFAULT '',
  `date` datetime NOT NULL DEFAULT '0001-01-01 00:00:00',
  `fine` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`member_type`,`member_id`,`book_id`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `permission` (
  `member_type` varchar(20) NOT NULL DEFAULT '',
  `gui_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`member_type`,`gui_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
