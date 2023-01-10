package ru.kata.SecuritiApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.SecuritiApp.model.Role;

@Repository
public interface RoleRepositoy extends JpaRepository<Role, Integer> {
}
