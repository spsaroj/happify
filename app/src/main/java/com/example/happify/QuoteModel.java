package com.example.happify;

public class QuoteModel {
    String text;
    String author;

    public QuoteModel(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getQuoteText() {
        return text;
    }

    public String getQuoteAuthor() {
        return author;
    }
}
