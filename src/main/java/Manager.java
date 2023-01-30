import java.util.Arrays;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {
        if (ticket.getDepartureAirport().equals(departureAirport)) {
            if (ticket.getArrivalAirport().equals(arrivalAirport)) {
                return true;
            }
        }
        return false;
    }
}


