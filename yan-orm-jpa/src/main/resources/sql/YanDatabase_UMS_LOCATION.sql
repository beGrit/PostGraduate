create table UMS_LOCATION
(
    id        bigint not null
        primary key,
    latitude  double null,
    longitude double null
)
    engine = MyISAM;

INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (2, 2, 3);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (3, 104.148339, 30.676023);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (8, 104.100221, 30.675709);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (1, 66, 77);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (4, 99, 99);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (5, 120.08083, 30.302959);