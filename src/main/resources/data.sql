INSERT INTO administradores (
    apellido, area_asignada, contraseña, correo, departamento, documento_identidad,
    id_admin, id_aux_admin, nivel_acceso, nombre, rol, tareas_asignadas, telefono
) VALUES
('Gomez', 'Finanzas', 'pass1234', 'gomez@example.com', 'Administracion', '12345678', 1, 101, 'Alto', 'Carlos', 'Admin', 'Gestion de recursos', '3001234567'),
('Perez', NULL, 'securePass', 'perez@example.com', 'Recursos Humanos', '87654321', 2, 102, 'Medio', 'Ana', 'Admin', NULL, '3007654321'),
('Rodriguez', 'IT', 'admin123', 'rodriguez@example.com', 'Tecnologia', '112233446', 3, 103, 'Alto', 'Luis', 'SuperAdmin', 'Mantenimiento de sistemas', '3012345678'),
('Fernandez', 'Logistica', 'logisticPass', 'fernandez@example.com', 'Operaciones', '22334455', 4, 104, 'Medio', 'Sofia', 'Admin', 'Coordinacion de transporte', '3023456789'),
('Lopez', NULL, 'lopezPass', 'lopez@example.com', 'Compras', '337445566', 5, 105, 'Bajo', 'Miguel', 'Admin', NULL, '3034567890'),
('Martinez', 'Seguridad', 'secure789', 'martinez@example.com', 'Seguridad', '44556677', 6, 106, 'Alto', 'Elena', 'SuperAdmin', 'Supervision de seguridad', '3045678901'),
('Sanchez', 'Marketing', 'marketingPass', 'sanchez@example.com', 'Ventas', '55667788', 7, 107, 'Medio', 'Javier', 'Admin', 'Campañas publicitarias', '3056789012'),
('Torres', 'Atencion al Cliente', 'clientePass', 'torres@example.com', 'Servicio al Cliente', '66778899', 8, 108, 'Bajo', 'Lucia', 'Admin', 'Soporte y atencion', '3067890123'),
('Diaz', NULL, 'diazPass', 'diaz@example.com', 'Calidad', '77889900', 9, 109, 'Medio', 'Fernando', 'Admin', NULL, '3078901234'),
('Ramirez', 'Ventas', 'ventas123', 'ramirez@example.com', 'Ventas', '88990011', 10, 110, 'Alto', 'Valeria', 'SuperAdmin', 'Estrategias comerciales', '3089012345'),
('Morales', 'Produccion', 'prodPass', 'morales@example.com', 'Produccion', '99001122', 11, 111, 'Medio', 'Esteban', 'Admin', 'Supervision de planta', '3090123456'),
('Hernandez', NULL, 'hernandezPass', 'hernandez@example.com', 'Recursos Humanos', '11223344', 12, 112, 'Bajo', 'Raquel', 'Admin', NULL, '3101234567'),
('Gutierrez', 'Legal', 'legalPass', 'gutierrez@example.com', 'Legal', '223344555', 13, 113, 'Alto', 'Mario', 'SuperAdmin', 'Asesoramiento legal', '3112345678'),
('Castro', 'Auditoria', 'auditPass', 'castro@example.com', 'Auditoria', '33445566', 14, 114, 'Medio', 'Alejandra', 'Admin', 'Auditoria financiera', '3123456789'),
('Vega', NULL, 'vegaPass', 'vega@example.com', 'Finanzas', '448556677', 15, 115, 'Bajo', 'Hugo', 'Admin', NULL, '3134567890'),
('Ruiz', 'Compras', 'comprasPass', 'ruiz@example.com', 'Compras', '556677880', 16, 116, 'Alto', 'Natalia', 'SuperAdmin', 'Negociacion con proveedores', '3145678901'),
('Mendoza', 'IT', 'mendozaPass', 'mendoza@example.com', 'Tecnologia', '663778899', 17, 117, 'Medio', 'Oscar', 'Admin', 'Desarrollo de software', '3156789012'),
('Herrera', NULL, 'herreraPass', 'herrera@example.com', 'Atencion al Cliente', '778889900', 18, 118, 'Bajo', 'Carla', 'Admin', NULL, '3167890123'),
('Salazar', 'Seguridad', 'segPass', 'salazar@example.com', 'Seguridad', '889905011', 19, 119, 'Alto', 'Antonio', 'SuperAdmin', 'Monitoreo y vigilancia', '3178901234'),
('Ortega', 'Logistica', 'logPass', 'ortega@example.com', 'Operaciones', '998001122', 20, 120, 'Medio', 'Paula', 'Admin', 'Coordinacion de despachos', '3189012345');


