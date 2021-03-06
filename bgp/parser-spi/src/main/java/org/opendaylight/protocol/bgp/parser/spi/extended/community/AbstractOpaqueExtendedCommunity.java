/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.protocol.bgp.parser.spi.extended.community;

public abstract class AbstractOpaqueExtendedCommunity implements ExtendedCommunityParser, ExtendedCommunitySerializer {

    private static final int TYPE = 3;

    @Override
    public int getType(final boolean isTransitive) {
        return ExtendedCommunityUtil.setTransitivity(TYPE, isTransitive);
    }

}
