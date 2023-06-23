Create database DAWI_CL3_Grupo3;
use DAWI_CL3_Grupo3;

CREATE TABLE usuariocl3 (
                            idusu_cl3 INT auto_increment NOT NULL,
                            nomusu_cl3 varchar(200) NULL,
                            email_cl3 varchar(250) NULL,
                            pass_cl3 varchar(300) NULL,
                            nom_cl3 varchar(255) NULL,
                            ape_cl3 varchar(255) NULL,
                            activo BOOL NULL,
                            CONSTRAINT users_pk PRIMARY KEY (idusu_cl3)
);


CREATE TABLE rolcl3 (
                        idrol_cl3 INT auto_increment NOT NULL,
                        nomrol_cl3 varchar(250) NULL,
                        CONSTRAINT roles_pk PRIMARY KEY (idrol_cl3)
);


CREATE TABLE usuariorolcl3 (
                               idusu_cl3 INT NOT NULL,
                               idrol_cl3 INT NOT NULL,
                               CONSTRAINT usuario_rol_pk PRIMARY KEY (idusu_cl3, idrol_cl3),
                               CONSTRAINT usuario_rol_fk FOREIGN KEY (idusu_cl3) REFERENCES DAWI_CL3_Grupo3.usuariocl3(idusu_cl3),
                               CONSTRAINT usuario_rol_fk_1 FOREIGN KEY (idrol_cl3) REFERENCES DAWI_CL3_Grupo3.rolcl3(idrol_cl3)
);