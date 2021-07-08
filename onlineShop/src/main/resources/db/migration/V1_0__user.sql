CREATE TABLE `shop`.`product` (
                                  `product_id` INT NOT NULL AUTO_INCREMENT,
                                  `title` VARCHAR(64) NOT NULL,
                                  `description` VARCHAR(512) NOT NULL,
                                  `price` DECIMAL(10,2) NOT NULL,
                                  PRIMARY KEY (`product_id`));

CREATE TABLE `shop`.`user` (
                               `user_id` INT NOT NULL AUTO_INCREMENT,
                               `login` VARCHAR(64) NOT NULL,
                               `password` VARCHAR(64) NOT NULL,
                               `first_name` VARCHAR(64) NOT NULL,
                               `last_name` VARCHAR(64) NOT NULL,
                               `surname` VARCHAR(64) NULL,
                               `email` VARCHAR(64) NOT NULL,
                               `phone` VARCHAR(64) NOT NULL,
                               `address` VARCHAR(64) NULL,
                               `birth_date` DATE NULL,
                               PRIMARY KEY (`user_id`),
                               UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
                               UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
                               UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE);