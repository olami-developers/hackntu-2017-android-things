/*
	Copyright 2017, VIA Technologies, Inc. & OLAMI Team.

	http://olami.ai

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package ai.olami.android.hackNTU;

import ai.olami.cloudService.APIConfiguration;

public class Config {

    // * Setting localize option
    public static int SAMPLE_LOCALIZE_OPTION = APIConfiguration.LOCALIZE_OPTION_SIMPLIFIED_CHINESE;

    // * Replace your APP KEY with this variable.
    private static String mAppKey = "ccab4be6c4e54ab5a1ee22e4e1123bb4";
    public static void setAppKey(String appKey) {
        mAppKey = appKey;
    }
    public static String getAppKey() {
        return mAppKey;
    }

    // * Replace your APP SECRET with this variable.
    private static String mAppSecret = "0ffeda175f8c4078a0bdc6258442992d";
    public static void setAppSecret(String appSecret) {
        mAppSecret = appSecret;
    }
    public static String getAppSecret() {
        return mAppSecret;
    }

    private static int mLocalizeOption = SAMPLE_LOCALIZE_OPTION;
    public static void setLocalizeOption(int localizeOption) {
        mLocalizeOption = localizeOption;
    }
    public static int getLocalizeOption() {
        return APIConfiguration.LOCALIZE_OPTION_TRADITIONAL_CHINESE;
    }

}
