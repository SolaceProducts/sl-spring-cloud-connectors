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
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;

import com.solace.labs.spring.cloud.core.SolaceMessagingInfo;





public class SolaceMessagingServiceInfoTest {

	@Test
	public void basicConstructorTest() {
		SolaceMessagingInfo smi = new SolaceMessagingInfo("test-instance");
		Assert.assertEquals("test-instance", smi.getId());
		
		
	}
	
	@Test
	public void fullSetGetCredentialsTest() throws IllegalAccessException, InvocationTargetException {
		
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
		
		SolaceMessagingInfo smi = new SolaceMessagingInfo("full-credentials-instance", exCred);
		
		// Check Top Level stuff
		assertEquals("full-credentials-instance", smi.getId());
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
