-- Drop Table Courses; 
USE StudentDatabase;

DROP TABLE Courses;

CREATE TABLE Courses 
(
courseID varChar(100) NOT NULL,
sectionNo integer NOT NULL,
courseTitle varchar(100) NOT NULL, 
department varchar(100) NOT NULL, 
Primary Key(courseID, sectionNo)
);

INSERT INTO Courses (courseID, sectionNo, courseTitle, department)
VALUES ('10000PP', 34143, 'Introduction to Programming & Computer Science', 'Computer Science');
INSERT INTO Courses (courseID, sectionNo, courseTitle, department)
VALUES ('10200CC1', 32120, 'Introduction to Computing', 'Computer Science');
INSERT INTO Courses (courseID, sectionNo, courseTitle, department)
VALUES ('22100P', 32132, 'Software Design Laboratory', 'Computer Science');


SELECT * FROM Courses; 