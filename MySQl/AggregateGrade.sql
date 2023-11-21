Drop Table AggregateGrade;

-- CREATE TABLE AggregateGrade
-- (
-- 	grade varchar(1) REFERENCES classes(grade),
--     Primary Key(grade)
-- );

CREATE TABLE AggregateGrade
(
	grade varchar(1) REFERENCES classes(grade),
	counted int NOT NULL default 0,  
    Primary Key(grade)
);

INSERT INTO AggregateGrade (grade)
Values ('A'), ('B'), ('C'), ('D'), ('F'), ('W');

--  SELECT Shippers.ShipperName, COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
-- LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
-- GROUP BY ShipperName; 

UPDATE AggregateGrade
SET counted = (SELECT Count(Classes.grade) FROM Classes Where Classes.grade = "A")
WHERE grade = "A";


-- SELECT AggregateGrade.grade, Count(Classes.grade) AS countgrade
-- FROM Classes
-- LEFT JOIN AggregateGrade ON Classes.grade = AggregateGrade.Grade
-- GROUP BY Classes.grade;
-- SELECT Count(grade) FROM Classes Where Classes.grade = "A";
SELECT * FROM AggregateGrade;
SELECT counted From AggregateGrade
Where grade = "A";
-- SELECT * FROM classes; 