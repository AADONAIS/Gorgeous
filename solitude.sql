//�������ݿ�
create database solitude;
//�����û��� 
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

//��ѯ���
select * from user;   //��ѯ�����û�
select * from user where name=?;  //����������

//�������
insert into user(id,name,password,gender,age,phone,address,auth) value(1,'mary','123456','��',20,'123456','�Ͼ�����','����Ա');
insert into user(id,name,password,gender,age,phone,address,auth) value(0,'jimy','123456','��',20,'123456','�Ͼ�����','����Ա');
insert into user(id,name,password,gender,age,phone,address,auth) value(0,'tom','123456','��',20,'123456','�Ͼ�����','����Ա');

//������Ӧ�̱�


//������Ʒ��