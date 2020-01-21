CREATE TABLE Genre (
                       genre_id INTEGER NOT NULL AUTO_INCREMENT,
                       genre_title VARCHAR(128) NOT NULL ,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       PRIMARY KEY (genre_id)
);

CREATE TABLE User (
                      user_id   INTEGER NOT NULL AUTO_INCREMENT,
                      user_name VARCHAR(128) ,
                      password VARCHAR(20),
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      PRIMARY KEY (user_id)
);

CREATE TABLE Movie (
                       movie_id   INTEGER  NOT NULL AUTO_INCREMENT,
                       movie_name VARCHAR(128) NOT NULL,
                       genre_id INTEGER,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,
                       PRIMARY KEY (movie_id),
                       FOREIGN KEY (genre_id) REFERENCES Genre(genre_id)
);

CREATE TABLE Rating (
                        rating_id   INTEGER  NOT NULL AUTO_INCREMENT,
                        text_review VARCHAR(128) NOT NULL,
                        user_id INTEGER,
                        movie_id INTEGER,
                        created_at TIMESTAMP,
                        updated_at TIMESTAMP,
                        PRIMARY KEY (rating_id),
                        FOREIGN KEY (user_id) REFERENCES User(user_id),
                        FOREIGN KEY (movie_id) REFERENCES Movie(movie_id)
);




