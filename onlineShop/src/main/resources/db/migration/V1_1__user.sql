CREATE TABLE `shop`.`cart` (
                                    `cart_id` INT NOT NULL AUTO_INCREMENT,
                                    `username` VARCHAR(45) NOT NULL,
                                    PRIMARY KEY (`cart_id`),
                                    INDEX `fk_cart_to_user_idx` (`username` ASC) VISIBLE,
                                    CONSTRAINT `fk_cart_to_user`
                                        FOREIGN KEY (`username`)
                                            REFERENCES `shop`.`users` (`username`)
                                            ON DELETE NO ACTION
                                            ON UPDATE NO ACTION);

CREATE TABLE `shop`.`cart_product` (
                                            `cart_id` INT NOT NULL,
                                            `product_id` INT NOT NULL,
                                            `product_quantity` INT NOT NULL,
                                            PRIMARY KEY (`cart_id`, `product_id`),
                                            INDEX `fk_cart_product_to_product_idx` (`product_id` ASC) VISIBLE,
                                            CONSTRAINT `fk_cart_product_to_cart`
                                                FOREIGN KEY (`cart_id`)
                                                    REFERENCES `shop`.`cart` (`cart_id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
                                            CONSTRAINT `fk_cart_product_to_product`
                                                FOREIGN KEY (`product_id`)
                                                    REFERENCES `shop`.`product` (`product_id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION);
