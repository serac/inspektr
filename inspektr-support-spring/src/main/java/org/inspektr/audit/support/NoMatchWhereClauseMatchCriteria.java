/**
 * Copyright (C) 2010 Virginia Tech.
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

import java.util.Collections;
import java.util.List;

/**
 * Constructs a where clause that matches no records.
 *
 * @author Marvin S. Addison
 * @version $Revision: $
 *
 */
public class NoMatchWhereClauseMatchCriteria extends AbstractWhereClauseMatchCriteria {
  
  public NoMatchWhereClauseMatchCriteria() {
    sbClause.append("WHERE 0=1");
  }

  /** {@inheritDoc} */
  public List<?> getParameterValues()
  {
    return Collections.emptyList();
  }

}
