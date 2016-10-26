--
-- Create USER
--
CREATE USER 'tasklist'@'localhost'
IDENTIFIED BY 'tasklist';

--
-- Create DB
--
CREATE DATABASE  IF NOT EXISTS tasklist_schema;


--
-- Grant Privileges to created user
--
GRANT ALL ON tasklist_schema.* TO 'tasklist'@'localhost';

--
-- Use created DB
--
USE tasklist_schema;

--
-- Create tables
--
DROP TABLE IF EXISTS task;
CREATE TABLE task (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  date_due datetime DEFAULT NULL,
  priority int DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
) /*ENGINE=InnoDB*/ DEFAULT CHARSET=utf8;

-- End
