CREATE TABLE IF NOT EXISTS users(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(255) NOT NULL,
  nickname VARCHAR(45),
  CONSTRAINT UQ__username UNIQUE(username)
);

CREATE TABLE IF NOT EXISTS authorities(
  username VARCHAR(45) NOT NULL PRIMARY KEY,
  authority VARCHAR(45) NOT NULL
);