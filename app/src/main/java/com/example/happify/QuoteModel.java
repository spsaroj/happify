package com.example.happify;

public class QuoteModel {
    String text;
    String author;

    public QuoteModel(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
