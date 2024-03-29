package com.javajober.blocks.styleSetting.backgroundSetting.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.javajober.blocks.styleSetting.backgroundSetting.domain.BackgroundSetting;
import com.javajober.core.exception.ApiStatus;
import com.javajober.core.exception.ApplicationException;

public interface BackgroundSettingRepository extends Repository<BackgroundSetting, Long> {

	BackgroundSetting save(final BackgroundSetting backgroundSetting);

	Optional<BackgroundSetting> findById(final Long id);

	default BackgroundSetting getById (final Long id) {
		return findById(id)
			.orElseThrow(() -> new ApplicationException(ApiStatus.NOT_FOUND, "블록 설정 데이터를 찾을 수 없습니다."));
	}
}