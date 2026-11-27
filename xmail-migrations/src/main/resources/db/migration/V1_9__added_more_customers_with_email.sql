INSERT INTO customers (customer_name, customer_surname, customer_email, customer_uuid)
SELECT
    names.first_names[1 + n % 20],
    names.last_names[1 + (n / 5) % 20],
    lower(names.first_names[1 + n % 20] || '.' || names.last_names[1 + (n / 5) % 20]) || n || '@example.com',
    gen_random_uuid()
FROM generate_series(1, 100) AS n,
    (SELECT
    ARRAY['Luca', 'Giulia', 'Marco', 'Francesca', 'Andrea', 'Sara', 'Matteo', 'Elena', 'Davide', 'Chiara',
    'Simone', 'Laura', 'Paolo', 'Marta', 'Fabio', 'Anna', 'Nicola', 'Irene', 'Stefano', 'Alice'] AS first_names,
    ARRAY['Bianchi', 'Romano', 'Colombo', 'Ricci', 'Marino', 'Greco', 'Bruno', 'Gallo', 'Conti', 'Costa',
    'Giordano', 'Rizzo', 'Lombardi', 'Moretti', 'Barbieri', 'Fontana', 'Santoro', 'Mariani', 'Rinaldi', 'Caruso'] AS last_names
    ) AS names;