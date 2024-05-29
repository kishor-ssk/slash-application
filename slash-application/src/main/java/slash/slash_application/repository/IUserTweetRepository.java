package slash.slash_application.repository;

import slash.slash_application.entity.UserTweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserTweetRepository extends JpaRepository<UserTweetEntity, Long > {

//    List<UserTweetEntity> findAllById(Long userId);
}
