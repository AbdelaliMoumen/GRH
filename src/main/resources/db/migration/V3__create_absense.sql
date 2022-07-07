CREATE TABLE `absense` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `employee_id` INT NOT NULL,
                            `date` VARCHAR(10) NOT NULL DEFAULT '',
                            `obs` VARCHAR(255) DEFAULT '',
                            `just` VARCHAR(10) DEFAULT '',
                            PRIMARY KEY (`id`)
);

ALTER TABLE `absense` ADD CONSTRAINT `absense_fk0` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
