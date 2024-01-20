package store.api.storeapi.Extra.Mapper;


import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import store.api.storeapi.Extra.DTOs.CartDTO;
import store.api.storeapi.Extra.DTOs.DTO;
import store.api.storeapi.Extra.DTOs.ProductDTO;
import store.api.storeapi.Extra.ImageUtils;
import store.api.storeapi.Model.AbstractModel;
import store.api.storeapi.Model.Cart;
import store.api.storeapi.Model.Product;

import java.io.Serializable;

@Service
@Component
public class Mapper implements Serializable
{
    private ModelMapper mapper;
    public void init(){
        mapper = new ModelMapper();

        mapper.getConfiguration().
                setFieldMatchingEnabled(true).
                setMatchingStrategy(MatchingStrategies.STRICT).
                setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
    public ModelMapper mapper() { return mapper; }

    public Mapper() {
       init();
    }
    public <E extends AbstractModel,D > E toObject(Class<E> entityType, D source){
        return mapper().map(source, entityType);
    }
    public <E ,D extends DTO> D toDTO(Class<D> dtoType, E source){

        return mapper().map(source,dtoType);
    }
    public ProductDTO toProductDTO(Product product)
    {

        return ProductDTO
                .builder()
                .name(product.getName())
                .amount(product.getAmount())
                .category(product.getCategory())
                .comments(product.getComments())
                .description(product.getDescription())
                .quantity(product.getQuantity())
            //    .images(ImageUtils.decompressImage(product.getImages()))
                .ratings(product.getRatings())
                .id(product.getId())
                .owner_id(product.getOwner_id())
                .createdAt(product.getCreatedAt())
                .lastUpdate(product.getLastUpdate())
                .build();
    }
    public Product toProduct(ProductDTO dto)
    {
        Product product=new Product();
        product.setName(dto.getName());
      //  product.setImages(ImageUtils.compressImage(dto.images));
        product.setDescription(dto.getDescription());
        product.setAmount(dto.getAmount());
        product.setOwner_id(dto.getOwner_id());
        product.setComments(dto.getComments());
        product.setRatings(dto.getRatings());
        product.setLastUpdate(dto.getLastUpdate());
        product.setCategory(dto.getCategory());
        product.setQuantity(dto.getQuantity());

        return product;
    }

    public CartDTO toCartDTO(Cart cart){
        CartDTO cartDTO=new CartDTO();
        cartDTO.id= cart.getId();
        cartDTO.numberOfProduct=cart.getNumberOfProduct();
        cartDTO.product=toProductDTO(cart.getProduct());
        cartDTO.owner_id=cart.getOwner_id();
        cartDTO.createdAt=cart.getCreatedAt();
        cartDTO.lastUpdate=cart.getLastUpdate();

        return cartDTO;
    }
}
