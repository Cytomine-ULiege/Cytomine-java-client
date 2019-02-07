package be.cytomine.client.collections;

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

import be.cytomine.client.models.User;
import org.json.simple.JSONObject;

/**
 * User: lrollus
 * Date: 9/01/13
 * GIGA-ULg
 */
public class UserCollection extends Collection {

    public UserCollection(int offset, int max) {
        super(max, offset);
    }

    public String toURL() {
        if (isFilterBy("project") && isFilterBy("admin")) {
            return "/api/project/" + getFilter("project") + "/admin.json";
        } else if (isFilterBy("project")) {
            return "/api/project/" + getFilter("project") + "/user.json";
        } else {
            return getJSONResourceURL();
        }
    }

    public String getDomainName() {
        return "user";
    }

    public User get(int i) {
        User user = new User();
        Object item = list.get(i);
        user.setAttr((JSONObject) item);
        return user;
    }
}
