CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    user_name  character varying(255) unique NOT NULL,
    password   bytea                         NOT NULL,
    icq_number int unique                    NOT NULL
);

CREATE TABLE contacts
(
    user_id    int NOT NULL,
    contact_id int
);

CREATE TABLE messages
(
    id            SERIAL PRIMARY KEY,
    from_user_icq int NOT NULL,
    to_user_icq   int NOT NULL,
    value_message character varying(1000),
    creation_date timestamptz
);

insert into users (id, user_name, password, icq_number)
values (default, 'pavel', E'\\xE10ADC3949BA59ABBE56E057F20F883E', 1000);

insert into users (id, user_name, password, icq_number)
values (default, 'dmitrii', E'\\xE10ADC3949BA59ABBE56E057F20F883E', 1001);

insert into users (id, user_name, password, icq_number)
values (default, 'stas', E'\\xE10ADC3949BA59ABBE56E057F20F883E', 1002);

insert into users (id, user_name, password, icq_number)
values (default, 'artem', E'\\xE10ADC3949BA59ABBE56E057F20F883E', 1003);

insert into contacts (user_id, contact_id)
values (1, 2);

insert into contacts (user_id, contact_id)
values (2, 3);

insert into contacts (user_id, contact_id)
values (2, 4);

insert into contacts (user_id, contact_id)
values (2, 1);

insert into contacts (user_id, contact_id)
values (1, 3);

INSERT INTO messages (id, from_user_icq, to_user_icq, value_message, creation_date)
values (default, 1000, 1001, 'привет, я сделал ДЗ, глянешь мой код?', '2023-01-06 10:23:04+05');

INSERT INTO messages (id, from_user_icq, to_user_icq, value_message, creation_date)
values (default, 1001, 1000, 'привет, глянул - обыкновенный гавнокод', '2023-01-06 12:35:54+07');

INSERT INTO messages (id, from_user_icq, to_user_icq, value_message, creation_date)
values (default, 1000, 1001, 'спасибо, бро!', '2023-01-06 10:44:34+05');

INSERT INTO messages (id, from_user_icq, to_user_icq, value_message, creation_date)
values (default, 1000, 1002, 'qa.guru это круто!', '2023-01-06 11:44:34+05');