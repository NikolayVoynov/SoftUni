package softuni.exam.models.dtos;

import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeOff;
    @XmlElement(name = "from-town")
    private TicketFromTownDto ticketFromTownDto;
    @XmlElement(name = "to-town")
    private TicketToTownDto ticketToTownDto;
    @XmlElement(name = "passenger")
    private TicketPassengerDto ticketPassengerDto;
    @XmlElement(name = "plane")
    private TicketPlaneDto ticketPlaneDto;

    @Size(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public TicketFromTownDto getTicketFromTownDto() {
        return ticketFromTownDto;
    }

    public void setTicketFromTownDto(TicketFromTownDto ticketFromTownDto) {
        this.ticketFromTownDto = ticketFromTownDto;
    }

    public TicketToTownDto getTicketToTownDto() {
        return ticketToTownDto;
    }

    public void setTicketToTownDto(TicketToTownDto ticketToTownDto) {
        this.ticketToTownDto = ticketToTownDto;
    }

    public TicketPassengerDto getTicketPassengerDto() {
        return ticketPassengerDto;
    }

    public void setTicketPassengerDto(TicketPassengerDto ticketPassengerDto) {
        this.ticketPassengerDto = ticketPassengerDto;
    }

    public TicketPlaneDto getTicketPlaneDto() {
        return ticketPlaneDto;
    }

    public void setTicketPlaneDto(TicketPlaneDto ticketPlaneDto) {
        this.ticketPlaneDto = ticketPlaneDto;
    }
}
