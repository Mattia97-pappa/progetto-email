DELETE FROM customers c
    USING customers d
WHERE c.customer_name = d.customer_name
  AND c.customer_surname = d.customer_surname
  AND c.customer_id > d.customer_id;