create table MMS_MASTER_MAJOR
(
    id          bigint       not null
        primary key,
    code        varchar(255) null,
    description varchar(255) null,
    name        varchar(255) null
)
    engine = MyISAM;

INSERT INTO YanDatabase.MMS_MASTER_MAJOR (id, code, description, name) VALUES (1, '11120', '软件', '软件工程');
INSERT INTO YanDatabase.MMS_MASTER_MAJOR (id, code, description, name) VALUES (2, '11130', '哲学', '哲学');