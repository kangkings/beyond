package org.example.spring_day01.board.model;

public class BoardCreateRes {
    private String title;

    public BoardCreateRes() {
    }

    @Override
    public String toString() {
        return "BoardCreateRes{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
