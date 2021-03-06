/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.ml.dataset.feature.extractor.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.apache.ignite.ml.dataset.feature.extractor.ExtractionUtils;
import org.apache.ignite.ml.environment.deploy.DeployableObject;
import org.apache.ignite.ml.math.primitives.vector.Vector;

/**
 * Vectorizer on Vector.
 *
 * @param <K> Type of key.
 */
public final class DummyVectorizer<K> extends ExtractionUtils.ArrayLikeVectorizer<K, Vector> implements DeployableObject {
    /** Serial version uid. */
    private static final long serialVersionUID = -6225354615212148224L;

    /**
     * Creates an instance of Vectorizer.
     *
     * @param coords Coordinates.
     */
    public DummyVectorizer(Integer ... coords) {
        super(coords);
    }

    /** {@inheritDoc} */
    @Override protected Serializable feature(Integer coord, K key, Vector val) {
        return val.getRaw(coord);
    }

    /** {@inheritDoc} */
    @Override protected int sizeOf(K key, Vector val) {
        return val.size();
    }

    /** {@inheritDoc} */
    @Override public List<Object> getDependencies() {
        return Collections.emptyList();
    }
}
