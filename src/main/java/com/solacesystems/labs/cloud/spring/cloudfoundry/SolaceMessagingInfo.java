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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

/*
 * A Simple Solace Messaging Service Descriptor, showing all accessible services. 
 * In general the Solace message router can fulfill various service roles and could be modeled as 
 * completely separate services.
 */
@ServiceLabel("solacemessaging")
public class SolaceMessagingInfo extends BaseServiceInfo {

	private Map<String, Object> serviceData = new HashMap<>();

	// TODO: See what id is used for in ServiceInfo, is it the credentials Id? the binding id?
	
	public static enum CredentialKeys {
		id, clientUsername, clientPassword, msgVpnName, jmsTlsUri, jmsUri, managementPassword, managementUsername, smfTlsUri, smfUri, webMessagingUri, smfZipUri, managementHttpUris(
				true), managementHttpsUris(true), mqttTlsUris(
						true), mqttUris(true), mqttWsUris(true), mqttWssUris(true), restUris(true), restTlsUris(true);

		private boolean isList = false;

		CredentialKeys() {
			this(false);
		}

		CredentialKeys(Boolean isList) {
			this.isList = isList;
		}

		public boolean isList() {
			return isList;
		}

	}

	public SolaceMessagingInfo(String id) {
		super(id);
		serviceData.put(CredentialKeys.id.name(), id);
	}

	public SolaceMessagingInfo(String id, Map<String, Object> credentials) {
		super(id);
		serviceData.put(CredentialKeys.id.name(), id);
		addPropertiesFromMap(credentials);
	}

	protected void addPropertiesFromMap(Map<String, Object> credentials) {
		for (CredentialKeys k : CredentialKeys.values()) {
			String key = k.name();
			if (credentials.containsKey(key)) {
				serviceData.put(key, credentials.get(key));
			}
		}
	}

	@ServiceProperty
	public String getClientUsername() {
		return (String) serviceData.get(CredentialKeys.clientUsername.name());
	}

	@ServiceProperty
	public String getClientPassword() {
		return (String) serviceData.get(CredentialKeys.clientPassword.name());
	}

	@ServiceProperty
	public String getMsgVpnName() {
		return (String) serviceData.get(CredentialKeys.msgVpnName.name());
	}

	@ServiceProperty
	public String getJmsTlsUri() {
		return (String) serviceData.get(CredentialKeys.jmsTlsUri.name());
	}

	@ServiceProperty
	public String getJmsUri() {
		return (String) serviceData.get(CredentialKeys.jmsUri.name());
	}

	@SuppressWarnings("unchecked")
	@ServiceProperty
	public List<String> getManagementHttpUris() {
		return (List<String>) serviceData.get(CredentialKeys.managementHttpUris.name());
	}

	@ServiceProperty
	public String getManagementPassword() {
		return (String) serviceData.get(CredentialKeys.managementPassword.name());
	}

	@ServiceProperty
	public String getManagementUsername() {
		return (String) serviceData.get(CredentialKeys.managementUsername.name());
	}

	@SuppressWarnings("unchecked")
	@ServiceProperty
	public List<String> getMqttTlsUris() {
		return (List<String>) serviceData.get(CredentialKeys.mqttTlsUris.name());
	}

	@SuppressWarnings("unchecked")
	@ServiceProperty
	public List<String> getMqttUris() {
		return (List<String>) serviceData.get(CredentialKeys.mqttUris.name());
	}

	@SuppressWarnings("unchecked")
	@ServiceProperty
	public List<String> getMqttWsUris() {
		return (List<String>) serviceData.get(CredentialKeys.mqttWsUris.name());
	}

	@SuppressWarnings("unchecked")
	@ServiceProperty
	public List<String> getMqttWssUris() {
		return (List<String>) serviceData.get(CredentialKeys.mqttWssUris.name());
	}

	@SuppressWarnings("unchecked")
	@ServiceProperty
	public List<String> getRestUris() {
		return (List<String>) serviceData.get(CredentialKeys.restUris.name());
	}

