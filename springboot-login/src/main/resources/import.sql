


INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');


INSERT INTO `usuarios` (username, password, enabled,nombre,apellido,email) VALUES ('andres','$2a$10$rc676iS4gdV9Dn4/LXKV8u5Ux9X2ob7.Qmo3Ji4aIlURn1lREW43W',1,'Andres','Guzman','a@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$3bXUXvb6Xu6XQAc69ARHz.HxgVPuwQutQ9TxidiFnCvo5wufrQM8a',1,'Beto','Ortiz','b@gmail.com');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);
