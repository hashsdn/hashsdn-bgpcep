/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.bgpcep.topology.provider.bgp;

import java.util.EventListener;

import org.opendaylight.controller.md.sal.common.api.data.DataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.DataModification;

public interface LocRIBListener extends EventListener {
	/**
	 * @param trans Modification transaction. The implementation must explicitly commit
	 *              it if it wishes to have its modifications propagated. The transaction
	 *              is not shared with any other entity and will be cleaned up by the
	 *              caller if it is not committed before this method returns.
	 * @param event Data change event
	 * @throws Exception throw it if you must. If you can handle it, please do so.
	 */
	public void onLocRIBChange(DataModification<?, ?> trans, DataChangeEvent<?, ?> event) throws Exception;
}
