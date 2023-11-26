package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.LinkedList;

public class LibrarySystem<E> {
public LinkedList<Book> booksList=new LinkedList<Book>();
public LinkedList<LibMember> membersList=new LinkedList<LibMember>();
public int booksListSize;
private int membersListSize ;
    LibrarySystem() {
        booksListSize=0;
        membersListSize=0;

    }


    public boolean addBook(Book value) {
        if (this.booksListSize == 0) {
            booksList.addFirst(value);
            booksListSize++;
            return true;
        } else {
            ListIterator iterator = this.booksList.listIterator();

            do {
                if (!iterator.hasNext()) {
                    booksList.add(value);
                    ++this.booksListSize;
                    return true;
                }
            } while(!iterator.next().equals(value));

            return false;
        }
    }









}
