# CREATE DATABASE  home_work1;
# USE home_work1;

CREATE TABLE IF NOT EXISTS companies (
  company_id INT AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(30) NOT NULL
);


CREATE TABLE IF NOT EXISTS projects (
  project_id  INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(60)  NOT NULL,
  cost        INT UNSIGNED NOT NULL,
  company_id  INT DEFAULT NULL,
  customer_id INT DEFAULT NULL,
  FOREIGN KEY (company_id) REFERENCES companies (company_id),
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

CREATE TABLE IF NOT EXISTS developers (
  developer_id INT AUTO_INCREMENT PRIMARY KEY,
  name         VARCHAR(30) NOT NULL,
  salary       INT UNSIGNED,
  project_id   INT,
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);


CREATE TABLE IF NOT EXISTS skills (
  skill_id INT AUTO_INCREMENT PRIMARY KEY,
  name     VARCHAR(30) NOT NULL
);


CREATE TABLE IF NOT EXISTS developers_skills (
  developer_id INT NOT NULL,
  skill_id     INT NOT NULL,
  PRIMARY KEY (developer_id, skill_id),
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (skill_id) REFERENCES skills (skill_id)
);