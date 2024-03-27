CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NULL,
    role VARCHAR(20) NULL
);

CREATE TABLE projects (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    createdDate DATE NOT NULL
);

CREATE TABLE users_project (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    projectId INT NOT NULL,
    userId INT NOT NULL,
    FOREIGN KEY (projectId) REFERENCES projects (id),
    FOREIGN KEY (userId) REFERENCES users (id)
);