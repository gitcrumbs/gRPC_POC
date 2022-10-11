drop table "orders" if exists;
drop table "user" if exists;


CREATE TABLE IF NOT EXISTS `user` (
    `id`  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `username` varchar(50) DEFAULT NULL,
    `password` varchar(50) DEFAULT NULL,
     `name` VARCHAR(50) NOT NULL,
     `gender` varchar(50) DEFAULT NULL,
     `age`        INTEGER  NOT NULL
);

INSERT INTO `user` VALUES (1,'admin','admin','John Doe','MALE', 28),(2,'christian','christian','Christian Bale','MALE', 35),(3,'hugh','hugh','Hugh Jackman','MALE', 45),(4,'ross','ross','Ross Geller','MALE', 35),(5,'chandler','chandler','Chandler Bing','MALE',35),(6,'monica','monica','Monica Geller','FEMALE',34),(7,'rachel','rachel','Rachel Greene','FEMALE',40),(8,'pheobe','pheobe','Pheobe Buffay','FEMALE',40);






