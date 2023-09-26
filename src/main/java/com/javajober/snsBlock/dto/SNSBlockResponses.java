package com.javajober.snsBlock.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class SNSBlockResponses {
	List<SNSBlockResponse> snsBlockResponses;

	public SNSBlockResponses(final List<SNSBlockResponse> snsBlockResponses) {
		this.snsBlockResponses = snsBlockResponses;
	}
}
