package rbq.wtf.lycoris.client.wrapper.wrappers.wrapper;

import com.google.common.util.concurrent.ListenableFuture;
import rbq.wtf.lycoris.client.wrapper.MapEnum;
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapClass;
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapField;
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapMethod;
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapperClass;
import rbq.wtf.lycoris.client.wrapper.wrappers.utils.ReflectUtil;
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.entity.EntityPlayerSP;
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.gui.GuiScreen;
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.gui.ScaledResolution;
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.multiplayer.PlayerControllerMP;
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.multiplayer.WorldClient;
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.util.MovingObjectPosition;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

@WrapperClass(mcpName = "net.minecraft.client.Minecraft", targetMap = MapEnum.VANILLA189)
public class Minecraft extends IWrapper {
    @WrapClass(mcpName = "net.minecraft.client.Minecraft", targetMap = MapEnum.VANILLA189)
    public static Class<?> MinecraftClass;
    @WrapField(mcpName = "theMinecraft", targetMap = MapEnum.VANILLA189)
    public static Field theMinecraft;
    @WrapMethod(mcpName = "getMinecraft", targetMap = MapEnum.VANILLA189)
    public static Method getMinecraft;
    @WrapField(mcpName = "timer", targetMap = MapEnum.VANILLA189)
    public static Field timer;
    @WrapMethod(mcpName = "displayGuiScreen", targetMap = MapEnum.VANILLA189)
    public static Method displayGuiScreen;
    @WrapField(mcpName = "theWorld", targetMap = MapEnum.VANILLA189)
    public static Field world;
    @WrapField(mcpName = "thePlayer", targetMap = MapEnum.VANILLA189)
    public static Field player;
    @WrapField(mcpName = "currentScreen", targetMap = MapEnum.VANILLA189)
    public static Field currentScreen;
    @WrapField(mcpName = "ingameGUI", targetMap = MapEnum.VANILLA189)
    public static Field ingameGUI;
    @WrapField(mcpName = "serverName", targetMap = MapEnum.VANILLA189)
    public static Field serverName;
    @WrapField(mcpName = "serverPort", targetMap = MapEnum.VANILLA189)
    public static Field serverPort;
    @WrapField(mcpName = "gameSettings", targetMap = MapEnum.VANILLA189)
    public static Field gameSettings;
    @WrapField(mcpName = "objectMouseOver", targetMap = MapEnum.VANILLA189)
    public static Field objectMouseOver;
    @WrapField(mcpName = "playerController", targetMap = MapEnum.VANILLA189)
    public static Field playerController;
    @WrapField(mcpName = "leftClickCounter", targetMap = MapEnum.VANILLA189)
    public static Field leftClickCounter;
    @WrapMethod(mcpName = "runTick", targetMap = MapEnum.VANILLA189)
    public static Method runTick;
    @WrapMethod(mcpName = "dispatchKeypresses", targetMap = MapEnum.VANILLA189)
    public static Method dispatchKeypresses;
    @WrapField(mcpName = "debugFPS", targetMap = MapEnum.VANILLA189)
    public static Field debugFPS;
    @WrapField(mcpName = "renderManager", targetMap = MapEnum.VANILLA189)
    public static Field renderManager;
    @WrapField(mcpName = "renderEngine", targetMap = MapEnum.VANILLA189)
    public static Field renderEngine;
    @WrapField(mcpName = "displayWidth", targetMap = MapEnum.VANILLA189)
    public static Field displayWidth;
    @WrapField(mcpName = "displayHeight", targetMap = MapEnum.VANILLA189)
    public static Field displayHeight;
    @WrapField(mcpName = "session", targetMap = MapEnum.VANILLA189)
    public static Field session;
    @WrapMethod(mcpName = "setIngameNotInFocus", targetMap = MapEnum.VANILLA189)
    public static Method setIngameNotInFocus;
    @WrapMethod(mcpName = "runGameLoop", targetMap = MapEnum.VANILLA189)
    public static Method runGameLoop;
    @WrapMethod(mcpName = "getNetHandler", targetMap = MapEnum.VANILLA189)
    public static Method getNetHandler;
    @WrapField(mcpName = "currentServerData", targetMap = MapEnum.VANILLA189)
    public static Field currentServerData;
    @WrapField(mcpName = "fontRendererObj", targetMap = MapEnum.VANILLA189)
    public static Field fontRendererObj;
    @WrapField(mcpName = "pointedEntity", targetMap = MapEnum.VANILLA189)
    public static Field pointedEntity;
    @WrapField(mcpName = "renderViewEntity", targetMap = MapEnum.VANILLA189)
    public static Field renderViewEntity;
    @WrapMethod(mcpName = "loadWorld", targetMap = MapEnum.VANILLA189)
    public static Method loadWorld;
    @WrapField(mcpName = "entityRenderer", targetMap = MapEnum.VANILLA189)
    public static Field entityRenderer;
    @WrapField(mcpName = "renderGlobal", targetMap = MapEnum.VANILLA189)
    public static Field renderGlobal;
    @WrapMethod(mcpName = "addScheduledTask", targetMap = MapEnum.VANILLA189, signature = "(Ljava/lang/Runnable;)Lcom/google/common/util/concurrent/ListenableFuture;")
    public static Method addScheduledTask;

    public Minecraft(Object obj) {
        super(obj);
    }

    public static int getDebugFPS() {
        return (int) ReflectUtil.getFieldStatic(debugFPS);
    }

    public static Minecraft getMinecraft() {
        return new Minecraft(ReflectUtil.getFieldStatic(theMinecraft));
    }

    public int getDisplayHeight() {
        return (int) getField(displayHeight);
    }

    public int getDisplayWidth() {
        return (int) getField(displayWidth);
    }

    public EntityPlayerSP getPlayer() {
        return new EntityPlayerSP(getField(player));
    }

    public WorldClient getWorld() {
        return new WorldClient(getField(world));
    }

    public PlayerControllerMP getPlayerController() {
        return new PlayerControllerMP(getField(playerController));
    }

    public <V> ListenableFuture<V> addScheduledTask(Callable<V> p_addScheduledTask_1_) {
        return (ListenableFuture<V>) invoke(addScheduledTask, p_addScheduledTask_1_);
    }

    public GameSettings getGameSettings() {
        return new GameSettings(getField(gameSettings));
    }

    public MovingObjectPosition getObjectMouseOver() {
        return new MovingObjectPosition(getField(objectMouseOver));
    }

    public void displayGuiScreenBypass(GuiScreen screen) {
        setField(currentScreen, screen.getWrapObject());
        invoke(setIngameNotInFocus);
        ScaledResolution scaledresolution = new ScaledResolution(this);
        int i = scaledresolution.getScaledWidth();
        int j = scaledresolution.getScaledHeight();
        getCurrentScreen().setMc(this);
        getCurrentScreen().setHeight(j);
        getCurrentScreen().setWidth(i);
        getCurrentScreen().initGui();
    }

    public GuiScreen getCurrentScreen() {
        return new GuiScreen(getField(currentScreen));
    }
}