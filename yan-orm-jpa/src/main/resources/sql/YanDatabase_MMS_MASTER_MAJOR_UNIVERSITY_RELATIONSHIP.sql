create table MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP
(
    id              bigint       not null
        primary key,
    curHasStudents  int          null,
    description     varchar(255) null,
    `rank`          int          null,
    theOpeningTime  datetime     null,
    master_major_id bigint       null,
    university_id   bigint       null
)
    engine = MyISAM;

create index FKdmragg3257ki80emccltmk0d2
    on MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (master_major_id);

create index FKiqj7ptrgek84gu5no2v8n8p6k
    on MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (university_id);

INSERT INTO YanDatabase.MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (id, curHasStudents, description, `rank`, theOpeningTime, master_major_id, university_id) VALUES (1, 222, null, 12, '2000-05-11 12:24:14', 1, 1);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (id, curHasStudents, description, `rank`, theOpeningTime, master_major_id, university_id) VALUES (2, 221, null, 19, '1999-05-11 12:24:42', 2, 2);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (id, curHasStudents, description, `rank`, theOpeningTime, master_major_id, university_id) VALUES (3, 300, null, 20, '2001-05-11 12:25:09', 2, 1);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (id, curHasStudents, description, `rank`, theOpeningTime, master_major_id, university_id) VALUES (4, 100, null, null, '2021-06-09 10:21:53', 1, 3);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_UNIVERSITY_RELATIONSHIP (id, curHasStudents, description, `rank`, theOpeningTime, master_major_id, university_id) VALUES (5, 500, null, 2, '2021-06-20 18:20:13', 1, 6);