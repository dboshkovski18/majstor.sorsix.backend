CREATE TABLE rated_masters
(
    id             bigserial primary key,
    recommendation text,
    client_id         bigserial,
    master_id         bigserial,
    constraint fk_client
        foreign key (client_id) references clients (id)
            on delete CASCADE,
    constraint fk_master
        foreign key (master_id) references masters (id)
            on delete CASCADE
);

INSERT INTO rated_masters (recommendation, client_id, master_id) values ('RECOMMENDED',2,1),
                                                                  ('NOT_RECOMMENDED',2,2),
                                                                  ('RECOMMENDED',3,1),
                                                                  ('RECOMMENDED',1,1)