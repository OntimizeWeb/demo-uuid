package com.imatia.implatform.prototypen.model.core.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imatia.implatform.prototypen.api.core.service.IMainService;

@Service
public class MainService implements IMainService {
	private static final String RELEASE_NAME = "RELEASE_NAME";
	private static final String APPLICATION_NAME = "APPLICATION_NAME";
	private static final String NAMESPACE_SUBDOMAIN = "NAMESPACE_SUBDOMAIN";
	private static final String DOMAIN = "DOMAIN";
	private static final String TLS = "TLS";

	String mainUrl = null;

	public String getMainUrl() {
		if (this.mainUrl == null) {
			final Map<String, String> env = System.getenv();
			final String releaseName = env.get(RELEASE_NAME);
			final String applicationName = env.get(APPLICATION_NAME);
			final String namespaceSubdomain = env.get(NAMESPACE_SUBDOMAIN);
			final String domain = env.get(DOMAIN);
			final String tls = env.get(TLS);

			if (releaseName == null) {
				this.mainUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
			} else {
				this.mainUrl = ((tls == null) ? "http://" : "https://") + applicationName + namespaceSubdomain + domain;
			}
		}

		return this.mainUrl;
	}
}
