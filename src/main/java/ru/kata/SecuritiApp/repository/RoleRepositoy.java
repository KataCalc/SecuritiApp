package ru.kata.SecuritiApp.repository;


import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.SecuritiApp.models.Role;

@Repository
public interface RoleRepositoy extends JpaRepository<Role, Integer> {
}
