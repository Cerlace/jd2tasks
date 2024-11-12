create table person
(
    id             int auto_increment
        primary key,
    age            int          null,
    salary         decimal      null,
    passport       varchar(10)  null,
    address        varchar(200) null,
    dateOfBirthday date         null,
    dateTimeCreate datetime     null,
    timeToLunch    time         null,
    letter         text         null
);
