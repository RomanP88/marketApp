package ru.market.marketApp.spring_rest2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.market.marketApp.spring_rest2.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
