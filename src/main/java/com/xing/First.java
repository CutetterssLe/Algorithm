package com.xing;


import java.util.function.Predicate;

/**
 * @author Mystery
 */
public class First<T> {
    public static void main(String[] args) throws Exception {

    }

    private  Predicate<T> negeta() {
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return false;
            }

            @Override
            public Predicate<T> and(Predicate<? super T> other) {
                return Predicate.super.and(other);
            }

            @Override
            public Predicate<T> negate() {
                return Predicate.super.negate();
            }
        }.negate();
    }


}
