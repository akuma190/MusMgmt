package museum.repository;

import museum.model.event;
import museum.model.eventArtwork;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<event,Integer> {

    @Query(value="select ev.event_id,\n" +
            "       ev.event_name,\n" +
            "\t   ev.event_type,\n" +
            "\t   ev.creation_date,\n" +
            "\t   ev.artist_id,\n" +
            "       count(*) as painting_count\n" +
            "       from museumdbms.event ev,\n" +
            "            museumdbms.event_artwork er\n" +
            "\t   where ev.event_id=er.event_id\n" +
            "       and er.status='in_event'\n" +
            "       group by ev.event_id",nativeQuery=true)
    List<event> findByEventId();

    @Query(value="select count(*) as painting_count\n" +
            "       from museumdbms.event ev,\n" +
            "            museumdbms.event_artwork er\n" +
            "\t   where ev.event_id=er.event_id\n" +
            "\t   and ev.event_id=:eventId\n" +
            "       and er.status='in_event'\n" +
            "       group by ev.event_id",nativeQuery=true)
    int findCountById(@Param("eventId") Integer eventId);

    @Query(value="select * from event where event_id =:eventId",nativeQuery=true)
    event findOne(@Param("eventId") Integer eventId);
}
