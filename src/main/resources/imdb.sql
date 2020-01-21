CREATE TABLE genre (
                       genre_id INTEGER NOT NULL AUTO_INCREMENT,
                       genre_title VARCHAR(128) NOT NULL ,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       PRIMARY KEY (genre_id)
);
CREATE TABLE user (
                      user_id   INTEGER NOT NULL AUTO_INCREMENT,
                      user_name VARCHAR(128) NOT NULL ,
                      password VARCHAR(20) NOT NULL ,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      PRIMARY KEY (user_id)
);

CREATE TABLE movie (
                       movie_id   INTEGER  NOT NULL AUTO_INCREMENT,
                       movie_name VARCHAR(128) NOT NULL,
                       genre_id INTEGER,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT current_timestamp,
                       PRIMARY KEY (movie_id),
                       FOREIGN KEY (genre_id) REFERENCES genre(genre_id)

);

CREATE TABLE rating (
                        rating_id   INTEGER  NOT NULL AUTO_INCREMENT,
                        text_review VARCHAR(128) NOT NULL,
                        user_id INTEGER,
                        movie_id INTEGER,
                        created_at TIMESTAMP,
                        updated_at TIMESTAMP,
                        PRIMARY KEY (rating_id),
                        FOREIGN KEY (user_id) REFERENCES user(user_id),
                        FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);
