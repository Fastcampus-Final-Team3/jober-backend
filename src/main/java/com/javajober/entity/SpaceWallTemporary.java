package com.javajober.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "space_wall_temporary")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class SpaceWallTemporary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blocks", columnDefinition = "json", nullable = false)
    private String blocks;

    @Column(name = "share_url", nullable = false)
    private String shareURL;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_space_id", nullable = false)
    private AddSpace addSpace;

    @Column(name = "space_wall_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpaceWallCategoryType spaceWallCategoryType;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    protected SpaceWallTemporary() {

    }

    public SpaceWallTemporary(final String blocks, final SpaceWallCategoryType spaceWallCategoryType, final String shareURL) {
        this.blocks = blocks;
        this.spaceWallCategoryType = spaceWallCategoryType;
        this.shareURL = shareURL;
    }

}
