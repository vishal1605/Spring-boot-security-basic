package com.jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.beans.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
