/*ユーザーマスタ*/
CREATE TABLE IF NOT EXISTS user (
 id int AUTO_INCREMENT,
 user_id VARCHAR(256)PRIMARY KEY,
 password VARCHAR(200),
 user_name VARCHAR(50) UNIQUE,
 birthday DATE,
 gender BOOLEAN,
 role VARCHAR(50),
 deleted BOOLEAN
 );

 /*ドラマ情報マスタ*/
CREATE TABLE IF NOT EXISTS drama_info (
 id int AUTO_INCREMENT PRIMARY KEY,
 drama_image VARCHAR(50),
 drama_name VARCHAR(50),
 drama_story VARCHAR(500),
 lead_actor VARCHAR(50),
 release_date DATE
 );

  /*ドラマレビューマスタ*/
CREATE TABLE IF NOT EXISTS drama_review (
 id int AUTO_INCREMENT PRIMARY KEY,
 review_title VARCHAR(20),
 review_text VARCHAR(400),
 evaluation int,
 user_name VARCHAR(50),
 drama_id int

 );