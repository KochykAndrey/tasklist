CREATE TABLE IF NOT EXISTS tasks
(
--      id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    id              BIGSERIAL PRIMARY KEY,
    title           VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NULL,
    status          VARCHAR(255) NOT NULL,
    expiration_date TIMESTAMP    NULL
);