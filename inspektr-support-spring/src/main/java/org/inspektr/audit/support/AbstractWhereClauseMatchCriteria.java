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

/**
 * Match criteria defined in terms of a SQL where clause limiter.  The
 * {@link #toString()} method of this class produces a where clause beginning
 * with the text "WHERE" such that is can be directly appended to a SQL
 * statement without a where clause to narrow results.
 *
 * @author Marvin S. Addison
 * @version $Revision: $
 *
 */
public abstract class AbstractWhereClauseMatchCriteria implements WhereClauseMatchCriteria {
  
  /** Stores where clause string */
  protected StringBuilder sbClause = new StringBuilder();
  
 
  /**
   * @return The where clause text beginning with the string " WHERE" such that
   * the return value can be directly appended to a SQL statement with no
   * where clause.
   */
  @Override
  public String toString() {
    return sbClause.toString();
  }

  
  /**
   * Adds a parameterized selection criterion of the form column=? to the
   * where clause.
   *
   * @param column Database column name.
   */
  protected void addCriteria(String column) {
    addCriteria(column, "=");
  }

  
  /**
   * Adds a parameterized selection criterion of the form "column [operator] ?"
   * to the where clause.
   *
   * @param column Database column name.
   */
  protected void addCriteria(String column, String operator) {
    if (sbClause.length() == 0) {
      sbClause.append("WHERE");
    } else {
      sbClause.append(" AND");
    }
    sbClause.append(' ');
    sbClause.append(column);
    sbClause.append(' ');
    sbClause.append(operator);
    sbClause.append(" ?");
  }
}
