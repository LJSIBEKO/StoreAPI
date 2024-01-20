package droppa.integration.droppaintegration.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class ContactDTO
{
    @NonNull
    public String firstName;

    @NonNull
    public String lastName;

    @NonNull
    public String phone;

    public String base64Image;

    @NonNull
    public String email;

    public String companyName;

    public String complex;

    public String unitNo;
}
