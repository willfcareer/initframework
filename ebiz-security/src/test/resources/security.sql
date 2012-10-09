drop table if exists user;
create table user(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(20) NOT NULL,
	`password` varchar(20) NOT NULL,
	PRIMARY KEY  (`id`)
);


drop table if exists role;
create table role(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(20) NOT NULL,
	PRIMARY KEY  (`id`)
);


drop table if exists resource;
create table resource(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(20) NOT NULL,
	`value` varchar(20) NOT NULL,
	PRIMARY KEY  (`id`)
);

INSERT INTO user (`name`,`password`) values('edwin','pass');

INSERT INTO role (`name`) values('user');
INSERT INTO role (`name`) values('supversior');

INSERT INTO resource (`name`,`value`) values('INDEX','INDEX_VALUE');
INSERT INTO resource (`name`,`value`) values('SECURE','SECURE_VALUE');