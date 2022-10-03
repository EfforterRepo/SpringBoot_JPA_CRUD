# SpringBoot-JPA

테이블 추가사항
CREATE TABLE user_table(
	memberID INT AUTO_INCREMENT,
	loginID VARCHAR(20),
	password VARCHAR(100),
	name VARCHAR(100),
	reg_day DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (memberID)
);

