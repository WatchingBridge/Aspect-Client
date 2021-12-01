package club.aspect.api.mod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModInfo {

    int keybind() default 0;

    String name();

    String description() default "No description provided.";

    Category category();

    String renderName();


}
