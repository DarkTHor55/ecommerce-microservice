-- Create category table
CREATE TABLE IF NOT EXISTS category (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255)
);

-- Create product table
CREATE TABLE IF NOT EXISTS product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255),
    available_quantity DOUBLE NOT NULL,
    price DECIMAL(38, 2),
    category_id INT,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Create table to store sequence values
CREATE TABLE IF NOT EXISTS sequences (
    name VARCHAR(255) NOT NULL PRIMARY KEY,
    value BIGINT NOT NULL
);

-- Initialize sequences with starting values
INSERT IGNORE INTO sequences (name, value) VALUES ('category_sequence', 0);
INSERT IGNORE INTO sequences (name, value) VALUES ('product_sequence', 0);


DELIMITER //

CREATE PROCEDURE get_next_value(IN sequence_name VARCHAR(255), OUT next_value BIGINT)
BEGIN
    -- Start a transaction
    START TRANSACTION;

    -- Get the current value and increment it by 50
    UPDATE sequences
    SET value = value + 50
    WHERE name = sequence_name;

    -- Get the updated value
    SELECT value INTO next_value
    FROM sequences
    WHERE name = sequence_name;

    -- Commit the transaction
    COMMIT;
END //

DELIMITER ;
-- Get the next value from the category_sequence
CALL get_next_value('category_sequence', @next_category_value);
SELECT @next_category_value;

-- Get the next value from the product_sequence
CALL get_next_value('product_sequence', @next_product_value);
SELECT @next_product_value;
-- Get the next value for category id
CALL get_next_value('category_sequence', @next_category_value);

-- Insert data into category table
INSERT INTO category (id, description, name) VALUES
(@next_category_value, 'Computer Keyboards', 'Keyboards'),
(@next_category_value + 1, 'Computer Monitors', 'Monitors'),
(@next_category_value + 2, 'Display Screens', 'Screens'),
(@next_category_value + 3, 'Computer Mice', 'Mice'),
(@next_category_value + 4, 'Computer Accessories', 'Accessories');

-- Verify data in category table
SELECT * FROM category;

-- Get the next value for product id
CALL get_next_value('product_sequence', @next_product_value);

-- Insert products for the 'Keyboards' category
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (@next_product_value, 10, 'Mechanical keyboard with RGB lighting', 'Mechanical Keyboard 1', 99.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (@next_product_value + 1, 15, 'Wireless compact keyboard', 'Wireless Compact Keyboard 1', 79.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (@next_product_value + 2, 20, 'Backlit gaming keyboard with customizable keys', 'Gaming Keyboard 1', 129.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (@next_product_value + 3, 25, 'Mechanical keyboard with wrist rest', 'Ergonomic Keyboard 1', 109.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (@next_product_value + 4, 18, 'Wireless keyboard and mouse combo', 'Wireless Combo 1', 69.99, (SELECT id FROM category WHERE name = 'Keyboards'));

-- Verify data in product table
SELECT * FROM product;
