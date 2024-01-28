DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    email       VARCHAR(100) NOT NULL,
    username    VARCHAR(50) NOT NULL,
    password    VARCHAR(500) NOT NULL,
    profile_url VARCHAR(1000),
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW(),
    primary key (id)
)
