import java.util.ArrayList;

public class Server implements IReceive{
    // The ArrayList to store messages
    private ArrayList<String> messages = new ArrayList<>();
    // The ArrayList to store connected clients
    private ArrayList<Client> clients = new ArrayList<>();

    // Method to add a new client to the ArrayList of connected clients
    public void addClient(Client client) {
        clients.add(client);
    }

    // Method to remove a client from the ArrayList of connected clients
    public void removeClient(Client client) {
        clients.remove(client);
    }

    // Method to receive a message from a client and broadcast it to all other clients
    public void publish(String message) {
        // Add the message to the ArrayList of messages
        messages.add(message);
        //System.out.println("Number of connected clients: " + clients.size());
        for (Client client : clients) {         // Iterate through all connected clients
            client.receive(message);// Send the message to the client
        }
        //System.out.println("Hello World");
    }

    @Override
    public void send(String Sender, String Message) {

    }

    // Method to subscribe a client to this server
    public void subscribe(IReceive client) {
        if (!clients.contains(client)) {
            clients.add((Client) client);
        }
    }

    @Override
    public String receive(String message) {
        return null;
    }

    @Override
    public void subscribe(Client client) {

    }

    @Override
    public void unsubscribe(Client client) {

    }

    // Method to unsubscribe a client from this server
    public void unsubscribe(IReceive client) {
        clients.remove(client);
    }
}







