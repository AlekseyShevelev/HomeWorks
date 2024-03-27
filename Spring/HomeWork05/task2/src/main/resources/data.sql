INSERT INTO users (username, password, email, role) VALUES ('Петров Василий', '123456789', 'vpetrov@yandex.ru', 'Роль 1');
INSERT INTO users (username, password, email, role) VALUES ('Иванов Сергей', '987654321', 'sivanov@yandex.ru', 'Роль 2');

INSERT INTO projects (name, description, createdDate) VALUES ('PROJECT_1', 'Проект 1', '2024-03-15');
INSERT INTO projects (name, description, createdDate) VALUES ('PROJECT_2', 'Проект 2', '2024-03-16');
INSERT INTO projects (name, description, createdDate) VALUES ('PROJECT_3', 'Проект 3', '2024-03-17');

INSERT INTO users_project (projectId, userId)
SELECT p.id, u.id
FROM projects p, users u
WHERE p.name = 'PROJECT_1' AND u.username = 'Петров Василий';

INSERT INTO users_project (projectId, userId)
SELECT p.id, u.id
FROM projects p, users u
WHERE p.name = 'PROJECT_2' AND u.username = 'Иванов Сергей';

INSERT INTO users_project (projectId, userId)
SELECT p.id, u.id
FROM projects p, users u
WHERE p.name = 'PROJECT_3' AND u.username in ('Петров Василий', 'Иванов Сергей');
