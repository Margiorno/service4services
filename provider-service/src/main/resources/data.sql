INSERT INTO provider (id, name, address, phone, email, created_at)
SELECT '11111111-1111-1111-1111-111111111111', 'MediCare Sp. z o.o.', 'ul. Zdrowa 12, Warszawa', '123456789', 'kontakt@medicare.pl', '2024-01-15T10:00:00'
    WHERE NOT EXISTS (
    SELECT 1 FROM provider WHERE id = '11111111-1111-1111-1111-111111111111'
);

INSERT INTO provider (id, name, address, phone, email, created_at)
SELECT '22222222-2222-2222-2222-222222222222', 'Zdrowie Plus', 'ul. Lekarska 5, Kraków', '987654321', 'info@zdrowieplus.pl', '2024-02-01T09:30:00'
    WHERE NOT EXISTS (
    SELECT 1 FROM provider WHERE id = '22222222-2222-2222-2222-222222222222'
);

INSERT INTO provider (id, name, address, phone, email, created_at)
SELECT '33333333-3333-3333-3333-333333333333', 'Opieka24', 'ul. Pomocna 7, Wrocław', '555666777', 'biuro@opieka24.pl', '2024-03-10T08:45:00'
    WHERE NOT EXISTS (
    SELECT 1 FROM provider WHERE id = '33333333-3333-3333-3333-333333333333'
);
