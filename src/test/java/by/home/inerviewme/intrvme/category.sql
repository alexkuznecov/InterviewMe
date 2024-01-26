create table category
(
    id     bigint not null
        primary key,
    name   varchar(255),
    weight bigint
);

alter table category
    owner to intrvme;

