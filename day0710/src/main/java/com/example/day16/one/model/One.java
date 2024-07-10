package com.example.day16.one.model;

import com.example.day16.many.Many;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class One {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String str;

    //@Builder.Default
    //@BatchSize(size = 10)
    @OneToMany(mappedBy = "one", fetch = FetchType.LAZY)
    private List<Many> manyList = new ArrayList<>();

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List<Many> getManyList() {
        return manyList;
    }

    public void setManyList(List<Many> manyList) {
        this.manyList = manyList;
    }
}
