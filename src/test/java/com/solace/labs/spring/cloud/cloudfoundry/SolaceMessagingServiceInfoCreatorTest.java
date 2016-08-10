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

package com.solace.labs.spring.cloud.cloudfoundry;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.solace.labs.spring.cloud.core.SolaceMessagingInfo;


public class SolaceMessagingServiceInfoCreatorTest {

	@Test
	public void basicSolaceMessagingServiceInfoCreationTest() {

		Map<String, Object> exVcapServices = createVcapMap();

		SolaceMessagingInfoCreator smic = new SolaceMessagingInfoCreator();

		assertTrue(smic.accept(exVcapServices));

		SolaceMessagingInfo smi = smic.createServiceInfo(exVcapServices);

		validateExampleSmi(smi);

	}

	@Test
	public void mismatchLabelTest() {
		Map<String, Object> exVcapServices = createVcapMap();

		exVcapServices.put("label", "no-match");

		SolaceMessagingInfoCreator smic = new SolaceMessagingInfoCreator();

		assertFalse(smic.accept(exVcapServices));
	}

	// We could do a lot more negative testing. But other Spring cloud
	// connectors seem very tolerant. For now starting with this limited
	// coverage.
	@Test(expected=IllegalArgumentException.class)
	public void corruptVcapTest() {
		Map<String, Object> exVcapServices = createVcapMap();

		exVcapServices.remove("credentials");

		SolaceMessagingInfoCreator smic = new SolaceMessagingInfoCreator();

		// Should still accept it.
		assertTrue(smic.accept(exVcapServices));
		
		// Should be throw exception for null credentials.
		smic.createServiceInfo(exVcapServices);
	}

	@Test
	public void missingKeyValueTest() {
		// Should simply result in those values still being null.
		Map<String, Object> exVcapServices = createVcapMap();

		@SuppressWarnings("unchecked")
		Map<String, Object> exCred = (Map<String, Object>) exVcapServices.get("credentials");
		exCred.remove("smfUri");
		
		SolaceMessagingInfoCreator smic = new SolaceMessagingInfoCreator();

		// Should still accept it.
		assertTrue(smic.accept(exVcapServices));
		
		SolaceMessagingInfo smi = smic.createServiceInfo(exVcapServices);
		
		// Validate smf is null. Others are not
		assertNull(smi.getSmfUri());
		assertEquals("tcps://192.168.1.50:7003", smi.getSmfTlsUri());
		
	}
	
	@Test 
	public void loadCreatorFromMeta() {
		
		String metaFileName = "src/main/resources/META-INF/services/org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator";
		String solaceMessagingInfoCreatorClassName = null;
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(metaFileName));

			while ((sCurrentLine = br.readLine()) != null) {
				 solaceMessagingInfoCreatorClassName = sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		try {
			Class<?> z = Class.forName(solaceMessagingInfoCreatorClassName);
			assertTrue(z != null);
			assertTrue(z.equals(SolaceMessagingInfoCreator.class));
		} catch (ClassNotFoundException e) {
			fail("Should not throw.");
		}
		
	}
	
	private Map<String, Object> createVcapMap() {
		Map<String, Object> exVcapServices = new HashMap<String, Object>();

		Map<String, Object> exCred = new HashMap<String, Object>();
		exCred.put("clientUsername", "sample-client-username");
		exCred.put("clientPassword", "sample-client-password");
		exCred.put("msgVpnName", "sample-msg-vpn");
		exCred.put("smfUri", "tcp://192.168.1.50:7000");
		exCred.put("smfTlsUri", "tcps://192.168.1.50:7003");
		exCred.put("smfZipUri", "tcp://192.168.1.50:7001");
		exCred.put("webMessagingUri", "http://192.168.1.50:80");
		exCred.put("jmsUri", "smf://192.168.1.50:7000");
		exCred.put("jmsTlsUri", "smfs://192.168.1.50:7003");
		exCred.put("mqttUris", Arrays.asList("tcp://192.168.1.50:7020"));
		exCred.put("mqttTlsUris", Arrays.asList("ssl://192.168.1.50:7021"));
		exCred.put("mqttWsUris", Arrays.asList("ws://192.168.1.50:7022"));
		exCred.put("mqttWssUris", Arrays.asList("wss://192.168.1.50:7023"));
		exCred.put("restUris", Arrays.asList("http://192.168.1.50:7018"));
		exCred.put("restTlsUris", Arrays.asList("https://192.168.1.50:7019"));
		exCred.put("managementHttpUris", Arrays.asList("http://192.168.1.50:8080/SEMP/v2"));
		exCred.put("managementHttpsUris", Arrays.asList("https://192.168.1.50:443/SEMP/v2"));
		exCred.put("managementUsername", "sample-mgmt-username");
		exCred.put("managementPassword", "sample-mgmt-password");

		exVcapServices.put("credentials", exCred);
		exVcapServices.put("label", "solace-messaging");
		exVcapServices.put("name", "test-service-instance-name");
		exVcapServices.put("plan", "vmr-shared");
		exVcapServices.put("provider", "Solace Systems");
		// no need to check for tags in terms of validation. It's more for
		exVcapServices.put("tags", Arrays.asList("solace", "rest", "mqtt", "mq", "queue", "jms", "messaging"));
		return exVcapServices;
	}

	private void validateExampleSmi(SolaceMessagingInfo smi) {
		// Validate it all got set correctly.
		
		// Check Top Level stuff
		assertEquals("test-service-instance-name", smi.getId());
		assertEquals("sample-client-username", smi.getClientUsername());
		assertEquals("sample-client-password", smi.getClientPassword());
		assertEquals("sample-msg-vpn", smi.getMsgVpnName());

		// Check SMF
		assertEquals("tcp://192.168.1.50:7000", smi.getSmfUri());
		assertEquals("tcps://192.168.1.50:7003", smi.getSmfTlsUri());
		assertEquals("tcp://192.168.1.50:7001", smi.getSmfZipUri());

		// Check Web Messsaging
		assertEquals("http://192.168.1.50:80", smi.getWebMessagingUri());

		// Check JMS
		assertThat(smi.getMqttUris(), is(Arrays.asList("tcp://192.168.1.50:7020")));
		assertThat(smi.getMqttTlsUris(), is(Arrays.asList("ssl://192.168.1.50:7021")));
		assertThat(smi.getMqttWsUris(), is(Arrays.asList("ws://192.168.1.50:7022")));
		assertThat(smi.getMqttWssUris(), is(Arrays.asList("wss://192.168.1.50:7023")));

		// Check REST
		assertThat(smi.getRestUris(), is(Arrays.asList("http://192.168.1.50:7018")));
		assertThat(smi.getRestTlsUris(), is(Arrays.asList("https://192.168.1.50:7019")));

		// Check Management Interfaces
		assertThat(smi.getManagementHttpUris(), is(Arrays.asList("http://192.168.1.50:8080/SEMP/v2")));
		assertThat(smi.getManagementHttpsUris(), is(Arrays.asList("https://192.168.1.50:443/SEMP/v2")));
		assertEquals("sample-mgmt-username", smi.getManagementUsername());
		assertEquals("sample-mgmt-password", smi.getManagementPassword());
	}
}
