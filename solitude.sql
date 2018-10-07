//创建数据库
create database solitude;
//创建用户表 
create table user(
   id int  primary key auto_increment,
   name varchar(30) not null,
   password varchar(40) not null,
   gender varchar(20) not null,
   age int not null,
   phone varchar(30) not null,
   address varchar(40) not null,
   auth varchar(20) not null
)engine=InnoDB default charset utf8;

//查询语句
select * from user;   //查询所有用户
select * from user where name=?;  //按姓名查找

//插入语句
insert into user(id,name,password,gender,age,phone,address,auth) value(1,'mary','123456','男',20,'123456','南京网博','管理员');
insert into user(id,name,password,gender,age,phone,address,auth) value(0,'jimy','123456','男',20,'123456','南京网博','管理员');
insert into user(id,name,password,gender,age,phone,address,auth) value(0,'tom','123456','男',20,'123456','南京网博','管理员');

//创建供应商表


//创建商品表