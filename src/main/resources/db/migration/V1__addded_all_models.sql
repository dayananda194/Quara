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

CREATE TABLE answer_details
(
    id         BIGINT   NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NULL,
    upvote     BIGINT NULL,
    downvote   BIGINT NULL,
    answer_id  BIGINT NULL,
    CONSTRAINT pk_answerdetails PRIMARY KEY (id)
);

CREATE TABLE comment
(
    id           BIGINT       NOT NULL,
    created_at   datetime     NOT NULL,
    updated_at   datetime NULL,
    comment_type  enum('ANSWWER','QUESTION','COMMENT') NULL,
    question_id  BIGINT NULL,
    answer_id    BIGINT NULL,
    comment_id   BIGINT NULL,
    user_id      BIGINT NULL,
    content      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

CREATE TABLE comment_details
(
    id         BIGINT   NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NULL,
    upvote     BIGINT NULL,
    downvote   BIGINT NULL,
    comment_id BIGINT NULL,
    CONSTRAINT pk_commentdetails PRIMARY KEY (id)
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

CREATE TABLE question_details
(
    id          BIGINT   NOT NULL,
    created_at  datetime NOT NULL,
    updated_at  datetime NULL,
    upvote      BIGINT NULL,
    downvote    BIGINT NULL,
    question_id BIGINT NULL,
    CONSTRAINT pk_questiondetails PRIMARY KEY (id)
);

CREATE TABLE user
(
    id         BIGINT      AUTO_INCREMENT NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime NULL,
    username   VARCHAR(255) NOT NULL,
    dob        date         NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE answer_details
    ADD CONSTRAINT FK_ANSWERDETAILS_ON_ANSWER FOREIGN KEY (answer_id) REFERENCES answer (id);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);

ALTER TABLE answer
    ADD CONSTRAINT FK_ANSWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE comment_details
    ADD CONSTRAINT FK_COMMENTDETAILS_ON_COMMENT FOREIGN KEY (comment_id) REFERENCES comment (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_ANSWER FOREIGN KEY (answer_id) REFERENCES answer (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_COMMENT FOREIGN KEY (comment_id) REFERENCES comment (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE question_details
    ADD CONSTRAINT FK_QUESTIONDETAILS_ON_QUESTION FOREIGN KEY (question_id) REFERENCES question (id);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);