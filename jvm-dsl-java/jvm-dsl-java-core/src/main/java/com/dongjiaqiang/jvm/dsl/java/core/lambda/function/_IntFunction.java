package com.dongjiaqiang.jvm.dsl.java.core.lambda.function;

@FunctionalInterface
public interface _IntFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    R apply(int value) throws Exception;
}