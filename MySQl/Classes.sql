USE StudentDatabase;

-- DROP TABLE Classes; 

CREATE TABLE Classes
(
studentID Integer AUTO_INCREMENT REFERENCES student(empID), 
courseID varchar(100) NOT NULL, 
year Integer NOT NULL, 
semester varchar(100) NOT NULL, 
grade varchar(1) NOT NULL,
PRIMARY KEY(studentID)
);

INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'B');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'F');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'C');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'F');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'W');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'D');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'D');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'B');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'C');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'D');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'D');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'W');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'C');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'B');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'C');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'D');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'F');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'B');
INSERT INTO Classes (courseID, year, semester, grade)
VALUES ('22100P', 2017, 'Spring', 'A');

SELECT * FROM Classes;