	@ServiceProperty
	public String getRestTlsUris() {
		return (String) serviceData.get(CredentialKeys.restTlsUris.name());
	}

	@ServiceProperty
	public String getSmfTlsUri() {
		return (String) serviceData.get(CredentialKeys.smfTlsUri.name());
	}

	@ServiceProperty
	public String getSmfUri() {
		return (String) serviceData.get(CredentialKeys.smfUri.name());
	}

	@ServiceProperty
	public String getWebMessagingUri() {
		return (String) serviceData.get(CredentialKeys.webMessagingUri.name());
	}

	@ServiceProperty
	public String getSmfZipUri() {
		return (String) serviceData.get(CredentialKeys.smfZipUri.name());
	}

	public void setClientUsername(String clientUsername) {
		serviceData.put(CredentialKeys.clientUsername.name(), clientUsername);
	}

	public void setClientPassword(String clientPassword) {
		serviceData.put(CredentialKeys.clientPassword.name(), clientPassword);
	}

	public void setMsgVpnName(String msgVpnName) {
		serviceData.put(CredentialKeys.msgVpnName.name(), msgVpnName);
	}

	public void setJmsTlsUri(String jmsTlsUri) {
		serviceData.put(CredentialKeys.jmsTlsUri.name(), jmsTlsUri);
	}

	public void setJmsUri(String jmsUri) {
		serviceData.put(CredentialKeys.jmsUri.name(), jmsUri);
	}

	public void setManagementHttpUris(List<String> managementHttpUris) {
		serviceData.put(CredentialKeys.managementHttpUris.name(), managementHttpUris);
	}

	public void setManagementPassword(String managementPassword) {
		serviceData.put(CredentialKeys.managementPassword.name(), managementPassword);
	}

	public void setManagementUsername(String managementUsername) {
		serviceData.put(CredentialKeys.managementUsername.name(), managementUsername);
	}

	public void setMqttTlsUris(List<String> mqttTlsUris) {
		serviceData.put(CredentialKeys.mqttTlsUris.name(), mqttTlsUris);
	}

	public void setMqttUris(List<String> mqttUris) {
		serviceData.put(CredentialKeys.mqttUris.name(), mqttUris);
	}

	public void setMqttWsUris(List<String> mqttWsUris) {
		serviceData.put(CredentialKeys.mqttWsUris.name(), mqttWsUris);
	}

	public void setMqttWssUris(List<String> mqttWssUris) {
		serviceData.put(CredentialKeys.mqttWssUris.name(), mqttWssUris);
	}

	public void setRestUris(List<String> restUris) {
		serviceData.put(CredentialKeys.restUris.name(), restUris);
	}

	public void setRestTlsUris(List<String> restTlsUris) {
		serviceData.put(CredentialKeys.restTlsUris.name(), restTlsUris);
	}

	public void setSmfTlsUri(String smfTlsUri) {
		serviceData.put(CredentialKeys.smfTlsUri.name(), smfTlsUri);
	}

	public void setSmfUri(String smfUri) {
		serviceData.put(CredentialKeys.smfUri.name(), smfUri);
	}

	public void setWebMessagingUri(String webMessagingUri) {
		serviceData.put(CredentialKeys.webMessagingUri.name(), webMessagingUri);
	}

	public void setSmfZipUri(String smfZipUri) {
		serviceData.put(CredentialKeys.smfZipUri.name(), smfZipUri);
	}

	public Object get(CredentialKeys k) {
		if (k == null)
			return null;
		return serviceData.get(k.name());
	}
	
	public Object get(String name) {
		if (name == null)
			return null;
		return serviceData.get(name);
	}

	@Override
	public String toString() {

		JSONObject retJson = new JSONObject();
		for (CredentialKeys key : CredentialKeys.values()) {
			retJson.put(key.name(), serviceData.get(key.name()));
		}

		return retJson.toString(4);

	}

}