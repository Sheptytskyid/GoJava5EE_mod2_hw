# CREATE DATABASE  home_work1;
# USE home_work1;

CREATE TABLE IF NOT EXISTS companies (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);


CREATE TABLE IF NOT EXISTS projects (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(60)  NOT NULL,
  cost        INT UNSIGNED NOT NULL,
  company_id  INT          NOT NULL,
  customer_id INT          NOT NULL,
  FOREIGN KEY (company_id) REFERENCES companies (id),
  FOREIGN KEY (customer_id) REFERENCES customers (id)
);

CREATE TABLE IF NOT EXISTS developers (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(30) NOT NULL,
  salary     INT UNSIGNED,
  project_id INT,
  FOREIGN KEY (project_id) REFERENCES projects (id)
);


CREATE TABLE IF NOT EXISTS skills (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);


CREATE TABLE IF NOT EXISTS developers_skills (
  developer_id INT NOT NULL,
  skill_id     INT NOT NULL,
  PRIMARY KEY (developer_id, skill_id),
  FOREIGN KEY (developer_id) REFERENCES developers (id),
  FOREIGN KEY (skill_id) REFERENCES skills (id)
);