package com.deere.isg.demo;

import java.util.function.Consumer;

//When a pair of actions have to be taken together (such as file open/close),
//you can use a HigherOrderFunction that wraps the actions around the function that is passed in.
public class ExecuteAroundMethod {
    static class Resource {
        //we want to clean up the object quite deterministically as soon as we're done with it.
        //Java 7 ARM is a step closer to this, but still requires programmers to remember to use
        //the try format.
        //Using EAM pattern the Java 8 compiler can gently force the programmer to naturally use it without having
        //to remember.

        private Resource() {
            System.out.println("Instance created");
        }

        public void op1() {
            System.out.println("op1 called....");
        }

        public void op2() {
            System.out.println("op2 called...");
        }

        private void close() {
            System.out.println("do any cleanup here...");
        }

        // Java 8 Way
        public static void use(Consumer<Resource> consume) {
            Resource resource = new Resource();
            try {
                consume.accept(resource);
            } finally {
                resource.close();
            }
        }
    }

    public static void main(String[] args) {
        //This is how the class will be used by fellow programmers.
        Resource resource = new Resource();
        resource.op1();
        resource.op2();
        resource.close();

        // Java 8 Way
        Resource.use(resrc -> {
            resrc.op1();
            resrc.op2();
        });
    }
}