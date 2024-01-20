package store.api.storeapi.Model.Enum;

public enum Roles
{
    CUSTOMER("CUSTOMER"),ADMIN("ADMIN"),SUPER_ADMIN("SUPER_ADMIN");
    private String description;

    Roles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
