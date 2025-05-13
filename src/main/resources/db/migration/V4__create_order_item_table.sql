CREATE TABLE order_item(
    shirt_id UUID,
    order_id UUID,
    quantity INTEGER NOT NULL,
    unit_value INTEGER NOT NULL,
    PRIMARY KEY(shirt_id, order_id),
    FOREIGN KEY(shirt_id) REFERENCES shirt(id) ON DELETE CASCADE,
    FOREIGN KEY(order_id) REFERENCES "order"(id) ON DELETE CASCADE
);