INSERT INTO "user" (id, username, email, password, join_Date, is_Active) VALUES
(UUID(), 'emma_dev', 'emma@example.com', 'securePass', CURRENT_TIMESTAMP, TRUE),
(UUID(), 'john_doe', 'john.doe@example.com', 'password456', CURRENT_TIMESTAMP, FALSE),
(UUID(), 'jane_smith', 'jane.smith@example.com', 'testpass', CURRENT_TIMESTAMP, TRUE),
(UUID(), 'alice_wonder', 'alice@example.com', 'wonder123', CURRENT_TIMESTAMP, TRUE),
(UUID(), 'bob_marley', 'bob@example.com', 'oneLove', CURRENT_TIMESTAMP, FALSE),
(UUID(), 'charlie_brown', 'charlie@example.com', 'peanuts', CURRENT_TIMESTAMP, TRUE),
(UUID(), 'david_garcia', 'david@example.com', 'strongPass', CURRENT_TIMESTAMP, TRUE),
(UUID(), 'eva_green', 'eva@example.com', 'greenTea', CURRENT_TIMESTAMP, FALSE),
(UUID(), 'frank_castle', 'frank@example.com', 'punisher', CURRENT_TIMESTAMP, TRUE),
(UUID(), 'grace_hopper', 'grace@example.com', 'coder', CURRENT_TIMESTAMP, TRUE);
