/*
 * Copyright (c) 2018 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.stack.client.transport.uasc.fsm.events;

import org.eclipse.milo.opcua.stack.client.transport.uasc.fsm.ChannelFsm;

public class ConnectFailure implements ChannelFsm.Event {

    private final Throwable failure;

    public ConnectFailure(Throwable failure) {
        this.failure = failure;
    }

    public Throwable getFailure() {
        return failure;
    }

}