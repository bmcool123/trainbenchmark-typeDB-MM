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
package hu.bme.mit.trainbenchmark.benchmark.sql.transformations.user;

import hu.bme.mit.trainbenchmark.sql.driver.SQLDriver;

import java.util.Collection;

import javax.xml.soap.Node;

public class SQLTransformationUserSemaphoreNeighbor extends SQLTransformationUser {

	public SQLTransformationUserSemaphoreNeighbor(final SQLDriver sqlDriver) {
		super(sqlDriver);
	}

	@Override
	public void rhs(final Collection<Long> routes) {
		for (final Node route : routes) {
			final Iterable<Relationship> entries = route.getRelationships(relationshipTypeEntry);
			for (final Relationship entry : entries) {
				entry.delete();
			}
		}
	}

}
