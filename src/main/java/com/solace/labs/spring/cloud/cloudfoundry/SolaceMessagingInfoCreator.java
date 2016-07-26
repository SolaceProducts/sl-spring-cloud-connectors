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

import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import com.solace.labs.spring.cloud.core.SolaceMessagingInfo;

public class SolaceMessagingInfoCreator extends CloudFoundryServiceInfoCreator<SolaceMessagingInfo> {

	//private static final Log trace = LogFactory.getLog(SolaceMessagingInfoCreator.class);

	String label = "solace-messaging";
	
	public SolaceMessagingInfoCreator() {
		super(new Tags("solace-messaging", 
				 "solace",
			     "rest",
			     "mqtt",
			     "mq",
			     "queue",
			     "event-streaming",
			     "amqp",
			     "jms",
			     "messaging"));
	}
	
	
	// As a starting point, will only accept if the labels match.
	public boolean accept(Map<String, Object> serviceData) {
		String serviceLabel = (String) serviceData.get("label");
		
		if (!super.accept(serviceData)) 
			return false;
		
		if (!this.label.equals(serviceLabel))
			return false;
		
		return true;
	}
	
	public SolaceMessagingInfo createServiceInfo(Map<String, Object> serviceData) {
		String id = getId(serviceData);

		Map<String, Object> credentials = getCredentials(serviceData);

		SolaceMessagingInfo solMessagingInfo = new SolaceMessagingInfo(id, credentials);
		
		return solMessagingInfo;
	}

	// These will come later from future version of Spring Cloud. For now clone
	// methods here.

	@SuppressWarnings("unchecked")
	protected Map<String, Object> getCredentials(Map<String, Object> serviceData) {
		return (Map<String, Object>) serviceData.get("credentials");
	}
}
