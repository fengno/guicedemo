package org.demo.guicedemo.hellodemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.BindingAnnotation;

@Retention(RetentionPolicy.RUNTIME)//除了编译时用到，运行时也需要用到
@BindingAnnotation
public @interface Output {

}
