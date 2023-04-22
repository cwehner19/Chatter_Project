import javax.swing.*;
import java.awt.*;

public class MyFrame {

    private JTextArea chatHistory;
    private JTextField messageField;
    private JButton sendButton;

    public MyFrame() {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFont(new Font("SansSerif", Font.PLAIN,18));

        // display text and creates/ adds components
        chatHistory = new JTextArea(10,30);
        chatHistory.setEditable(false); //the user is not able to edit chat history
        JScrollPane scroll = new JScrollPane(chatHistory);

        // creates an instance of this class
        messageField = new JTextField(30);

        // creates the send button
        sendButton = new JButton("Send");

        // adds components to the main container using a BorderLayout
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(messageField, BorderLayout.SOUTH);
        frame.add(sendButton, BorderLayout.EAST);

        frame.setVisible(true); // shows the frame
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame(); // create an instance of MyFrame
    }
}
