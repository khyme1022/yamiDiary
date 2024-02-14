package com.yamidiary.yamiyami.diary.entity;

import com.yamidiary.yamiyami.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name="DIARY")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_NO", nullable = false, updatable = false)
    private int diaryNo; // 다이어리 번호

    @ManyToOne
    @JoinColumn(name = "DIARY_WRITER")
    @ToString.Exclude
    private User diaryWriter; // 작성자 / 외래키 User(userId)

    @Column(name="DIARY_TITLE", nullable = false)
    private String diaryTitle; // 다이어리 제목

    @Column(name="DIARY_PRIVATE_YN", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private Boolean diaryPrivateYn; // 다이어리 공개 여부 0은 비공개 1은 공개

    @Column(name="DIARY_DELETE_YN", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private Boolean diaryDeleteYn; // 다이어리 삭제 여부 0은 활성화 1은 삭제

    @Column(name="DIARY_VIEW", nullable = false, columnDefinition = "Integer default 0")
    private int diaryView; // 다이어리 조회수

    @CreatedDate
    @Column(name = "DIARY_WRITE_DATE", nullable = false, updatable = false, columnDefinition = "DATETIME")
    private LocalDateTime diaryWriteDate; // 다이어리 작성 날짜
}
