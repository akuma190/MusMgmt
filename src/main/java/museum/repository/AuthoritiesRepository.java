package museum.repository;

import museum.model.authorities;
import museum.model.users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<authorities,String> {

    @Query(value="select * from authorities where username =:userName",nativeQuery=true)
    authorities findOne(@Param("userName") String userName);
}
