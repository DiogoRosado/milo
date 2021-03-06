/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.enumerated;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import org.eclipse.milo.opcua.stack.core.serialization.UaDecoder;
import org.eclipse.milo.opcua.stack.core.serialization.UaEncoder;
import org.eclipse.milo.opcua.stack.core.serialization.UaEnumeration;

public enum ExceptionDeviationFormat implements UaEnumeration {

    AbsoluteValue(0),
    PercentOfValue(1),
    PercentOfRange(2),
    PercentOfEURange(3),
    Unknown(4);

    private final int value;

    ExceptionDeviationFormat(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    private static final ImmutableMap<Integer, ExceptionDeviationFormat> VALUES;

    static {
        Builder<Integer, ExceptionDeviationFormat> builder = ImmutableMap.builder();
        for (ExceptionDeviationFormat e : values()) {
            builder.put(e.getValue(), e);
        }
        VALUES = builder.build();
    }

    public static ExceptionDeviationFormat from(Integer value) {
        if (value == null) return null;
        return VALUES.getOrDefault(value, null);
    }

    public static void encode(ExceptionDeviationFormat exceptionDeviationFormat, UaEncoder encoder) {
        encoder.writeInt32(null, exceptionDeviationFormat.getValue());
    }

    public static ExceptionDeviationFormat decode(UaDecoder decoder) {
        int value = decoder.readInt32(null);

        return VALUES.getOrDefault(value, null);
    }

}
