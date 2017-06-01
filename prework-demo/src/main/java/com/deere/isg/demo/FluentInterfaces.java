package com.deere.isg.demo;
//In software engineering, a fluent interface (as first coined by Eric Evans and Martin Fowler)
// is an implementation of an object oriented API that aims to provide more readable code
//-defined through the return value of a called method
//-self-referential, where the new context is equivalent to the last context
//-terminated through the return of a void context

import java.util.function.Consumer;

public class FluentInterfaces {

    static class Mailer {
        /*public void from(String addr) { System.out.println("from: " + addr); }
        public void to(String addr) { System.out.println("to: " + addr); }
        public void subject(String subjectLine) { System.out.println("subject: " + subjectLine); }
        public void body(String message) { System.out.println("body: " + message); }
        public void send() { System.out.println("sending..."); }*/

        public Mailer from(String addr) { System.out.println("from"); return this; }
        public Mailer to(String addr) { System.out.println("to"); return this; }
        public Mailer subject(String subjectLine) { System.out.println("subject"); return this; }
        public Mailer body(String message) { System.out.println("body"); return this; }

        public static void send(Consumer<Mailer> block) {
            Mailer mailer = new Mailer();
            block.accept(mailer);
            System.out.println("sending...");
        }
    }

    public static void main(String[] args) {
        /*Mailer mailer = new Mailer();
        mailer.from("builder@agiledeveloper.com");
        mailer.to("venkats@agiledeveloper.com");
        mailer.subject("Your code sucks");
        mailer.body("...");
        mailer.send();*/

        Mailer.send(mailer -> {
            mailer.from("builder@agiledeveloper.com")
                    .to("venkats@agiledeveloper.com")
                    .subject("Your code sucks")
                    .body("...");
        });
    }
}

