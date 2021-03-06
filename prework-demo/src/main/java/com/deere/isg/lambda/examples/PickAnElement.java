package com.deere.isg.lambda.examples;

import java.util.List;
import java.util.Optional;

public class PickAnElement {
    public static void pickName(final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.print(String.format("A name starting with %s: ", startingLetter));
        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    //More Elegant way
    public static void pickNameUsingStream(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter)).findFirst();

        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found")));
    }
}
