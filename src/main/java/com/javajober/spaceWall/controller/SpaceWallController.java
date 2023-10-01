package com.javajober.spaceWall.controller;

import com.javajober.core.message.SuccessMessage;
import com.javajober.core.util.ApiUtils;
import com.javajober.spaceWall.domain.FlagType;
import com.javajober.spaceWall.dto.request.SpaceWallSaveRequest;
import com.javajober.spaceWall.dto.response.SpaceWallResponse;
import com.javajober.spaceWall.service.SpaceWallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class SpaceWallController {

    private final SpaceWallService spaceWallService;

    public SpaceWallController(final SpaceWallService spaceWallService) {
        this.spaceWallService = spaceWallService;
    }

    @GetMapping("/wall-temporary/storage/{memberId}/{addSpaceId}")
    public ResponseEntity<ApiUtils.ApiResponse<SpaceWallResponse>> checkSpaceWallTemporary(@PathVariable final Long memberId, @PathVariable final Long addSpaceId) {

        SpaceWallResponse response = spaceWallService.checkSpaceWallTemporary(memberId, addSpaceId);

        return ResponseEntity.ok(ApiUtils.success(HttpStatus.OK, SuccessMessage.SPACE_WALL_TEMPORARY_QUERY_SUCCESS, response));
    }

    @PostMapping("/wall")
    public ResponseEntity<?> save(@RequestBody final SpaceWallSaveRequest spaceWallSaveRequest) {

        spaceWallService.save(spaceWallSaveRequest, FlagType.SAVED);

        return ResponseEntity.ok(ApiUtils.success(HttpStatus.OK, SuccessMessage.CREATE_SUCCESS, null));
    }

    @PostMapping(path = "/wall-temporary")
    public ResponseEntity<?> savePending (@RequestBody final SpaceWallSaveRequest spaceWallSaveRequest)
    {

        spaceWallService.save(spaceWallSaveRequest, FlagType.PENDING);

        return ResponseEntity.ok(ApiUtils.success(HttpStatus.OK, SuccessMessage.CREATE_SUCCESS, null));
    }

}
