/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.spring.boot.example.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class PoliceSolution {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "detectiveRange")
    private List<Detective> detectiveList;

    @PlanningEntityCollectionProperty
    private List<Investigation> investigationList;

    @PlanningScore
    private HardSoftScore score;

    public PoliceSolution() {
    }

    public PoliceSolution(List<Detective> detectiveList, List<Investigation> investigationList) {
        this.detectiveList = detectiveList;
        this.investigationList = investigationList;
    }

    // ************************************************************************
    // Getters/setters
    // ************************************************************************

    public List<Detective> getDetectiveList() {
        return detectiveList;
    }

    public List<Investigation> getInvestigationList() {
        return investigationList;
    }

    public HardSoftScore getScore() {
        return score;
    }

}
