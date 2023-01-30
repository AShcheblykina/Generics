public class Ticket implements Comparable<Ticket> {
    private int id;
    private int ticketPrice;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public Ticket(int id, int ticketPrice, String departureAirport, String arrivalAirport, int travelTime) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.ticketPrice = ticketPrice;

    }

    public int getId() {
        return id;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (ticketPrice < o.getTicketPrice()) {
            return -1;
        } else if (ticketPrice > o.getTicketPrice()) {
            return 1;
        } else {
            return 0;
        }

    }
}
