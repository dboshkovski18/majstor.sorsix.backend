CREATE TABLE rated_masters
(
    id             bigserial primary key,
    recommendation text,
    client         bigserial,
    master         bigserial,
    constraint fk_client
        foreign key (client) references clients (id)
            on delete CASCADE,
    constraint fk_master
        foreign key (master) references masters (id)
            on delete CASCADE
);

INSERT INTO rated_masters (recommendation, client, master) values ('RECOMMENDED',2,1),
                                                                  ('NOT_RECOMMENDED',2,2),
                                                                  ('RECOMMENDED',3,1),
                                                                  ('RECOMMENDED',1,1)