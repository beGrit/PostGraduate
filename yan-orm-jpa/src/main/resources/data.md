```
DROP DATABASE YanDatabase;
CREATE DATABASE YanDatabase CHARACTER SET utf8 COLLATE utf8_general_ci;

```

- ### 院校位置

``` sql

INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (1, 1, 1);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (2, 12, 11);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (3, 44, 55);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (4, 13, 13);
INSERT INTO YanDatabase.UMS_LOCATION (id, latitude, longitude) VALUES (5, 11, 111);
```

- ### 城市

``` sql
INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (1, '北京市');
INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (2, '成都市');
INSERT INTO YanDatabase.UMS_CITY (id, name) VALUES (3, '杭州市');
```

- ### 院校

``` sql
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (1, 1, 1, 1, 1, '杭州大学', ' www.hd.com', 11, 3, 1);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (2, 1, 1, 1, 1, '北京大学', 'www.beijingdx.com', 1, 1, 2);
INSERT INTO YanDatabase.UMS_UNIVERSITY (id, isEYY, isJBW, isYJSY, isZHX, name, officialUrl, `rank`, city_id, location_id) VALUES (3, 1, 0, 1, 0, '成都理工大学', 'www.cdlg.com', 110, 2, 5);
```

- ### 招生简章

``` sql
INSERT INTO YanDatabase.UMS_ENROLLMENT_GUIDE (id, attachmentPath, attachmentType, publishTime, title, belongToYear, publisherName, university_id) VALUES (1, '/static/files/a.txt', 1, '2021-05-11 08:19:58', '北京大学招生简章', '2020-05-11 08:20:27', '北京大学招生办', 2);
```

- ### 院校新闻

``` sql
INSERT INTO YanDatabase.UMS_UNIVERSITY_NEWS (id, attachmentPath, attachmentType, publishTime, title, newsType, university_id) VALUES (1, '/static/files/news1.txt', 1, '2021-05-11 08:22:24', '考试时间新闻', 1, 2);

```

