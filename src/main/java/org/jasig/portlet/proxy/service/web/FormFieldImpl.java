/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
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
package org.jasig.portlet.proxy.service.web;

import org.jasig.portlet.proxy.service.IFormField;

public class FormFieldImpl implements IFormField {
	
	private String name = "blankField";
	private String[] values = new String[1];
	private boolean secured = false;
	
	public FormFieldImpl() {
	}
	
	public FormFieldImpl(String name, String value) {
		this(name, value, false);
	}
	
	public FormFieldImpl(String name, String value, boolean secured) {
		this(name, new String[]{value}, secured);
	}
	
	public FormFieldImpl(String name, String[] values) {
		this(name, values, false);
	}
	
	public FormFieldImpl(String name, String[] values, boolean secured) {
		this.name = name;
		this.values = values;
		this.secured = secured;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setValue(String value) {
		this.values[0] = value;
	}
	
	@Override
	public void setValues(String[] values) {
		this.values = values;
	}

	@Override
	public String getValue() {
		return this.values[0];
	}
	
	@Override
	public String[] getValues() {
		return values;
	}

	@Override
	public boolean getSecured() {
		return this.secured;
	}

	@Override
	public void setSecured(boolean isSecured) {
		this.secured = isSecured;
	}

	@Override
	public IFormField duplicate() {
        IFormField copy = new FormFieldImpl();
		copy.setName(this.name);
		copy.setSecured(this.getSecured());
		
		String[] values = this.getValues();
		String[] copiedValues = new String[values.length];
		System.arraycopy(values, 0, copiedValues, 0, values.length);
		copy.setValues(copiedValues);
        return copy;
	}
}