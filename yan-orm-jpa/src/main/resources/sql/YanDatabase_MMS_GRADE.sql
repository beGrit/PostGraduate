create table MMS_GRADE
(
    id               bigint       not null
        primary key,
    average          int          null,
    maxGrade         int          null,
    minGrade         int          null,
    numberOfExaminee int          null,
    year             varchar(255) not null
)
    engine = MyISAM;

INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (1, 57, 90, 41, 200, '2019');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (2, 66, 87, 22, 240, '2020');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (3, 77, 88, 22, 300, '2018');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (4, 66, 77, 55, 200, '2018');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (5, 66, 70, 80, 220, '2019');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (6, 77, 88, 88, 230, '2020');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (7, 77, 66, 77, 220, '2018');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (8, 66, 55, 77, 210, '2019');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (9, 66, 66, 66, 200, '2020');