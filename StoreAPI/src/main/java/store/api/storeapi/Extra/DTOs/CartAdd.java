package store.api.storeapi.Extra.DTOs;

import lombok.Data;

@Data
public class CartAdd
{
    public long userOid;
    public long productOid;
    public int numberOfProduct;
}
