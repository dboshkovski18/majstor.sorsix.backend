CREATE TABLE IF NOT EXISTS users
(
    id       bigserial primary key,
    username text unique,
    password text,
    role     text,
    is_account_not_expired bool,
    is_account_non_locked bool,
    is_credentials_not_expired bool,
    is_enabled bool,
    master_id bigint,
    client_id bigint,
    constraint pk_master
        foreign key (master_id)
            references masters (id) ON DELETE CASCADE ON UPDATE CASCADE,
    constraint pk_client
        foreign key (client_id)
            references clients (id) ON DELETE CASCADE ON UPDATE CASCADE
);