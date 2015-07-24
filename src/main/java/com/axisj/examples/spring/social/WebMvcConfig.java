package com.axisj.examples.spring.social;

import freemarker.template.TemplateModel;
import kr.pe.kwonnam.freemarker.inheritance.BlockDirective;
import kr.pe.kwonnam.freemarker.inheritance.ExtendsDirective;
import kr.pe.kwonnam.freemarker.inheritance.PutDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Map<String, TemplateModel> freemarkerLayoutDirectives() {
		Map<String, TemplateModel> freemarkerLayoutDirectives = new HashMap<>();
		freemarkerLayoutDirectives.put("extends", new ExtendsDirective());
		freemarkerLayoutDirectives.put("block", new BlockDirective());
		freemarkerLayoutDirectives.put("put", new PutDirective());
		return freemarkerLayoutDirectives;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
		freemarkerConfig.setTemplateLoaderPath("classpath:/templates");
		freemarkerConfig.setDefaultEncoding("UTF-8");

		Map<String, Object> freemarkerVariables = new HashMap<>();
		freemarkerVariables.put("layout", freemarkerLayoutDirectives());

		freemarkerConfig.setFreemarkerVariables(freemarkerVariables);
		return freemarkerConfig;
	}

	@Bean
	public ViewResolver viewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setCache(false);
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".ftl");
		viewResolver.setContentType("text/html; charset=utf-8");
		return viewResolver;
	}
}
