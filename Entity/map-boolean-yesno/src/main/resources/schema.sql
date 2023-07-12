drop table author;

create table author (
    id bigint(20) not null auto_increment,
    age int(11) not null,
    best_selling varchar(3) not null ,
    genre varchar(255) default null,
    name varchar(255) default null,
    primary key (id)
)