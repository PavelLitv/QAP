CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    user_name  character varying(255) unique NOT NULL,
    password   character varying(255)        NOT NULL,
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
    from_user_id  int NOT NULL,
    to_user_id    int NOT NULL,
    value_message character varying(1000),
    creation_date timestamptz
);

insert into users (id, user_name, password, icq_number)
values (default, 'pavel', 'xe10adc3949ba59abbe56e057f20f883e', 1000);

insert into users (id, user_name, password, icq_number)
values (default, 'dmitrii', 'xe10adc3949ba59abbe56e057f20f883e', 1001);

insert into users (id, user_name, password, icq_number)
values (default, 'stas', 'xe10adc3949ba59abbe56e057f20f883e', 1002);

insert into users (id, user_name, password, icq_number)
values (default, 'artem', 'xe10adc3949ba59abbe56e057f20f883e', 1003);

insert into contacts (user_id, contact_id)
values (1, 2);

insert into contacts (user_id, contact_id)
values (2, 3);

insert into contacts (user_id, contact_id)
values (2, 4);

insert into contacts (user_id, contact_id)
values (2, 1);

INSERT INTO messages (id, from_user_id, to_user_id, value_message, creation_date)
values (default, 1, 2, 'привет, я сделал ДЗ, глянешь мой код?', '2023-01-06 10:23:04+05');

INSERT INTO messages (id, from_user_id, to_user_id, value_message, creation_date)
values (default, 2, 1, 'привет, глянул - обыкновенный гавнокод', '2023-01-06 12:35:54+07');

INSERT INTO messages (id, from_user_id, to_user_id, value_message, creation_date)
values (default, 1, 2, 'спасибо, бро!', '2023-01-06 10:44:34+05');