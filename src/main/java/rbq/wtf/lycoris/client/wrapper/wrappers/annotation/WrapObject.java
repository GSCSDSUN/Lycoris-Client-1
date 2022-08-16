package rbq.wtf.lycoris.client.wrapper.wrappers.annotation;

import rbq.wtf.lycoris.client.wrapper.wrappers.annotation.repeat.WrapObjects;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(WrapObjects.class)
/**
 * Auto setup field
 */
public @interface WrapObject {
    String mcpName();
    String targetMap();
    String customSrgName() default "none";
}
