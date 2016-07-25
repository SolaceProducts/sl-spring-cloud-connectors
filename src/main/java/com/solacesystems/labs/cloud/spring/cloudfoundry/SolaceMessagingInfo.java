/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.solacesystems.labs.cloud.spring.cloudfoundry;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

/*
 * A implementation of Spring Cloud Connector ServiceInfo to wrap the SolaceMessaging Cloud Foundry
 * Service. This class provides easy access to all of the information in the VCAP_SERVICES without
 * extra dependencies on any Solace Enterprise APIs.
 * 
 * For more details see the GitHub project:
 *    - https://github.com/SolaceLabs/sl-solace-messaging-service-info
 * 
 */
@ServiceLabel("solacemessaging")
public class SolaceMessagingInfo extends BaseServiceInfo {

	private String clientUsername;
	private String clientPassword;
	private String msgVpnName;
	private String smfUri;
	private String smfTlsUri;
	private String smfZipUri;
	private String webMessagingUri;
	private String jmsUri;
	private String jmsTlsUri;
	private List<String> restUris;
	private List<String> restTlsUris;
	private List<String> mqttUris;
	private List<String> mqttTlsUris;
	private List<String> mqttWsUris;
	private List<String> mqttWssUris;
	private List<String> managementHttpUris;
	private List<String> managementHttpsUris;
	private String managementPassword;
	private String managementUsername;

	
	public SolaceMessagingInfo() {
		super(null);
	}
	
