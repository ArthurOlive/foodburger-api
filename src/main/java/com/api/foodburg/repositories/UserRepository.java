package com.api.foodburg.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.foodburg.models.UserSystem;

@Repository
public interface UserRepository extends CrudRepository<UserSystem, UUID> {

    @Query("SELECT u FROM UserSystem u WHERE u.auth.username =:username")
    public UserSystem findByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserSystem u WHERE u.profile.id =:profileId")
    UserSystem findByProfileId(@Param("profileId") long profileId);
}
