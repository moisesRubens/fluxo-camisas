CREATE TABLE "order" (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    total_value DOUBLE PRECISION NOT NULL,
    client_id UUID,
    FOREIGN KEY(client_id) REFERENCES client(id) ON DELETE CASCADE
);