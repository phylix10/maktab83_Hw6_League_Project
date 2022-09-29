create database league;

create table league_tbl
(
    name varchar,
    type varchar primary key
);

create table clubs
(
    league_type      varchar,
    name             varchar primary key,
    coach            varchar,
    stadium          varchar,
    number_of_player int,
    number_of_cups   int,
    constraint fk_league_type
        foreign key (league_type)
            references league_tbl (type)
);

create table football_tbl
(
    club_name         varchar primary key,
    number_of_matches int default 0,
    win               int default 0,
    draw              int default 0,
    lost              int default 0,
    goals_scored      int default 0,
    goals_received    int default 0,
    goals_difference  int default 0,
    point             int default 0,
    constraint fk_club_name
        foreign key (club_name)
            references clubs (name)
);

create table football_match
(
    match_id    serial primary key,
    match_type  varchar,
    host_team   varchar,
    host_goals  int,
    guest_team  varchar,
    guest_goals int,
    constraint fk_match_type
        foreign key (match_type)
            references league_tbl (type),
    constraint fk_host_team
        foreign key (host_team)
            references clubs (name),
    constraint fk_guest_team
        foreign key (guest_team)
            references clubs (name)
);

create table volleyball_tbl
(
    club_name         varchar primary key,
    number_of_matches int default 0,
    win               int default 0,
    lost              int default 0,
    win_sets          int default 0,
    lost_sets         int default 0,
    point             int default 0,
    constraint fk_club_name
        foreign key (club_name)
            references clubs (name)
);

create table volleyball_match
(
    match_id    serial primary key,
    match_type  varchar,
    host_team   varchar,
    host_sets  int,
    guest_team  varchar,
    guest_sets int,
    constraint fk_match_type
        foreign key (match_type)
            references league_tbl (type),
    constraint fk_host_team
        foreign key (host_team)
            references clubs (name),
    constraint fk_guest_team
        foreign key (guest_team)
            references clubs (name)
)