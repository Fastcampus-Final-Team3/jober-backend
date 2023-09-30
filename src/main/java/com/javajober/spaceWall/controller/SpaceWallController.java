package com.javajober.spaceWall.controller;

import com.javajober.core.error.exception.Exception404;
import com.javajober.core.message.ErrorMessage;
import com.javajober.core.message.SuccessMessage;
import com.javajober.core.util.ApiUtils;
import com.javajober.spaceWall.dto.request.SpaceWallRequest;
import com.javajober.spaceWall.dto.response.SpaceWallResponse;
import com.javajober.spaceWall.service.SpaceWallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping("/api")
@RestController
public class SpaceWallController {

    private final SpaceWallService spaceWallService;

    public SpaceWallController(SpaceWallService spaceWallService) {
        this.spaceWallService = spaceWallService;
    }

    @GetMapping("/wall-temporary/storage/{memberId}/{addSpaceId}")
    public ResponseEntity<ApiUtils.ApiResponse<SpaceWallResponse>> checkSpaceWallTemporary(@PathVariable Long memberId, @PathVariable Long addSpaceId) {

        SpaceWallResponse response = spaceWallService.checkSpaceWallTemporary(memberId, addSpaceId);

        return ResponseEntity.ok(ApiUtils.success(HttpStatus.OK, SuccessMessage.SPACE_WALL_TEMPORARY_QUERY_SUCCESS, response));
    }

    @PostMapping("/wall")
    public ResponseEntity<?> save(@RequestBody final SpaceWallRequest spaceWallRequest) {

        spaceWallService.save(spaceWallRequest);

        return ResponseEntity.ok(ApiUtils.success(HttpStatus.OK, SuccessMessage.CREATE_SUCCESS, null));
    }


}
