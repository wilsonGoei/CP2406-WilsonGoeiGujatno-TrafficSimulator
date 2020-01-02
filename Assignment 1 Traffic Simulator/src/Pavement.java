
import javax.swing.*;

public class Pavement extends JButton {
    private int num;

    public Pavement(){
        super();
    }

    public void setNumber(int number){
        this.num = number;
    }

    public int getNumber(){
        return num;
    }
}
