package com.pohang.mm.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.pohang.mm.model.mapper"
)
public class DatabaseConfiguration {}