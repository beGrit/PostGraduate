``` mysql
SET @tables = NULL;
SELECT GROUP_CONCAT('`', table_schema, '`.`', table_name,'`') INTO @tables FROM information_schema.tables 
  WHERE table_schema = 'myDatabase' AND table_name LIKE BINARY 'del%';

SET @tables = CONCAT('DROP TABLE ', @tables);
PREPARE stmt1 FROM @tables;
EXECUTE stmt1;
DEALLOCATE PREPARE stmt1;


```

``` mysql

SET @tables = NULL;
SELECT GROUP_CONCAT('`', table_schema, '`.`', table_name,'`') INTO @tables FROM information_schema.tables 
  WHERE table_schema = 'JPALearning' AND table_name LIKE BINARY '%' AND table_name NOT IN ('users', 'authorities');

SET @tables = CONCAT('DROP TABLE ', @tables);
PREPARE stmt1 FROM @tables;
EXECUTE stmt1;
DEALLOCATE PREPARE stmt1;

```

