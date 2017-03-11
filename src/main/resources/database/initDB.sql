#CREATE DATABASE IF NOT EXISTS test123;
#USE test123;

CREATE TABLE IF NOT EXISTS companies (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
  id   INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(30)                    NOT NULL
);

CREATE TABLE IF NOT EXISTS projects (
  id          INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name        VARCHAR(60)                    NOT NULL,
  cost        INT UNSIGNED                   NOT NULL,
  company_id  INT DEFAULT NULL,
  customer_id INT DEFAULT NULL,
  FOREIGN KEY (company_id) REFERENCES companies (id),
  FOREIGN KEY (customer_id) REFERENCES customers (id)
);

CREATE TABLE IF NOT EXISTS developers (
  id         INT          AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name       VARCHAR(30)                             NOT NULL,
  salary     INT UNSIGNED DEFAULT NULL,
  project_id INT          DEFAULT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE IF NOT EXISTS skills (
  id   INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name VARCHAR(30)                    NOT NULL
);

CREATE TABLE IF NOT EXISTS developers_skills (
  id INT NOT NULL,
  skills_id     INT NOT NULL,
  PRIMARY KEY (id, skills_id),
  FOREIGN KEY (id) REFERENCES developers (id),
  FOREIGN KEY (skills_id) REFERENCES skills (id)
);