package ChatBot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBotGUI extends JFrame implements ActionListener {
    private static JTextArea area;
    private JTextField field;
    public JButton send;
    private ChatBotLogic chatBotLogic;

    public ChatBotGUI(String title) {
        super(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth, screenHeight);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(10, 20, screenWidth - 25, screenHeight - 150);
        add(panel);


        area = new JTextArea();
        area.setEditable(false);
        area.setBackground(Color.WHITE);
        area.setFont(new Font("Serif", Font.PLAIN, 20));
        JScrollPane sp = new JScrollPane(area);
        panel.add(sp, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        field = new JTextField();
        field.setForeground(Color.BLACK);
        field.setFont(new Font("Serif", Font.BOLD, 25));
        field.setPreferredSize(new Dimension(screenWidth - 200, 35));
        inputPanel.add(field);

        send = new JButton("Enter");
        send.setFont(new Font("Serif", Font.BOLD, 25));
        send.setBackground(Color.WHITE);
        send.addActionListener(this);
        inputPanel.add(send);

        panel.add(inputPanel, BorderLayout.SOUTH);

        chatBotLogic = new ChatBotLogic();

        bot("Hello, user my name is AflacBot with Aflac Business Solutions."); // Initial bot message
        bot("The reason for my message is to schedule some time with you.");
        bot("I've been able to work with business owners who were frustrated by rising operating costs and wanted to lower their worker's comp and reduce their payroll tax.");
        bot("If we could meet for 15-minutes I'd like to learn more about you and your company.");
    }

    public void actionPerformed(ActionEvent e) {
        String message = field.getText().toLowerCase();
        area.append("You: " + field.getText() + "\n");
        field.setText("");

        String response = chatBotLogic.generateResponse(message);
        bot(response);
    }

    public static void bot(String message) {
        area.append("Bot: " + message + "\n");
    }

    public static void bot(int number) {
        area.append("Bot: " + number + "\n");
    }

    public static void main(String[] args) {
        new ChatBotGUI("Chat Bot");
    }
}
