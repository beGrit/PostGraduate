create table UMS_CITY
(
    id   bigint       not null
        primary key,
    name varchar(255) not null,
    constraint UK_erkw73rvj1pdl69auh06vmqc9
        unique (name)
)
    engine = MyISAM;

INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (1, '杭州');
INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (2, '成都');
INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (3, '北京');
INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (4, '广州');