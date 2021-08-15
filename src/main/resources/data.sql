INSERT INTO USERS
VALUES (
    'rm', '{bcrypt}$2a$12$Xzawsoxbqho.Od/BXRThBeZ4kewZTR8r/Y5eCTFQmf8oNdr2JokUK', 1
);

INSERT INTO AUTHORITIES
VALUES (
    'ROLE_ADMIN', 'rm'
);