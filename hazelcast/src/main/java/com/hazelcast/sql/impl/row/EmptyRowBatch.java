/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.sql.impl.row;

/**
 * Empty row batch.
 */
public final class EmptyRowBatch implements RowBatch {
    /** Singleton instance. */
    public static final EmptyRowBatch INSTANCE = new EmptyRowBatch();

    private EmptyRowBatch() {
        // No-op.
    }

    @Override
    public Row getRow(int idx) {
        throw new UnsupportedOperationException("Should not be called.");
    }

    @Override
    public int getRowCount() {
        return 0;
    }
}