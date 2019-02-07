package be.cytomine.client.models;

/*
 * Copyright (c) 2009-2018. Authors: see NOTICE file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * User: lrollus
 * Date: 9/01/13
 * GIGA-ULg
 */
public class User extends Model {

    public String toURL() {

        if (getLong("id") != null) {
            return getJSONResourceURL(getLong("id"));
        } else if (getStr("username get") != null) {
            return getJSONResourceURL(getStr("username get"));
        } else if (getStr("current") != null) {
            return "/api/user/current.json";
        } else if (isFilterBy("publicKey")) {
            return getJSONResourceURL() + "?publicKey=" + getFilter("publicKey");
        } else if (isFilterBy("publicKeyFilter")) {
            return "/api/userkey/" + getFilter("publicKeyFilter") + "/keys.json";
        } else if (isFilterBy("id") && isFilterBy("keys")) {
            return "/api/user/" + getFilter("id") + "/keys.json";
        } else {
            return getJSONResourceURL();
        }
    }

    public String getDomainName() {
        return "user";
    }

}
