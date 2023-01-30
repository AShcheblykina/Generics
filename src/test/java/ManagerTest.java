import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Ticket ticket1 = new Ticket(1, 800, "GOJ", "LED", 120);
    Ticket ticket2 = new Ticket(2, 600, "GOJ", "LED", 160);
    Ticket ticket3 = new Ticket(3, 900, "GOJ", "LED", 180);
    Ticket ticket4 = new Ticket(4, 1_500, "FRU", "LED", 240);
    Ticket ticket5 = new Ticket(5, 850, "MOW", "LED", 50);
    Ticket ticket6 = new Ticket(6, 400, "FRU", "LED", 80);


    @Test
    public void findOneTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] expected = {ticket6, ticket4};
        Ticket[] actual = manager.findAll("FRU", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findFiveTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("MOW", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortAndFind() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = manager.findAll("GOJ", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noValidTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("RVH", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }
}