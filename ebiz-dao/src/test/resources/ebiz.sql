-- 创建表
create table USERS(
  USERNAME   VARCHAR2(50) not null,
  PASSWORD   VARCHAR2(50) not null,
  ENABLED    NUMBER(1) not null,
  USERNAMECN VARCHAR2(50),
  primary key( username )
)

create table AUTHORITIES(
  USERNAME  VARCHAR2(50) not null,
  AUTHORITY VARCHAR2(50) not null
)

Create primary, unique and foreign key constraints 
alter table AUTHORITIES
add constraint FK_AUTHORITIES_USERS foreign key (USERNAME)
references USERS (USERNAME);

-- 插入用户
insert into users (USERNAME, PASSWORD, ENABLED, USERNAMECN, ROWID)
values ('lxb', 'c7d3f4c857bc8c145d6e5d40c1bf23d9', 1, '登录用户', 'AAAHmhAALAAAAAOAAA');

insert into users (USERNAME, PASSWORD, ENABLED, USERNAMECN, ROWID)
values ('admin', 'ceb4f32325eda6142bd65215f4c0f371', 1, '系统管理员', 'AAAHmhAALAAAAAPAAA');

insert into users (USERNAME, PASSWORD, ENABLED, USERNAMECN, ROWID)
values ('user', '47a733d60998c719cf3526ae7d106d13', 1, '普通用户', 'AAAHmhAALAAAAAPAAB');


-- 插入权限
insert into authorities (USERNAME, AUTHORITY, ROWID)
values ('admin', 'ROLE_PLATFORMADMIN', 'AAAHmjAALAAAAAgAAA');

insert into authorities (USERNAME, AUTHORITY, ROWID)
values ('admin', 'ROLE_SYSADMIN', 'AAAHmjAALAAAAAgAAB');

insert into authorities (USERNAME, AUTHORITY, ROWID)
values ('lxb', 'ROLE_LOGIN', 'AAAHmjAALAAAAAeAAA');

insert into authorities (USERNAME, AUTHORITY, ROWID)
values ('lxb', 'ROLE_LOGINTOWELCOME', 'AAAHmjAALAAAAAeAAB');

insert into authorities (USERNAME, AUTHORITY, ROWID)
values ('user', 'ROLE_USER', 'AAAHmjAALAAAAAgAAC');