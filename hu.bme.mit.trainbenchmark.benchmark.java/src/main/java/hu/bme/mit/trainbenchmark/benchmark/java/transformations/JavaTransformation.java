/*******************************************************************************
 * Copyright (c) 2010-2015, Gabor Szarnyas, Benedek Izso, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.trainbenchmark.benchmark.java.transformations;

import hu.bme.mit.trainbenchmark.benchmark.benchmarkcases.transformations.Transformation;
import hu.bme.mit.trainbenchmark.benchmark.java.transformations.repair.JavaTransformationRepairPosLength;
import hu.bme.mit.trainbenchmark.benchmark.java.transformations.repair.JavaTransformationRepairRouteSensor;
import hu.bme.mit.trainbenchmark.benchmark.java.transformations.repair.JavaTransformationRepairSemaphoreNeighbor;
import hu.bme.mit.trainbenchmark.benchmark.java.transformations.repair.JavaTransformationRepairSwitchSensor;
import hu.bme.mit.trainbenchmark.benchmark.java.transformations.repair.JavaTransformationRepairSwitchSet;
import hu.bme.mit.trainbenchmark.constants.Query;
import hu.bme.mit.trainbenchmark.constants.Scenario;
import hu.bme.mit.trainbenchmark.emf.EMFDriver;
import hu.bme.mit.trainbenchmark.emf.transformation.user.EMFUserTransformation;

public abstract class JavaTransformation<M> extends Transformation<M> {

	public static Transformation<?> newInstance(final EMFDriver driver, final Query query, final Scenario scenario) {
		switch (scenario) {
		case REPAIR:
			switch (query) {
			case POSLENGTH:
				return new JavaTransformationRepairPosLength();
			case ROUTESENSOR:
				return new JavaTransformationRepairRouteSensor();
			case SEMAPHORENEIGHBOR:
				return new JavaTransformationRepairSemaphoreNeighbor();
			case SWITCHSENSOR:
				return new JavaTransformationRepairSwitchSensor();
			case SWITCHSET:
				return new JavaTransformationRepairSwitchSet();
			default:
				break;
			}
		case USER:
			return EMFUserTransformation.newInstance(driver, query);
		default:
			break;
		}
		throw new UnsupportedOperationException("Query: " + query.toString() + ", scenario: " + scenario);
	}
}
