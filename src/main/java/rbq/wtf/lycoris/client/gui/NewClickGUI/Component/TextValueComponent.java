package rbq.wtf.lycoris.client.gui.NewClickGUI.Component;

import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;
import rbq.wtf.lycoris.client.gui.ClickGUI.RenderUtil;
import rbq.wtf.lycoris.client.gui.Font.FontLoaders;
import rbq.wtf.lycoris.client.gui.NewClickGUI.NewClickGUI;
import rbq.wtf.lycoris.client.value.BooleanValue;
import rbq.wtf.lycoris.client.value.ModeValue;
import rbq.wtf.lycoris.client.value.TextValue;

import java.awt.*;

public class TextValueComponent extends Component {
    public TextValue Value;
    private float x;
    private float y;
    public TextValueComponent(TextValue value) {
        this.Value = value;
        this.setHeight(35);
    }

    @Override
    public void updateComponent(float X, float Y, int mouseX, int mouseY) {
        this.x = X;
        this.y = Y;
        render();
    }

    @Override
    public void render() {
        FontLoaders.default20.drawString(Value.getName(),
                x,
                y,
                new Color(255,255,255).getRGB());

        RenderUtil.drawFastRoundedRect(x + 220 - 10,
                y + 10 + 1,
                x + 310,
                y + 30 - 1,
                2,
                new Color(38, 38, 38).getRGB()
        );
        FontLoaders.default20.drawCenteredString(Value.getValue(),
                x + 260,
                y + 16,
                new Color(255,255,255).getRGB()
        );
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (this.isHovered(x + 120,
                y + 10,
                x + 310,
                y + 30,
                mouseX,
                mouseY)){
            NewClickGUI.currentActiveTextValue = this;
        } else {
            if (NewClickGUI.currentActiveTextValue != null) {
                if (NewClickGUI.currentActiveTextValue == this){
                    NewClickGUI.currentActiveTextValue = null;
                }
            }
        }
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        if (keyCode == Keyboard.KEY_BACK) {
            if (Value.getValue().length() != 0) {
                Value.setValue(Value.getValue().substring(0,Value.getValue().length()-1));
            }
        } else {
            if (ChatAllowedCharacters.isAllowedCharacter(typedChar)) {
                Value.setValue(Value.getValue() + typedChar);
            }
        }

    }
}
