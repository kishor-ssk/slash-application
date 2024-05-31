CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;

CREATE SEQUENCE IF NOT EXISTS user_tweets_user_tweet_id_seq;

CREATE TABLE IF NOT EXISTS user_tweets(
    user_tweet_id bigint NOT NULL DEFAULT nextval('user_tweets_user_tweet_id_seq'),
    user_id bigint NULL,
    tweet varchar(200) NULL,
    creation_time timestamp with time zone NULL DEFAULT NOW()
);

/* Create Primary Keys, Indexes, Uniques, Checks */
ALTER TABLE user_tweets ADD CONSTRAINT "PK_user_tweet_id"
	PRIMARY KEY (user_tweet_id);

/* Create Foreign Key Constraints */
ALTER TABLE user_tweets ADD CONSTRAINT "FK_user_details_user_tweet_details"
    FOREIGN KEY (user_id) REFERENCES user_details (user_id) ON DELETE No Action ON UPDATE No Action;