package org.springframework.social.kakao.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

public class KakaoNamespaceHandler extends AbstractProviderConfigNamespaceHandler {
	@Override
	protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {
		return null;
	}
}
