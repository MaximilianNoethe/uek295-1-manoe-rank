-- books
INSERT INTO rank (rank, buy_count, book_name)
VALUES (1, 1000, 'Besuch der alten Dame'),
       (2, 500, 'Tschick'),
       (4, 125, 'Harry Potter und der Stein der Weisen'),
       (3, 250, 'Harry Potter und das verwunschene Kind');

-- users
INSERT INTO users (users_Id, user_Name, password)
VALUES (1, 'user', 'Uek295'),
       (2, 'user2', 'uek295_2') ON CONFLICT DO NOTHING; -- If a conflict appears, do nothing.

-- roles
INSERT INTO roles(role_Id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER') ON CONFLICT DO NOTHING;

-- authorities
INSERT INTO authority(authority_Id, name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE') ON CONFLICT DO NOTHING; -- If a conflict appears, do nothing.

-- assign roles to users
INSERT INTO rank_users_roles (user_id, role_Id)
VALUES (1, 1),
       (2, 2) ON CONFLICT DO NOTHING;

-- assign authorities to roles
INSERT INTO rank_roles_authorities(role_Id, authority_Id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2) ON CONFLICT DO NOTHING;

