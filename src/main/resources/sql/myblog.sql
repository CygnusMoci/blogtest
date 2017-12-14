create table t_blog
(
	id int not null
		primary key,
	title char(20) null,
	content varchar(20) null,
	clickHit int null,
	type_id int null
)
;

create index t_blog_t_blogtype_id_fk
	on t_blog (type_id)
;

create table t_blogger
(
	id int not null
		primary key,
	username char(20) not null,
	password int not null,
	email char(20) null
)
;

create table t_blogtype
(
	id int not null
		primary key,
	type_name char(20) null,
	order_num int null
)
;

alter table t_blog
	add constraint t_blog_t_blogtype_id_fk
		foreign key (type_id) references t_blogtype (id)
;

create table t_comment
(
	id int not null
		primary key
)
;