INSERT INTO medicos (
    apellido, area_especializacion, contraseña, correo, dependencia, documento_identidad, 
    horario_trabajo, id_medico, no_consultorio, nombre, numero_licencia, rol, telefono
) VALUES
('Gomez', 'Cardiología', 'pass123', 'gomez@hospital.com', 'Unidad Cardiovascular', '1023456789', '8am - 5pm', 1, 'C101', 'Juan Gomez', 'LIC12345', 'Medico', '3001234567'),
('Perez', 'Dermatología', 'pass456', 'perez@hospital.com', 'Unidad Dermatología', '2034567890', '9am - 6pm', 2, 'D202', 'Ana Perez', 'LIC67890', 'Medico', '3012345678'),
('Rodriguez', 'Pediatría', 'pass789', 'rodriguez@hospital.com', 'Unidad Pediatría', '3045678901', '7am - 4pm', 3, 'P303', 'Luis Rodriguez', 'LIC11223', 'Medico', '3023456789'),
('Lopez', 'Neurología', 'pass012', 'lopez@hospital.com', 'Unidad Neurología', '4056789012', '10am - 7pm', 4, 'N404', 'Maria Lopez', 'LIC33445', 'Medico', '3034567890'),
('Martinez', 'Ortopedia', 'pass345', 'martinez@hospital.com', 'Unidad Ortopedia', '5067890123', '6am - 3pm', 5, 'O505', 'Carlos Martinez', 'LIC55667', 'Medico', '3045678901'),
('Hernandez', 'Gastroenterología', 'pass678', 'hernandez@hospital.com', 'Unidad Gastroenterología', '6078901234', '8am - 5pm', 6, 'G606', 'Laura Hernandez', 'LIC77889', 'Medico', '3056789012'),
('Gonzalez', 'Oncología', 'pass901', 'gonzalez@hospital.com', 'Unidad Oncología', '7089012345', '9am - 6pm', 7, 'O707', 'Jorge Gonzalez', 'LIC99001', 'Medico', '3067890123'),
('Diaz', 'Psiquiatría', 'pass234', 'diaz@hospital.com', 'Unidad Psiquiatría', '8090123456', '7am - 4pm', 8, 'P808', 'Paula Diaz', 'LIC11212', 'Medico', '3078901234'),
('Torres', 'Urología', 'pass567', 'torres@hospital.com', 'Unidad Urología', '9091234567', '10am - 7pm', 9, 'U909', 'Ricardo Torres', 'LIC33434', 'Medico', '3089012345'),
('Ramirez', 'Reumatología', 'pass890', 'ramirez@hospital.com', 'Unidad Reumatología', '1009123456', '6am - 3pm', 10, 'R1010', 'Carmen Ramirez', 'LIC55656', 'Medico', '3090123456'),
('Fernandez', NULL, 'pass111', 'fernandez@hospital.com', 'Unidad Medicina General', '1112345678', '8am - 5pm', 11, NULL, 'Jose Fernandez', NULL, 'Medico', '3101234567'),
('Sanchez', 'Nefrología', 'pass222', 'sanchez@hospital.com', 'Unidad Nefrología', '1213456789', '9am - 6pm', 12, 'N1212', 'Gabriela Sanchez', 'LIC77878', 'Medico', '3112345678'),
('Morales', 'Endocrinología', 'pass333', 'morales@hospital.com', 'Unidad Endocrinología', '1314567890', '7am - 4pm', 13, 'E1313', 'Andres Morales', 'LIC99099', 'Medico', '3123456789'),
('Jimenez', 'Geriatría', 'pass444', 'jimenez@hospital.com', 'Unidad Geriatría', '1415678901', '10am - 7pm', 14, 'G1414', 'Silvia Jimenez', 'LIC11211', 'Medico', '3134567890'),
('Rojas', 'Hematología', 'pass555', 'rojas@hospital.com', 'Unidad Hematología', '1516789012', '6am - 3pm', 15, 'H1515', 'Fernando Rojas', 'LIC33433', 'Medico', '3145678901'),
('Navarro', NULL, 'pass666', 'navarro@hospital.com', 'Unidad Medicina Interna', '1617890123', '8am - 5pm', 16, NULL, 'Beatriz Navarro', NULL, 'Medico', '3156789012'),
('Castillo', 'Oftalmología', 'pass777', 'castillo@hospital.com', 'Unidad Oftalmología', '1718901234', '9am - 6pm', 17, 'O1717', 'Hector Castillo', 'LIC55655', 'Medico', '3167890123'),
('Mendez', 'Otorrinolaringología', 'pass888', 'mendez@hospital.com', 'Unidad Otorrinolaringología', '1819012345', '7am - 4pm', 18, 'O1818', 'Luisa Mendez', 'LIC77877', 'Medico', '3178901234'),
('Cruz', 'Cirugía General', 'pass999', 'cruz@hospital.com', 'Unidad Cirugía', '1920123456', '10am - 7pm', 19, 'C1919', 'Eduardo Cruz', 'LIC99000', 'Medico', '3189012345'),
('Vargas', 'Cirugía Plástica', 'pass000', 'vargas@hospital.com', 'Unidad Cirugía', '2021234567', '6am - 3pm', 20, 'C2020', 'Monica Vargas', 'LIC11210', 'Medico', '3190123456');


