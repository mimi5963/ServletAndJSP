create table member2 (
  num int primary key auto_increment,
  id varchar(20) not null,
  pass varchar(20) not null,
  name varchar(20) not null,
  age int not null,
  email varchar(20) not null,
  phone varchar(20) not null,
  unique key(id)
);

select * from member;
DROP TABLE member;