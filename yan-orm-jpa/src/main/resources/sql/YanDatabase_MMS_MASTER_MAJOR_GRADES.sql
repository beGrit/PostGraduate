create table MMS_MASTER_MAJOR_GRADES
(
    mater_major_id bigint not null,
    grade_id       bigint not null,
    constraint UK_kchd6o3x5sai57hs7afv30a9r
        unique (grade_id)
)
    engine = MyISAM;

create index FKh0p5esswg4s6isjcjrks8re8w
    on MMS_MASTER_MAJOR_GRADES (mater_major_id);

INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (1, 1);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (1, 2);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (1, 3);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (5, 4);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (5, 5);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (5, 6);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (4, 7);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (4, 8);
INSERT INTO YanDatabase.MMS_MASTER_MAJOR_GRADES (mater_major_id, grade_id) VALUES (4, 9);