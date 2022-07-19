CREATE TABLE if not exists cities
(
    city_id bigserial primary key,
    name    text
);

CREATE TABLE if not exists masters
(
    id           bigserial primary key,
    name         text,
    surname      text,
    phone_number int,
    embg         int,
    gender       text,
    rating       float,
    type         text
);

CREATE TABLE masters_cities
(
    id     bigserial primary key,
    master bigserial,
    city   bigserial,
    constraint master_fk
        foreign key (master) references masters (id),
    constraint city_fk
        foreign key (city) references cities (city_id)
);

CREATE TABLE if not exists bookings
(
    id     bigserial primary key,
    date   date,
    master bigserial,
    constraint pk_master
        foreign key (master)
            references masters (id)
);