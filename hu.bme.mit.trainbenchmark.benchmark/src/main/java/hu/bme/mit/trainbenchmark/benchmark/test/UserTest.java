/*******************************************************************************
 * Copyright (c) 2010-2014, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.trainbenchmark.benchmark.test;

import hu.bme.mit.trainbenchmark.constants.QueryConstants;
import hu.bme.mit.trainbenchmark.constants.ScenarioConstants;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

public abstract class UserTest extends TransformationTest {

	@Test
	public void posLengthUser() throws ParseException, IOException {
		testTransformation(QueryConstants.POSLENGTH, ScenarioConstants.USER, 36);
	}

	@Test
	public void routeSensorUser() throws ParseException, IOException {
		testTransformation(QueryConstants.ROUTESENSOR, ScenarioConstants.USER, 24);
	}

	@Test
	public void signalNeighborUser() throws ParseException, IOException {
		testTransformation(QueryConstants.SIGNALNEIGHBOR, ScenarioConstants.USER, 2);
	}

	@Test
	public void switchSensorUser() throws ParseException, IOException {
		testTransformation(QueryConstants.SWITCHSENSOR, ScenarioConstants.USER, 7);
	}
	
	@Test
	public void switchSetUser() throws ParseException, IOException {
//		testTransformation(QueryConstants.SWITCHSENSOR, ScenarioConstants.USER, 5);
	}

}
