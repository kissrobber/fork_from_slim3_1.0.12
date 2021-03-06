/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.slim3.controller.validator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slim3.util.ApplicationMessage;

/**
 * @author higa
 * 
 */
public class AbstValidatorTest {

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        ApplicationMessage.setBundle("test", Locale.ENGLISH);
    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        ApplicationMessage.clearBundle();
    }

    /**
     * @throws Exception
     */
    @Test
    public void getLabel() throws Exception {
        assertThat(new MyValidator().getLabel("aaa"), is("Aaa"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void getLabelWhenMessageIsNotFound() throws Exception {
        assertThat(new MyValidator().getLabel("xxx"), is("xxx"));
    }

    private static class MyValidator extends AbstractValidator {

        public String validate(Map<String, Object> parameters, String name) {
            return null;
        }

        @Override
        protected String getMessageKey() {
            return null;
        }
    }
}
