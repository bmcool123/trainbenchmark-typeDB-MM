/*******************************************************************************
 * Copyright (c) 2010-2015, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.trainbenchmark.generator.config;

import hu.bme.mit.trainbenchmark.config.AbstractConfigBase;

public final class GeneratorConfigBase extends AbstractConfigBase {

	protected final Scenario scenario;
	protected final int size;

	public GeneratorConfigBase(final Scenario scenario, final int size) {
		super();
		this.scenario = scenario;
		this.size = size;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public int getSize() {
		return size;
	}

	public String getModelFileNameWithoutExtension() {
		final String variant = scenario.toString().toLowerCase();

		final StringBuilder filenameBuilder = new StringBuilder();
		filenameBuilder.append("railway-" + variant + "-");
		filenameBuilder.append(size);
		return filenameBuilder.toString();
	}

	public String getModelPathWithoutExtension() {
		return getModelDir() + getModelFileNameWithoutExtension();
	}

}
