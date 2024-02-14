package com.yamidiary.yamiyami.diary.entity;

import com.yamidiary.yamiyami.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="REPLY")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_NO", nullable = false, updatable = false)
    private int replyNo; // 댓글 번호

    @ManyToOne
    @JoinColumn(name = "REPLY_WRITER")
    @ToString.Exclude
    private User replyWriter; // 댓글 작성자 외래키 - User(userId)

    @ManyToOne
    @JoinColumn(name = "DIARY_NO")
    @ToString.Exclude
    private Diary diaryNo;  // 해당 다이어리 번호 / 외래키 Diary(diaryNo)

    @Column(name = "REPLY_CONTENT", nullable = false, updatable = false, columnDefinition = "VARCHAR(800)")
    private String replyContent; // 다이어리 내용

    @Column(name = "REPLY_DELETE_YN", nullable = false, updatable = false, columnDefinition = "TINYINT(1) default 0")
    private Boolean replyDeleteYn; // 다이어리 삭제 여부, 0이 존재, 1은 삭제

}
