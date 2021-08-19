CREATE TABLE `shop`.`order_history` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                          `username` VARCHAR(45) NOT NULL,
                                          `product_id` VARCHAR(45) NOT NULL,
                                          `price` INT NOT NULL,
                                          PRIMARY KEY (`id`));