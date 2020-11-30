package museum.repository;

import museum.model.collector;
import museum.model.eventArtwork;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventArtWorkRepository extends CrudRepository<eventArtwork,Integer> {

    @Query(value="select * from event_artwork where event_id =:eventId and status='in_event'",nativeQuery=true)
    List<eventArtwork> findOne(@Param("eventId") Integer eventId);

    @Query(value="select * from event_artwork where event_id =:eventId",nativeQuery=true)
    List<eventArtwork> findMyEventList(@Param("eventId") Integer eventId);

    @Query(value="select * from event_artwork where artwork_id =:artId",nativeQuery=true)
    eventArtwork findByArt(@Param("artId") Integer artId);

}
