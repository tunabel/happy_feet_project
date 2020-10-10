package c1812m.happyfeet.repository;


import c1812m.happyfeet.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Transactional(readOnly = true)
    @Query("select u from UserRole u where u.userId = :id")
    Iterable<UserRole> findRolesOfUser(@Param("id") int userId);
}
