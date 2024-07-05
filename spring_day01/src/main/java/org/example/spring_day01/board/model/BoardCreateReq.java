package org.example.spring_day01.board.model;

public class BoardCreateReq {
    private String title;

    private String contents;

    public BoardCreateReq() {
    }

    @Override
    public String toString() {
        return "BoardCreateReq{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
