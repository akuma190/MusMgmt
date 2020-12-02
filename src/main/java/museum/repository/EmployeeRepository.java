package museum.repository;

import museum.model.artwork;
import museum.model.collector;
import museum.model.employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<employee,Integer> {

    @Query(value="select * from employee where role='salesperson'",nativeQuery=true)
    List<employee> findAllXcpt();


    @Query(value="select * from employee where role='salesperson' and staff_name=:salesName",nativeQuery=true)
    employee findBySalesName(@Param("salesName") String salesName);
}
