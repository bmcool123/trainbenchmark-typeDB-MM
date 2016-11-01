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
package hu.bme.mit.trainbenchmark.benchmark.ingraph.match;

import hu.bme.mit.trainbenchmark.benchmark.matches.RouteSensorMatch;
import scala.collection.immutable.Map;
import scala.collection.immutable.Vector;

public class IngraphRouteSensorMatch extends IngraphMatch implements RouteSensorMatch {

	public IngraphRouteSensorMatch(final Map<Object, Object> qs) {
		super(qs);
	}

	@Override
	public Long getRoute() {
		return (Long) qs.apply("route");
	}

	@Override
	public Long getSensor() {
		return (Long) qs.apply("sensor");
	}

	@Override
	public Long getSwP() {
		return (Long) qs.apply("swP");
	}

	@Override
	public Long getSw() {
		return (Long) qs.apply("sw");
	}

}
