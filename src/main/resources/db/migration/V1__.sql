CREATE TABLE answer
(
    id          BIGINT       NOT NULL,
    created_at  datetime     NOT NULL,
    updated_at  datetime NULL,
    content     VARCHAR(255) NOT NULL,
    question_id BIGINT NULL,
    user_id     BIGINT NULL,
    CONSTRAINT pk_answer PRIMARY KEY (id)
);

CREATE TABLE question
(
    id         BIGINT       NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime NULL,
    content    VARCHAR(255) NOT NULL,
    user_id    BIGINT NULL,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE queston_details
(
    id          BIGINT   NOT NULL,
    created_at  datetime NOT NULL,
    updated_at  datetime NULL,
    upvote      BIGINT NULL,
    downvote    BIGINT NULL,
    question_id BIGINT NULL,
    CONSTRAINT pk_questondetails PRIMARY KEY (id)
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

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE queston_details
    ADD CONSTRAINT FK_QUESTONDETAILS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);