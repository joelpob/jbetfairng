package com.jbetfairng.entities;

/**
 * @author catalin.mincu @since 27/12/17.
 */
public class MarketVersion {
    private long version;

    public MarketVersion(long version) {
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
