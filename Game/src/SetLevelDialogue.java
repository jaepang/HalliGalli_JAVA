import javax.swing.*;
import javax.swing.JOptionPane;

public class SetLevelDialogue extends JFrame implements Runnable{
    private Server server;
    SetLevelDialogue(Server server){
        this.server = server;
    }
    @Override
    public void run(){
        String[] buttons = {"Beginner","Novice","Expert"};
        int result = JOptionPane.showOptionDialog(null, "게임 난이도 선택", "Level Decision",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,buttons,"Novice");
        if(result == JOptionPane.YES_OPTION){
            this.server.level = 10000;  // 10 sec
        }else if(result == JOptionPane.NO_OPTION){
            this.server.level = 5000;
        }else if(result == JOptionPane.CANCEL_OPTION){
            this.server.level = 1000;
        }
    }
}
