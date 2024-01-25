CREATE TABLE IF NOT EXISTS users_tasks
(
    user_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, task_id),
    CONSTRAINT fk_users_tasks_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT fk_users_tasks_tasks FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE ON UPDATE NO ACTION
);