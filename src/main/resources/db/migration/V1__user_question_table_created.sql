CREATE TABLE question
(
    id         BIGINT       NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime NULL,
    content    VARCHAR(255) NOT NULL,
    user_id    BIGINT NULL,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE user
(
    id         BIGINT       NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime NULL,
    username   VARCHAR(255) NOT NULL,
    dob        datetime     NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);