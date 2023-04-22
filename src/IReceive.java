public interface IReceive {
    void send(String Sender, String Message);

    String receive(String message);

    void subscribe(Client client);
    void unsubscribe(Client client);

    void unsubscribe(IReceive client);
}
