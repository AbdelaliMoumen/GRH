CREATE TABLE `outside` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `soumission_id` INT NOT NULL,
                            `name` VARCHAR(45) DEFAULT '',
                            `date` VARCHAR(10) DEFAULT '',
                            `salary` VARCHAR(20) DEFAULT '0.00',
                            nbr INT ,
                            
                            PRIMARY KEY (`id`)
);

ALTER TABLE `outside` ADD CONSTRAINT `outside_fk0` FOREIGN KEY (`soumission_id`) REFERENCES `soumission`(`id`);

