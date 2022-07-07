CREATE TABLE `department` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `nom` VARCHAR(45) NOT NULL DEFAULT '',
                            `obs` VARCHAR(255) DEFAULT '',
                            `skills` VARCHAR(255) DEFAULT '',
                            PRIMARY KEY (`id`)
);

INSERT INTO department (nom, obs, skills)
VALUES ("directory", '', 'management')