INSERT INTO `shop`.`product` (`product_id`, `title`, `description`, `price`, `photo`) VALUES ('1', 'Продукт 1', 'Продукт 1', '1000', 'Нет фото');
INSERT INTO `shop`.`product` (`product_id`, `title`, `description`, `price`, `photo`) VALUES ('2', 'Продукт 2', 'Продукт 2', '2000', 'Нет фото');
INSERT INTO `shop`.`product` (`product_id`, `title`, `description`, `price`, `photo`) VALUES ('3', 'Продукт 3', 'Продукт 3', '3000', 'Нет фото');

INSERT INTO `shop`.`cart` (`cart_id`, `username`) VALUES ('admin_cart', 'admin');
INSERT INTO `shop`.`cart` (`cart_id`, `username`) VALUES ('user_cart', 'user');

INSERT INTO `shop`.`cart_product` (`cart_id`, `product_id`, `product_quantity`) VALUES ('admin_cart', '1', '1');
INSERT INTO `shop`.`cart_product` (`cart_id`, `product_id`, `product_quantity`) VALUES ('admin_cart', '2', '1');
INSERT INTO `shop`.`cart_product` (`cart_id`, `product_id`, `product_quantity`) VALUES ('admin_cart', '3', '1');
INSERT INTO `shop`.`cart_product` (`cart_id`, `product_id`, `product_quantity`) VALUES ('user_cart', '2', '3');