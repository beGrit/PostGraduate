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

INSERT INTO YanDatabase.AMS_USER_BASIC_INFO (DTYPE, id, avatarPath, nickName, master_major_id, email) VALUES ('UserDetailInfo', 1, '/image/pocky.jpg', 'pocky1314', 1, '1134187280@qq.com');
INSERT INTO YanDatabase.AMS_USER_BASIC_INFO (DTYPE, id, avatarPath, nickName, master_major_id, email) VALUES ('UserDetailInfo', 2, '/image/lsf.jpg', 'lsf1314', 1, '1029259726@qq.com');