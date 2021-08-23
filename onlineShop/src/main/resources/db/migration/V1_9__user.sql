ALTER TABLE `shop`.`cart_product`
    DROP FOREIGN KEY `fk_c_p_to_product`,
    DROP FOREIGN KEY `fk_c_p_to_cart`;
ALTER TABLE `shop`.`cart_product`
    DROP INDEX `fk_c_p_to_product_idx` ;

ALTER TABLE `shop`.`cart_product`
    DROP COLUMN `product_quantity`,
    ADD COLUMN `id` INT NOT NULL AUTO_INCREMENT FIRST,
    DROP PRIMARY KEY,
    ADD PRIMARY KEY (`id`);

ALTER TABLE `shop`.`cart_product`
    ADD INDEX `fk_cp_to_cart_idx` (`cart_id` ASC) VISIBLE,
    ADD INDEX `fk_cp_to_product_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `shop`.`cart_product`
    ADD CONSTRAINT `fk_cp_to_cart`
        FOREIGN KEY (`cart_id`)
            REFERENCES `shop`.`cart` (`cart_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_cp_to_product`
        FOREIGN KEY (`product_id`)
            REFERENCES `shop`.`product` (`product_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;