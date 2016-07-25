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

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

public class SolaceMessagingInfoCreator extends CloudFoundryServiceInfoCreator<SolaceMessagingInfo> {

	private static final Log trace = LogFactory.getLog(SolaceMessagingInfoCreator.class);

	public SolaceMessagingInfoCreator() {
		super(new Tags("solace-messaging"));
	}

	
	public SolaceMessagingInfo createServiceInfo(Map<String, Object> serviceData) {
		String id = getId(serviceData);

		Map<String, Object> credentials = getCredentials(serviceData);

		SolaceMessagingInfo solMessagingInfo = new SolaceMessagingInfo(id);
		
		try {
			BeanUtils.populate(solMessagingInfo, credentials);
		} catch (IllegalAccessException | InvocationTargetException e) {
			trace.error("Could not populate SolaceMessagingInfo with serviceData provided", e);
			solMessagingInfo = null;
		}
		
		return solMessagingInfo;
	}

	// These will come later from future version of Spring Cloud. For now clone
	// methods here.

	@SuppressWarnings("unchecked")
	protected Map<String, Object> getCredentials(Map<String, Object> serviceData) {
		return (Map<String, Object>) serviceData.get("credentials");
	}
}
