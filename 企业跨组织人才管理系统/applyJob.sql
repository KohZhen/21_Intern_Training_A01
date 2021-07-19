/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/15 14:12:33                           */
/*==============================================================*/


drop table if exists tb_applicants;

drop table if exists tb_apply_job;

drop table if exists tb_article;

drop table if exists tb_certificate;

drop table if exists tb_class_info;

drop table if exists tb_company;

drop table if exists tb_favPost;

drop table if exists tb_info;

drop table if exists tb_major;

drop table if exists tb_menu;

drop table if exists tb_post;

drop table if exists tb_project_exp;

drop table if exists tb_resume;

drop table if exists tb_resume_manage;

drop table if exists tb_special_col;

drop table if exists tb_training_exp;

drop table if exists tb_user;

drop table if exists tb_userMenu;

drop table if exists tb_workExp;

/*==============================================================*/
/* Table: tb_applicants                                         */
/*==============================================================*/
create table tb_applicants
(
   ID                   int not null auto_increment,
   name                 name,
   account              varchar(100),
   password             varchar(100),
   birthDate            date,
   major                int,
   gra_school           varchar(100),
   edu_level            varchar(100),
   hp_num               varchar(100),
   gender               int,
   varchar              varchar(100),
   gra_date             date,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_apply_job                                          */
/*==============================================================*/
create table tb_apply_job
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   salary_req           varchar(100),
   work_place           varchar(100),
   work_des             varchar(100),
   job                  varchar(100),
   resume_id            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_article                                            */
/*==============================================================*/
create table tb_article
(
   ID                   int(11) not null auto_increment,
   column               int(11),
   title                varchar(100),
   title_pic            varchar(100),
   summary              varchar(200),
   author               varchar(100),
   link                 varchar(100),
   content              text,
   sequence             int(11),
   create_date          date,
   creator              int(11),
   last_edit            date,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_certificate                                        */
/*==============================================================*/
create table tb_certificate
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   doc                  varchar(100),
   get_date             date,
   resume_id            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_class_info                                         */
/*==============================================================*/
create table tb_class_info
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_company                                            */
/*==============================================================*/
create table tb_company
(
   ID                   int not null auto_increment,
   name                 int,
   account              varchar(100),
   password             varchar(100),
   contacts             varchar(100),
   contact_no           varchar(100),
   email                varchar(100),
   address              varchar(200),
   website              varchar(100),
   size                 varchar(100),
   type                 varchar(100),
   logo                 varchar(100),
   intro                text,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_favPost                                            */
/*==============================================================*/
create table tb_favPost
(
   ID                   int not null auto_increment,
   company_id           int,
   post_id              int,
   applicants_id        int,
   keep_date            date,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_info                                               */
/*==============================================================*/
create table tb_info
(
   ID                   int not null auto_increment,
   key                  varchar(100),
   value                varchar(100),
   num                  int,
   status               int,
   class_id             int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_major                                              */
/*==============================================================*/
create table tb_major
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   parent_ID            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_menu                                               */
/*==============================================================*/
create table tb_menu
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   icon                 varchar(100),
   link                 varchar(100),
   authority            varchar(100),
   parent_ID            int,
   type                 int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_post                                               */
/*==============================================================*/
create table tb_post
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   edu_req              varchar(100),
   salary               varchar(100),
   post_des             text,
   company_id           int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_project_exp                                        */
/*==============================================================*/
create table tb_project_exp
(
   ID                   int not null auto_increment,
   project_name         varchar(100),
   project_des          text,
   start_date           date,
   end_date             date,
   resume_id            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_resume                                             */
/*==============================================================*/
create table tb_resume
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   apply_status         int,
   self_eva             text,
   advantage_des        text,
   applicants_id        int,
   status               int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_resume_manage                                      */
/*==============================================================*/
create table tb_resume_manage
(
   ID                   int not null,
   company_id           int,
   post_id              int,
   resume_id            int,
   send_date            date,
   status               int,
   applicants_ID        int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_special_col                                        */
/*==============================================================*/
create table tb_special_col
(
   ID                   int(11) not null auto_increment,
   name                 varchar(100),
   upper_column         int(11),
   picture              varchar(100),
   summary              varchar(200),
   single_page          char(1),
   link                 varchar(100),
   content              text,
   sequence             int(11),
   create_date          date,
   creator              int(11),
   delete               char(1),
   position             int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_training_exp                                       */
/*==============================================================*/
create table tb_training_exp
(
   ID                   int not null auto_increment,
   开始时间                 date,
   结束时间                 date,
   培训机构                 varchar(100),
   培训课程                 varchar(100),
   简历ID                 int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   ID                   int not null auto_increment,
   account              varchar(100),
   password             varchar(100),
   name                 varchar(100),
   login_date           date,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_userMenu                                           */
/*==============================================================*/
create table tb_userMenu
(
   user_id              int not null,
   menu_id              int not null,
   primary key (user_id, menu_id)
);

/*==============================================================*/
/* Table: tb_workExp                                            */
/*==============================================================*/
create table tb_workExp
(
   ID                   int not null auto_increment,
   com_name             varchar(100),
   post                 varchar(100),
   salary               varchar(100),
   des_                 text,
   on_date              date,
   leave_date           date,
   resume_id            int,
   primary key (ID)
);

