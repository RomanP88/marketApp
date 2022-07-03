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