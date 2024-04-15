INSERT INTO users (name, password, email) VALUES ('admin', '{noop}password', NULL);
INSERT INTO users (name, password, email) VALUES ('maria', '{noop}password', NULL);
INSERT INTO users (name, password, email) VALUES ('alexey', '{noop}password', 'alexey@yandex.ru');
INSERT INTO users (name, password, email) VALUES ('olga', '{noop}password', 'olga@yandex.ru');

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('MANAGER');
INSERT INTO roles (name) VALUES ('CLIENT');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO user_roles (user_id, role_id) VALUES (4, 3);

INSERT INTO operations (name, price, duration) VALUES ('Стрижка мужская простая', 500, 30);
INSERT INTO operations (name, price, duration) VALUES ('Стрижка мужская модельная', 800, 45);
INSERT INTO operations (name, price, duration) VALUES ('Стрижка женская модельная', 1000, 60);

INSERT INTO branches (name, address, phone) VALUES ('Северная роза', 'Северный проспект, д.5, к.2', '8121234567');
INSERT INTO branches (name, address, phone) VALUES ('Южный берег', 'Южный бульвар, д.7, к.1', '8129876543');

INSERT INTO employees (name, rating, image, branch_id) VALUES ('Елена', 5, 'image1.png', 1);
INSERT INTO employees (name, rating, image, branch_id) VALUES ('Оксана', 3, 'image2.png', 1);
INSERT INTO employees (name, rating, image, branch_id) VALUES ('Сергей', 4, 'image3.png', 1);
INSERT INTO employees (name, rating, image, branch_id) VALUES ('Виктория', 5, 'image4.png', 2);
INSERT INTO employees (name, rating, image, branch_id) VALUES ('Олег', 5, 'image5.png', 2);

INSERT INTO reservations (user_id, employee_id, operation_id, service_date, notice_date)
    VALUES (3, 1, 1, '2024-04-26 18:00:00', '2024-04-25 18:00:00');
INSERT INTO reservations (user_id, employee_id, operation_id, service_date, notice_date)
    VALUES (4, 4, 3, '2024-05-04 16:30:00', '2024-05-03 16:30:00');