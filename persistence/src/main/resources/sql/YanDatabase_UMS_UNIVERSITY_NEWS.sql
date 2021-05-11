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

