DROP TABLE IF EXISTS reservas CASCADE;
DROP TABLE IF EXISTS hoteles CASCADE;
DROP TABLE IF EXISTS clientes CASCADE;

-- Table: clientes (Cliente entity)
CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(20)
);

-- Table: hoteles (Hotel entity)
CREATE TABLE hoteles (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    estrellas INTEGER NOT NULL,
    telefono VARCHAR(20)
);

-- Table: reservas (Reservas entity)
CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    num_huespedes INTEGER NOT NULL DEFAULT 1,
    hotel_id INTEGER NOT NULL REFERENCES hoteles(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    cliente_id BIGINT NOT NULL REFERENCES clientes(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Indexes for performance
CREATE INDEX idx_reservas_hotel_id ON reservas(hotel_id);
CREATE INDEX idx_reservas_cliente_id ON reservas(cliente_id);
CREATE INDEX idx_clientes_email ON clientes(email);

-- Sample data (optional)
INSERT INTO clientes (nombre, email, telefono) VALUES 
('Juan Perez', 'juan@example.com', '123456789'),
('Maria Lopez', 'maria@example.com', '987654321');

INSERT INTO hoteles (nombre, direccion, estrellas, telefono) VALUES 
('Hotel Luxury', 'Av Principal 123', 5, '555-0101'),
('Hotel Comfort', 'Calle Secundaria 456', 3, '555-0202');

INSERT INTO reservas (fecha_entrada, fecha_salida, num_huespedes, hotel_id, cliente_id) VALUES 
('2024-12-01', '2024-12-05', 2, 1, 1),
('2024-12-10', '2024-12-12', 1, 2, 2);

-- Verify
-- SELECT * FROM clientes;
-- SELECT * FROM hoteles; 
-- SELECT * FROM reservas;

