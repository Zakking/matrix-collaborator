DROP TABLE IF EXISTS collaborator;
DROP TABLE IF EXISTS interview;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS collaborator_project;
DROP TABLE IF EXISTS situation;
DROP TABLE IF EXISTS collaborator_situation;

CREATE TABLE collaborator (
  mail_adresse VARCHAR(250) PRIMARY KEY
);

INSERT INTO collaborator (mail_adresse) VALUES
  ('adangote@sqli.com'),
  ('aelouardi@sqli.com'),
  ('ielouardi@sqli.com'),
  ('yelouardi@sqli.com');

CREATE TABLE interview (
  interview_id INT AUTO_INCREMENT  PRIMARY KEY,
  interview_title VARCHAR(250) NOT NULL,
  interview_description VARCHAR(250) NOT NULL,
  interview_date DATE DEFAULT current_date,
  collaborator_mail_adresse VARCHAR(250) NOT NULL
);

INSERT INTO interview (interview_title, interview_description, interview_date, collaborator_mail_adresse) VALUES
  ('First meeting','The interview of the first meeting','2020-01-01','adangote@sqli.com'),
  ('Annual point','Annual Point with TLRH','2020-01-02','aelouardi@sqli.com'),
  ('Pre-mission meeting','Pre-mission meeting','2020-01-03','ielouardi@sqli.com'),
  ('Meeting after Mission','Meeting after Mission','2020-01-04','yelouardi@sqli.com');


CREATE TABLE project (
  project_id INT AUTO_INCREMENT  PRIMARY KEY,
  project_title VARCHAR(250) NOT NULL,
  project_description VARCHAR(250) NOT NULL
);

INSERT INTO project (project_title, project_description) VALUES
  ('AEM','AEM Project'),
  ('RADLE','RADLE Project'),
  ('AXA','AXA Project'),
  ('AIRBUS','AIRBUS Project');

CREATE TABLE collaborator_project (
 mail_adresse VARCHAR(250) NOT NULL,
 project_id INT NOT NULL
);

INSERT INTO collaborator_project (mail_adresse, project_id) VALUES
  ('adangote@sqli.com',1),
  ('adangote@sqli.com',2),
  ('yelouardi@sqli.com',3),
  ('yelouardi@sqli.com',4);

  CREATE TABLE situation (
    situation_id INT AUTO_INCREMENT  PRIMARY KEY,
    situation_title VARCHAR(250) NOT NULL,
    situation_description VARCHAR(250) NOT NULL
  );
  INSERT INTO situation (situation_title, situation_description) VALUES
    ('InterContrat','Profile Disponible'),
    ('En mission','Profile En mission cher le client'),
    ('En projet sur site','Profile placer sur un projet forfait sur site');

  CREATE TABLE collaborator_situation (
   mail_adresse VARCHAR(250) NOT NULL,
   situation_id INT NOT NULL
  );

  INSERT INTO collaborator_project (mail_adresse, situation_id) VALUES
    ('adangote@sqli.com',1),
    ('adangote@sqli.com',2),
    ('yelouardi@sqli.com',3),
    ('yelouardi@sqli.com',4);
