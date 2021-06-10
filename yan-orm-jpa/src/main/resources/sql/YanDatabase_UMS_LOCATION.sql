create table UMS_LOCATION
(
    id        bigint auto_increment
        primary key,
    latitude  double null,
    longitude double null
)
    engine = MyISAM;

INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (2, 2, 3);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (3, 3, 3);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (8, 108.918798, 34.233838);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (1, 66, 77);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (4, 99, 99);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (5, 100, 99);