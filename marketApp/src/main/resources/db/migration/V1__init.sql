-- create table categories (id bigserial primary key, title varchar(255));
-- insert into categories(title)
-- values('Food');


-- create table products (id bigserial primary key, title varchar(255), cost int, category_id bigint references categories(id));
--
-- insert into products(title, cost, category_id)
-- values
--     ('Bread', 40, 1),
--     ('Milk', 80, 1),
--     ('Eat', 100, 1),
--     ('Fish', 150, 1),
--     ('Sugar', 70, 1),
--     ('Eggs', 90, 1),
--     ('Apple', 60, 1),
--     ('Pork', 200, 1),
--     ('Flour', 50, 1),
--     ('Vermicelli', 45, 1),
--     ('Salt', 25, 1),
--     ('Carrot', 30, 1),
--     ('Onion', 20, 1),
--     ('Olive oil', 140, 1),
--     ('Potato', 50, 1),
--     ('Chicken', 150, 1),
--     ('Tomatoes', 80, 1),
--     ('Sausage', 120, 1),
--     ('Cheese', 100, 1),
--     ('Dumplings', 130, 1);

create table products (id bigserial primary key, title varchar(255), cost int);

insert into products(title, cost)
values
    ('Bread', 40),
    ('Milk', 80),
    ('Eat', 100),
    ('Fish', 150),
    ('Sugar', 70),
    ('Eggs', 90),
    ('Apple', 60),
    ('Pork', 200),
    ('Flour', 50),
    ('Vermicelli', 45),
    ('Salt', 25),
    ('Carrot', 30),
    ('Onion', 20),
    ('Olive oil', 140),
    ('Potato', 50),
    ('Chicken', 150),
    ('Tomatoes', 80),
    ('Sausage', 120),
    ('Cheese', 100),
    ('Dumplings', 130);


create table users
(
    id              bigserial primary key,
    username        varchar(30) not null unique,
    password        varchar(100) not null,
    email           varchar(50) not null unique,
    enthusiasm      varchar(70),
    created_at timestamp default  current_time,
    updated_at timestamp default  current_time
);


create table roles
(
    id          serial primary key ,
    name        varchar(50) not null,
    created_at timestamp default  current_time,
    updated_at timestamp default  current_time
);

create table users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);


insert into users(username, password, email, enthusiasm)
values
    ('Bob', '$2a$12$3gW6p2O3C9ufSMBHLDsuHOKulDKNu2iyvo1CEFuhSudeQQzdGOKR6', 'bob18@mail.ru', 'football'),
    ('John', '$2a$12$jZSwdf7wsnu3RvUJ4YtB7.BePRAab/Lm3bQNFQPFeyyxBnzqnyVc2', 'john99@mail.ru', 'dance');

insert into roles(name)
values
    ('ROLE_USER'), ('ROLE_ADMIN');

insert into users_roles (user_id, role_id)
values
    (1, 2), (2, 1);


