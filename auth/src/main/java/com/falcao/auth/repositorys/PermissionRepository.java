package com.falcao.auth.repositorys;

import com.falcao.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    @Query("SELECT P FROM Permission P WHERE P.description =:description ")
    Permission findByDescription(@Param("description") String description);
}
