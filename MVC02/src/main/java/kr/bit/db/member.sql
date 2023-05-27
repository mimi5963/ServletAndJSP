--맴바 테이블 만들기
create table member (
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null,
	unique key(id)
);

--검색
select * from member;
--insert(저장)
insert into member(id, pass, name, age, email, phone) 
values('admin','admin','관리자',27,'mdd@dd','010-3xxx-xxxx');

--update
update member set age=45, phone='010-1111-00000' where id='admin';

--delete(삭제)
--delete from member where
DROP table member;


