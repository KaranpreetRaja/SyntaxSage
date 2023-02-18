package CustomComponents;

import java.awt.*;

public class MultipleChoiceButton extends SelectionButton {

    private static final long serialVersionUID = 5372412163416639597L;

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