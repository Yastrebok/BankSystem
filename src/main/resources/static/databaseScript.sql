CREATE SCHEMA IF NOT EXISTS banksystem ;
use banksystem;

create table account
(
  id         int    not null
    primary key,
  customerId int    not null,
  quantity   double not null,
  constraint id_UNIQUE
  unique (id)
)
  engine = InnoDB;

create table customer
(
  id      int auto_increment
    primary key,
  name    varchar(100) not null,
  address varchar(45)  null,
  age     int          null,
  constraint id_UNIQUE
  unique (id)
)
  engine = InnoDB;

create table transaction
(
  id_transaction int auto_increment
    primary key,
  account        int        not null,
  increase       tinyint(1) not null,
  value          double     not null,
  date           datetime   not null,
  constraint id_transaction_UNIQUE
  unique (id_transaction)
)
  engine = InnoDB;

