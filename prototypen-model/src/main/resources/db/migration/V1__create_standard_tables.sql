CREATE TABLE usr_user (
	usr_id serial NOT NULL,
	usr_login varchar(50) NOT NULL,
	usr_name varchar(50) NULL,
	usr_surname varchar(100) NULL,
	usr_email varchar(250) NULL,
	usr_password varchar(50) NOT NULL,
	usr_notes text NULL,
	usr_phone varchar(50) NULL,
	usr_creation_date timestamp NULL DEFAULT now(),
	usr_down_date timestamp NULL,
	usr_photo varchar NULL,
	CONSTRAINT usr_user_pk PRIMARY KEY (usr_id),
	CONSTRAINT usr_user_un UNIQUE (usr_login)
);

CREATE TABLE usr_role (
	rol_id serial NOT NULL,
	rol_name varchar(100) NOT NULL,
	rol_xml_client_permission text NOT NULL,
	rol_json_client_permission text,
	rol_notes text NULL,
	CONSTRAINT usr_role_pk PRIMARY KEY (rol_id),
	CONSTRAINT usr_role_un UNIQUE (rol_name)
);

CREATE TABLE usr_user_role (
	uro_id serial NOT NULL,
	usr_id int4 NOT NULL,
	rol_id int4 NOT NULL,
	CONSTRAINT usr_user_role_pk PRIMARY KEY (uro_id)
);
ALTER TABLE usr_user_role ADD CONSTRAINT usr_user_role_fk FOREIGN KEY (usr_id) REFERENCES usr_user(usr_id);
ALTER TABLE usr_user_role ADD CONSTRAINT usr_user_role_fk_1 FOREIGN KEY (rol_id) REFERENCES usr_role(rol_id);

CREATE TABLE usr_server_permission (
	srp_id serial NOT NULL,
	srp_name varchar(400) NOT NULL,
	CONSTRAINT usr_server_permission_pk PRIMARY KEY (srp_id),
	CONSTRAINT usr_server_permission_un UNIQUE (srp_name)
);

CREATE TABLE usr_role_server_permission (
	rsp_id serial NOT NULL,
	rol_id int4 NOT NULL,
	srp_id int4 NOT NULL,
	CONSTRAINT usr_role_server_permiss_pk PRIMARY KEY (rsp_id)
);
ALTER TABLE usr_role_server_permission ADD CONSTRAINT usr_role_server_permiss_fk FOREIGN KEY (rol_id) REFERENCES usr_role(rol_id);
ALTER TABLE usr_role_server_permission ADD CONSTRAINT usr_role_server_permiss_fk_1 FOREIGN KEY (srp_id) REFERENCES usr_server_permission(srp_id);

INSERT INTO usr_user (usr_id, usr_login, usr_name, usr_surname, usr_email, usr_password, usr_notes, usr_phone, usr_creation_date, usr_down_date, usr_photo)
	VALUES(1, 'admin', 'ADMIN NAME', 'ADMIN SURNAME', 'adminuser@mail.com', 'adminuser', 'This is the administrator user', '', NOW(), NULL, NULL);
INSERT INTO usr_user (usr_id, usr_login, usr_name, usr_surname, usr_email, usr_password, usr_notes, usr_phone, usr_creation_date, usr_down_date, usr_photo)
	VALUES(2, 'demo', 'DEMO NAME', 'DEMO SURNAME', 'demouser@mail.com', 'demouser', 'This is the demo user', '', NOW(), NULL, NULL);
ALTER SEQUENCE usr_user_usr_id_seq RESTART WITH 2;

INSERT INTO usr_role (rol_id, rol_name, rol_xml_client_permission, rol_json_client_permission, rol_notes) VALUES(1, 'ADMIN', '<?xml version="1.0" encoding="UTF-8"?><security><MENU><ELEMENT attr="admin"><Enabled restricted="yes"/><Visible restricted="yes"/></ELEMENT></MENU></security>', NULL, 'Administrator');
INSERT INTO usr_role (rol_id, rol_name, rol_xml_client_permission, rol_json_client_permission, rol_notes) VALUES(2, 'USER', '<?xml version="1.0" encoding="UTF-8"?><security><MENU><ELEMENT attr="admin"><Enabled restricted="yes"/><Visible restricted="yes"/></ELEMENT></MENU></security>', '{ "menu": [{ "attr": "admin", "visible": false, "enabled": false }] }', 'User');
ALTER SEQUENCE usr_role_rol_id_seq RESTART WITH 3;

INSERT INTO usr_user_role (uro_id, usr_id, rol_id) VALUES(1, 1, 1);
INSERT INTO usr_user_role (uro_id, usr_id, rol_id) VALUES(2, 2, 2);
ALTER SEQUENCE usr_user_role_uro_id_seq RESTART WITH 3;

INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (1, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/userQuery');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (2, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/userInsert');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (3, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/userUpdate');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (4, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/userDelete');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (5, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/roleQuery');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (6, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/roleInsert');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (7, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/roleUpdate');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (8, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/roleDelete');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (9, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/serverRoleQuery');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (10, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/serverRoleUpdate');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (11, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/rolesForUserQuery');
INSERT INTO usr_server_permission(srp_id, srp_NAME) VALUES (12, 'com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService/rolesForUserUpdate');
ALTER SEQUENCE usr_server_permission_srp_id_seq RESTART WITH 13;

INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (1, 1, 1);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (2, 1, 2);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (3, 1, 3);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (4, 1, 4);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (5, 1, 5);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (6, 1, 6);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (7, 1, 7);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (8, 1, 8);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (9, 1, 9);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (10, 1, 10);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (11, 1, 11);
INSERT INTO usr_role_server_permission(rsp_id, rol_id, srp_id) VALUES (12, 1, 12);
ALTER SEQUENCE usr_role_server_permission_rsp_id_seq RESTART WITH 13;