INSERT INTO pacientes (apellido, contraseña, correo, direccion, documento_identidad, fecha_nacimiento, historial_medico, id_paciente, nombre, numero_seguro, proxima_cita, rol, sexo, telefono, ultima_cita) 
VALUES
('Gomez', 'pass1234', 'gomez1@mail.com', 'Calle 123', '123456789', '1985-07-12', 'Sin antecedentes', 1, 'Juan', 'ABC12345', NULL, 'Paciente', 'M', '3001234567', '2024-01-15'),
('Perez', 'pass5678', 'perez2@mail.com', 'Av. Siempre Viva', '987654321', '1990-05-23', NULL, 2, 'Maria', NULL, '2024-05-10', 'Paciente', 'F', '3109876543', '2024-02-20'),
('Rodriguez', 'pass91011', 'rodri3@mail.com', 'Calle Falsa 456', '321654987', '1988-11-30', 'Alergia a penicilina', 3, 'Carlos', 'XYZ98765', '2024-06-01', 'Paciente', 'M', '3205647382', NULL),
('Lopez', 'pass1415', 'lopez4@mail.com', 'Cra 50 #20-30', '654987321', '1975-03-10', NULL, 4, 'Ana', NULL, NULL, 'Paciente', 'F', '3056783452', '2024-03-12'),
('Martinez', 'pass1617', 'martinez5@mail.com', 'Cl 10 #5-40', '159357486', '2000-09-25', 'Asma infantil', 5, 'Pedro', 'LMN54321', '2024-07-14', 'Paciente', 'M', '3187654321', NULL),
('Sanchez', 'pass1819', 'sanchez6@mail.com', 'Diagonal 75', '753951456', '1982-04-18', NULL, 6, 'Luis', NULL, '2024-08-20', 'Paciente', 'M', '3045781293', '2024-02-28'),
('Ramirez', 'pass2021', 'ramirez7@mail.com', 'Calle 80 #30-50', '852963741', '1995-12-10', 'Diabetes tipo 2', 7, 'Isabel', 'JKL24680', '2024-09-05', 'Paciente', 'F', '3194567382', '2024-04-15'),
('Torres', 'pass2223', 'torres8@mail.com', 'Avenida 68', '951753852', '1979-06-22', NULL, 8, 'Ricardo', NULL, '2024-10-10', 'Paciente', 'M', '3124876592', NULL),
('Gonzalez', 'pass2425', 'gonzalez9@mail.com', 'Carrera 100', '753159852', '1987-02-05', 'Hipertensión', 9, 'Carmen', 'OPQ13579', NULL, 'Paciente', 'F', '3152764893', '2024-05-30'),
('Vargas', 'pass2627', 'vargas10@mail.com', 'Cll 50 #25-10', '456789123', '1993-08-14', NULL, 10, 'Andres', NULL, '2024-11-25', 'Paciente', 'M', '3106594837', '2024-06-17'),
('Gutierrez', 'pass2829', 'guti11@mail.com', 'Diagonal 33', '654123987', '1980-01-03', 'Historial limpio', 11, 'Rosa', 'MNO95137', NULL, 'Paciente', 'F', '3016547283', NULL),
('Rojas', 'pass3031', 'rojas12@mail.com', 'Cra 20 #40-55', '369852147', '1996-05-29', NULL, 12, 'Esteban', NULL, '2024-12-15', 'Paciente', 'M', '3204781265', '2024-07-01'),
('Herrera', 'pass3233', 'herrera13@mail.com', 'Cl 15 #60-70', '159263487', '1972-07-17', 'Hipotiroidismo', 13, 'Clara', 'UVW86420', '2025-01-10', 'Paciente', 'F', '3165483729', NULL),
('Morales', 'pass3435', 'mora14@mail.com', 'Cra 45 #100-20', '785412369', '1984-11-09', NULL, 14, 'Hector', NULL, NULL, 'Paciente', 'M', '3074158623', '2024-08-21'),
('Castillo', 'pass3637', 'casti15@mail.com', 'Diagonal 85', '852147963', '1998-03-22', 'Alergia al polvo', 15, 'Valeria', 'XYZ74152', '2025-02-05', 'Paciente', 'F', '3109845632', '2024-09-18'),
('Mejia', 'pass3839', 'mejia16@mail.com', 'Cl 200 #45-80', '963852741', '1989-10-01', NULL, 16, 'Raul', NULL, NULL, 'Paciente', 'M', '3215476983', '2024-10-30'),
('Mendoza', 'pass4041', 'mendoza17@mail.com', 'Av. Roosevelt', '456321789', '1991-06-15', 'Historial limpio', 17, 'Adriana', 'RST75342', '2025-03-15', 'Paciente', 'F', '3145829637', NULL),
('Paredes', 'pass4243', 'paredes18@mail.com', 'Calle 90 #10-50', '258147369', '1976-09-05', NULL, 18, 'Felipe', NULL, '2025-04-20', 'Paciente', 'M', '3187596324', '2024-11-11'),
('Ortega', 'pass4445', 'ortega19@mail.com', 'Cra 25 #100-30', '159874263', '2002-02-25', 'Asma controlada', 19, 'Laura', 'LMN25841', NULL, 'Paciente', 'F', '3198527461', '2024-12-05'),
('Salazar', 'pass4647', 'salazar20@mail.com', 'Cl 300 #5-60', '369741852', '1986-04-12', NULL, 20, 'Fernando', NULL, '2025-05-10', 'Paciente', 'M', '3006584729', '2025-01-25');
