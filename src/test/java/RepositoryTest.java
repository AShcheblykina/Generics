import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Ticket ticket1 = new Ticket(1, 800, "GOJ", "LED", 180);
    Ticket ticket2 = new Ticket(2, 600, "GOJ", "LED", 160);
    Ticket ticket3 = new Ticket(3, 900, "GOJ", "LED", 120);
    Ticket ticket4 = new Ticket(4, 1_500, "FRU", "LED", 240);
    Ticket ticket5 = new Ticket(5, 850, "MOW", "LED", 50);
    Ticket ticket6 = new Ticket(6, 400, "FRU", "LED", 80);


    @Test
    public void addTicket() {
        Repository repo = new Repository();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addOneTicket() {
        Repository repo = new Repository();

        repo.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTwoTicket() {
        Repository repo = new Repository();

        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteOneTicket() {
        Repository repo = new Repository();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket6};
        Ticket[] actual = repo.deletyById(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteOneToTicket() {
        Repository repo = new Repository();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.deletyById(1);

        Assertions.assertArrayEquals(expected, actual);
    }

}

