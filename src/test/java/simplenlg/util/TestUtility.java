/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * https://www.mozilla.org/en-US/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is "Simplenlg".
 *
 * The Initial Developer of the Original Code is Ehud Reiter, Albert Gatt and Dave Westwater.
 * Portions created by Ehud Reiter, Albert Gatt and Dave Westwater are Copyright (C) 2010-11 The University of Aberdeen. All Rights Reserved.
 *
 * Contributor(s): Ehud Reiter, Albert Gatt, Dave Westwater, Roman Kutlak, Margaret Mitchell, and Saad Mahamood.
 */

package simplenlg.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.junit.Ignore;

/**
 * {@link TestUtility} is a utility class that contains helper methods for running SimpleNLG unit tests.
 */
@Ignore
public class TestUtility {

	/**
	 * getResourceFilePath -- A utility method for returning the file path for a given test resource file.
	 *
	 * @param resourceName : The resource name to retrieve the file path for.
	 * @return File path {@link String} or empty String.
	 * @throws URISyntaxException -- Exception if the file path contains invalid syntax.
	 */
	public String getResourceFilePath(String resourceName) throws URISyntaxException {
		if(null != resourceName && !resourceName.isEmpty()) {
			URL filePathURL = this.getClass().getClassLoader().getResource(resourceName);
			if(null != filePathURL) {
				URI filePathURI = new URI(filePathURL.getPath());
				return filePathURI.getPath();
			}
		}
		return "";
	}

	/**
	 * getResourceFileAsString -- A utility method that returns a test resource file as a {@link String}.
	 *
	 * @param resourceName : The resource name to retrieve the file path for.
	 * @return File contents as {@link String} or empty String.
	 * @throws URISyntaxException -- Exception if the file path contains invalid syntax.
	 * @throws FileNotFoundException == Exception thrown if the file cannot be found.
	 */
	public String getResourceFileAsString(String resourceName) throws URISyntaxException, FileNotFoundException {
		String filePathURL = this.getResourceFilePath(resourceName);
		if(null != filePathURL && !filePathURL.isEmpty()) {
			FileInputStream fileInputStream = new FileInputStream(filePathURL);
			try(Scanner scanner = new Scanner(fileInputStream)) {
				return scanner.useDelimiter("\\A").next();
			}
		}
		return "";
	}

}
