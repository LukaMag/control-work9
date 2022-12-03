create table users
(
    id       bigserial not null
        constraint users_pk
            primary key,
    email    varchar,
    active   boolean,
    password varchar(10000)
);

alter table users
    owner to postgres;

create unique index users_email_uindex
    on users (email);