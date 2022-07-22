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
    phone_number text,
    embg         int,
    gender       text,
    type         text,
    email        text
);

CREATE TABLE masters_cities
(
    id     bigserial primary key,
    master_id bigserial,
    city_id   bigserial,
    constraint master_fk
        foreign key (master_id) references masters (id)
            on delete CASCADE
            on update CASCADE,
    constraint city_fk
        foreign key (city_id) references cities (city_id)
            on delete CASCADE
            on update CASCADE

);

CREATE TABLE if not exists clients
(
    id           bigserial primary key,
    name         text,
    surname      text,
    phone_number text,
    gender       text,
    email        text,
    address      text
);

CREATE TABLE if not exists bookings
(
    id     bigserial primary key,
    date   date,
    master_id bigserial,
    client_id bigserial,
    constraint pk_master
        foreign key (master_id)
            references masters (id) ON DELETE CASCADE ON UPDATE CASCADE,
    constraint pk_client
        foreign key (client_id)
            references clients (id)
);