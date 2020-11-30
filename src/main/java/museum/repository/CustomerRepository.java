package museum.repository;

import museum.model.artist;
import museum.model.customer;
import museum.model.report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<customer,Integer> {

    @Query(value="select * from customer where customer_name =:custName",nativeQuery=true)
    customer findOne(@Param("custName") String custName);


}
