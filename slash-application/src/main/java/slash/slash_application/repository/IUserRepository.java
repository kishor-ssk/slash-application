package slash.slash_application.repository;

import slash.slash_application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String emailId);

    UserEntity findByPassword(String password);

    UserEntity findByUserId(Long userId);

}
