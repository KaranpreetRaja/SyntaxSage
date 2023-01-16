package src.CustomComponents;

// imports
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class SelectionButton extends JButton {
    private boolean isSelected;
    private Color originalColor = Color.GRAY; //defult color for unselected button
    private Color selectedColor = Color.YELLOW; //color for button after it is "selected"

    public SelectionButton(String text) {
        super(text);
        originalColor = getBackground();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchSelected(); //runs switchSelected() every time button is clicked
            }
        });
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
        if (selected) {
            setBackground(selectedColor);
        } else {
            setBackground(originalColor);
        }
    }

    public void switchSelected() {
        this.isSelected = !(this.isSelected);
        if (this.isSelected) {
            setBackground(selectedColor);
        } else {
            setBackground(originalColor);
        }
    }
}
