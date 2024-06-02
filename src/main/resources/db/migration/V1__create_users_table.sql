CREATE TABLE IF NOT EXISTS users  (
    userid SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    username VARCHAR(100),
    password VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    state VARCHAR(100),
    zip_code VARCHAR(20),
    role INTEGER
);
