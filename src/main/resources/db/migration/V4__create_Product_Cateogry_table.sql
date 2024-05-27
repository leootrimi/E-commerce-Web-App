CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(1024),
    image VARCHAR(255),
    category_id BIGINT,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES category(id)
);
