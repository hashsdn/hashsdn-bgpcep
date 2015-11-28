/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.pcep.pcc.mock.protocol;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import javax.annotation.Nonnull;
import org.opendaylight.protocol.pcep.PCEPPeerProposal;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.pcep.sync.optimizations.rev150714.Tlvs3;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.pcep.sync.optimizations.rev150714.Tlvs3Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.pcep.sync.optimizations.rev150714.lsp.db.version.tlv.LspDbVersionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.pcep.types.rev131005.open.object.open.TlvsBuilder;

public class PCCServerPeerProposal implements PCEPPeerProposal {
    private boolean isAfterReconnection;
    private final BigInteger dbVersion;

    public PCCServerPeerProposal(@Nonnull final BigInteger dbVersion) {
        this.dbVersion = dbVersion;
    }

    @Override
    public void setPeerSpecificProposal(@Nonnull final InetSocketAddress address, @Nonnull final TlvsBuilder openBuilder) {
        Preconditions.checkNotNull(address);
        final LspDbVersionBuilder LspDBV = new LspDbVersionBuilder();
        if (isAfterReconnection) {
            LspDBV.setLspDbVersionValue(this.dbVersion);
        } else {
            isAfterReconnection = true;
        }
        openBuilder.addAugmentation(Tlvs3.class, new Tlvs3Builder().setLspDbVersion(LspDBV.build()).build());
    }
}