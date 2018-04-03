package com.test.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.test.common.Constant.RedisConst;


@Component
public class ProductIdGenerator {

	@Autowired
	private StringRedisTemplate template;

	public Number generateProductId() {
		return template.boundValueOps(RedisConst.ID_GENERATOR_PRODUCT).increment(1);
	}
}
