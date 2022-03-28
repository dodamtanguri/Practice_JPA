package com.example.practice_jpa.contents.model;


import com.example.practice_jpa.common.converters.BooleanConverter;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "board")
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "writer_id")
    private Writer writer;

    @Column(length = 5000)
    private String content;

    @Column
    @CreatedDate
    private LocalDateTime createDate;

    @Column
    @LastModifiedDate
    private LocalDateTime modifyDate;

    @Convert(converter = BooleanConverter.class)
    private boolean enabled;

    public Board() {
        this.enabled = true;
    }

    @Builder
    public Board(String title, String content, Writer writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
