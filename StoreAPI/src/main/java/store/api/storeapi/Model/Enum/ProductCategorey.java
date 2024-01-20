package store.api.storeapi.Model.Enum;

public enum ProductCategorey
{
    CLOTHING("CLOTHING"),ELECTRONIC("ELECTRONIC");

    private String description;

    ProductCategorey(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
