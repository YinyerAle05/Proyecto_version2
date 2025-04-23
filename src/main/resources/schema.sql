-- Crear la tabla
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    id INT IDENTITY(1,1) PRIMARY KEY,
    dni CHAR(8) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    state CHAR(1) NOT NULL
);
-- Crear la tabla producto
DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
    id INT IDENTITY(1,1) PRIMARY KEY, 
    nombre VARCHAR(100) NOT NULL,      
    descripcion VARCHAR(255),          
    estado CHAR(1) NOT NULL,           
    precio DECIMAL(10, 2) NOT NULL    
);

CREATE TABLE pedido (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fecha_pedido DATE,
    total DOUBLE
);

DROP TABLE IF EXISTS pedido;

--  tabla pedido
CREATE TABLE pedido (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    fecha_pedido DATE NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    estado CHAR(1) NOT NULL, -- "A" = Activo, "I" = Inactivo
    customer_id INT, -- Clave foránea (opcional)
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);


