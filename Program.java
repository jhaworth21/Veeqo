import runlenencoder.RunLenEncoder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program extends JFrame {

    //declares the output and user input variables
    private JTextArea output;
    private JTextField usr_input;
    private JCheckBox case_sens;

    /**
     * jhaworth.veeqo.Program constructor
     */
    public Program() {

        //initialises the frame components and packs them to the frame
        this.initComponents();
        this.pack();

        //sets program to stop on exit
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets frame to visible
        this.setVisible(true);
    }

    /**
     *
     */
    private void initComponents() {
        //gets the content pane of the window
        Container contentPane = this.getContentPane();

        //creates a new panel to add the components to
        JPanel pane = new JPanel();

        //creates a new grid bag layout and constraints
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //sets the pane's layout to the grid bag layout
        pane.setLayout(gb);

        //sets the initial grid positions
        gbc.gridx = 0;
        gbc.gridy = 0;
        //creates the title label of the window
        JLabel title = new JLabel("Run Length Encoder");
        //adds the title to the pane
        pane.add(title, gbc);

        //updates the grid positions
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel in_label = new JLabel("Input:");
        pane.add(in_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        usr_input = new JTextField(null, 20);
        pane.add(usr_input, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        case_sens = new JCheckBox("Case Sensitive");
        pane.add(case_sens, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel out_label = new JLabel("Output:");
        pane.add(out_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.output = new JTextArea();
        output.setEditable(false);
        pane.add(output, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton encode_btn = new JButton("Encode");
        encode_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encode_action();
            }
        });
        //adds the encode button to the pane
        pane.add(encode_btn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        //creates the decode button and adds the action listener
        JButton decode_btn = new JButton("Decode");
        decode_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calls the decode function
                decode_action();
            }
        });
        //adds the decode button to the pane
        pane.add(decode_btn, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        JButton clear_btn = new JButton("Clear");
        clear_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        //adds the clear button to the pane
        pane.add(clear_btn, gbc);

        //adds the components to the content pane
        contentPane.add(pane);
    }

    /**
     * Used to carry out the encoding of the user's input
     */
    private void encode_action() {

        //creates a new run length encoder object
        RunLenEncoder e = new RunLenEncoder();
        String encode_str;

        //checks if to encode should be case-sensitive
        if (case_sens.isSelected()) {
            //performs run length encoding on the user input
            encode_str = e.encode(this.usr_input.getText());
        } else {
            //sets input to lower case and then performs run length encoding
            encode_str = e.encode(this.usr_input.getText().toLowerCase());
        }

        //adds the output string to the text area
        this.output.setText(null);
        this.output.setText(encode_str);
    }

    /**
     * Used to carry out the decoding of the user's input
     */
    private void decode_action() {
        //creates a new run length encoder object
        RunLenEncoder e = new RunLenEncoder();
        String decode_str;

        //checks if to decode should be case-sensitive
        if (case_sens.isSelected()) {
            //performs run length encoding on the user input
            decode_str = e.decode(this.usr_input.getText());
        } else {
            //sets input to lower case and then performs run length decoding
            decode_str = e.decode(this.usr_input.getText().toLowerCase());
        }

        //adds the output string to the text area
        this.output.setText(null);
        this.output.setText(decode_str);
    }


    /**
     * Used to clear all the field on the GUI
     */
    private void clear() {
        //clears the user input field
        this.usr_input.setText(null);

        //clears the output field
        this.output.setText(null);
    }

    public static void main(String[] args) {
        new Program();
    }
}