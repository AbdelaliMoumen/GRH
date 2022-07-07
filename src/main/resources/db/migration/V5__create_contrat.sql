CREATE TABLE `contrat` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(45) NOT NULL DEFAULT '',                            
                            `occupation` VARCHAR(45) NOT NULL DEFAULT '',
                            `address` VARCHAR(45) NOT NULL DEFAULT '',
                            `email` VARCHAR(45) NOT NULL DEFAULT '',
                            `phone` VARCHAR(13) NOT NULL DEFAULT '',
                            `contractStart` VARCHAR(10) NOT NULL DEFAULT '',
                            `contractEnd` VARCHAR(10) NOT NULL DEFAULT '',
                            `salary` VARCHAR(20) NOT NULL DEFAULT '0.00',
                            `obs` VARCHAR(255) DEFAULT '',
                            PRIMARY KEY (`id`)
);

INSERT INTO contrat (name, occupation, address, email, phone, contractStart, contractEnd, salary)
VALUES ("maroc telecom", "webprojet", "adre m tel", "mt@gmail.com","936930630", "01-04-2021", "01-04-2022", '1000000')