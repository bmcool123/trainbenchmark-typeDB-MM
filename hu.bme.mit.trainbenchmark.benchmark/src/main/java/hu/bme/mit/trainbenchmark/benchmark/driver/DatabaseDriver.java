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
package hu.bme.mit.trainbenchmark.benchmark.driver;

import hu.bme.mit.trainbenchmark.benchmark.benchmarkcases.transformations.AttributeOperation;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public abstract class DatabaseDriver<T> {

	public void beginTransaction() throws IOException {
	}

	public void finishTransaction() throws IOException {
	}

	public abstract void read(String modelPath) throws IOException;

	public abstract List<T> runQuery() throws IOException;

	public abstract Comparator<T> getComparator();

	public void destroy() throws IOException {
	}

	// create

	public abstract void insertVertexWithEdge(final List<T> sourceVertices, final String sourceVertexType, final String targetVertexType,
			final String edgeType) throws IOException;

	// read

	public abstract List<T> collectVertices(final String type) throws IOException;

	// update

	public abstract void updateProperties(final List<T> vertices, final String vertexType, final String propertyName,
			final AttributeOperation attributeOperation) throws IOException;

	// delete

	public abstract void deleteAllIncomingEdges(final List<T> vertices, final String sourceVertexType, final String edgeType) throws IOException;

	public abstract void deleteAllOutgoingEdges(final List<T> vertices, final String vertexType, final String edgeType) throws IOException;

	public abstract void deleteOneOutgoingEdge(final List<T> vertices, final String vertexType, final String edgeType) throws IOException;

	public abstract void deleteSingleOutgoingEdge(final List<T> vertices, final String vertexType, final String edgeType)
			throws IOException;

}