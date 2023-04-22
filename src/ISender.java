public interface ISender {
    void send(String Sender, String Message);
    void subscribe(IReceive client);


}
