import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements IReceive,ActionListener,ISender{
    private String name;
    private Server server;
    private JTextArea chatHistory = new JTextArea();
    private JTextField chatBox = new JTextField();
    private JButton sendButton = new JButton("Send"); // Add sendButton component

    public Client(String name, Server server) {
        this.name = name;
        this.server = server;
        server.subscribe(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle(name);

        // Add chatBox, sendButton, and chatHistory components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chatBox, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(chatHistory), BorderLayout.CENTER);

        // Add action listener to the sendButton
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server.publish(name + ": " + chatBox.getText());
                chatBox.setText("");
            }
        });
        setVisible(true);
    }

    public String receive(String message) {
        System.out.println("Messages: " + message);
        chatHistory.append(message + "\n");
        return message;
    }

    @Override
    public void subscribe(Client client) {

    }

    @Override
    public void unsubscribe(Client client) {

    }

    @Override
    public void unsubscribe(IReceive client) {

    }


    public void unsubscribe() {
        server.unsubscribe(this);
    }

public static void main(String[] args) {
        //Create a new instance of the Server class
        Server server = new Server();
        //Create three clients and add them to the server
        Client client1 = new Client("Client 1", server);
                 server.addClient(client1);
                 Client client2 = new Client("Client 2", server);
                  server.addClient(client2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void send(String Sender, String Message) {

    }

    @Override
    public void subscribe(IReceive client) {

    }
}


