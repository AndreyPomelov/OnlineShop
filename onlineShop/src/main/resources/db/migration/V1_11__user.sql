ALTER TABLE `shop`.`order_history`
    ADD COLUMN `order_status` TINYINT(1) NOT NULL AFTER `price`;
