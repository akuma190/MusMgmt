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

    @Query(value="select * from report where report_id =:reportId",nativeQuery=true)
    report findByReportId(@Param("reportId") Integer reportId);

    @Query(value="select * from report where customer_id =:custId",nativeQuery=true)
    List<report> findAllByCustomer(@Param("custId") Integer custId);

    @Query(value="select * from report order by sold_date",nativeQuery=true)
    List<report> findBySellDate();
}
