/*
 * Copyright 2015 Codice Foundation
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.codice.testify;

import org.codice.testify.objects.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

@RunWith(JUnit4.class)
public class RequestTest {

    @Test
    public void testGetType() {
        HashMap<String, String> testBlock = new HashMap<>();
        testBlock.put("test", "Test Test Block");
        Request request = new Request("Test Type", "Test Endpoint", testBlock);
        assert ( request.getType().equals("Test Type") );
    }

    @Test
    public void testGetEndpoint() {
        HashMap<String, String> testBlock = new HashMap<>();
        testBlock.put("test", "Test Test Block");
        Request request = new Request("Test Type", "Test Endpoint", testBlock);
        assert ( request.getEndpoint().equals("Test Endpoint") );
    }

    @Test
    public void testGetTestBlock() {
        HashMap<String, String> testBlock = new HashMap<>();
        testBlock.put("test", "Test Test Block");
        Request request = new Request("Test Type", "Test Endpoint", testBlock);
        assert ( request.getTestBlock().get("test").equals("Test Test Block") );
    }

}
