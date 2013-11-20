package cws.core.core;

public class VMType implements Cloneable {
    /**
     * The processing power of this VM
     */
    private int mips;

    /**
     * The number of cores of this VM
     */
    private int cores;

    /**
     * Price per billing unit of usage
     */
    private double billingUnitPrice;

    /**
     * For how long we pay in advance
     */
    private double billingTimeInSeconds;

    /**
     * Delay from when the VM is launched until it is ready
     */
    private double provisioningDelay;

    /**
     * Delay from when the VM is terminated until it is no longer charged
     */
    private double deprovisioningDelay; // TODO(bryk): There is no CLI param for this.

    /**
     * The number of bytes on internal disk that can be used as a cache
     * @see {@link cws.core.storage.cache.VMCacheManager}
     */
    private long cacheSize;

    public int getMips() {
        return mips;
    }

    public int getCores() {
        return cores;
    }

    public double getPriceForBillingUnit() {
        return billingUnitPrice;
    }

    public double getBillingTimeInSeconds() {
        return billingTimeInSeconds;
    }

    public double getProvisioningDelay() {
        return provisioningDelay;
    }

    public double getDeprovisioningDelay() {
        return deprovisioningDelay;
    }

    public long getCacheSize() {
        return cacheSize;
    }

    public VMType(int mips, int cores, double billingUnitPrice, double billingTimeInSeconds, double provisioningTime,
            double deprovisioningTime, long cacheSize) {
        this.mips = mips;
        this.cores = cores;
        this.billingUnitPrice = billingUnitPrice;
        this.billingTimeInSeconds = billingTimeInSeconds;
        this.provisioningDelay = provisioningTime;
        this.deprovisioningDelay = deprovisioningTime;
        this.cacheSize = cacheSize;
    }
}
