# --- !Ups

create table users (
  id                   bigint auto_increment not null,
  email                varchar(100),
  password             varchar(100),
  configured           tinyint(1) default 0,
  dt_create            datetime not null,
  dt_update            datetime not null,
  constraint uq_users_email unique (email),
  constraint pk_users primary key (id))
;

create table categories (
  category_id         bigint auto_increment not null,
  id                  bigint,
  category            varchar(255),
  tags                varchar(255),
  dt_create           datetime not null,
  dt_update           datetime not null,
  constraint pk_categories primary key (category_id))
;

alter table categories add constraint fk_users_categories foreign key (id) references users (id) on delete restrict on update restrict;
create index ix_users_categories on categories (id);

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table categories;

drop table users;

SET FOREIGN_KEY_CHECKS=1;