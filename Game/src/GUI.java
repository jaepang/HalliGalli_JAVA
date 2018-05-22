/*
Currently on PRACTICE step
->  Following codes are ORIGINALLY from "http://unikys.tistory.com/178"
    with some modifications.
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GUI extends JFrame {
    private static final long serialVersionUID = -711163588504124217L;

    public GUI(){
        super("Event Firer");

        setBounds(100,100,300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        JPanel pane = new JPanel();
        JButton buttonStart = new JButton("Start");
        final JTextField textPeriod = new JTextField(5);
        JLabel labelPeriod = new JLabel("Input period: ");
        JCheckBox checkboxIsRandom = new JCheckBox("Fire randomly");

        checkboxIsRandom.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(((JCheckBox)e.getSource()).isSelected()){
                    textPeriod.setText("Random");
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
        pane.add(checkboxIsRandom);
        contentPane.add(pane);

        setVisible(true);


    }
}
