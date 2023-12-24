CREATE TABLE IF NOT EXISTS address (
    id BIGINT PRIMARY KEY,
    creation TIMESTAMP,
    content VARCHAR(255),
    auteur VARCHAR(255)
);
