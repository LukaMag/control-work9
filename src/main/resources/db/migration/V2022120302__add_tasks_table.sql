create table tasks
(
    id           bigserial not null
        constraint tasks_pk
            primary key,
    name         varchar,
    date_created date default CURRENT_DATE,
    status       varchar   not null,
    user_id      bigserial not null
        constraint tasks___fk_user_id
            references users
            on update cascade on delete cascade
);

alter table tasks
    owner to postgres;

