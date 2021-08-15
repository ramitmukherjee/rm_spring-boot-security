CREATE TABLE USERS (
    username varchar2(255) PRIMARY KEY,
    password varchar2(255),
    enabled TINYINT(1)
);

CREATE TABLE AUTHORITIES (
    authority varchar2(255),
    username varchar2(255),
    foreign key (username) references USERS(username)
);