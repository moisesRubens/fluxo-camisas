CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE shirt(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    quantity INTEGER NOT NULL,
    size_shirt INTEGER NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    collar BOOLEAN NOT NULL,
    sleeve BOOLEAN NOT NULL,
    color VARCHAR(50) NOT NULL
);