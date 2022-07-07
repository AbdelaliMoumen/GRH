CREATE TABLE `soumission` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(45) NOT NULL DEFAULT '',                            
                            `occupation` VARCHAR(45) NOT NULL DEFAULT '',
                            `address` VARCHAR(45) NOT NULL DEFAULT '',
                            `email` VARCHAR(45) NOT NULL DEFAULT '',
                            `phone` VARCHAR(13) NOT NULL DEFAULT '',
                            `dat` VARCHAR(10) NOT NULL DEFAULT '',
                            `salary` VARCHAR(20) NOT NULL DEFAULT '0.00',
                            `obs` VARCHAR(255) DEFAULT '',
                            PRIMARY KEY (`id`)
);

INSERT INTO soumission (name, occupation, address, email, phone, dat, salary)
VALUES ("ONEE", "facture d'eau et d'electricité", "adre ONEE", "ONEE@gmail.com", "936930630", "04-08-2021", '6500')