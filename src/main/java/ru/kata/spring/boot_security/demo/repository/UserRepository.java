package ru.kata.spring.boot_security.demo.repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select c from User c join fetch c.roles where c.userName = :userName")
    User findByUsername(String userName);
}
