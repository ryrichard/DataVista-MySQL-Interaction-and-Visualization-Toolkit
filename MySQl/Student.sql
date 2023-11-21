 -- Create Database and fill it 
use StudentDataBase;

-- DROP TABLE Students;  
CREATE TABLE Students
(
empID Integer NOT NULL AUTO_INCREMENT,
firstName varChar(20) NOT NULL,
lastName varChar(20) NOT NULL, 
email varChar(50) NOT NULL,
gender varChar(1) NOT NULL,
PRIMARY KEY(empID)
);

INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Pubret', 'Adams', 'pubAdams@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Gomez', 'Adams', 'goAdams@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Snow', 'White', 'sleepy@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Thomas', 'Tank', 'chuchu@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Decep', 'DaCon', 'TopG@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Mount', 'Ain', 'everest8848@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Ben', 'Dover', 'bdover@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Ei', 'lean', 'wall@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Peredwus', 'Eckersley', 'pereEck@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Thai', 'Wintjen', 'thaiWin@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Geroge', 'Hosten', 'gHost@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Mana', 'Menner', 'maname@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Darlene', 'Ickerson', 'ickersonD@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Noelle', 'Minniear', 'NoMin@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Shaylynn', 'Bachman', 'sBach@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Keira', 'Noble', 'knob@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Bella', 'Enderson', 'bellend@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Blu', 'Waffle', 'bluWaffle@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Noe', 'Wuan', 'whosThere@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Bask', 'EtBall', 'sports1@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Soc', 'Err', 'sports2@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Fut', 'Bal', 'soccer@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Fortee', 'Two', 'answer@school.com', 'U');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Dex', 'Ter', 'laboratory@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Ed', 'Edd', 'Eddy@school.com', 'M');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Sweet', 'Suger', 'chemX@school.com', 'F');
INSERT INTO Students (firstName, lastName, email, gender)
VALUES ('Blus', 'Clue', 'steve@school.com', 'U');

-- ---------------------------------------------------------
SELECT * FROM Students;  
--  



