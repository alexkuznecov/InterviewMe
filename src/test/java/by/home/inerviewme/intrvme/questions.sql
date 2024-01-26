create table questions
(
    id       bigint not null
        primary key,
    answer   varchar(255),
    text     varchar(255),
    level    varchar(255),
    priority integer default 0
);

alter table questions
    owner to intrvme;

