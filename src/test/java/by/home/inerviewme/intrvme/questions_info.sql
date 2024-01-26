create table questions_info
(
    id              bigint not null
        primary key,
    additional_info varchar(255),
    mark            smallint,
    question_id     bigint
        constraint fkns8a74hk2wfrrjhjxnysh6g6e
            references questions,
    candidate_id    bigint
        constraint fkbvnw9coe6bmmpyms73w5vicl2
            references candidate,
    constraint uniquequestioninfo
        unique (question_id, candidate_id)
);

alter table questions_info
    owner to intrvme;

