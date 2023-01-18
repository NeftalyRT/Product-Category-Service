INSERT INTO keywords (id, name) VALUES
(1, 'Lawn'),
(2, 'Garden'),
(3, 'GardeningTools'),
(4, 'Cleaning'),
(5, 'Cooking');

INSERT INTO categories (id, name, parent_id) VALUES
(1, 'Home Appliances', null),
(2, 'Lawn & Garden', 1),
(3, 'Major Appliances', 1),
(4, 'Kitchen Appliances', 3),
(5, 'General Appliances', 3);

INSERT INTO category_keywords (category_id, keyword_id) VALUES
(1, 4),
(4, 5),
(2, 1), (2, 2), (2, 3);