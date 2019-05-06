/*******************************************************************************
 * (c) Copyright 2017 EntIT Software LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the 
 * "Software"), to deal in the Software without restriction, including without 
 * limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to 
 * whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY 
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN 
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * IN THE SOFTWARE.
 ******************************************************************************/
package com.fortify.integration.sonarqube.common.source.ssc.ce;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer.MeasureComputerContext;

import com.fortify.client.ssc.connection.SSCAuthenticatingRestConnection;
import com.fortify.integration.sonarqube.common.ce.IFortifyComputeEngineSideConnectionHelper;
import com.fortify.integration.sonarqube.common.source.ssc.IFortifySSCConnectionHelper;
import com.fortify.integration.sonarqube.common.source.ssc.metrics.FortifySSCConnectionPropertiesMetrics;

/**
 * <p>SSC connection helper for ComputeEngine-side to get SSC connection instance and
 * application version id.</p>
 * 
 * <p>Instead of getting the connection properties from the SonarQube configuration, 
 * we have a sensor on the scanner side provide the relevant properties as SonarQube 
 * measures for the following two reasons:</p>
 * <ul>
 *   <li>Connection properties like SSC URL and application version name or id may
 *       not have been configured on the SonarQube server, but instead being provided
 *       on the scanner command line.</li>
 *   <li>Even if connection properties have been configured on the SonarQube server,
 *       these could have been overridden on the scanner command line; we want the
 *       compute engine to use the same connection properties as used on the scanner
 *       command line.</li>
 * </ul> 
 * 
 * @author Ruud Senden
 *
 */
public final class FortifySSCComputeEngineSideConnectionHelper implements IFortifySSCConnectionHelper, IFortifyComputeEngineSideConnectionHelper<SSCAuthenticatingRestConnection> {
	private final MeasureComputerContext measureComputerContext;
	private SSCAuthenticatingRestConnection connection = null;
	
	/**
	 * Constructor for injecting dependencies
	 * @param measureComputerContext
	 */
	public FortifySSCComputeEngineSideConnectionHelper(MeasureComputerContext measureComputerContext) {
		this.measureComputerContext = measureComputerContext;
	}
	
	/**
	 * Get the input metric keys, containing the SSC URL and application version id
	 * @return
	 */
	public static final String[] getInputMetricKeys() {
		return FortifySSCConnectionPropertiesMetrics.METRICS_KEYS;
	}
	
	/**
	 * Get the SSC URL including credentials from the measure saved on the scanner side
	 */
	public final String getSSCUrl() {
		Measure measure = measureComputerContext.getMeasure(FortifySSCConnectionPropertiesMetrics.PRP_SSC_URL);
		return measure == null ? null : measure.getStringValue();
	}
	
	/**
	 * Get the application version id from the measure saved on the scanner side
	 */
	public final String getApplicationVersionId() {
		Measure measure = measureComputerContext.getMeasure(FortifySSCConnectionPropertiesMetrics.PRP_APP_VERSION_ID);
		return measure == null ? null : measure.getStringValue();
	}
	
	/**
	 * Get the {@link SSCAuthenticatingRestConnection} based on the URL returned by {@link #getSSCUrl()}.
	 * The connection instance is cached for this {@link FortifySSCComputeEngineSideConnectionHelper}
	 * instance. If the connection is not available, this method returns null.
	 */
	public final synchronized SSCAuthenticatingRestConnection getConnection() {
		String sscUrl = getSSCUrl();
		if ( connection==null && StringUtils.isNotBlank(sscUrl) ) {
			connection = SSCAuthenticatingRestConnection.builder().baseUrl(getSSCUrl()).build();
		}
		return connection;
	}
	
	/**
	 * This method indicates whether SSC connection and application version id 
	 * are available. 
	 */
	public final boolean isConnectionAvailable() {
		return getConnection()!=null && getApplicationVersionId()!=null; 
	}
}
