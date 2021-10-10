CREATE TABLE time_validity
(
    id         BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP,
    end_time   TIMESTAMP

);

CREATE TABLE copyright
(
    id  BIGSERIAL PRIMARY KEY,
    pay INT,
    company_id int,
    time_live int,
    record_id INT,
    CONSTRAINT record_fk FOREIGN KEY (record_id) REFERENCES recording (id) ON DELETE CASCADE,
    CONSTRAINT company_fk FOREIGN KEY (company_id) REFERENCES company (id) ON DELETE CASCADE,
    CONSTRAINT time_live_fk FOREIGN KEY (company_id) REFERENCES time_validity (id) ON DELETE CASCADE
);
