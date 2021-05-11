create table UMS_LOCATION
(
    id        bigint not null
        primary key,
    latitude  double null,
    longitude double null
)
    engine = MyISAM;

INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (1, 1, 1);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (2, 2, 3);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (3, 3, 3);