CREATE DATABASE blog;

use blog;

CREATE TABLE users(
    `id` INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `username` varchar(30) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `create_time` timestamp
) ENGINE=INNODB, DEFAULT CHARSET=UTF8;