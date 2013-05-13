/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.map.client;

import com.hazelcast.concurrent.lock.client.AbstractLockRequest;
import com.hazelcast.map.MapPortableHook;
import com.hazelcast.map.MapService;
import com.hazelcast.nio.serialization.Data;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.spi.DefaultObjectNamespace;
import com.hazelcast.spi.ObjectNamespace;

import java.io.IOException;

public class MapLockRequest extends AbstractLockRequest {

    private String name;

    public MapLockRequest() {
    }

    public MapLockRequest(String name, Data key, int threadId) {
        super(key, threadId);
        this.name = name;
    }

    public MapLockRequest(String name, Data key, int threadId, long ttl, long timeout) {
        super(key, threadId, ttl, timeout);
        this.name = name;
    }

    @Override
    protected ObjectNamespace getNamespace() {
        return new DefaultObjectNamespace(MapService.SERVICE_NAME, name);
    }

    @Override
    public int getFactoryId() {
        return MapPortableHook.F_ID;
    }

    public int getClassId() {
        return MapPortableHook.LOCK;
    }

    public void writePortableInternal(PortableWriter writer) throws IOException {
        writer.writeUTF("n", name);
    }

    public void readPortableInternal(PortableReader reader) throws IOException {
        name = reader.readUTF("n");
    }
}
