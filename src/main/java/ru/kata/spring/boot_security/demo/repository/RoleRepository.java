package ru.kata.spring.boot_security.demo.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

//@Qualifier("role_repo")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
