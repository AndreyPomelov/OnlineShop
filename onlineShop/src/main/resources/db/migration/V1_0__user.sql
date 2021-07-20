CREATE TABLE `shop`.`product` (
                                `product_id` INT NOT NULL AUTO_INCREMENT,
                                `title` VARCHAR(45) NOT NULL,
                                `description` VARCHAR(500) NOT NULL,
                                `price` DECIMAL(10,2) NOT NULL,
                                `photo` VARCHAR(45) NOT NULL,
                                PRIMARY KEY (`product_id`));

INSERT INTO `shop`.`product` (`product_id`, `title`, `description`, `price`, `photo`) VALUES ('1', 'Продукт 1', 'Продукт 1', '1000', 'Нет фото');
INSERT INTO `shop`.`product` (`product_id`, `title`, `description`, `price`, `photo`) VALUES ('2', 'Продукт 2', 'Продукт 2', '2000', 'Нет фото');
INSERT INTO `shop`.`product` (`product_id`, `title`, `description`, `price`, `photo`) VALUES ('3', 'Продукт 3', 'Продукт 3', '3000', 'Нет фото');

CREATE TABLE `shop`.`users` (
                                `username` VARCHAR(45) NOT NULL,
                                `password` VARCHAR(100) NOT NULL,
                                `enabled` TINYINT(1) NOT NULL,
                                PRIMARY KEY (`username`));

INSERT INTO `shop`.`users` (`username`, `password`, `enabled`) VALUES
                        ('admin', '$2a$10$x6gBLn.6ZH/JeZGIRMetqeW76PBuQq8na40jo5tcfNlwZSmddONae', '1');
INSERT INTO `shop`.`users` (`username`, `password`, `enabled`) VALUES
                        ('user', '$2a$10$2XINqOf1dt9Pdr1mkhjGreaPNq8tcoh3ubWqZB7C1to0pXUYCch.q', '1');

CREATE TABLE `shop`.`authorities` (
                                      `username` VARCHAR(45) NOT NULL,
                                      `authority` VARCHAR(45) NOT NULL,
                                      PRIMARY KEY (`username`, `authority`),
                                      CONSTRAINT `fk_auth_to_user`
                                          FOREIGN KEY (`username`)
                                              REFERENCES `shop`.`users` (`username`)
                                              ON DELETE NO ACTION
                                              ON UPDATE NO ACTION);

INSERT INTO `shop`.`authorities` (`username`, `authority`) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `shop`.`authorities` (`username`, `authority`) VALUES ('admin', 'ROLE_USER');
INSERT INTO `shop`.`authorities` (`username`, `authority`) VALUES ('user', 'ROLE_USER');