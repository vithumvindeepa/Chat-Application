DROP DATABASE IF EXISTS chatapp;
CREATE DATABASE IF NOT EXISTS chatapp;
SHOW DATABASES;
USE chatapp;



DROP TABLE IF EXISTS UserName;
CREATE TABLE IF NOT EXISTS UserName
(
    username VARCHAR(45),
        CONSTRAINT PRIMARY KEY (UserName)


);
SHOW TABLES;
DESCRIBE UserName;