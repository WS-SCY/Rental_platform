 

create table user(
	id int primary key auto_increment,
	name varchar(40) not null,
	login_password varchar(40) not null,
	age int default null,
	sex ENUM('ÄÐ','Å®') default null,
	login_tel char(30) not null,
	wechat varchar(50) default null,
	address varchar(200) default null,
	permission varchar(20) default null
)CHARSET=utf8mb4;


create table house(  
	id int primary key auto_increment,
	distric varchar(100) not null,
	storey int not null,
	area int default null,
	price int default null,
	homeownerid varchar(20) not null,
	rentedflag bool default null,
	sharflag bool default null,
	icon varchar(200) default null,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP 
)

create table picture(  
	id int primary key auto_increment,
	houseid varchar(20) not null,
	picurl varchar(200) not null
);

alter  table house add introduction varchar(500) default null after icon;

 
 
