-- Categories
INSERT INTO category (id, name)
SELECT '11111111-1111-1111-1111-111111111111', 'Hosting'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id = '11111111-1111-1111-1111-111111111111'
);

INSERT INTO category (id, name)
SELECT '22222222-2222-2222-2222-222222222222', 'Storage'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id = '22222222-2222-2222-2222-222222222222'
);

INSERT INTO category (id, name)
SELECT '33333333-3333-3333-3333-333333333333', 'Network'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id = '33333333-3333-3333-3333-333333333333'
);

INSERT INTO category (id, name)
SELECT '44444444-4444-4444-4444-444444444444', 'Database'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id = '44444444-4444-4444-4444-444444444444'
);

INSERT INTO category (id, name)
SELECT '55555555-5555-5555-5555-555555555555', 'Security'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id = '55555555-5555-5555-5555-555555555555'
);


-- Templates
INSERT INTO template (id, service_name, category_id)
SELECT 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', 'Basic Hosting', '11111111-1111-1111-1111-111111111111'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', 'Premium Hosting', '11111111-1111-1111-1111-111111111111'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'S3-like Storage', '22222222-2222-2222-2222-222222222222'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2', 'Cold Storage', '22222222-2222-2222-2222-222222222222'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'ccccccc1-cccc-cccc-cccc-ccccccccccc1', 'VPC Network', '33333333-3333-3333-3333-333333333333'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'ccccccc1-cccc-cccc-cccc-ccccccccccc1'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'ddddddd1-dddd-dddd-dddd-dddddddddddd', 'Managed SQL Database', '44444444-4444-4444-4444-444444444444'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'ddddddd1-dddd-dddd-dddd-dddddddddddd'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'ddddddd2-dddd-dddd-dddd-ddddddddddde', 'NoSQL Database', '44444444-4444-4444-4444-444444444444'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'ddddddd2-dddd-dddd-dddd-ddddddddddde'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'eeeeeee1-eeee-eeee-eeee-eeeeeeeeeeee', 'Firewall Service', '55555555-5555-5555-5555-555555555555'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'eeeeeee1-eeee-eeee-eeee-eeeeeeeeeeee'
);

INSERT INTO template (id, service_name, category_id)
SELECT 'eeeeeee2-eeee-eeee-eeee-eeeeeeeeeeef', 'DDoS Protection', '55555555-5555-5555-5555-555555555555'
    WHERE NOT EXISTS (
    SELECT 1 FROM template WHERE id = 'eeeeeee2-eeee-eeee-eeee-eeeeeeeeeeef'
);
