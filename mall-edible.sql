CREATE DATABASE edible_mall charset utf8;
USE edible_mall;

CREATE TABLE `ums_member` (
  `member_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(64),
  `password` varchar(64),
  `email` varchar(200),
  `nickname` varchar(200),
  `created_time` datetime,
  `status` int(1)
);

CREATE TABLE `ums_member_statistic` (
  `member_id` int PRIMARY KEY,
  `order_count` int,
  `consume_amount` decimal(10,2)
);

CREATE TABLE `ums_admin` (
  `admin_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(64),
  `password` varchar(64),
  `nickname` varchar(200)
);

CREATE TABLE `ums_mall_statistic` (
  `id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `order_count` int,
  `shop_count` int,
  `member_count` int,
  `product_count` int,
  `consume_amount` decimal(10,2),
  `fee_amount` decimal(10,2),
  `advertise_amount` decimal(10,2),
  `income` decimal(10,2),
  `time` datetime
);

CREATE TABLE `ums_shop` (
  `shop_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(64),
  `password` varchar(64),
  `shop_name` varchar(200),
  `income` decimal(10,2),
  `status` int(1)
);

CREATE TABLE `ums_shop_statistic` (
  `shop_id` int PRIMARY KEY,
  `product_count` int,
  `order_count` int,
  `income_amount` decimal(10,2),
  `fee_amount` decimal(10,2),
  `advertise_amount` decimal(10,2)
);

CREATE TABLE `pms_product` (
  `product_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `shop_id` int,
  `product_name` varchar(200),
  `product_price` decimal(10,2),
  `stock` int,
  `sold_quantity` int,
  `monthly_sold_quantity` int,
  `advertise_price` decimal(10,2)
);

CREATE TABLE `oms_order` (
  `order_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `member_id` int,
  `shop_id` int,
  `status` int(1),
  `created_time` datetime,
  `pay_amount` decimal(10,2),
  `return_amount` decimal(10,2),
  `fee_amount` decimal(10,2)
);

CREATE TABLE `oms_order_item` (
  `item_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `order_id` int,
  `product_id` int,
  `product_price` decimal(10,2),
  `order_quantity` int
);

CREATE TABLE `oms_return_item` (
  `return_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `order_id` int,
  `product_id` int,
  `product_price` decimal(10,2),
  `return_quantity` int
);

CREATE TABLE `sms_advertise_order` (
  `advertise_id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `shop_id` int,
  `product_id` int,
  `advertise_price` decimal(10,2),
  `advertise_count` int,
  `start_time` datetime,
  `end_time` datetime
);

INSERT INTO ums_admin (username, password, nickname) VALUES ("testAdmin1", "testPass1", "testName1");
