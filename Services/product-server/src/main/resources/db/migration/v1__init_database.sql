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

-- Create a stored procedure to get the next value from the sequence
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

-- Example of using the stored procedure
-- Get the next value from the category_sequence
CALL get_next_value('category_sequence', @next_category_value);
SELECT @next_category_value;

-- Get the next value from the product_sequence
CALL get_next_value('product_sequence', @next_product_value);
SELECT @next_product_value;
