DROP DATABASE IF EXISTS certificate;
CREATE DATABASE IF NOT EXISTS certificate;
USE certificate;

CREATE TABLE IF NOT EXISTS gift_certificate
(
    id               INTEGER PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(255) NOT NULL,
    price            INTEGER      NOT NULL,
    description      VARCHAR(255) NOT NULL,
    duration         INTEGER      NOT NULL,
    create_date      DATE         NOT NULL,
    last_update_date DATE         NOT NULL
);

CREATE TABLE IF NOT EXISTS tag
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS gift_certificate_tag
(
    gift_certificate_id INTEGER NOT NULL,
    tag_id              INTEGER NOT NULL,
    PRIMARY KEY (gift_certificate_id, tag_id),
    FOREIGN KEY (gift_certificate_id) REFERENCES gift_certificate (id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tag (id) ON DELETE CASCADE
);