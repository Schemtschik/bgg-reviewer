CREATE TABLE dates (
    id INT NOT NULL PRIMARY KEY,
    year INT NOT NULL,
    month INT NOT NULL,
    day INT NOT NULL
);

CREATE TABLE products (
    id INT NOT NULL PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    issue_date INT NOT NULL REFERENCES dates(id)
);

CREATE TABLE game_families (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fans_count int DEFAULT 0,
    games_count int DEFAULT 0,
    first_issue_date INT NOT NULL REFERENCES dates(id)
);

CREATE TABLE game_designers (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    found_date INT NOT NULL REFERENCES dates(id)
);

CREATE TABLE games (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    mechanics VARCHAR(255) NOT NULL,
    players_count INT NOT NULL,
    players_age INT NOT NULL,
    price FLOAT NOT NULL,
    rating FLOAT NOT NULL,
    issue_date INT NOT NULL REFERENCES dates(id),
    designer INT NOT NULL REFERENCES game_designers(id) ON DELETE CASCADE
);

CREATE TABLE game_to_product (
    game_id INT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    product_id INT NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, product_id)
);

CREATE TABLE game_to_family (
    game_id INT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    family_id INT NOT NULL REFERENCES game_families(id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, family_id)
);