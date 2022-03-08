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

import java.io.File;

/**
 * Constants
 */

public interface Constants {

    String SRC_TEST_RESOURCE_PATH = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "test" + File.separator + "resources" + File.separator;
    String MASTER_TEST_DATA = SRC_TEST_RESOURCE_PATH + "MASTER_TEST_DATA.json";
    String REPORTS_PATH = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Screenshots//";
}
