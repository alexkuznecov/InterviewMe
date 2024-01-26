create table candidate
(
    id                   bigint not null
        primary key,
    name                 varchar(255),
    additional_info      varchar(255),
    cv_link              varchar(255),
    expected_position    smallint
        constraint candidate_expected_position_check
            check ((expected_position >= 0) AND (expected_position <= 4)),
    experience           varchar(255),
    interview_date       timestamp(6) default CURRENT_TIMESTAMP,
    recommended_position smallint
        constraint candidate_recommended_position_check
            check ((recommended_position >= 0) AND (recommended_position <= 4))
);

alter table candidate
    owner to intrvme;

