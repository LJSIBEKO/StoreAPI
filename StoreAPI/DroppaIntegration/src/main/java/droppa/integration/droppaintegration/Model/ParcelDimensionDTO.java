package droppa.integration.droppaintegration.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParcelDimensionDTO
{
    public String parcel_number;

    public double parcel_length;

    public double parcel_breadth;

    public double parcel_height;

    public double parcel_mass;
    public String parcel_description;

    public double volumetricMass;

    public String parcel_reference;
}
