package store.api.storeapi.Model.Enum;

public enum TransitionType
{
    CREDIT("CREDIT"),DEBIT("DEBIT");
    private String description;

    TransitionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
