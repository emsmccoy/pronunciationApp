-- Enable UUID generation if not already enabled
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- User mock data.

-- INSERT INTO "user" (id, username, email, password, join_Date, is_Active) VALUES
-- (gen_random_uuid(), 'emma_dev', 'emma@example.com', 'securePass', CURRENT_TIMESTAMP, TRUE),

-- Insert 10 users with explicit IDs
INSERT INTO "user" (id, username, email, password, join_date, is_active) VALUES
('111e4567-e89b-12d3-a456-426614174000', 'emma_dev', 'emma@example.com', 'securePass', CURRENT_TIMESTAMP, TRUE),
('112e4567-e89b-12d3-a456-426614174001', 'john_doe', 'john.doe@example.com', 'password456', CURRENT_TIMESTAMP, FALSE),
('113e4567-e89b-12d3-a456-426614174002', 'jane_smith', 'jane.smith@example.com', 'testpass', CURRENT_TIMESTAMP, TRUE),
('114e4567-e89b-12d3-a456-426614174003', 'alice_wonder', 'alice@example.com', 'wonder123', CURRENT_TIMESTAMP, TRUE),
('115e4567-e89b-12d3-a456-426614174004', 'bob_marley', 'bob@example.com', 'oneLove', CURRENT_TIMESTAMP, FALSE),
('116e4567-e89b-12d3-a456-426614174005', 'charlie_brown', 'charlie@example.com', 'peanuts', CURRENT_TIMESTAMP, TRUE),
('117e4567-e89b-12d3-a456-426614174006', 'david_garcia', 'david@example.com', 'strongPass', CURRENT_TIMESTAMP, TRUE),
('118e4567-e89b-12d3-a456-426614174007', 'eva_green', 'eva@example.com', 'greenTea', CURRENT_TIMESTAMP, FALSE),
('119e4567-e89b-12d3-a456-426614174008', 'frank_castle', 'frank@example.com', 'punisher', CURRENT_TIMESTAMP, TRUE),
('120e4567-e89b-12d3-a456-426614174009', 'grace_hopper', 'grace@example.com', 'coder', CURRENT_TIMESTAMP, TRUE);

