


INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');


INSERT INTO `usuarios` (username, password, enabled) VALUES ('andres','$2a$10$rc676iS4gdV9Dn4/LXKV8u5Ux9X2ob7.Qmo3Ji4aIlURn1lREW43W',1);
INSERT INTO `usuarios` (username, password, enabled) VALUES ('admin','$2a$10$3bXUXvb6Xu6XQAc69ARHz.HxgVPuwQutQ9TxidiFnCvo5wufrQM8a',1);

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);
