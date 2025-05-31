DELETE FROM worklogs;
DELETE FROM employees;
DELETE FROM worklog_types;
DELETE FROM grades;

INSERT INTO grades (id, name) VALUES (1, 'Engineer'), (2, 'Senior Engineer');

INSERT INTO worklog_types (id, name) VALUES (1, 'Development'), (2, 'Testing'), (3, 'Analysis');

-- Yeni Team Lead: Serdar (id 11)
INSERT INTO employees (id, first_name, last_name, grade_id, team_lead, director, start_date, end_date) VALUES
  (11, 'Serdar', 'Yılmaz', 2, NULL, 'Mehmet', '2025-01-01', NULL),  -- Serdar Team Lead, grade Senior Engineer, director Mehmet

  -- Çalışanlar (yarısı Serdar'a bağlı)
  (1, 'Zeynep', 'Demir', 1, 'Serdar', 'Mehmet', '2025-01-21', NULL),
  (2, 'Mert', 'Yılmaz', 2, 'Serdar', 'Mehmet', '2025-01-15', NULL),
  (3, 'Elif', 'Koç', 1, 'Serdar', 'Mehmet', '2025-01-27', NULL),
  (4, 'Emir', 'Şahin', 1, 'Serdar', 'Mehmet', '2025-01-18', NULL),
  (5, 'Ceren', 'Aydın', 1, 'Serdar', 'Mehmet', '2025-01-18', NULL),

  -- Diğer yarısı Ayşe'ye bağlı
  (6, 'Kaan', 'Çelik', 1, 'Ayşe', 'Mehmet', '2025-01-19', NULL),
  (7, 'Naz', 'Kara', 1, 'Ayşe', 'Mehmet', '2025-01-03', NULL),
  (8, 'Burak', 'Polat', 1, 'Ayşe', 'Mehmet', '2025-01-03', NULL),
  (9, 'Melis', 'Öztürk', 2, 'Ayşe', 'Mehmet', '2025-01-21', NULL),
  (10, 'Deniz', 'Arslan', 1, 'Ayşe', 'Mehmet', '2025-01-12', NULL);

INSERT INTO worklogs (employee_id, month_date, type_id, effort) VALUES
  (1, '2025-05', 3, 10),
  (2, '2025-05', 3, 12),
  (3, '2025-05', 1, 15),
  (4, '2025-05', 1, 10),
  (5, '2025-05', 1, 10),
  (6, '2025-05', 2, 10),
  (7, '2025-05', 1, 12),
  (8, '2025-05', 2, 10),
  (9, '2025-05', 2, 10),
  (10, '2025-05', 3, 12);

