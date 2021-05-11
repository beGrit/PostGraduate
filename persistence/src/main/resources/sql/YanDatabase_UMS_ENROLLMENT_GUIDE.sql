create table UMS_ENROLLMENT_GUIDE
(
    id             bigint       not null
        primary key,
    attachmentPath varchar(255) null,
    attachmentType int          null,
    publishTime    datetime     null,
    title          varchar(255) not null,
    belongToYear   datetime     null,
    publisherName  varchar(255) not null,
    university_id  bigint       not null
)
    engine = MyISAM;

create index FKsiysclfcwwto4wrxanb569avb
    on UMS_ENROLLMENT_GUIDE (university_id);

