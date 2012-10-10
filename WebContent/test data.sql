/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/9/18 11:58:10                           */
/*==============================================================*/

/*==============================================================*/
/* Table: USERINFO                                              */
/*==============================================================*/
/*create table USERINFO
(
   userid               integer not null,
   username             varchar(200),
   password             varchar(20),
   primary key (userid)
);*/
INSERT INTO USERINFO VALUES(1,'user1','123');
INSERT INTO USERINFO VALUES(2,'user2','123');
INSERT INTO USERINFO VALUES(3,'user3','123');

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
/*create table ROLE
(
   roleid               Integer not null,
   rolename             varchar(200),
   primary key (roleid)
);*/

INSERT INTO ROLE VALUES(1,'administrator');
INSERT INTO ROLE VALUES(2,'master');
INSERT INTO ROLE VALUES(3,'user');

/*==============================================================*/
/* Table: USERINFO_ROLE                                         */
/*==============================================================*/
/*create table USERINFO_ROLE
(
   userinfo_role_id     Integer not null,
   roleid               Integer,
   userid               integer,
   primary key (userinfo_role_id)
);*/

INSERT INTO USERINFO_ROLE VALUES(1,1,1);
INSERT INTO USERINFO_ROLE VALUES(2,2,2);
INSERT INTO USERINFO_ROLE VALUES(3,3,3);


/*==============================================================*/
/* Table: FUNCTION                                              */
/*==============================================================*/
/*create table FUNCTION
(
   functionid           integer not null,
   moduleid             integer,
   url                  varchar(1000),
   functionname         varchar(200),
   primary key (functionid)
);*/

INSERT INTO FUNCTION VALUES(1,1,'url1','func1');
INSERT INTO FUNCTION VALUES(2,1,'url2','func2');
INSERT INTO FUNCTION VALUES(3,2,'url3','func3');

/*==============================================================*/
/* Table: ROLE_FUNCTION                                         */
/*==============================================================*/
/*create table ROLE_FUNCTION
(
   rolefunctionid       Integer not null,
   roleid               integer,
   functionid           integer,
   primary key (rolefunctionid)
);*/

INSERT INTO ROLE_FUNCTION VALUES(1,1,1);
INSERT INTO ROLE_FUNCTION VALUES(2,1,2);
INSERT INTO ROLE_FUNCTION VALUES(3,1,3);
INSERT INTO ROLE_FUNCTION VALUES(4,2,1);
INSERT INTO ROLE_FUNCTION VALUES(5,2,2);
INSERT INTO ROLE_FUNCTION VALUES(6,3,1);

/*==============================================================*/
/* Table: MODULE                                                */
/*==============================================================*/
/*create table MODULE
(
   moduleid             integer not null,
   modulename           varchar(200),
   primary key (moduleid)
);*/

INSERT INTO MODULE VALUES(1,'module1');
INSERT INTO MODULE VALUES(2,'module2');







/*
 * alter table FUNCTION add constraint FK_FK_FUNCTION_MODULE foreign key (moduleid)
      references MODULE (moduleid) on delete restrict on update restrict;

alter table ROLE_FUNCTION add constraint FK_FK_FUNCTION_ROLEFUNCTION foreign key (functionid)
      references FUNCTION (functionid) on delete restrict on update restrict;

alter table ROLE_FUNCTION add constraint FK_FK_ROLE_ROLEFUNCTION foreign key (roleid)
      references ROLE (roleid) on delete restrict on update restrict;

alter table USERINFO_ROLE add constraint FK_FK_ROLE_USERINFOROLE foreign key (roleid)
      references ROLE (roleid) on delete restrict on update restrict;

alter table USERINFO_ROLE add constraint FK_FK_USERINFO_USERINFOROLE foreign key (userid)
      references USERINFO (userid) on delete restrict on update restrict;
 * */

