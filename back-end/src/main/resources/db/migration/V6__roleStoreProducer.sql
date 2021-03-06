drop procedure if EXISTS role_create;
DELIMITER $$
CREATE PROCEDURE role_create(
    in _name VARCHAR (255),
    in _code VARCHAR (100),
    in _description VARCHAR (255)
        ) body:
BEGIN
    declare
newId int;
    SET
max_sp_recursion_depth = 255;
    if
(
select count(category.id)
from category
where category.code = _code) > 0 then
SET @message_text = CONCAT('Catgory \'', _code, '\' already exists');
SIGNAL
SQLSTATE '45000' SET MESSAGE_TEXT = @message_text;
else
        insert into category(name, code, description, active_flag, created_date, updated_date)
        values (_name, _code, _description, 1, now(), now());
        set
newId = last_insert_id();
end if;
select newId;
END$$
DELIMITER ;

drop procedure if EXISTS role_findByRoleName;
DELIMITER $$
CREATE PROCEDURE role_findByRoleName(in _roleName varchar(100))
begin
select *
from role
where role_name = _roleName
      and(active_flag = 1
    or active_flag = 0);
end$$
DELIMITER ;

drop procedure if EXISTS role_findAll;
DELIMITER $$
CREATE PROCEDURE role_findAll()
begin
select *
from role
where (active_flag = 1
    or active_flag = 0);
end$$
DELIMITER ;