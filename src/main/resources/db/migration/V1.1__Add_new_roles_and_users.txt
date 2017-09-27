
INSERT INTO users (username, password, email, enabled) VALUES ('admin', 'admin', 'danil661@mail.ru', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('moderator', 'moderator', 'danil662@mail.ru', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('some_user', 'user', 'danil663@mail.ru', TRUE);

INSERT INTO roles (name, description) VALUES ('ROLE_ADMIN', 'Create moderator and user.');
INSERT INTO roles (name, description) VALUES ('ROLE_MODERATOR', 'Delete wrong goods, create categories and approve new user request.');
INSERT INTO roles (name, description) VALUES ('ROLE_USER', 'Can create goods.');
INSERT INTO roles (name, description) VALUES ('ROLE_GUEST', 'Can see goods.');
