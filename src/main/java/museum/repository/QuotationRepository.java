package museum.repository;

import museum.model.artwork;
import museum.model.quotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends CrudRepository<quotation,Integer> {
    @Query(value="select * from quotation where artwork_id =:artId",nativeQuery=true)
    quotation findOne(@Param("artId") int artId);
}
