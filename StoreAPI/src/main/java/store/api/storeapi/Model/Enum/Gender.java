package store.api.storeapi.Model.Enum;

public enum Gender
{
    MALE("MALE"),FEMALE("FEMALE");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }


}
