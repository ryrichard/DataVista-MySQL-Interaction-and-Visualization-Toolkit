CREATE TABLE Schedule  
(CourseId varchar(10) NOT NULL,  
SectionNo Integer NOT NULL,  
Title varchar(100) NOT NULL,  
Year Integer NOT NULL,  
Semester varchar(10) NOT NULL,  
Instructor varchar(50) NOT NULL,  
Department varchar(50) NOT NULL,  
Program varchar(20) NOT NULL,  
PRIMARY KEY(CourseId, SectionNo));

INSERT INTO Schedule  
(CourseId, SectionNo, Title, Year,  
Semester, Instructor, Department, Program)  
VALUES 
('10000PP', 34134,  
'Introduction to Programming & Computer Science', 2021,  
'Spring', 'Anna Towne', 'Computer Science', 'Undergraduate'),

('10200CC3', 32139,
'Introduction to Computing', 2021,  
'Spring', 'Jun Wu', 'Computer Science', 'Undergraduate'),

('22100P', 32132,  
'Software Design Laboratory', 2021,  
'Spring', 'Hesham Auda', 'Computer Science', 'Undergraduate');


SELECT * FROM Schedule;

DROP TABLE Schedule;