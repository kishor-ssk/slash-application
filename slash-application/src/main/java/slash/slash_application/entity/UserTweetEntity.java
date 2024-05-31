package slash.slash_application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_tweets")
public class UserTweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tweets_generator")
    @SequenceGenerator(name="user_tweets_generator", sequenceName = "user_tweets_user_tweet_id_seq", allocationSize=1)
    @Column(name="user_tweet_id")
    private Long userTweetId;
    @Column(name="user_id")
    private Long userId;

    @Column(name="tweet")
    private String tweet;

    @CreationTimestamp
    @Column(name="creation_time")
    private LocalDateTime creationTime;

}
