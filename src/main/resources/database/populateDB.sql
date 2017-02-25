-- Fill the company table --
INSERT INTO companies (name)
VALUES
  ('EPAM'),
  ('CIKLUM'),
  ('ORACLE');

-- Fill the customers table --
INSERT INTO customers (name)
VALUES
  ('Ministry of Culture'),
  ('Cisco'),
  ('Audi');
-- Fill the project table --
INSERT INTO projects (name, cost, company_id, customer_id)
VALUES
  ('Museums guide web site', 11300,  1, 1),
  ('GoIT phone application', 13000, 2, 2),
  ('Remote driver mobile service',15000,  3, 3),
  ('Mobile network firewall', 2000, 2, 1),
  ('Art gallery',3000, 1, 1),
  ('LTE Network manager',7200, 2, 3),
  ('Kiev sightseeing online tour ',5400, 1, 3),
  ('Car navigation system',6900, 3, 2),
  ('Smart driving', 9300, 3, 2);

-- Fill the developers table--
INSERT INTO developers (name, project_id)
VALUES
  ('Denys Butenko', 1),
  ('Nick Pick', 2),
  ('Joe Goe', 3),
  ('Roman Moroz', 4),
  ('Roman Boyko', 5),
  ('Oleg Moroz', 6),
  ('Katia Liakh', 7),
  ('Olena Bilan', 8),
  ('Roman Chalyi', 9),
  ('Petro Kish', 1),
  ('Vasyl Chornyi', 2),
  ('Ivan Brom', 3),
  ('Cristina Boyko', 4);

-- Fill the skills table--
INSERT INTO skills (name)
VALUES
  ('Java'),
  ('C++'),
  ('C#'),
  ('Maven'),
  ('Tomcat');

-- Fill the developers skills table--
INSERT INTO developers_skills (developer_id, skill_id)
VALUES
  (1, 1),
  (1, 4),
  (1, 5),
  (2, 2),
  (2, 4),
  (2, 5),
  (3, 3),
  (3, 4),
  (3, 5),
  (4, 1),
  (4, 4),
  (4, 5);

