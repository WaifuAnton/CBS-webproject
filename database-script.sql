create database electricityitems;

use electricityitems;

create table hibernate_sequences
(
    sequence_name varchar(255) not null
        primary key,
    next_val      int          null
);

create table users
(
    id       int auto_increment
        primary key,
    login    varchar(63)      not null,
    auth_str varchar(255)     not null,
    balance  double default 0 null,
    constraint users_auth_str_uindex
        unique (auth_str),
    constraint users_login_uindex
        unique (login)
);

create table conditioners
(
    id             int                            not null
        primary key,
    name           varchar(255) default 'unknown' not null,
    power          int                            not null,
    maxTemperature int                            not null,
    rentCost       double                         not null,
    minTemperature int                            not null,
    inUse          bit                            not null,
    type           varchar(255)                   null,
    usedBy         varchar(63)  default 'none'    not null,
    constraint conditioners_users_login_fk
        foreign key (usedBy) references users (login)
            on update cascade
);

create table items
(
    id       int auto_increment
        primary key,
    name     varchar(255) default 'unknown' not null,
    power    int                            not null,
    inUse    tinyint(1)                     not null,
    rentCost double                         not null,
    type     varchar(255)                   null,
    usedBy   varchar(63)  default 'none'    not null,
    constraint items_users_login_fk
        foreign key (usedBy) references users (login)
            on update cascade
);

create table kettles
(
    id       int auto_increment
        primary key,
    name     varchar(255) default 'unknown' not null,
    power    int                            not null,
    rentCost double                         not null,
    liters   int                            not null,
    inUse    bit                            not null,
    type     varchar(255)                   null,
    usedBy   varchar(63)  default 'none'    not null,
    constraint kettles_users_login_fk
        foreign key (usedBy) references users (login)
            on update cascade
);

create table salt
(
    id    int         not null,
    value varchar(32) not null,
    constraint salt_id_uindex
        unique (id),
    constraint salt_users_id_fk
        foreign key (id) references users (id)
            on delete cascade
);

alter table salt
    add primary key (id);

create table washingmachines
(
    id               int                            not null
        primary key,
    name             varchar(255) default 'unknown' not null,
    power            int                            not null,
    maxClothesWeight int                            not null,
    rentCost         double                         not null,
    inUse            bit                            not null,
    type             varchar(255)                   null,
    usedBy           varchar(63)  default 'none'    not null,
    constraint washingmachines_users_login_fk
        foreign key (usedBy) references users (login)
            on update cascade
);