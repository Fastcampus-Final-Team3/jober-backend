package com.javajober.fileBlock.dto.request;

import com.javajober.fileBlock.domain.FileBlock;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FileBlockUpdateRequest {

    private Long fileId;
    private String fileTitle;
    private String fileDescription;

    public FileBlockUpdateRequest() {
    }

    public static FileBlock toEntity(final FileBlockUpdateRequest fileBlockSaveRequest, String fileName) {
        return FileBlock.builder()
                .fileTitle(fileBlockSaveRequest.getFileTitle())
                .fileDescription(fileBlockSaveRequest.fileDescription)
                .fileName(fileName)
                .build();
    }
}
