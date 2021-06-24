create table UMS_UNIVERSITY_NEWS
(
    id             bigint       not null
        primary key,
    attachmentPath varchar(255) null,
    attachmentType int          null,
    publishTime    datetime     null,
    title          varchar(255) not null,
    newsType       int          null,
    university_id  bigint       null
)
    engine = MyISAM;

create index FKbhhh0ueqifgqxq1qqghtvlni0
    on UMS_UNIVERSITY_NEWS (university_id);

INSERT INTO YanDatabase.UMS_UNIVERSITY_NEWS (id, attachmentPath, attachmentType, publishTime, title, newsType, university_id) VALUES (1, '/university/news/foo1.txt', 0, '2021-06-09 20:58:56', '电子科技大学2021年招生政策出来啦!', 0, 1);
INSERT INTO YanDatabase.UMS_UNIVERSITY_NEWS (id, attachmentPath, attachmentType, publishTime, title, newsType, university_id) VALUES (2, '/university/news/foo2.txt', 0, '2021-06-09 21:08:08', '四川大学考研资讯推荐!', 1, 2);
INSERT INTO YanDatabase.UMS_UNIVERSITY_NEWS (id, attachmentPath, attachmentType, publishTime, title, newsType, university_id) VALUES (3, '/university/news/foo3.txt', 0, '2021-06-09 21:09:20', '成都理工大学摄影专业相关资讯!', 1, 3);
INSERT INTO YanDatabase.UMS_UNIVERSITY_NEWS (id, attachmentPath, attachmentType, publishTime, title, newsType, university_id) VALUES (4, '/university/news/foo3.txt', 0, '2021-06-10 10:09:45', '浙江大学软件工程专业机考须知', 0, 6);