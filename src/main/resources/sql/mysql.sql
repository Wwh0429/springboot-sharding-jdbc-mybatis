create database IF NOT EXISTS `test` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use test;

DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `city_id`  INT NOT NULL,
  `city_name` VARCHAR(300),
  PRIMARY KEY (`city_id`)
);

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id`  INT NOT NULL,
  `user_name` VARCHAR(300),
  `city_id` INT,
  PRIMARY KEY (`user_id`)
);

DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `order_id` INT NOT NULL,
  `user_id`  INT NOT NULL,
  `order_amount` INT NOT NULL default 0,
  PRIMARY KEY (`order_id`)
);

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `order_id` INT NOT NULL,
  `user_id`  INT NOT NULL,
  `order_amount` INT NOT NULL default 0,
  PRIMARY KEY (`order_id`)
);

DROP TABLE IF EXISTS `t_order_item_0`;
CREATE TABLE `t_order_item_0` (
  `item_id`  INT NOT NULL,
  `order_id` INT NOT NULL,
  `item_num` INT NOT NULL,
  `item_price` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`item_id`)
);

DROP TABLE IF EXISTS `t_order_item_1`;
CREATE TABLE `t_order_item_1` (
  `item_id`  INT NOT NULL,
  `order_id` INT NOT NULL,
  `item_num` INT NOT NULL,
  `item_price` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`item_id`)
);

DROP TABLE IF EXISTS `t_product_0`;
CREATE TABLE `t_product_0` (
  `product_id`  INT NOT NULL,
  `product_name` VARCHAR(300),
  PRIMARY KEY (`product_id`)
);

DROP TABLE IF EXISTS `t_product_1`;
CREATE TABLE `t_product_1` (
  `product_id`  INT NOT NULL,
  `product_name` VARCHAR(300),
  PRIMARY KEY (`product_id`)
);


