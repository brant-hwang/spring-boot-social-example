package org.springframework.social.kakao.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.impl.KakaoTemplate;

public class KakaoApiHelper implements ApiHelper<Kakao> {
	private final UsersConnectionRepository usersConnectionRepository;
	
	private final UserIdSource userIdSource;
	
	private KakaoApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
		this.usersConnectionRepository = usersConnectionRepository;
		this.userIdSource = userIdSource;
	}
	
	public Kakao getApi() {
		if (logger.isDebugEnabled()) {
			logger.debug("Getting API bingding instance for Kakao");
		}
		
		Connection<Kakao> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Kakao.class);
		if (logger.isDebugEnabled() && connection == null) {
			logger.debug("No current connection; Returning default KakaoTemplate instance.");
		}
		return connection != null ? connection.getApi() : new KakaoTemplate();
	}
	
	private final static Log logger = LogFactory.getLog(KakaoApiHelper.class);
}
