package uz.ages.appclickup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ages.appclickup.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);
}
