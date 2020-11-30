package museum.repository;

import museum.model.artwork;
import museum.model.collector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtworkRepository extends CrudRepository<artwork,Integer> {

    @Query(value="select * from artwork where status='waiting_for_approval'",nativeQuery=true)
    List<artwork> findAllByWait();

    @Query(value="delete from artwork where artwork_id =:artId",nativeQuery=true)
    void deletArtEntry(@Param("artId") int artId);

    @Query(value="select * from artwork where artwork_id =:artId",nativeQuery=true)
    artwork findOne(@Param("artId") int artId);

    @Query(value="select * from artwork where Art_col_id =:artId and status='in_museum'",nativeQuery=true)
    List<artwork> findForEvent(@Param("artId") int artId);

    @Query(value="select * from artwork where status='in_museum'",nativeQuery=true)
    List<artwork> findAllForEvent();

    @Query(value="select * from artwork where status='in_discussion' and Art_col_id=:artId",nativeQuery=true)
    List<artwork> findForArtistApp(@Param("artId") int artId);

    @Query(value="select * from artwork where  curdate()-creation_date>=180",nativeQuery=true)
    List<artwork> findForManageArt();

}
