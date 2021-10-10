CREATE TABLE singer
(
    id   SERIAL primary key,
    name VARCHAR(256)
);
CREATE TABLE company
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(256)
);

CREATE TABLE recording
(
    id           BIGSERIAL PRIMARY KEY,
    song_code    VARCHAR(32),
    title        VARCHAR(4096),
    version      VARCHAR(128),
    release_time TIMESTAMP,
    singer_id    INT,
    CONSTRAINT singer_fk FOREIGN KEY (singer_id) REFERENCES singer (id) ON DELETE CASCADE
);


