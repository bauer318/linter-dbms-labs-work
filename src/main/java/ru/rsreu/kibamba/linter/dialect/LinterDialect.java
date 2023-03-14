package ru.rsreu.kibamba.linter.dialect;

import org.springframework.data.relational.core.dialect.AbstractDialect;
import org.springframework.data.relational.core.dialect.LimitClause;
import org.springframework.data.relational.core.dialect.LockClause;
import org.springframework.data.relational.core.sql.LockOptions;

public class LinterDialect extends AbstractDialect {

    private static final LimitClause LIMIT_CLAUSE = new LimitClause() {
        public String getLimit(long limit) {
            return String.format("FETCH FIRST %d ROWS ONLY", limit);
        }

        public String getOffset(long offset) {
            return String.format("OFFSET %d ROWS", offset);
        }

        public String getLimitOffset(long limit, long offset) {
            return String.format("OFFSET %d ROWS FETCH FIRST %d ROWS ONLY", offset, limit);
        }

        public LimitClause.Position getClausePosition() {
            return Position.AFTER_ORDER_BY;
        }
    };


    private static final LockClause LOCK_CLAUSE = new LockClause() {
        public String getLock(LockOptions lockOptions) {
            return "FOR UPDATE";
        }

        public LockClause.Position getClausePosition() {
            return org.springframework.data.relational.core.dialect.LockClause.Position.AFTER_ORDER_BY;
        }
    };

    @Override
    public LimitClause limit() {
        return LIMIT_CLAUSE;
    }

    @Override
    public LockClause lock() {
        return LOCK_CLAUSE;
    }
}
