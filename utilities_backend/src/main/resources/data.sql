INSERT INTO user (bill, email, username) VALUES (100,'username001@mail.ru', 'username001');
INSERT INTO user (bill, email, username) VALUES (200,'username002@mail.ru', 'username002');
INSERT INTO user (bill, email, username) VALUES (300,'username003@mail.ru', 'username003');
INSERT INTO user (bill, email, username) VALUES (400,'username004@mail.ru', 'username004');

INSERT INTO utility (date, amount, user_id) VALUES ('2021-03-07', 70, 1);
INSERT INTO utility (date, amount, user_id) VALUES ('2021-04-07', 80, 1);
INSERT INTO utility (date, amount, user_id) VALUES ('2021-04-07', 70, 2);
INSERT INTO utility (date, amount, user_id) VALUES ('2021-04-07', 70, 4);

INSERT INTO gas (amount, date, utility_id) VALUES (30, '2021-03-07', 1);
INSERT INTO gas (amount, date, utility_id) VALUES (20, '2021-04-07', 1);
INSERT INTO gas (amount, date, utility_id) VALUES (30, '2021-04-07', 2);
INSERT INTO gas (amount, date, utility_id) VALUES (20, '2021-04-07', 3);
INSERT INTO gas (amount, date, utility_id) VALUES (20, '2021-04-07', 4);

INSERT INTO water (amount, date, utility_id) VALUES (30, '2021-03-07', 1);
INSERT INTO water (amount, date, utility_id) VALUES (20, '2021-04-07', 1);
INSERT INTO water (amount, date, utility_id) VALUES (30, '2021-04-07', 2);
INSERT INTO water (amount, date, utility_id) VALUES (20, '2021-04-07', 3);
INSERT INTO water (amount, date, utility_id) VALUES (20, '2021-04-07', 4);

INSERT INTO electricity (amount, date, utility_id) VALUES (30, '2021-03-07', 1);
INSERT INTO electricity (amount, date, utility_id) VALUES (20, '2021-04-07', 1);
INSERT INTO electricity (amount, date, utility_id) VALUES (30, '2021-04-07', 2);
INSERT INTO electricity (amount, date, utility_id) VALUES (20, '2021-04-07', 3);
INSERT INTO electricity (amount, date, utility_id) VALUES (20, '2021-04-07', 4);
