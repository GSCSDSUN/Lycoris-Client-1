package rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.util.event.click

import rbq.wtf.lycoris.client.wrapper.MapEnum
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapField
import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.WrapperClass
import rbq.wtf.lycoris.client.wrapper.wrappers.wrapper.IWrapper
import java.lang.reflect.Field

@WrapperClass(mcpName = "net.minecraft.event.ClickEvent", targetMap = MapEnum.VANILLA189)
class ClickEvent(obj: Any) : IWrapper(obj) {
    companion object {
        @WrapField(mcpName = "action", targetMap = MapEnum.VANILLA189)
        lateinit var action: Field

        @WrapField(mcpName = "value", targetMap = MapEnum.VANILLA189)
        lateinit var value: Field
    }

    val action: Enum<*>
        get() = getField(Companion.action) as Enum<*>
    val value: String
        get() = getField(Companion.value) as String
}