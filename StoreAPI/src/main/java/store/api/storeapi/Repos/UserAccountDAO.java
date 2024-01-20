package store.api.storeapi.Repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.api.storeapi.Model.UserAccount;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountDAO extends AbstractRepo<UserAccount> {

    Optional<UserAccount> findUserAccountByEmail(String email);
}
