CREATE TABLE games (
    id INT NOT NULL PRIMARY KEY,
    bgg_url VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    min_players INT NOT NULL,
    max_players INT NOT NULL,
    avg_time INT NOT NULL,
    min_time INT NOT NULL,
    max_time INT NOT NULL,
    year INT NOT NULL,
    avg_rating FLOAT NOT NULL,
    geek_rating FLOAT NOT NULL,
    num_votes INT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    owned INT NOT NULL
);

CREATE TABLE families (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE categories (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE designers (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE mechanics (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE game_to_designers (
    game_id INT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    designer_id INT NOT NULL REFERENCES designers(id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, designer_id)
);

CREATE TABLE game_to_family (
    game_id INT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    family_id INT NOT NULL REFERENCES families(id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, family_id)
);

CREATE TABLE game_to_category (
    game_id INT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    category_id INT NOT NULL REFERENCES categories(id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, category_id)
);

CREATE TABLE game_to_mechanics (
    game_id INT NOT NULL REFERENCES games(id) ON DELETE CASCADE,
    mechanic_id INT NOT NULL REFERENCES mechanics(id) ON DELETE CASCADE,
    PRIMARY KEY (game_id, mechanic_id)
);