CREATE TABLE product (
  id INT PRIMARY KEY,
  category VARCHAR(255) NOT NULL,
  discountPercentage DECIMAL(5, 2) NOT NULL DEFAULT 0.00,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);