create table work_logs
(
    id               bigserial not null
        constraint work_logs_pk
            primary key,
    spent_time       varchar(6),
    datetime_started timestamp default CURRENT_TIMESTAMP,
    user_id          bigserial not null
        constraint work_logs___fk_user_id
            references users
            on update cascade on delete cascade
);

alter table work_logs
    owner to postgres;

