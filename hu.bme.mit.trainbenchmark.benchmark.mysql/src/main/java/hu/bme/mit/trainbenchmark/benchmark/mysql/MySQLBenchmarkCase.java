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

package hu.bme.mit.trainbenchmark.benchmark.mysql;

import hu.bme.mit.trainbenchmark.benchmark.mysql.driver.MySQLDriver;
import hu.bme.mit.trainbenchmark.benchmark.sql.benchmarkcases.SQLBenchmarkCase;
import hu.bme.mit.trainbenchmark.benchmark.sql.benchmarkcases.SQLChecker;
import hu.bme.mit.trainbenchmark.benchmark.sql.transformations.SQLTransformation;
import hu.bme.mit.trainbenchmark.constants.Scenario;
import hu.bme.mit.trainbenchmark.sql.process.MySQLProcess;

import java.io.IOException;

public class MySQLBenchmarkCase extends SQLBenchmarkCase {

	public MySQLBenchmarkCase() {
		super();
		driver = sqlDriver = new MySQLDriver();
	}

	@Override
	public void init() throws IOException {
		super.init();
		MySQLProcess.startSQLProcess();

		checker = new SQLChecker(sqlDriver, bc);

		if (bc.getScenario() != Scenario.BATCH) {
			transformation = SQLTransformation.newInstance(sqlDriver, bc.getQuery(), bc.getScenario());
		}
	}

	@Override
	protected void destroy() throws IOException {
		driver.destroy();
	}

}
