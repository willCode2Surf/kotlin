/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.k2js.test;

import com.intellij.testFramework.UsefulTestCase;
import junit.framework.Test;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.k2js.test.utils.SingleFileTest;

@SuppressWarnings("JUnitTestCaseWithNoTests")
public final class ExamplesTest extends UsefulTestCase {

    public static Test suite() {
        return SingleFileTest.suiteForDirectory("examples/", new SingleFileTest.Tester() {
            @Override
            public void performTest(@NotNull TranslationTest test, @NotNull String filename) throws Exception {
                test.runFunctionOutputTest(filename, "Anonymous", "box", "OK");
            }
        });
    }
}
