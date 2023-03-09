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

INSERT INTO usr_user (
	usr_id, 
	usr_login, 
	usr_name, 
	usr_surname, 
	usr_email, 
	usr_password, 
	usr_notes, 
	usr_phone, 
	usr_creation_date, 
	usr_down_date, 
	usr_photo) VALUES(1, 'demo', 'DEMONAME', 'DEMOSURNAME', 'demouser@mail.com', 'demouser', 'This is the demo user', '', NOW(), NULL, NULL);

ALTER SEQUENCE usr_user_usr_id_seq RESTART WITH 2;

INSERT INTO usr_role (rol_id, rol_name, rol_xml_client_permission, rol_notes) VALUES(1, 'ADMIN', '<?xml version="1.0" encoding="ISO-8859-1" standalone="no"?> <Security>  <!-- <MENU>  <ELEMENT attr="managerIO">      <Enabled restricted="yes"/>      <Visible restricted="yes"/>   </ELEMENT>  <ELEMENT attr="managerEntryPointControl">      <Enabled restricted="yes"/>      <Visible restricted="yes"/>   </ELEMENT>  </MENU>   <FORM archive="formRegistryManagement.form">  <ELEMENT attr="remove">   <Enabled restricted="yes"/>   <Visible restricted="yes"/>  </ELEMENT> </FORM>  <FORM archive="formRegistry.form">  <ELEMENT attr="IOR_INPUT_WEIGHT">   <Enabled restricted="yes"/>   <Visible restricted="yes"/>  </ELEMENT> </FORM> --> </Security>', 'Usuario administrador');

ALTER SEQUENCE usr_role_rol_id_seq RESTART WITH 2;

INSERT INTO usr_user_role (uro_id, usr_id, rol_id) VALUES(1, 1, 1);

ALTER SEQUENCE usr_user_role_uro_id_seq RESTART WITH 2;

