package droppa.integration.droppaintegration.Model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class DroppaBooking
{
    public String oid;

    public String businessKey;

    public String serviceId;


    public ContactDTO dropOff;


    public ContactDTO pickUp;


    public String vehicleType;

    @NonNull
    public String pickUpAddress;

    @NonNull
    public LocalDateTime date;

    @NonNull
    public String dropOffAddress;

    @NonNull
    public Double price;

    public String province;

    public double itemMass;

    @NonNull
    public String transportMode;

    @NonNull
    public String type;

    @NonNull
    public String pickUpDate;

    public String destinationProvince;

    @NonNull
    public String comment;

    public boolean isExpress;

    public String fromSuburb;

    public String toSuburb;

    public String pickUpPCode;

    public String dropOffPCode;
    public String platform;
    public String shopify_orderNo;;

    public List<ParcelDimensionDTO> parcelDimensions;

    public LocalDateTime expectedDeliveryDate;
    public boolean isTender;
}
