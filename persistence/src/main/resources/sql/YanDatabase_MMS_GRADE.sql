create table MMS_GRADE
(
    id               bigint       not null
        primary key,
    average          int          null,
    maxGrade         int          null,
    minGrade         int          null,
    numberOfExaminee int          null,
    year             varchar(255) null
)
    engine = MyISAM;

INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (1, 57, 90, 41, 200, '2019');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (2, 66, 87, 22, 240, '2020');
INSERT INTO YanDatabase.MMS_GRADE (id, average, maxGrade, minGrade, numberOfExaminee, year) VALUES (3, 77, 88, 22, 300, '2018');