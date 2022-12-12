DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sequence INT NOT NULL
);

DROP TABLE IF EXISTS size;
CREATE TABLE size (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    stock_id INT,
    back_soon BOOLEAN NOT NULL,
    special BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS stock;
CREATE TABLE stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT NOT NULL
);
