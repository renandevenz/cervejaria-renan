package com.beerhouse.infra.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Adapter {

    /**
     *
     * @return o nome do componente sugerido, se houver (ou String vazia, caso contrário)
     */

    @AliasFor(annotation = Component.class)
    String value() default "";
}
