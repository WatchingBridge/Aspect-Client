package club.aspect.api.command;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandInfo {

    /**
     * @return Command name
     */
    String[] names();

    /**
     * @return Command description
     */
    String description() default "No description provided.";
}
