INSERT INTO `shop`.`cart` (`cart_id`, `username`) VALUES ('1', 'admin');
INSERT INTO `shop`.`cart` (`cart_id`, `username`) VALUES ('2', 'user');

ALTER TABLE `shop`.`users`
    ADD CONSTRAINT `fk_user_to_cart`
        FOREIGN KEY (`username`)
            REFERENCES `shop`.`cart` (`username`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;