delimiter $$
create trigger new_user after insert
    on users for each row
begin
    INSERT INTO `cart` (`cart_id`, `username`) VALUES (new.username, new.username);
end $$