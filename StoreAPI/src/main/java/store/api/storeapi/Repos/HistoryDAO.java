package store.api.storeapi.Repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.History;

import java.util.Optional;

@Repository
public interface HistoryDAO extends AbstractRepo<History>
{
    @Query(value = "SELECT s FROM History s WHERE s.owner_id = ?1")
    Optional<History> findByOwner_id(long ownerId);
}
