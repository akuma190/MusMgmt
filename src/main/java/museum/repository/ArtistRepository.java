package museum.repository;

import museum.model.artist;
import museum.model.users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<artist,Integer> {

    @Query(value="select * from artist where artist_name =:artName",nativeQuery=true)
    artist findOne(@Param("artName") String artName);
}
