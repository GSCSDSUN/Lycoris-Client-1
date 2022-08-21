package rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.util;

import rbq.wtf.lycoris.client.wrapper.MapEnum;
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapMethod;
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapperClass;
import rbq.wtf.lycoris.client.wrapper.wrappers.utils.ReflectUtil;

import java.lang.reflect.Method;

@WrapperClass(mcpName = "net.minecraft.util.ChatAllowedCharacters", targetMap = MapEnum.VANILLA189)
public class ChatAllowedCharacters {
    @WrapMethod(mcpName = "isAllowedCharacter", targetMap = MapEnum.VANILLA189)
    public static Method isAllowedCharacter;
    @WrapMethod(mcpName = "filterAllowedCharacters", targetMap = MapEnum.VANILLA189)
    public static Method filterAllowedCharacters;

    public static boolean isAllowedCharacter(char chars) {
        return (boolean) ReflectUtil.invokeStatic(isAllowedCharacter, chars);
    }
}
