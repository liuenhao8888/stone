
# FUNCTION countSubstr  #
CREATE FUNCTION countSubstr( str varchar(200), str2 char(1)) 
RETURNS INT
BEGIN
DECLARE count INT;
SET count =0;
count = (LENGTH(str) - LENGTH(REPLACE(str,str2, ""))) / LENGTH(str2);
RETURN count;
END