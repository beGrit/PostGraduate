create table AMS_USER_BASIC_INFO_UMS_UNIVERSITY
(
    UserDetailInfo_id        bigint not null,
    concernedUniversities_id bigint not null,
    primary key (UserDetailInfo_id, concernedUniversities_id)
)
    engine = MyISAM;

create index FKqpqn981linwmegyrpk1pooddq
    on AMS_USER_BASIC_INFO_UMS_UNIVERSITY (concernedUniversities_id);

INSERT INTO YanDatabase.AMS_USER_BASIC_INFO_UMS_UNIVERSITY (UserDetailInfo_id, concernedUniversities_id) VALUES (1, 1);
INSERT INTO YanDatabase.AMS_USER_BASIC_INFO_UMS_UNIVERSITY (UserDetailInfo_id, concernedUniversities_id) VALUES (1, 3);