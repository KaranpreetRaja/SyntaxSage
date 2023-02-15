package CustomComponents;

import java.awt.*;

public class MultipleChoiceButton extends SelectionButton {

    public MultipleChoiceButton(String text) {
        super(text);
    }

    @Override
    public void switchSelected() {
        if (getParent() != null) {
            for (Component c : getParent().getComponents()) {
                if (c instanceof SelectionButton) {
                    ((SelectionButton) c).setSelected(false);
                }
            }
        }
        this.isSelected = true;
        setBackground(selectedColor);
    }
}