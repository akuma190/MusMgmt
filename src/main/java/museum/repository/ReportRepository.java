package museum.repository;

import museum.model.artist;
import museum.model.report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<report,Integer> {
    @Query(value="select * from report where Art_col_id =:art_col_id",nativeQuery=true)
    List<report> findOne(@Param("art_col_id") Integer art_col_id);
}
