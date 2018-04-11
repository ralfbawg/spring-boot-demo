/*==============================================================*/
/* Table: SYS_BATCH_JOB                                         */
/*==============================================================*/
DROP TABLE IF EXISTS USER;
create table USER
(
   ID                   BIGINT not null auto_increment,
   USERNAME             varchar(32),
   AGE                  INT
);



