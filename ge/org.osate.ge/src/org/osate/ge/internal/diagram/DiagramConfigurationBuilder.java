package org.osate.ge.internal.diagram;

import java.util.HashSet;
import java.util.Set;

public class DiagramConfigurationBuilder {
	private CanonicalBusinessObjectReference contextBoReference;
	private final Set<String> lcEnabledAadlPropertyNames = new HashSet<>();
	
	public DiagramConfigurationBuilder() {
		this.contextBoReference = null;
	}
	
	public DiagramConfigurationBuilder(final DiagramConfiguration config) {
		this.contextBoReference = config.getContextBoReference();
		this.lcEnabledAadlPropertyNames.addAll(config.getEnabledAadlPropertyNames());
	}
	
	public DiagramConfigurationBuilder setContextBoReference(final CanonicalBusinessObjectReference value) {
		this.contextBoReference = value;
		return this;
	}
	
	public DiagramConfigurationBuilder addAadlProperty(final String qualifiedPropertyName) {
		lcEnabledAadlPropertyNames.add(qualifiedPropertyName.toLowerCase());
		return this;
	}
	
	public DiagramConfigurationBuilder removeAadlProperty(final String qualifiedPropertyName) {
		lcEnabledAadlPropertyNames.remove(qualifiedPropertyName.toLowerCase());
		return this;
	}
	
	public DiagramConfiguration build() {
		return new DiagramConfiguration(contextBoReference, lcEnabledAadlPropertyNames);
	}
}
