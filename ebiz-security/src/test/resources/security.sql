drop table if exists user;
create table user(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(20) NOT NULL,
	`password` varchar(20) NOT NULL,
	PRIMARY KEY  (`id`)
);


drop table if exists role;
create table role(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(32) NOT NULL,
	PRIMARY KEY  (`id`)
);


drop table if exists resource;
create table resource(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(32) NOT NULL,
	`value` varchar(256) NOT NULL,
	PRIMARY KEY  (`id`)
);

-- 创建关联表
drop table if exists user_role;
create table user_role(
	`user_id` int(11) NOT NULL,
	`role_id` int(11) NOT NULL,
	PRIMARY KEY  (`user_id`,`role_id`)
);

drop table if exists role_resource;
create table role_resource(
	`role_id` int(11) NOT NULL,
	`resource_id` int(11) NOT NULL,
	PRIMARY KEY  (`role_id`,`resource_id`)
);

INSERT INTO user (`id`,`username`,`password`) values(1,'admin','admin');
INSERT INTO user (`id`,`username`,`password`) values(2,'edwin','edwin');


INSERT INTO role (`id`,`name`) values(1,'supervisor');
INSERT INTO role (`id`,`name`) values(2,'user');

INSERT INTO resource (`id`,`name`,`value`) values(1,'SECURE_EXTREME_INDEX','/secure/extreme/index.jsp');
INSERT INTO resource (`id`,`name`,`value`) values(2,'SECURE_INDEX','/secure/index.jsp');

INSERT INTO user_role (`user_id`,`role_id`) values(1,1);
INSERT INTO user_role (`user_id`,`role_id`) values(1,2);
INSERT INTO user_role (`user_id`,`role_id`) values(2,2);


INSERT INTO role_resource (`role_id`,`resource_id`) values(1,1);
INSERT INTO role_resource (`role_id`,`resource_id`) values(1,2);
INSERT INTO role_resource (`role_id`,`resource_id`) values(2,2);



