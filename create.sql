CREATE TABLE games (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    picture VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    player_min_age INT NOT NULL,
    players_min_amount INT NOT NULL,
    players_max_amount INT NOT NULL,
    duration INT NOT NULL,
    release_year INT NOT NULL,
    rating FLOAT NOT NULL
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