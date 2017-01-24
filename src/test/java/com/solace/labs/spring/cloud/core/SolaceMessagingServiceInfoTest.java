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

package com.solace.labs.spring.cloud.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;

public class SolaceMessagingServiceInfoTest {

	@Test
	public void fullSetGetCredentialsTest() throws IllegalAccessException, InvocationTargetException {

		String id = "full-credentials-instance";
		String clientUsername = "sample-client-username";
		String clientPassword = "sample-client-password";
		String msgVpnName = "sample-msg-vpn";
		String smfHost = "tcp://192.168.1.50:7000";
		String smfTlsHost = "tcps://192.168.1.50:7003";
		String smfZipHost = "tcp://192.168.1.50:7001";
		String webMessagingUri = "http://192.168.1.50:80";
		String webMessagingTlsUri = "https://192.168.1.50:80";
		String jmsJndiUri = "smf://192.168.1.50:7000";
		String jmsJndiTlsUri = "smfs://192.168.1.50:7003";
		List<String> mqttUris = Arrays.asList("tcp://192.168.1.50:7020");
		List<String> mqttTlsUris = Arrays.asList("ssl://192.168.1.50:7021");
		List<String> mqttWsUris = Arrays.asList("ws://192.168.1.50:7022");
		List<String> mqttWssUris = Arrays.asList("wss://192.168.1.50:7023");
		List<String> restUris = Arrays.asList("http://192.168.1.50:7018");
		List<String> restTlsUris = Arrays.asList("https://192.168.1.50:7019");
		List<String> managementHostnames = Arrays.asList("vmr-Medium-VMR-0");
		String managementUsername = "sample-mgmt-username";
		String managementPassword = "sample-mgmt-password";

		SolaceMessagingInfo smi = new SolaceMessagingInfo(id, clientUsername, clientPassword, msgVpnName, smfHost,
				smfTlsHost, smfZipHost, webMessagingUri, webMessagingTlsUri, jmsJndiUri, jmsJndiTlsUri, restUris, restTlsUris, mqttUris, mqttTlsUris,
				mqttWsUris, mqttWssUris, managementHostnames, managementPassword, managementUsername);

		// Check Top Level stuff
		assertEquals(id, smi.getId());
		assertEquals(clientUsername, smi.getClientUsername());
		assertEquals(clientPassword, smi.getClientPassword());
		assertEquals(msgVpnName, smi.getMsgVpnName());

		// Check SMF
		assertEquals(smfHost, smi.getSmfHost());
		assertEquals(smfTlsHost, smi.getSmfTlsHost());
		assertEquals(smfZipHost, smi.getSmfZipHost());

		// Check Web Messsaging
		assertEquals(webMessagingUri, smi.getWebMessagingUri());

		// Check JMS
		assertEquals(jmsJndiUri, smi.getJmsJndiUri());
		assertEquals(jmsJndiTlsUri, smi.getJmsJndiTlsUri());

		// Check MQTT
		assertThat(smi.getMqttUris(), is(mqttUris));
		assertThat(smi.getMqttTlsUris(), is(mqttTlsUris));
		assertThat(smi.getMqttWsUris(), is(mqttWsUris));
		assertThat(smi.getMqttWssUris(), is(mqttWssUris));

		// Check REST
		assertThat(smi.getRestUris(), is(restUris));
		assertThat(smi.getRestTlsUris(), is(restTlsUris));

		// Check Management Interfaces
		assertThat(smi.getManagementHostnames(), is(managementHostnames));
		assertEquals(managementUsername, smi.getManagementUsername());
		assertEquals(managementPassword, smi.getManagementPassword());

	}

	@Test
	public void meanBeanGetterAndSetterCorrectness() throws Exception {
		new BeanTester().testBean(SolaceMessagingInfo.class);
	}

	@Test
	public void meanBeanEqualsAndHashCodeContract() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.testEqualsMethod(SolaceMessagingInfo.class);
	}
}
