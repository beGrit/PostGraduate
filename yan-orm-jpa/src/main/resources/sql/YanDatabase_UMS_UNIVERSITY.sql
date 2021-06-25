create table UMS_UNIVERSITY
(
    id          bigint       not null
        primary key,
    iconPath    varchar(255) null,
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

INSERT INTO YanDatabase.UMS_UNIVERSITY (id, iconPath, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (1, '/image/university_log/dzkjdx.jpeg', 1, 1, 1, 1, '电子科技大学', 'www.dzkjdx.com', 8, 2, 8);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, iconPath, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (2, null, 1, 1, 1, 1, '四川大学', 'www.scdx.com', 9, 2, 2);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, iconPath, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (3, '/image/university_log/cdlgdx.png', 1, 1, 1, 1, '成都理工大学', 'www.cdlg.com', 80, 2, 3);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, iconPath, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (4, null, 1, 1, 1, 1, '清华大学', 'www.qinghua.com', 2, 3, 1);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, iconPath, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (5, null, 1, 1, 1, 1, '广州大学', 'www.guangzhou.com', 99, 4, 4);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, iconPath, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (6, null, 1, 1, 1, 1, '浙江大学', 'www.zhejiangdaxue.com', 10, 1, 5);