package store.api.storeapi.Repos;

import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.ProductComment;

@Repository
public interface CommentsDAO extends AbstractRepo<ProductComment> {
}
