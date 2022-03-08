/*
 * Copyright © 2021 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package dataplex.e2e.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Json Read Utility
 */
public final class JSONReaderUtil {

    private JSONReaderUtil() {

    }

    /**
     * Parse the error.
     */
    private static final String PARSE_ERROR = "Unable parse input Json";


    /**
     * Gets the json single key value.
     *
     * @param jsonFile  the json file
     * @param parentKey the parent key
     *                  the key name to get value
     * @return the json single key value
     */
    public static String getJsonSingleKeyValue(final String jsonFile, final String parentKey) {
        JSONParser jsonParser = new JSONParser();
        String keyValueToReturn = null;
        try (FileReader reader = new FileReader(jsonFile);) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            keyValueToReturn = ((JSONObject) jsonObject.get(parentKey)).toString();
        } catch (IOException | org.json.simple.parser.ParseException e) {
//            log.error(e);
        }
        return keyValueToReturn;
    }

    /**
     * This function will take json file path and Parent key to return a specific
     * array index value.
     *
     * @param jsonFilePathName the json file path name
     * @param parentKey        the parent key
     * @param indexOfRecrod    the index of recrod
     * @return the json data
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> getJsonData(final String jsonFilePathName, final String parentKey,
                                                  final int indexOfRecrod) {
        JSONParser jsonParser = new JSONParser();
        Map<String, String> testData = null;
        JSONArray getData = null;
        try (FileReader reader = new FileReader(jsonFilePathName);) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            getData = (JSONArray) jsonObject.get(parentKey);
            testData = (Map<String, String>) getData.get(indexOfRecrod);
        } catch (IOException | org.json.simple.parser.ParseException e) {
//            log.error(e);
        }
        return testData;
    }
}
