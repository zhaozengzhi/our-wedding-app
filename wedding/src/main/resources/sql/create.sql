CREATE database 'zzz';
use 'zzz';

DROP TABLE IF EXISTS  `bless`;
CREATE TABLE `tbl_bless` (
  `user` VARCHAR(255) DEFAULT 'anonymous'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;