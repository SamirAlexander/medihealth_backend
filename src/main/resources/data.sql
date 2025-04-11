INSERT INTO administradores (
    id_admin, area_asignada, departamento, nivel_acceso, tareas_asignadas
) VALUES
(1, 'Recursos Humanos', 'Administración', 4, 'Supervisar procesos de contratación'),
(2, 'Sistemas', 'Tecnología', 5, 'Administrar infraestructura TI'),
(3, 'Contabilidad', 'Finanzas', 3, 'Revisar informes financieros mensuales'),
(4, 'Legal', 'Asuntos Jurídicos', 4, 'Coordinar cumplimiento legal'),
(5, 'Compras', 'Logística', 2, 'Gestionar proveedores y órdenes'),
(6, 'Atención al Cliente', 'Servicios', 3, 'Supervisar atención y soporte'),
(7, 'Marketing Digital', 'Marketing', 4, 'Diseñar campañas publicitarias'),
(8, 'Proyectos', 'Planeación Estratégica', 5, 'Supervisar ejecución de proyectos'),
(9, 'Calidad', 'Producción', 3, 'Controlar calidad de procesos'),
(10, 'Seguridad', 'Operaciones', 4, 'Implementar protocolos de seguridad'),
(11, 'Relaciones Públicas', 'Comunicación', 2, 'Gestionar imagen institucional'),
(12, 'Innovación', 'Desarrollo', 5, 'Coordinar nuevas iniciativas'),
(13, 'Logística', 'Distribución', 3, 'Optimizar rutas de entrega'),
(14, 'Formación', 'Capital Humano', 2, 'Organizar capacitaciones'),
(15, 'Auditoría Interna', 'Finanzas', 4, 'Realizar auditorías de control'),
(16, 'Mantenimiento', 'Infraestructura', 3, 'Supervisar reparaciones y mejoras'),
(17, 'Tecnología Educativa', 'Educación', 4, 'Gestionar plataformas virtuales'),
(18, 'Planificación Financiera', 'Finanzas', 5, 'Diseñar presupuestos anuales'),
(19, 'Reclamos y Sugerencias', 'Atención al Cliente', 2, 'Atender solicitudes de usuarios'),
(20, 'Sostenibilidad', 'Responsabilidad Social', 3, 'Implementar políticas ecológicas');


INSERT INTO medicos (
    id_medico, area_especializacion, dependencia, horario_trabajo, no_consultorio, numero_licencia
) VALUES
(1, 'Cardiología', 'Hospital Central', '08:00-16:00', 101, 'LIC-001'),
(2, 'Pediatría', 'Clínica Santa Rosa', '09:00-17:00', 102, 'LIC-002'),
(3, 'Dermatología', 'Centro Médico Norte', '10:00-18:00', 103, 'LIC-003'),
(4, 'Neurología', 'Hospital Universitario', '07:30-15:30', 104, 'LIC-004'),
(5, 'Oftalmología', 'Clínica de la Vista', '08:00-14:00', 105, 'LIC-005'),
(6, 'Psiquiatría', 'Instituto de Salud Mental', '11:00-19:00', 106, 'LIC-006'),
(7, 'Ginecología', 'Hospital de la Mujer', '08:30-16:30', 107, 'LIC-007'),
(8, 'Traumatología', 'Clínica Ortopédica', '12:00-20:00', 108, 'LIC-008'),
(9, 'Urología', 'Hospital General', '09:00-17:00', 109, 'LIC-009'),
(10, 'Oncología', 'Instituto Oncológico', '08:00-16:00', 110, 'LIC-010'),
(11, 'Endocrinología', 'Centro Metabólico', '07:00-15:00', 111, 'LIC-011'),
(12, 'Reumatología', 'Clínica Especializada Norte', '10:00-18:00', 112, 'LIC-012'),
(13, 'Neumología', 'Clínica RespiraBien', '09:30-17:30', 113, 'LIC-013'),
(14, 'Gastroenterología', 'Hospital Central', '08:00-14:00', 114, 'LIC-014'),
(15, 'Medicina Interna', 'Clínica San Rafael', '11:00-19:00', 115, 'LIC-015'),
(16, 'Otorrinolaringología', 'Centro Auditivo Integral', '07:00-13:00', 116, 'LIC-016'),
(17, 'Nefrología', 'Hospital Renal', '10:00-18:00', 117, 'LIC-017'),
(18, 'Cirugía General', 'Hospital Universitario', '06:00-14:00', 118, 'LIC-018'),
(19, 'Infectología', 'Clínica de Enfermedades Infecciosas', '09:00-17:00', 119, 'LIC-019'),
(20, 'Radiología', 'Centro de Imagenología', '08:00-16:00', 120, 'LIC-020');



