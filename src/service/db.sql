create database if not exists blogdb;
use blogdb;


drop table if exists user;
create table user(
  id int not null auto_increment,
  email varchar(50),
  username varchar(50),
  pwd varchar(50),
  primary key(id)
)

drop table if exists blog;
create table blog(
  id int not null auto_increment,
  title varchar(200),
  content text,
  user_id int,
  primary key(id),
  foreign key(user_id) references user(id)
)
