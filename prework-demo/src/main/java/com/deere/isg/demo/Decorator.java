package com.deere.isg.demo;

import java.util.List;
import java.util.ArrayList;
//Attach additional responsibility to an object dynamically. Decorator provide a flexible alternative to
// subclassing for extending functionality
public class Decorator {

    interface Book {
        public String describe();
    }

    static class BasicBook implements Book {
        @Override
        public String describe() {
            return "Book";
        }
    }

    abstract static class BookDecorator implements Book {
        protected Book book;

        BookDecorator(Book book) {
            this.book = book;
        }

        @Override
        public String describe() {
            return book.describe();
        }
    }

    static class FictionBookDecorator extends BookDecorator {
        FictionBookDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return ("Fiction " + super.describe());
        }
    }


    static class ScienceBookDecorator extends BookDecorator {
        ScienceBookDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return ("Science " + super.describe());
        }
    }

    static class HardCoverDecorator extends BookDecorator {
        HardCoverDecorator(Book book) {
            super(book);
        }

        @Override
        public String describe() {
            return (super.describe() + " with Hard Cover");
        }
    }

    public static void main(String[] args) {
        BasicBook book = new BasicBook();
        FictionBookDecorator fictionBook = new FictionBookDecorator(book);
        HardCoverDecorator hardCoverBook = new HardCoverDecorator(book);
        HardCoverDecorator hardCoverFictionBook = new HardCoverDecorator(fictionBook);
        ScienceBookDecorator scienceBook = new ScienceBookDecorator(book);
        HardCoverDecorator hardCoverScienceBook = new HardCoverDecorator(scienceBook);
        List<Book> bookList = new ArrayList<Book>() {
            {
                add(book);
                add(fictionBook);
                add(hardCoverBook);
                add(hardCoverFictionBook);
                add(scienceBook);
                add(hardCoverScienceBook);
            }
        };

        for (Book b : bookList) {
            System.out.println(b.describe());
        }
    }

    // Java 8 Way
      /*public static void main(String[] args) {
        BasicBook book = new BasicBook();
        Book fictionBook = () -> "Fiction " + book.describe();
        Book hardCoverBook = () -> book.describe() + " with Hard Cover";
        Book hardCoverFictionBook = () -> fictionBook.describe() + " with Hard Cover";
        Book scienceBook = () -> "Science " + book.describe();
        Book hardCoverScienceBook = () -> fictionBook.describe() + " with Hard Cover";
        List<Book> bookList = new ArrayList<Book>() {
            {
                add(book);
                add(fictionBook);
                add(hardCoverBook);
                add(hardCoverFictionBook);
                add(scienceBook);
                add(hardCoverScienceBook);
            }
        };
        bookList.forEach(b -> System.out.println(b.describe()));
    }*/
}
