
CREATE TABLE  customers(

                           customer_id SERIAL primary key,
                           customer_name varchar(100),
                           customer_surname varchar(100)
);

INSERT INTO customers (customer_name, customer_surname)
VALUES ('Mattia', 'Pappacena');

