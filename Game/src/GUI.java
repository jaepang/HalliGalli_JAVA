/*
Currently on PRACTICE step
->  Following codes are ORIGINALLY from "http://unikys.tistory.com/178"
    with some modifications.
->  From now(this commit), modification becomes larger, so no longer following codes from the site.
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GUI extends JFrame {
    private static final long serialVersionUID = -711163588504124217L;

    public GUI(){
        super("Event Firer");

        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        JPanel pane = new JPanel();
        JButton buttonStart = new JButton("Start");
        final JTextField textPeriod = new JTextField(10);
        JLabel labelPeriod = new JLabel("Input period: ");
        JCheckBox flipFlop = new JCheckBox("Flip?");

        flipFlop.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(((JCheckBox)e.getSource()).isSelected()){
                    textPeriod.setText("Flop?");
                    textPeriod.setEnabled(false);
                }else{
                    textPeriod.setText("");
                    textPeriod.setEnabled(true);
                }
            }
        });

        buttonStart.setMnemonic('S');

        pane.add(buttonStart);
        pane.add(labelPeriod);
        pane.add(textPeriod);
        pane.add(flipFlop);
        contentPane.add(pane);

        setVisible(true);


    }
}
