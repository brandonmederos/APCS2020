package controller;

import java.util.Collections;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame implements KeyListener{
	
    public static final int GRIDSIZE = 12;
    private int playerPosX;
    private int playerPosY;
    private int prePosX;
    private int prePosY;
    private ArrayList<Question> qList;
    private JButton help;
    private JButton check;
    private int currentQuestion;
    private JButton exit;
    private JPanel background;
    private JPanel maze;
    private JPanel questions;
    private gameTile[][] map;
    private JTextField answer;
    private JLabel question;
    private boolean canMove;
    private boolean[][] walls;
    
    private void focus() {
        this.requestFocus();
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
    }
    
    @Override
    public void keyTyped(final KeyEvent e) {
    }
    
    //Constructor 
    public Frame() {
        super("Riddler's Labrynth");
        playerPosX = 6;
        playerPosY = 4;
        prePosX = playerPosX;
        prePosY = playerPosY;
        qList = QuestionList.getQList();
        help = new JButton("?");
        check = new JButton("Test Your Fate");
        currentQuestion = 0;
        exit = new JButton("EXIT");
        background = new JPanel(new GridLayout(1, 2));
        maze = new JPanel(new GridLayout(12, 12));
        questions = new JPanel();
        map = new gameTile[12][12];
        answer = new JTextField();
        question = new JLabel();
        canMove = true;
        
        /*
         * These set of instructions construct the walls of the Labyrinth
         */
        boolean[][] walls = new boolean[12][];
        walls[0] = new boolean[] { true, true, false, true, true, true, true, true, true, true, true, true };
        int n = 1;
        boolean[] array = new boolean[12];
        array[0] = true;
        walls[n] = array;
        walls[2] = new boolean[] { true, false, true, true, true, true, true, true, true, true, true, false };
        walls[3] = new boolean[] { true, false, false, true, true, true, true, true, true, true, true, false };
        walls[4] = new boolean[] { true, true, false, true, false, false, false, false, true, false, false, false };
        walls[5] = new boolean[] { true, true, false, true, false, true, true, false, true, false, true, true };
        walls[6] = new boolean[] { true, false, false, true, false, true, true, false, true, false, true, true };
        walls[7] = new boolean[] { true, false, true, true, false, false, true, false, false, false, true, true };
        walls[8] = new boolean[] { true, false, true, true, true, false, true, true, true, true, true, true };
        walls[9] = new boolean[] { true, false, false, false, true, false, true, true, true, true, true, true };
        walls[10] = new boolean[] { true, true, true, false, true, false, true, true, true, true, true, true };
        walls[11] = new boolean[] { true, true, true, false, false, false, true, true, true, true, true, true };
        this.walls = walls;
        
        /*
         * This set of instructions constructs the entire labyrinth so that it is visible and can be played
         */
        this.addKeyListener(this);
        this.setFocusable(true);
        this.add(this.background);
        this.background.add(this.maze);
        this.background.add(this.questions);
        this.questions.setBackground(Color.GRAY);
        this.questions.setLayout(null);
        this.questions.add(this.check);
        this.check.setBounds(200, 225, 200, 25);
        
        
        /*
         * This ActionListener is what gets the user's text input and checks whether the player progresses or restarts
         */
        this.check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = Frame.this.answer.getText();
                String q = Frame.this.qList.get(Frame.this.currentQuestion - 1).getAnswer();
                System.out.println(q);
                if (a.equalsIgnoreCase(q)) {
                    question.setText("With Such Great Adversity You have Triumphed");
                    answer.setText("");
                    Frame.this.focus();
                }
                else {
                    Frame.this.map[4][6].setBackground(Color.CYAN);
                    Frame.this.map[Frame.this.playerPosY][Frame.this.playerPosX].setBackground(Color.LIGHT_GRAY);
                    Frame.this.answer.setText("");
                    Frame.this.question.setText("You Sadly, Have Gotten it Wrong and have been sent to the start :(");
                    Frame.this.reset();
                    Frame.this.focus();
                }
                Frame.this.focus();
            }
        });
        
        /*
         * These set of instructions add the question box and instructions to the frame
         */
        this.questions.add(this.question);
        this.question.setBounds(50, 100, 500, 20);
        this.questions.add(this.answer);
        this.answer.setBounds(200, 200, 200, 25);
        this.questions.add(this.help);
        this.help.setBounds(525, 10, 50, 50);
        this.help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JOptionPane.showMessageDialog(null, "1. Use ARROW KEYS to Control The Player \r\n2. Answer Questions To Further Along your \r\nQuest to Vicotry\r\n3. RED is a QUESTION, CYAN is the PLAYER, BLACK is a WALL, GREEN is FREEDOM\r\n4. NOW PRESS TEST YOUR FATE AND START YOUR JOURNEY");
            }
        });
        this.questions.add(this.exit);
        this.exit.setBounds(450, 500, 100, 50);
        this.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        
        /*
         * This set of instructions add the background and player into the frame
         */
        for (int y = 0; y < 12; ++y) {
            for (int x = 0; x < 12; ++x) {
                this.map[y][x] = new gameTile();
                this.maze.add(this.map[y][x]);
                if (this.walls[y][x]) {
                    this.map[y][x].setBackground(Color.DARK_GRAY);
                }
                else {
                    this.map[y][x].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
        this.map[this.playerPosY][this.playerPosX].setBackground(Color.CYAN);
        this.map[0][2].setBackground(Color.green);
        this.reset();
    }
    
    /*
     * This set of instructions gets the key movement and moves the player according to the key pressed
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        final int posX = this.playerPosX;
        final int posY = this.playerPosY;
        if (this.canMove) {
            if (e.getKeyCode() == 40) {
                if (posY < 11 && !this.walls[posY + 1][posX]) {
                    this.checkPos(this.map[posY + 1][posX]);
                    this.map[posY + 1][posX].setBackground(Color.CYAN);
                    this.map[posY][posX].setBackground(Color.LIGHT_GRAY);
                    ++this.playerPosY;
                }
            }
            else if (e.getKeyCode() == 38) {
                if (posY > 0 && !this.walls[posY - 1][posX]) {
                    this.checkPos(this.map[posY - 1][posX]);
                    this.map[posY - 1][posX].setBackground(Color.CYAN);
                    this.map[posY][posX].setBackground(Color.LIGHT_GRAY);
                    --this.playerPosY;
                }
            }
            else if (e.getKeyCode() == 37) {
                if (posX > 0 && !this.walls[posY][posX - 1]) {
                    this.checkPos(this.map[posY][posX - 1]);
                    this.map[posY][posX - 1].setBackground(Color.CYAN);
                    this.map[posY][posX].setBackground(Color.LIGHT_GRAY);
                    --this.playerPosX;
                }
            }
            else if (e.getKeyCode() == 39 && posX < 11 && !this.walls[posY][posX + 1]) {
                this.checkPos(this.map[posY][posX + 1]);
                this.map[posY][posX + 1].setBackground(Color.CYAN);
                this.map[posY][posX].setBackground(Color.LIGHT_GRAY);
                ++this.playerPosX;
            }
        }
    }
    /*
     * This method gets the position of the player and checks for the end game, checks whether the player
     * has reached the end of the game victorious
     */
    private void checkPos(gameTile g) {
        if (this.playerPosX == 2 && this.playerPosY == 0) {
            JOptionPane.showMessageDialog(null, "With Such A Great Journey You Must Reach an End");
            JOptionPane.showMessageDialog(null, "CONGRATULATIONS!");
            System.exit(0);
        }
        else if (g.getBackground().equals(Color.RED)) {
            this.askQuestion();
        }
    }
    
    /*
     * This method gets all the questions and is called when the player reaches a question box, asking
     * a random question from the given list 'QuestionList.java' class
     */
    private void askQuestion() {
        this.question.setText(this.qList.get(this.currentQuestion).getQuestion());
        this.canMove = false;
        ++this.currentQuestion;
    }
    
    /*
     * This method is called and used to reset the board once the player either selects replay or answers a question wrong
     */
    private void reset() {
        for (int y = 0; y < 12; ++y) {
            for (int x = 0; x < 12; ++x) {
                if (this.map[y][x].getBackground().equals(Color.RED)) {
                    this.map[y][x].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
        for (int cnt = 0; cnt < 5; ++cnt) {
            final int x = (int)(Math.random() * 12.0);
            final int y2 = (int)(Math.random() * 12.0);
            if (!this.walls[y2][x] && x != this.playerPosX && y2 != this.playerPosY && (x != 2 || y2 != 0)) {
                this.map[y2][x].setBackground(Color.RED);
            }
        }
        Collections.shuffle(this.qList);
    }
    
 
}
