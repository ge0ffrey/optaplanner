/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.persistence.xstream.impl.score.buildin.simpledouble;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.junit.Test;
import org.optaplanner.core.api.score.buildin.simpledouble.SimpleDoubleScore;
import org.optaplanner.persistence.xstream.impl.score.AbstractScoreXStreamConverterTest;

import static org.junit.Assert.*;

public class SimpleDoubleScoreXStreamConverterTest extends AbstractScoreXStreamConverterTest {

    @Test
    public void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestSimpleDoubleScoreWrapper(null));
        SimpleDoubleScore score = SimpleDoubleScore.valueOfInitialized(1234.4321);
        assertSerializeAndDeserialize(score, new TestSimpleDoubleScoreWrapper(score));
        score = SimpleDoubleScore.valueOf(-7, 1234.4321);
        assertSerializeAndDeserialize(score, new TestSimpleDoubleScoreWrapper(score));
    }

    public static class TestSimpleDoubleScoreWrapper extends TestScoreWrapper<SimpleDoubleScore> {

        @XStreamConverter(value = SimpleDoubleScoreXStreamConverter.class)
        private SimpleDoubleScore score;

        public TestSimpleDoubleScoreWrapper(SimpleDoubleScore score) {
            this.score = score;
        }

        @Override
        public SimpleDoubleScore getScore() {
            return score;
        }

    }

}
