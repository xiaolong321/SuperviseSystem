create table t_admin
(
	id varchar(36) not null,
	username varchar(20) not null,
	password varchar(50) not null,
	address varchar(50) null,
	phone bigint null,
	headicon varchar(100) null,
	email varchar(20) not null,
	role_id int null,
	constraint `PRIMARY`
		primary key (id)
)
;

create table t_leave
(
	id varchar(36) not null,
	leaveType varchar(10) not null,
	startTime date not null,
	endTime date not null,
	leaveReason varchar(50) null,
	constraint `PRIMARY`
		primary key (id)
)
;

create table t_permission
(
	id int auto_increment,
	permissionName varchar(50) not null,
	roleId int not null,
	constraint `PRIMARY`
		primary key (id)
)
;

create table t_role_permission
(
	id int auto_increment,
	role_id int not null,
	permission_id int not null,
	constraint `PRIMARY`
		primary key (id)
)
;

create table t_roles
(
	id int auto_increment,
	roleName varchar(50) not null,
	constraint `PRIMARY`
		primary key (id)
)
;

create table t_user
(
	id varchar(36) not null,
	username varchar(20) not null,
	password varchar(50) not null,
	address varchar(50) null,
	phone bigint not null,
	headicon varchar(100) null,
	email varchar(20) not null,
	role_id int default '2' not null,
	status int(2) default '0' not null,
	registerTime datetime null,
	constraint `PRIMARY`
		primary key (id),
	constraint t_user_email_uindex
		unique (email)
)
;

create table t_user_role
(
	id int auto_increment,
	user_id varchar(36) not null,
	role_id int not null,
	constraint `PRIMARY`
		primary key (id)
)
;

