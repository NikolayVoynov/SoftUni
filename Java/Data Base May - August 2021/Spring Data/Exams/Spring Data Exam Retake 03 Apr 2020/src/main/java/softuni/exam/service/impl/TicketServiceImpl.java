package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TicketSeedRootDto;
import softuni.exam.models.entities.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    private final TicketRepository ticketRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;

    public TicketServiceImpl(TicketRepository ticketRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser, TownService townService, PassengerService passengerService, PlaneService planeService) {
        this.ticketRepository = ticketRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(TICKETS_FILE_PATH, TicketSeedRootDto.class)
                .getTickets()
                .stream()
                .filter(ticketSeedDto -> {
                    boolean isValid = validationUtil.isValid(ticketSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Ticket %s - %s",
                            ticketSeedDto.getTicketFromTownDto().getName(), ticketSeedDto.getTicketToTownDto().getName()) :
                            "Invalid Ticket")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(ticketSeedDto -> {
                    Ticket ticket = modelMapper.map(ticketSeedDto, Ticket.class);

                    ticket.setFromTown(townService.findTownByGivenName(ticketSeedDto.getTicketFromTownDto().getName()));
                    ticket.setToTown(townService.findTownByGivenName(ticketSeedDto.getTicketToTownDto().getName()));
                    ticket.setPassenger(passengerService.findPassengerByGivenEmail(ticketSeedDto.getTicketPassengerDto()
                            .getEmail()));
                    ticket.setPlane(planeService.findPlaneByGivenRegisterNumber(ticketSeedDto.getTicketPlaneDto()
                            .getRegisterNumber()));

                    return ticket;
                })
                .forEach(ticketRepository::save);

        return sb.toString();
    }
}
