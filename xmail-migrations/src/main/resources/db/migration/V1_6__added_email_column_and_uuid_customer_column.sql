ALTER TABLE customers
ADD COLUMN customer_email VARCHAR(200) DEFAULT NULL;

ALTER TABLE customers
ADD COLUMN customer_uuid UUID;

UPDATE customers
SET customer_uuid = gen_random_uuid ( );

ALTER table customers
alter column customer_uuid set not null;

UPDATE customers
SET customer_email = 'mattiap1997@outlook.it'
WHERE customer_id = 1;

