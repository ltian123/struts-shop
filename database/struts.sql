create table t_user(
	id int primary key auto_increment,
	username varchar(20),
	password varchar(50),
	phone varchar(20),
	address varchar(20),
	email varchar(20)
)engine=Innodb default charset=utf8;



create table t_product_type(
	id int primary key auto_increment,
	name varchar(20),
	status int
)engine=Innodb default charset=utf8;

create table t_product(
	id int primary key auto_increment,
	name varchar(20),
	price double,
	type_id int,
	constraint FK_t_product_type foreign key(type_id) references t_product_type(id)
)engine=Innodb default charset=utf8;


create table t_order(
	id int primary key auto_increment,
	user_id int,
	no varchar(30),
	price double,
	constraint FK_t_user foreign key(user_id) references t_user(id)
)engine=Innodb default charset=utf8;

create table t_item(
	id int primary key auto_increment,
	product_id int,
	num int,
	order_id int,
	price double,
	constraint FK_t_product foreign key(product_id) references t_product(id),
	constraint FK_t_order foreign key(order_id) references t_order(id)
)engine=Innodb default charset=utf8;

select p.id,p.name,
p.price,pt.name typeName
from t_product p
left join t_product_type pt
on p.type_id = pt.id
where pt.status = 1;






