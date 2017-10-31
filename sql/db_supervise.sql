-- 管理员表
create table t_admin
(
  id varchar(36) not null
    primary key,
  username varchar(20) not null,
  password varchar(50) not null,
  address varchar(50) null,
  phone bigint null,
  headicon varchar(100) null,
  email varchar(20) not null,
  role_id int null,
  createTime timestamp default CURRENT_TIMESTAMP null
)
;
-- 车辆信息表
create table t_car
(
  id varchar(36) not null
    primary key,
  carName varchar(20) not null,
  carPrice varchar(20) not null,
  carColor varchar(20) not null,
  launchDat datetime null,
  carDes varchar(500) null,
  createTime timestamp default CURRENT_TIMESTAMP null
)
;
-- 费用信息表
create table t_cost
(
  id varchar(36) not null
    primary key,
  costName varchar(20) not null,
  costPrice varchar(20) not null,
  createTime timestamp default CURRENT_TIMESTAMP not null,
  costDes varchar(500) null
)
;

-- 用户表
create table t_customer
(
  id varchar(36) not null
    primary key,
  customerName varchar(20) not null,
  customerGender varchar(10) not null,
  customerEmail varchar(20) not null,
  customerPhone varchar(11) not null,
  customerDes varchar(500) null,
  customerRegTime timestamp default CURRENT_TIMESTAMP not null comment 'current_date'
)
;

-- 级别表
create table t_level
(
  id varchar(36) not null
    primary key,
  levelType varchar(10) not null,
  startTime date not null,
  endTime date not null,
  levelReason varchar(50) null
)
;
-- 订单表
create table t_order
(
  id varchar(36) not null
    primary key,
  orderName varchar(36) not null,
  productName varchar(50) not null,
  productPrice varchar(20) not null,
  userId varchar(36) not null,
  userPhone varchar(11) not null,
  productDes varchar(500) null,
  orderDes varchar(500) null
)
;
-- 权限表
create table t_permission
(
  id int auto_increment
    primary key,
  permissionName varchar(50) not null,
  roleId int not null
)
;
-- 角色权限对应表
create table t_role_permission
(
  id int auto_increment
    primary key,
  role_id int not null,
  permission_id int not null
)
;
-- 角色表
create table t_roles
(
  id int auto_increment
    primary key,
  roleName varchar(50) not null
)
;
-- 用户表
create table t_user
(
  id varchar(36) not null
    primary key,
  username varchar(20) not null,
  password varchar(50) not null,
  address varchar(50) null,
  phone bigint not null,
  headicon varchar(100) null,
  email varchar(20) not null,
  role_id int default '2' not null,
  status int(2) default '0' not null,
  registerTime datetime null,
  constraint t_user_email_uindex
  unique (email)
)
;
-- 用户角色表
create table t_user_role
(
  id int auto_increment
    primary key,
  user_id varchar(36) not null,
  role_id int not null
)
;

