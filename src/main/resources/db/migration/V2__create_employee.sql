CREATE TABLE `employee` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `department_id` INT ,
                            `name` VARCHAR(45) NOT NULL DEFAULT '',
                            `cin` VARCHAR(19) NOT NULL DEFAULT '',
                            `occupation` VARCHAR(45) NOT NULL DEFAULT '',
                            `address` VARCHAR(45) NOT NULL DEFAULT '',
                            `birth` VARCHAR(10) NOT NULL DEFAULT '',
                            `email` VARCHAR(45) NOT NULL DEFAULT '',
                            `phone` VARCHAR(13) NOT NULL DEFAULT '',
                            `contractStart` VARCHAR(10) NOT NULL DEFAULT '',
                            `contractEnd` VARCHAR(10) NOT NULL DEFAULT '',
                            `password` VARCHAR(20),
                            `isAdmin` BOOLEAN NOT NULL DEFAULT 0,
                            `salary` VARCHAR(20) NOT NULL DEFAULT '0.00',
                            `obs` VARCHAR(255) DEFAULT '',
                            PRIMARY KEY (`id`)
);

ALTER TABLE `employee` ADD CONSTRAINT `employee_fk0` FOREIGN KEY (`department_id`) REFERENCES `department`(`id`);

INSERT INTO employee (department_id, name, cin, occupation, address, birth, email, phone, contractStart, contractEnd, password, isAdmin, salary, obs)
VALUES (1, "Vander", "bi12", "développeur", "Ilha do Cabo", "13-04-1998", "v@gmail.com","936930630", "01-04-2021", "01-04-2022", "00000000",true,'10000', 'a')