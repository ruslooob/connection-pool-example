CREATE TABLE IF NOT EXISTS balances
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    balance INT          NOT NULL
);
