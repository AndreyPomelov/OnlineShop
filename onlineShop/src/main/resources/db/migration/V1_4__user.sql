ALTER TABLE `shop`.`cart`
    DROP FOREIGN KEY `fk_cart_to_user`;

ALTER TABLE `shop`.`cart_product`
    DROP FOREIGN KEY `fk_cart_product_to_product`,
    DROP FOREIGN KEY `fk_cart_product_to_cart`;
ALTER TABLE `shop`.`cart_product`
    DROP INDEX `fk_cart_product_to_product_idx` ;

ALTER TABLE `shop`.`users`
    DROP FOREIGN KEY `fk_user_to_cart`;

TRUNCATE `shop`.`cart`;

TRUNCATE `shop`.`cart_product`;

TRUNCATE `shop`.`product`;

ALTER TABLE `shop`.`cart`
    CHANGE COLUMN `cart_id` `cart_id` VARCHAR(45) NOT NULL ;

ALTER TABLE `shop`.`cart_product`
    CHANGE COLUMN `cart_id` `cart_id` VARCHAR(45) NOT NULL ,
    CHANGE COLUMN `product_id` `product_id` VARCHAR(45) NOT NULL ;

ALTER TABLE `shop`.`product`
    CHANGE COLUMN `product_id` `product_id` VARCHAR(45) NOT NULL ;

ALTER TABLE `shop`.`cart_product`
    ADD INDEX `fk_c_p_to_product_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `shop`.`cart_product`
    ADD CONSTRAINT `fk_c_p_to_cart`
        FOREIGN KEY (`cart_id`)
            REFERENCES `shop`.`cart` (`cart_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_c_p_to_product`
        FOREIGN KEY (`product_id`)
            REFERENCES `shop`.`product` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE `shop`.`cart`
    ADD CONSTRAINT `fk_cart_to_user`
        FOREIGN KEY (`username`)
            REFERENCES `shop`.`users` (`username`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;