	public SolaceMessagingInfo(String id) {
		super(id);
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	/**
	 * @return the clientUsername
	 */
	@ServiceProperty
	public String getClientUsername() {
		return clientUsername;
	}

	/**
	 * @param clientUsername the clientUsername to set
	 */
	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	/**
	 * @return the clientPassword
	 */
	@ServiceProperty
	public String getClientPassword() {
		return clientPassword;
	}

	/**
	 * @param clientPassword the clientPassword to set
	 */
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	/**
	 * @return the msgVpnName
	 */
	@ServiceProperty
	public String getMsgVpnName() {
		return msgVpnName;
	}

	/**
	 * @param msgVpnName the msgVpnName to set
	 */
	public void setMsgVpnName(String msgVpnName) {
		this.msgVpnName = msgVpnName;
	}

	/**
	 * @return the smfUri
	 */
	@ServiceProperty
	public String getSmfUri() {
		return smfUri;
	}

	/**
	 * @param smfUri the smfUri to set
	 */
	public void setSmfUri(String smfUri) {
		this.smfUri = smfUri;
	}

	/**
	 * @return the smfTlsUri
	 */
	@ServiceProperty
	public String getSmfTlsUri() {
		return smfTlsUri;
	}

	/**
	 * @param smfTlsUri the smfTlsUri to set
	 */
	public void setSmfTlsUri(String smfTlsUri) {
		this.smfTlsUri = smfTlsUri;
	}

	/**
	 * @return the smfZipUri
	 */
	@ServiceProperty
	public String getSmfZipUri() {
		return smfZipUri;
	}

	/**
	 * @param smfZipUri the smfZipUri to set
	 */
	public void setSmfZipUri(String smfZipUri) {
		this.smfZipUri = smfZipUri;
	}

	/**
	 * @return the webMessagingUri
	 */
	@ServiceProperty
	public String getWebMessagingUri() {
		return webMessagingUri;
	}

	/**
	 * @param webMessagingUri the webMessagingUri to set
	 */
	public void setWebMessagingUri(String webMessagingUri) {
		this.webMessagingUri = webMessagingUri;
	}

	/**
	 * @return the jmsUri
	 */
	@ServiceProperty
	public String getJmsUri() {
		return jmsUri;
	}

	/**
	 * @param jmsUri the jmsUri to set
	 */
	public void setJmsUri(String jmsUri) {
		this.jmsUri = jmsUri;
	}

	/**
	 * @return the jmsTlsUri
	 */
	@ServiceProperty
	public String getJmsTlsUri() {
		return jmsTlsUri;
	}

	/**
	 * @param jmsTlsUri the jmsTlsUri to set
	 */
	public void setJmsTlsUri(String jmsTlsUri) {
		this.jmsTlsUri = jmsTlsUri;
	}

	/**
	 * @return the restUris
	 */
	@ServiceProperty
	public List<String> getRestUris() {
		return restUris;
	}

	/**
	 * @param restUris the restUris to set
	 */
	public void setRestUris(List<String> restUris) {
		this.restUris = restUris;
	}

	/**
	 * @return the restTlsUris
	 */
	@ServiceProperty
	public List<String> getRestTlsUris() {
		return restTlsUris;
	}

	/**
	 * @param restTlsUris the restTlsUris to set
	 */
	public void setRestTlsUris(List<String> restTlsUris) {
		this.restTlsUris = restTlsUris;
	}

	/**
	 * @return the mqttUris
	 */
	@ServiceProperty
	public List<String> getMqttUris() {
		return mqttUris;
	}

	/**
	 * @param mqttUris the mqttUris to set
	 */
	public void setMqttUris(List<String> mqttUris) {
		this.mqttUris = mqttUris;
	}

	/**
	 * @return the mqttTlsUris
	 */
	@ServiceProperty
	public List<String> getMqttTlsUris() {
		return mqttTlsUris;
	}

	/**
	 * @param mqttTlsUris the mqttTlsUris to set
	 */
	public void setMqttTlsUris(List<String> mqttTlsUris) {
		this.mqttTlsUris = mqttTlsUris;
	}

	/**
	 * @return the mqttWsUris
	 */
	@ServiceProperty
	public List<String> getMqttWsUris() {
		return mqttWsUris;
	}

	/**
	 * @param mqttWsUris the mqttWsUris to set
	 */
	public void setMqttWsUris(List<String> mqttWsUris) {
		this.mqttWsUris = mqttWsUris;
	}

	/**
	 * @return the mqttWssUris
	 */
	@ServiceProperty
	public List<String> getMqttWssUris() {
		return mqttWssUris;
	}

	/**
	 * @param mqttWssUris the mqttWssUris to set
	 */
	public void setMqttWssUris(List<String> mqttWssUris) {
		this.mqttWssUris = mqttWssUris;
	}

	/**
	 * @return the managementHttpUris
	 */
	@ServiceProperty
	public List<String> getManagementHttpUris() {
		return managementHttpUris;
	}

	/**
	 * @param managementHttpUris the managementHttpUris to set
	 */
	public void setManagementHttpUris(List<String> managementHttpUris) {
		this.managementHttpUris = managementHttpUris;
	}

	/**
	 * @return the managementHttpsUris
	 */
	@ServiceProperty
	public List<String> getManagementHttpsUris() {
		return managementHttpsUris;
	}

	/**
	 * @param managementHttpsUris the managementHttpsUris to set
	 */
	public void setManagementHttpsUris(List<String> managementHttpsUris) {
		this.managementHttpsUris = managementHttpsUris;
	}

	/**
	 * @return the managementPassword
	 */
	@ServiceProperty
	public String getManagementPassword() {
		return managementPassword;
	}

	/**
	 * @param managementPassword the managementPassword to set
	 */
	public void setManagementPassword(String managementPassword) {
		this.managementPassword = managementPassword;
	}

	/**
	 * @return the managementUsername
	 */
	@ServiceProperty
	public String getManagementUsername() {
		return managementUsername;
	}

	/**
	 * @param managementUsername the managementUsername to set
	 */
	public void setManagementUsername(String managementUsername) {
		this.managementUsername = managementUsername;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((clientPassword == null) ? 0 : clientPassword.hashCode());
		result = prime * result + ((clientUsername == null) ? 0 : clientUsername.hashCode());
		result = prime * result + ((jmsTlsUri == null) ? 0 : jmsTlsUri.hashCode());
		result = prime * result + ((jmsUri == null) ? 0 : jmsUri.hashCode());
		result = prime * result + ((managementHttpUris == null) ? 0 : managementHttpUris.hashCode());
		result = prime * result + ((managementHttpsUris == null) ? 0 : managementHttpsUris.hashCode());
		result = prime * result + ((managementPassword == null) ? 0 : managementPassword.hashCode());
		result = prime * result + ((managementUsername == null) ? 0 : managementUsername.hashCode());
		result = prime * result + ((mqttTlsUris == null) ? 0 : mqttTlsUris.hashCode());
		result = prime * result + ((mqttUris == null) ? 0 : mqttUris.hashCode());
		result = prime * result + ((mqttWsUris == null) ? 0 : mqttWsUris.hashCode());
		result = prime * result + ((mqttWssUris == null) ? 0 : mqttWssUris.hashCode());
		result = prime * result + ((msgVpnName == null) ? 0 : msgVpnName.hashCode());
		result = prime * result + ((restTlsUris == null) ? 0 : restTlsUris.hashCode());
		result = prime * result + ((restUris == null) ? 0 : restUris.hashCode());
		result = prime * result + ((smfTlsUri == null) ? 0 : smfTlsUri.hashCode());
		result = prime * result + ((smfUri == null) ? 0 : smfUri.hashCode());
		result = prime * result + ((smfZipUri == null) ? 0 : smfZipUri.hashCode());
		result = prime * result + ((webMessagingUri == null) ? 0 : webMessagingUri.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolaceMessagingInfo other = (SolaceMessagingInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
				return false;
		if (clientPassword == null) {
			if (other.clientPassword != null)
				return false;
		} else if (!clientPassword.equals(other.clientPassword))
			return false;
		if (clientUsername == null) {
			if (other.clientUsername != null)
				return false;
		} else if (!clientUsername.equals(other.clientUsername))
			return false;
		if (jmsTlsUri == null) {
			if (other.jmsTlsUri != null)
				return false;
		} else if (!jmsTlsUri.equals(other.jmsTlsUri))
			return false;
		if (jmsUri == null) {
			if (other.jmsUri != null)
				return false;
		} else if (!jmsUri.equals(other.jmsUri))
			return false;
		if (managementHttpUris == null) {
			if (other.managementHttpUris != null)
				return false;
		} else if (!managementHttpUris.equals(other.managementHttpUris))
			return false;
		if (managementHttpsUris == null) {
			if (other.managementHttpsUris != null)
				return false;
		} else if (!managementHttpsUris.equals(other.managementHttpsUris))
			return false;
		if (managementPassword == null) {
			if (other.managementPassword != null)
				return false;
		} else if (!managementPassword.equals(other.managementPassword))
			return false;
		if (managementUsername == null) {
			if (other.managementUsername != null)
				return false;
		} else if (!managementUsername.equals(other.managementUsername))
			return false;
		if (mqttTlsUris == null) {
			if (other.mqttTlsUris != null)
				return false;
		} else if (!mqttTlsUris.equals(other.mqttTlsUris))
			return false;
		if (mqttUris == null) {
			if (other.mqttUris != null)
				return false;
		} else if (!mqttUris.equals(other.mqttUris))
			return false;
		if (mqttWsUris == null) {
			if (other.mqttWsUris != null)
				return false;
		} else if (!mqttWsUris.equals(other.mqttWsUris))
			return false;
		if (mqttWssUris == null) {
			if (other.mqttWssUris != null)
				return false;
		} else if (!mqttWssUris.equals(other.mqttWssUris))
			return false;
		if (msgVpnName == null) {
			if (other.msgVpnName != null)
				return false;
		} else if (!msgVpnName.equals(other.msgVpnName))
			return false;
		if (restTlsUris == null) {
			if (other.restTlsUris != null)
				return false;
		} else if (!restTlsUris.equals(other.restTlsUris))
			return false;
		if (restUris == null) {
			if (other.restUris != null)
				return false;
		} else if (!restUris.equals(other.restUris))
			return false;
		if (smfTlsUri == null) {
			if (other.smfTlsUri != null)
				return false;
		} else if (!smfTlsUri.equals(other.smfTlsUri))
			return false;
		if (smfUri == null) {
			if (other.smfUri != null)
				return false;
		} else if (!smfUri.equals(other.smfUri))
			return false;
		if (smfZipUri == null) {
			if (other.smfZipUri != null)
				return false;
		} else if (!smfZipUri.equals(other.smfZipUri))
			return false;
		if (webMessagingUri == null) {
			if (other.webMessagingUri != null)
				return false;
		} else if (!webMessagingUri.equals(other.webMessagingUri))
			return false;
		return true;
	}

}