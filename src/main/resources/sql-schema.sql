drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `orderitems` (
`Order_Items_ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`order_ID` INT NOT NULL,
`product_ID` INT NOT NULL,
`Quantity` INT NOT NULL,
FOREIGN KEY (`order_ID`) REFERENCES orders(`order_ID`),
FOREIGN KEY (`product_ID`) REFERENCES items(`product_ID`)
);


CREATE TABLE IF NOT EXISTS `items` (
`product_ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Product_name` VARCHAR(50) NOT NULL,
`Product_price` DECIMAL(10,2) NOT NULL
);


CREATE TABLE IF NOT EXISTS `orders` (
`order_ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`id` INT NOT NULL,
FOREIGN KEY (`id`) REFERENCES customers(`id`)
);