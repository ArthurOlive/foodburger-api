package com.api.foodburg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.foodburg.models.UserSystem;

@Repository
public interface UserRepository extends CrudRepository<com.api.foodburg.models.UserSystem, Long> {

    @Query("SELECT u FROM UserSystem u WHERE u.auth.username =:username")
    public UserSystem findByUsername(@Param("username") String username);

    @Query("SELECT DISTINCT u FROM UserSystem u WHERE u.role.name =:role")
    Page<UserSystem> findAllByRole(Pageable pageable, String role);

    @Query("SELECT u FROM UserSystem u WHERE u.profile.id =:profileId")
    UserSystem findByProfileId(@Param("profileId") long profileId);
}
