import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToeHelper implements ActionListener {

    Random random = new Random();
    JFrame mainFrame = new JFrame();
    JPanel titlePanel =new JPanel();
    JPanel buttonPanel =new JPanel();
    JLabel textField =new JLabel();
    JButton[] button = new JButton[9];
    boolean player1_turn;


    TicTacToeHelper() {
// set panel and frame attributes
        mainFrame.setSize(800,800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setBackground(new Color(60,60,60));

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,45));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe with Avi !");
        textField.setOpaque(true);

       titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        for(int i=0;i<9;i++) {
            button[i] = new JButton();
            buttonPanel.add(button[i]);
            button[i].setFont(new Font("MV Boli",Font.BOLD,120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }


        titlePanel.add(textField);
        mainFrame.add(titlePanel,BorderLayout.NORTH);
        mainFrame.add(buttonPanel);

        firstTurn();

    }
// find out who is the first player
    private void firstTurn() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn=true;
            textField.setText("Player X's Turn");
        } else{
            player1_turn=false;
            textField.setText("Player O's Turn");
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //if player turn , change the button text and check
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player1_turn) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    private void check() {
        //check X win conditions
        if(
                (button[0].getText()=="X") &&
                        (button[1].getText()=="X") &&
                        (button[2].getText()=="X")
        ) {
            xWins(0,1,2);
        }
        if(
                (button[3].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[5].getText()=="X")
        ) {
            xWins(3,4,5);
        }
        if(
                (button[6].getText()=="X") &&
                        (button[7].getText()=="X") &&
                        (button[8].getText()=="X")
        ) {
            xWins(6,7,8);
        }
        if(
                (button[0].getText()=="X") &&
                        (button[3].getText()=="X") &&
                        (button[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }
        if(
                (button[1].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[7].getText()=="X")
        ) {
            xWins(1,4,7);
        }
        if(
                (button[2].getText()=="X") &&
                        (button[5].getText()=="X") &&
                        (button[8].getText()=="X")
        ) {
            xWins(2,5,8);
        }
        if(
                (button[0].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[8].getText()=="X")
        ) {
            xWins(0,4,8);
        }
        if(
                (button[2].getText()=="X") &&
                        (button[4].getText()=="X") &&
                        (button[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        if(
                (button[0].getText()=="O") &&
                        (button[1].getText()=="O") &&
                        (button[2].getText()=="O")
        ) {
            oWins(0,1,2);
        }
        if(
                (button[3].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[5].getText()=="O")
        ) {
            oWins(3,4,5);
        }
        if(
                (button[6].getText()=="O") &&
                        (button[7].getText()=="O") &&
                        (button[8].getText()=="O")
        ) {
            oWins(6,7,8);
        }
        if(
                (button[0].getText()=="O") &&
                        (button[3].getText()=="O") &&
                        (button[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }
        if(
                (button[1].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[7].getText()=="O")
        ) {
            oWins(1,4,7);
        }
        if(
                (button[2].getText()=="O") &&
                        (button[5].getText()=="O") &&
                        (button[8].getText()=="O")
        ) {
            oWins(2,5,8);
        }
        if(
                (button[0].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[8].getText()=="O")
        ) {
            oWins(0,4,8);
        }
        if(
                (button[2].getText()=="O") &&
                        (button[4].getText()=="O") &&
                        (button[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }

    }
    public void xWins(int a,int b,int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            button[i].setEnabled(false);
        }
        textField.setText("X wins");
    }
    public void oWins(int a,int b,int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            button[i].setEnabled(false);
        }
        textField.setText("O wins");
    }

}

