package c1812m.happyfeet.repository;

import c1812m.happyfeet.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly = true)
    @Query("select u from User u where u.email = :email")
    Iterable<User> findByEmail(@Param("email") String email);

    @Transactional(readOnly = true)
    @Query("select u from User u where u.username = :username AND u.status = 0")
    Iterable<User> findActiveByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u " +
            "WHERE (:name IS NULL OR UPPER(u.username) LIKE CONCAT('%',UPPER(:name),'%') OR UPPER(u.name) LIKE CONCAT('%',UPPER(:name),'%'))")
    Page<User> getUserListByNameContaining(Pageable pageable, @Param("name") String name);

}
