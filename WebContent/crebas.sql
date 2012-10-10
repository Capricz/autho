/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/9/18 11:58:10                           */
/*==============================================================*/


drop table if exists FUNCTION;

drop table if exists MODULE;

drop table if exists ROLE;

drop table if exists ROLE_FUNCTION;

drop table if exists USERINFO;

drop table if exists USERINFO_ROLE;

/*==============================================================*/
/* Table: FUNCTION                                              */
/*==============================================================*/
create table FUNCTION
(
   functionid           integer not null,
   moduleid             integer,
   url                  varchar(1000),
   functionname         varchar(200),
   primary key (functionid)
);

/*==============================================================*/
/* Table: MODULE                                                */
/*==============================================================*/
create table MODULE
(
   moduleid             integer not null,
   modulename           varchar(200),
   primary key (moduleid)
);

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
create table ROLE
(
   roleid               Integer not null,
   rolename             varchar(200),
   primary key (roleid)
);

/*==============================================================*/
/* Table: ROLE_FUNCTION                                         */
/*==============================================================*/
create table ROLE_FUNCTION
(
   rolefunctionid       Integer not null,
   roleid               integer,
   functionid           integer,
   primary key (rolefunctionid)
);

/*==============================================================*/
/* Table: USERINFO                                              */
/*==============================================================*/
create table USERINFO
(
   userid               integer not null,
   username             varchar(200),
   password             varchar(20),
   primary key (userid)
);

/*==============================================================*/
/* Table: USERINFO_ROLE                                         */
/*==============================================================*/
create table USERINFO_ROLE
(
   userinfo_role_id     Integer not null,
   roleid               Integer,
   userid               integer,
   primary key (userinfo_role_id)
);

alter table FUNCTION add constraint FK_FK_FUNCTION_MODULE foreign key (moduleid)
      references MODULE (moduleid) on delete restrict on update restrict;

alter table ROLE_FUNCTION add constraint FK_FK_FUNCTION_ROLEFUNCTION foreign key (functionid)
      references FUNCTION (functionid) on delete restrict on update restrict;

alter table ROLE_FUNCTION add constraint FK_FK_ROLE_ROLEFUNCTION foreign key (roleid)
      references ROLE (roleid) on delete restrict on update restrict;

alter table USERINFO_ROLE add constraint FK_FK_ROLE_USERINFOROLE foreign key (roleid)
      references ROLE (roleid) on delete restrict on update restrict;

alter table USERINFO_ROLE add constraint FK_FK_USERINFO_USERINFOROLE foreign key (userid)
      references USERINFO (userid) on delete restrict on update restrict;

