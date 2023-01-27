INSERT INTO users(
	id,username,password,nickname
) VALUES(
	'1','user1','{bcrypt}$2a$10$M5JloOG9EyThd3s/2xocKOU3ojKF5dlMvZnh/tAEbuDHBGrWAfWWa','nick'
);

INSERT INTO authorities(
	username,authority
) VALUES(
	'user1','GENERAL'
);