create table UMS_UNIVERSITY
(
    id          bigint       not null
        primary key,
    isEYY       int          not null,
    isJBW       int          not null,
    isYJSY      int          not null,
    isZHX       int          not null,
    name        varchar(255) null,
    officialUrl varchar(255) null,
    `rank`      int          not null,
    city_id     bigint       not null,
    location_id bigint       not null
)
    engine = MyISAM;

create index FKd42d7rvmtaliytnhip9e1oube
    on UMS_UNIVERSITY (city_id);

create index FKg2o60ycgg90k11qywfb5nhfpv
    on UMS_UNIVERSITY (location_id);

INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id, iconPath) VALUES (1, 1, 1, 1, 1, '电子科技大学', 'www.dzkjdx.com', 8, 2, 8, null);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id, iconPath) VALUES (2, 1, 1, 1, 1, '四川大学', 'www.scdx.com', 9, 2, 2, null);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id, iconPath) VALUES (3, 1, 1, 1, 1, '成都理工大学', 'www.cdlg.com', 80, 2, 3, null);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id, iconPath) VALUES (4, 1, 1, 1, 1, '清华大学', 'www.qinghua.com', 2, 3, 1, null);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id, iconPath) VALUES (5, 1, 1, 1, 1, '广州大学', 'www.guangzhou.com', 99, 4, 4, null);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id, iconPath) VALUES (6, 1, 1, 1, 1, '浙江大学', 'www.zhejiangdaxue.com', 10, 1, 5, null);