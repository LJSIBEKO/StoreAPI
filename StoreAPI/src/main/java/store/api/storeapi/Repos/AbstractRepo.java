package store.api.storeapi.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.AbstractModel;

@Repository
public interface AbstractRepo<T extends AbstractModel> extends JpaRepository<T,Long> {
}
