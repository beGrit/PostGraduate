create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

INSERT INTO YanDatabase.hibernate_sequence (next_val) VALUES (3);