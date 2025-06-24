// new class
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield; // will hold num1, num2, result
    JButton[] numberButtons = new JButton[10]; // numbers 0~9
    JButton[] functionButtons = new JButton[8]; // 加減乘除
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton; // decimal, equal, delete, clear
    JPanel panel;

    Font myFont = new Font("Fira Code", Font.PLAIN, 25); // apply this font to all buttons

    double num1 = 0, num2 = 0, result = 0;
    char operator; // 加減乘除之一

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false); // can no longer type in text box, we will use buttons

        addButton = new JButton("+"); // add text to this button
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        // add buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        // use for loop to iterate over buttons
        for (int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this); // what does this do?
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); // outline around button

        }
        // for number buttons
        for (int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // these buttons will not be on JPanel
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid with 10px gaps 
        // buttons size calculated from panel size, gap size, number of buttons in a row/col
        panel.setBackground(Color.PINK);

        panel.add(numberButtons[1]); // the number "1"
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i=0; i<10; i++){
            if (e.getSource() == numberButtons[i]){
                // when we click on a number, it'll update our textfield
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton){
            
        }
    }

}