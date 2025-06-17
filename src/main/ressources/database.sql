-- Fichier database avec
-- une table Promo (id int, name string, startDate Date, duration int)
-- une table Student (relation promo one to many students) (id in, name string, firstname string, birthday Date)
-- une table skill ( en many to many avec student) (id int, label string)

-- Pas de "CREATE Database" car on souhaite pouvoir s'adapter et contrôler totalement sa création

-- Drop first pour vider les tables si elles existent déjà
    DROP TABLE if EXISTS Student_Skill;
    DROP TABLE if EXISTS Skill;
    DROP TABLE if EXISTS Student;
    DROP TABLE if EXISTS Promo;


-- Création de la table Promo
CREATE TABLE Promo (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       startDate DATE NOT NULL,
                       duration INT NOT NULL -- en jours ou en semaines
);

-- Création de la table Student
CREATE TABLE Student (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         firstname VARCHAR(100) NOT NULL,
                         birthday DATE NOT NULL,
                         promo_id INT,
                         FOREIGN KEY (promo_id) REFERENCES Promo(id) ON DELETE SET NULL
);

-- Création de la table Skill
CREATE TABLE Skill (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       label VARCHAR(100) NOT NULL
);

-- Table de liaison pour la relation many-to-many entre Student et Skill
CREATE TABLE Student_Skill (
                               student_id INT,
                               skill_id INT,
                               PRIMARY KEY (student_id, skill_id),
                               FOREIGN KEY (student_id) REFERENCES Student(id) ON DELETE CASCADE,
                               FOREIGN KEY (skill_id) REFERENCES Skill(id) ON DELETE CASCADE
);

INSERT INTO Skill (label) VALUES ('Java'),('JS'), ('PHP'), ('UML');
INSERT INTO Promo (name,startDate,duration) VALUES ('CDA_R21', '2025-03-04', 217),('FT1', '2022-01-01', 1200);
INSERT INTO Student (name, firstname, birthday, promo_id) VALUES
    ('LOUIS','Amy', '1989-03-09', 1),
    ('Hathat', 'Chahrazed ', '1950-04-14', 1),
    ('Khan', 'Habibi', '1990-01-12', 2),
    ('Bobson', 'Bobby', '1971-04-23', NULL);

INSERT INTO student_skill VALUES
(1, 4),
(1,2),
(2,3),
(2,1),
(2,2);
