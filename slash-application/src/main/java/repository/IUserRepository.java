package repository;

import entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String emailId);

    UserEntity findByPassword(String password);

    UserEntity findByUserId(Long userId);

}
