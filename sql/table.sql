drop table if exists users;
create table users(
	id int(11) not null auto_increment comment '编号',
	username varchar(255) default null comment '用户名',
	nickname varchar(255) default null comment '昵称',
	password varchar(255) default null comment '密码',
	usertype varchar(255) default null comment '用户类型',
	gender varchar(255) default null comment '性别',
	address varchar(255) default null comment '地址',
	avatar varchar(255) default null comment '头像',
	primary key(id)
) comment='用户';

drop table if exists userroles;
create table userroles(
	id int(11) not null auto_increment comment '编号',
	userid int(11) not null  comment '用户编号',
	roleid int(11) not null  comment '角色编号',
	primary key(id)
) comment='用户角色';


drop table if exists roles;
create table roles(
	id int(11) not null auto_increment comment '编号',
	name varchar(255) default null comment '岗位名称',
	primary key(id)
) comment='岗位';

drop table if exists rolepermissions;
create table rolepermissions(
	id int(11) not null auto_increment comment '编号',
	roleid int(11) not null  comment '角色编号',
	perid int(11) not null  comment '权限编号',
	primary key(id)
) comment='角色权限';


drop table if exists permissions;
create  table  permissions(
	id int(11) not null auto_increment comment '编号',
	name varchar(255) default null comment '权限名称',
	primary key(id)
) comment='权限';

drop table if exists labels;
create  table  labels(
	id int(11) not null auto_increment comment '编号',
	name varchar(255) default null comment '标签名称',
	primary key(id)
) comment='标签';

drop table if exists skills;
create  table  skills(
	id int(11) not null auto_increment comment '编号',
	type int(11) not null  comment '技能分类',
	name varchar(255) default null comment '技能名称',
	primary key(id)
) comment='技能';


drop table if exists skilltype;
create  table  skilltype(
	id int(11) not null auto_increment comment '编号',
	name varchar(255) default null comment '技能分类名称',
	primary key(id)
) comment='技能分类';

drop table if exists bugresolve;
create  table  bugresolve(
	id int(11) not null auto_increment comment '编号',
	name varchar(255) default null comment 'bug名称',
	content varchar(5000) default null comment '内容',
	primary key(id)
) comment='BUG解决方案';


drop table if exists worklog;
create  table  worklog(
	id int(11) not null auto_increment comment '编号',
	name varchar(255) default null comment '标题',
	content varchar(5000) default null comment '内容',
	userid int(11) default null comment '用户',
	primary key(id)
) comment='工作日志';



