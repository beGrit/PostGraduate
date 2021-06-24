create table MMS_MASTER_MAJOR
(
    id          bigint       not null
        primary key,
    code        varchar(255) null,
    description varchar(255) null,
    name        varchar(255) null
)
    engine = MyISAM;

INSERT INTO YanDatabase.MMS_MASTER_MAJOR (id, code, description, name) VALUES (1, '11120', '软件工程是一门研究用工程化方法构建和维护有效、实用和高质量的软件的学科。 它涉及程序设计语言、数据库、软件开发工具、系统平台、标准、设计模式等方面。 在现代社会中，软件应用于多个方面。 典型的软件有电子邮件、嵌入式系统、人机界面、办公套件、操作系统、编译器、数据库、游戏等。', '软件工程');
INSERT INTO YanDatabase.MMS_MASTER_MAJOR (id, code, description, name) VALUES (2, '11130', '哲学', '哲学');
INSERT INTO YanDatabase.MMS_MASTER_MAJOR (id, code, description, name) VALUES (3, '100900', '', '农业');