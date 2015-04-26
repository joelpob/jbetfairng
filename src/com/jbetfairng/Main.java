package com.jbetfairng;

import rx.Observable;
import rx.functions.Action1;

public class Main {
    public static void hello(String... names) {
        Observable.from(names).subscribe(new Action1<String>() {
            public void call(String s) {
                System.out.println("Hello " + s + "!");
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        hello("Bob Joel");
    }
}
