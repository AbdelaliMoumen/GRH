CREATE TABLE `paiment` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `employee_id` INT NOT NULL,
                            `name` VARCHAR(45) DEFAULT '',
                            `date` VARCHAR(10) DEFAULT '',
                            `salary` VARCHAR(20) DEFAULT '0.00',
                            
                            PRIMARY KEY (`id`)
);

ALTER TABLE `paiment` ADD CONSTRAINT `paiment_fk0` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);

