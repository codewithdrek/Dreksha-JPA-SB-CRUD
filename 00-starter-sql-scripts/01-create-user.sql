-- Drop user first if they exist
DROP USER if exists 'krishna'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'krishna'@'localhost' IDENTIFIED BY 'krishna';

GRANT ALL PRIVILEGES ON * . * TO 'krishna'@'localhost';