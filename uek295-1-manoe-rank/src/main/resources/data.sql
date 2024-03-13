-- books
INSERT INTO rank (rank, buy_count, book_name)
VALUES (1, 1000, 'Besuch der alten Dame'),
       (2, 500, 'Tschick'),
       (4, 125, 'Harry Potter und der Stein der Weisen'),
       (3, 250, 'Harry Potter und das verwunschene Kind');


-- roles
INSERT INTO roles(role_Id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER') ON CONFLICT DO NOTHING;

-- authorities
INSERT INTO authorities(authority_Id, name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE') ON CONFLICT DO NOTHING; -- If a conflict appears, do nothing.

-- assign authorities to roles
INSERT INTO rank_roles_authorities(id_role, id_authority)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2) ON CONFLICT DO NOTHING;

-- users and assign roles to users
INSERT INTO users (user_Id, user_Name, password, id_role)
VALUES (1, 'user', 'Uek295', 1),
       (2, 'user2', 'Uek295_2', 2) ON CONFLICT DO NOTHING; -- If a conflict appears, do nothing.



