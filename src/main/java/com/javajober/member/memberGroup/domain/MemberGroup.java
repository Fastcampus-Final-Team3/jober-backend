package com.javajober.member.memberGroup.domain;

import com.javajober.member.domain.AccountType;
import com.javajober.member.domain.Member;
import com.javajober.space.domain.AddSpace;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "member_group")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class MemberGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_hashtag_type")
    private MemberHashtagType memberHashtagType;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_space_id", nullable = false)
    private AddSpace addSpace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    protected MemberGroup() {}

    @Builder
    public MemberGroup(final MemberHashtagType memberHashtagType, final AccountType accountType, final AddSpace addSpace, final Member member) {
        this.memberHashtagType = memberHashtagType;
        this.accountType = accountType;
        this.addSpace = addSpace;
        this.member = member;
    }
}