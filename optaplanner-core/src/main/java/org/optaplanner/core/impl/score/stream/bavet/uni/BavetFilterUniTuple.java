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

package org.optaplanner.core.impl.score.stream.bavet.uni;

import java.util.ArrayList;
import java.util.List;

public final class BavetFilterUniTuple<A> extends BavetAbstractUniTuple<A> {

    private final BavetFilterUniNode<A> node;
    private final BavetAbstractUniTuple<A> parentTuple;

    protected List<BavetAbstractUniTuple<A>> childTupleList;

    public BavetFilterUniTuple(BavetFilterUniNode<A> node, BavetAbstractUniTuple<A> parentTuple,
            int childTupleListSize) {
        this.node = node;
        this.parentTuple = parentTuple;
        childTupleList = new ArrayList<>();
    }

    @Override
    public void refresh() {
        node.refresh(this);
    }

    @Override
    public String toString() {
        return "Filter(" + getFactA() + ") with " + childTupleList.size() + " children";
    }

    // ************************************************************************
    // Getters/setters
    // ************************************************************************

    @Override
    public BavetFilterUniNode<A> getNode() {
        return node;
    }

    @Override
    public A getFactA() {
        return parentTuple.getFactA();
    }

    public List<BavetAbstractUniTuple<A>> getChildTupleList() {
        return childTupleList;
    }

}
