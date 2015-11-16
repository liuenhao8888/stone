# procedure updateStandardValues  #

drop procedure updateStandardValues;
create procedure updateStandardValues(`index` INT, categoryId INT) 
BEGIN
update t_product_standard
set `VALUES` = CONCAT_WS(',',substring_index(`VALUES`, ',', `index`-1),substring_index(`VALUES`, ',', -(countSubstr(`VALUES`, ',')-`index`+1)))
where category_id = categoryId;
END