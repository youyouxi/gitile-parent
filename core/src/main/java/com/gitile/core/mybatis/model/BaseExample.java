package com.gitile.core.mybatis.model;


public class BaseExample {
	
	protected String limitByClause;
	protected String orderByClause;
    protected boolean distinct;
    
    public void clear() {
        orderByClause = null;
        distinct = false;
    }
    
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }
	
	public void setLimitByClause(String limitByClause) {
        this.limitByClause = limitByClause;
    }

    public String getLimitByClause() {
        return limitByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

}
