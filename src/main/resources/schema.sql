--CREATE TYPE  name AS ENUM ('IT', 'CS', 'ECE','EEE','ME','CE');

--CREATE TYPE  gender AS ENUM ('F', 'M');

CREATE TABLE IF NOT EXISTS  course (
     id  INT PRIMARY KEY,
     course_name name,
     fee INTEGER
 );

 CREATE TABLE IF NOT EXISTS student(
 	roll_no serial PRIMARY KEY,
 	name VARCHAR ( 50 ),
 	dob DATE,
 	gender gender,
 	address VARCHAR ( 25 ),
 	course_id INT,
 	CONSTRAINT fk_Course
    FOREIGN KEY(course_id)
    REFERENCES course(id)
 );

CREATE TABLE IF NOT EXISTS faculty(
  	faculty_id INT PRIMARY KEY,
   	name VARCHAR ( 50 ),
   	gender genDer,
    salary INTEGER,
    course_id INT,
    CONSTRAINT fk_Faculty
    FOREIGN KEY(course_id)
    REFERENCES course(id)
);

CREATE SEQUENCE IF NOT EXISTS sequence
INCREMENT 1
START 400
OWNED BY course.id;

CREATE SEQUENCE IF NOT EXISTS faculty_sequence
INCREMENT 1
START 100
OWNED BY faculty.faculty_id;