INSERT INTO pacientes ( numero_seguro, historial_medico, fecha_nacimiento, sexo,
  direccion, ultima_cita, proxima_cita
) VALUES
('123456789', NULL, '1990-05-10', 'M', 'Calle Falsa 123, Ciudad X', '2025-03-15', '2025-04-15'),
('987654321', NULL, '1985-07-20', 'F', 'Avenida Siempre Viva 456, Ciudad Y', '2025-02-10', '2025-04-10'),
('112233445', NULL, '1992-11-30', 'M', 'Calle Luna 789, Ciudad Z', '2025-01-22', '2025-04-20'),
('223344556', NULL, '1980-08-15', 'F', 'Calle Estrella 101, Ciudad A', '2025-03-01', '2025-05-01'),
('334455667', NULL, '1975-12-05', 'M', 'Calle Sol 202, Ciudad B', '2025-02-18', '2025-05-18'),
('445566778', NULL, '1995-03-25', 'F', 'Calle Viento 303, Ciudad C', '2025-03-10', '2025-04-25'),
('556677889', NULL, '1988-09-13', 'M', 'Calle Mar 404, Ciudad D', '2025-02-05', '2025-04-30'),
('667788990', NULL, '2000-01-02', 'F', 'Calle Agua 505, Ciudad E', '2025-01-28', '2025-05-05'),
('778899001', NULL, '1982-10-18', 'M', 'Calle Fuego 606, Ciudad F', '2025-03-03', '2025-04-10'),
('889900112', NULL, '1997-06-25', 'F', 'Calle Tierra 707, Ciudad G', '2025-03-22', '2025-05-10'),
('990011223', NULL, '1993-11-11', 'M', 'Calle Nieve 808, Ciudad H', '2025-02-28', '2025-04-18'),
('101010101', NULL, '1996-04-12', 'F', 'Calle Rayo 909, Ciudad I', '2025-03-05', '2025-04-25'),
('202020202', NULL, '1983-02-24', 'M', 'Calle Bosque 1010, Ciudad J', '2025-01-30', '2025-04-12'),
('303030303', NULL, '1994-05-30', 'F', 'Calle Cielo 1120, Ciudad K', '2025-03-12', '2025-05-01'),
('404040404', NULL, '1987-07-19', 'M', 'Calle Lluvia 1230, Ciudad L', '2025-02-25', '2025-04-20'),
('505050505', NULL, '1981-03-07', 'F', 'Calle Estación 1340, Ciudad M', '2025-03-08', '2025-05-08'),
('606060606', NULL, '1998-10-22', 'M', 'Calle Jardín 1450, Ciudad N', '2025-01-18', '2025-04-17'),
('707070707', NULL, '1999-12-02', 'F', 'Calle Árbol 1560, Ciudad O', '2025-02-15', '2025-05-12'),
('808080808', NULL, '1989-04-05', 'M', 'Calle Primavera 1670, Ciudad P', '2025-03-30', '2025-04-27'),
('909090909', NULL, '1986-08-09', 'F', 'Calle Invierno 1780, Ciudad Q', '2025-02-22', '2025-05-05');


INSERT INTO usuarios ( apellido, contrasena, correo, documento_identidad, nombre, rol, telefono
) VALUES
('Pérez', 'password123', 'juan.perez@example.com', '123456789', 'Juan', 'admin', '555-1234'),
('Gómez', 'password123', 'ana.gomez526@example.com', '987654321', 'Ana', 'usuario', '555-5678'),
('López', 'password123', 'carlos.lopez@example.com', '111223344', 'Carlos', 'usuario', '555-9101'),
('Fernández', 'password123', 'maria.fernandez@example.com', '222334455', 'María', 'admin', '555-1122'),
('Martínez', 'password123', 'pedro.martinez@example.com', '333445566', 'Pedro', 'usuario', '555-2233'),
('Díaz', 'password123', 'laura.diaz@example.com', '444556677', 'Laura', 'usuario', '555-3344'),
('Ramírez', 'password123', 'jorge.ramirez@example.com', '555667788', 'Jorge', 'admin', '555-4455'),
('Hernández', 'password123', 'sofia.hernandez@example.com', '666778899', 'Sofía', 'usuario', '555-5566'),
('García', 'password123', 'luis.garcia@example.com', '777889900', 'Luis', 'usuario', '555-6677'),
('Vásquez', 'password123', 'claudia.vasquez@example.com', '888990011', 'Claudia', 'usuario', '555-7788'),
('Sánchez', 'password123', 'roberto.sanchez@example.com', '999001122', 'Roberto', 'admin', '555-8899'),
('Morales', 'password123', 'patricia.morales@example.com', '101010101', 'Patricia', 'usuario', '555-9900'),
('Paredes', 'password123', 'raul.paredes@example.com', '202020202', 'Raúl', 'usuario', '555-1010'),
('Jiménez', 'password123', 'eva.jimenez@example.com', '303030303', 'Eva', 'usuario', '555-2121'),
('Ruiz', 'password123', 'miguel.ruiz@example.com', '404040404', 'Miguel', 'admin', '555-3232'),
('Serrano', 'password123', 'isabel.serrano@example.com', '505050505', 'Isabel', 'usuario', '555-4343'),
('Torres', 'password123', 'fernando.torres@example.com', '606060606', 'Fernando', 'usuario', '555-5454'),
('Castro', 'password123', 'gabriela.castro@example.com', '707070707', 'Gabriela', 'usuario', '555-6565'),
('Moreno', 'password123', 'david.moreno@example.com', '808080808', 'David', 'admin', '555-7676'),
('Jiménez', 'password123', 'paula.jimenez@example.com', '909090909', 'Paula', 'usuario', '555-8787');

