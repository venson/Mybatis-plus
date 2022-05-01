Create database if not exists mybatis_plus;

use mybatis_plus;

create table if not exists user(
    id BIGINT NOT NULL comment 'primary key id',
    name varchar(20) NULL DEFAULT NULL comment 'User name',
    age INT NULL default NULL default NULL  COMMENT 'User Age',
    email varchar(30) NULL default NULL comment 'User email',
    PRIMARY KEY (id)
);

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

