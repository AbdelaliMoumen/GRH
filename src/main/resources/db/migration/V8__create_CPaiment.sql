CREATE TABLE `cpaiment` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `contrat_id` INT NOT NULL,
                            `name` VARCHAR(45) DEFAULT '',
                            `date` VARCHAR(10) DEFAULT '',
                            `salary` VARCHAR(20) DEFAULT '0.00',
                            
                            PRIMARY KEY (`id`)
);

ALTER TABLE `cpaiment` ADD CONSTRAINT `cpaiment_fk0` FOREIGN KEY (`contrat_id`) REFERENCES `contrat`(`id`);

