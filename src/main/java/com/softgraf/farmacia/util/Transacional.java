package com.softgraf.farmacia.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/*
 * As transações serão controladas através de interceptadores
 * Aqui definimos uma anotação que fara a ligação entre uma
 * classe ou método com o interceptador (@Interceptor)
 */

// Especifica que a anotação definida neste arquivo será usada para
// fazer a ligação (biding) entre uma classe ou método e um interceptador
@InterceptorBinding

// a anotação será armazenada no .class
@Retention(RetentionPolicy.RUNTIME)

// anotação poderá ser usada para marcar uma classe ou método
// TYPE = classe
// METHOD = método
@Target({ ElementType.TYPE, ElementType.METHOD })

// @Transacional deverá ser usada em conjunto com @Interceptor
public @interface Transacional {

}
