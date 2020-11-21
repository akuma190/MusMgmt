package museum.repository;

import museum.model.users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<users,String> {
    @Query(value="select * from users where username =:userName",nativeQuery=true)
    users findOne(@Param("userName") String userName);

    @Query(value="select a.authority from users u,authorities a where a.username =:userName and u.username=a.username",nativeQuery=true)
    String applyJoin(@Param("userName") String userName);
}
