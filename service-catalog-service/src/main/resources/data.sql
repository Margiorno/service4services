INSERT INTO service_category (id, name)
SELECT '11111111-1111-1111-1111-111111111111', 'Hosting'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_category WHERE id = '11111111-1111-1111-1111-111111111111'
);

INSERT INTO service_category (id, name)
SELECT '22222222-2222-2222-2222-222222222222', 'Storage'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_category WHERE id = '22222222-2222-2222-2222-222222222222'
);

INSERT INTO service_category (id, name)
SELECT '33333333-3333-3333-3333-333333333333', 'Network'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_category WHERE id = '33333333-3333-3333-3333-333333333333'
);



INSERT INTO service_template (id, service_name, service_category_id)
SELECT 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', 'Basic Hosting', '11111111-1111-1111-1111-111111111111'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_template WHERE id = 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1'
);

INSERT INTO service_template (id, service_name, service_category_id)
SELECT 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', 'Premium Hosting', '11111111-1111-1111-1111-111111111111'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_template WHERE id = 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2'
);

INSERT INTO service_template (id, service_name, service_category_id)
SELECT 'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'S3-like Storage', '22222222-2222-2222-2222-222222222222'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_template WHERE id = 'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1'
);

INSERT INTO service_template (id, service_name, service_category_id)
SELECT 'ccccccc1-cccc-cccc-cccc-ccccccccccc1', 'VPC Network', '33333333-3333-3333-3333-333333333333'
    WHERE NOT EXISTS (
    SELECT 1 FROM service_template WHERE id = 'ccccccc1-cccc-cccc-cccc-ccccccccccc1'
);
