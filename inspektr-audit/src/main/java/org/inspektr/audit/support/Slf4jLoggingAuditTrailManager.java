/**
 * Copyright (C) 2009 Rutgers, the State University of New Jersey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.inspektr.audit.support;

import org.inspektr.audit.AuditActionContext;
import org.inspektr.audit.AuditTrailManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>AuditTrailManager</code> that dumps auditable information to a configured logger.
 * 
 * @author Dmitriy Kopylenko
 * @version $Revision$ $Date$
 * @since 1.0
 * @see AuditTrailManager
 */
public final class Slf4jLoggingAuditTrailManager implements AuditTrailManager {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void record(final AuditActionContext auditActionContext) {
        log.info("Audit trail record BEGIN");
        log.info("=============================================================");
        log.info("WHO: " + auditActionContext.getPrincipal());
        log.info("WHAT: " + auditActionContext.getResourceOperatedUpon());
        log.info("ACTION: " + auditActionContext.getActionPerformed());
        log.info("APPLICATION: " + auditActionContext.getApplicationCode());
        log.info("WHEN: " + auditActionContext.getWhenActionWasPerformed());
        log.info("CLIENT IP ADDRESS: " + auditActionContext.getClientIpAddress());
        log.info("SERVER IP ADDRESS: " + auditActionContext.getServerIpAddress());
        log.info("=============================================================");
        log.info("\n\n");
    }
}
