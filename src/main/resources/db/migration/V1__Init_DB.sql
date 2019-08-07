create table user_account
(
  id       bigint       not null
    constraint user_account_pkey
      primary key,
  login    varchar(254) not null
    constraint uk_plpggm55i6uhyv404q6pyu0ub
      unique,
  password varchar(60)  not null
);

create sequence if not exists user_sequence
  as bigint
  start 1
  increment by 1
  owned by user_account.id;

create table user_role
(
  user_id     bigint not null
    constraint fk7ojmv1m1vrxfl3kvt5bi5ur73
      references user_account,
  authorities varchar(255)
);

create table title
(
  tconst varchar(255) not null
    constraint title_pkey
      primary key
);

create table user_watchlist
(
  title_id varchar(255) not null
    constraint fk9vcldkkc9x334ansvbuur8og7
      references title,
  user_id  bigint       not null
    constraint fkqnuwa9s0v864vfhggf79ar3qy
      references user_account,
  watched  boolean,
  constraint user_watchlist_pkey
    primary key (title_id, user_id)
);


create table password_reset_token
(
  id          bigint       not null
    constraint password_reset_token_pkey
      primary key,
  expiry_date timestamp    not null,
  token       varchar(255) not null
    constraint uk_g0guo4k8krgpwuagos61oc06j
      unique,
  user_id     bigint       not null
    constraint fkns9q9f0f318uaoxiqn6lka9ux
      references user_account
);

create sequence if not exists token_sequence
  as bigint
  start 1
  increment by 1
  owned by password_reset_token.id;

create table name_basics
(
  nconst             text,
  primary_name       text,
  birth_year         integer,
  death_year         integer,
  primary_profession text,
  known_for_titles   text
);

create table title_basics
(
  tconst          text,
  title_type      text,
  primary_title   text,
  original_title  text,
  is_adult        boolean,
  start_year      integer,
  end_year        integer,
  runtime_minutes integer,
  genres          text
);

create table title_principals
(
  tconst     text,
  ordering   integer,
  nconst     text,
  category   text,
  job        text,
  characters text
);

create table title_ratings
(
  tconst         text,
  average_rating double precision,
  num_votes      integer
);