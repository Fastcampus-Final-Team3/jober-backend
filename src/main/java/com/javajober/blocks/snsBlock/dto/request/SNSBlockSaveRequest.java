package com.javajober.blocks.snsBlock.dto.request;

import com.javajober.blocks.snsBlock.domain.SNSBlock;
import com.javajober.blocks.snsBlock.domain.SNSType;

import lombok.Getter;

@Getter
public class SNSBlockSaveRequest {

	private String snsUUID;
	private String snsType;
	private String snsURL;

	private SNSBlockSaveRequest() {

	}

	public static SNSBlock toEntity(final SNSBlockSaveRequest snsBlockSaveRequest) {
		return SNSBlock.builder()
			.snsUUID(snsBlockSaveRequest.getSnsUUID())
			.snsType(SNSType.findSNSTypeByString(snsBlockSaveRequest.getSnsType()))
			.snsURL(snsBlockSaveRequest.getSnsURL())
			.build();
	}
}