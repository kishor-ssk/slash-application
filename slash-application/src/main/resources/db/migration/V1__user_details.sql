CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;

CREATE SEQUENCE IF NOT EXISTS user_details_user_id_seq;

CREATE TABLE IF NOT EXISTS user_details
(
    user_id bigint NOT NULL DEFAULT nextval('user_details_user_id_seq'),
    email varchar(100) NULL,
    password varchar(255) NULL,
    phonenumber varchar(20) NULL,
    name varchar(50) NULL,
    dateofbirth varchar(30) NULL,
    gender varchar(10) NULL,

    CONSTRAINT PK_user_details PRIMARY KEY (user_id)
);