create table AMS_USER_BASIC_INFO
(
    DTYPE           varchar(31)  not null,
    id              bigint       not null
        primary key,
    avatarPath      varchar(255) null,
    nickName        varchar(255) null,
    master_major_id bigint       null
)
    engine = MyISAM;

create index FK9bujloynfm7slpcr2uta2u2yq
    on AMS_USER_BASIC_INFO (master_major_id);

INSERT INTO YanDatabase.AMS_USER_BASIC_INFO (DTYPE, id, avatarPath, nickName, master_major_id) VALUES ('UserDetailInfo', 1, '/image/pocky.jpg', 'pocky1314', 1);