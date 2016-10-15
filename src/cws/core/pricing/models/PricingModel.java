package cws.core.pricing.models;

import cws.core.VM;
import cws.core.core.VMType;

import java.util.List;

/**
 * Created by Marcin Ziaber on 2016-10-11.
 */
public abstract class PricingModel {

    /**
     * For how long we pay in advance
     */
    protected final double billingTimeInSeconds;

    public PricingModel(double billingTimeInSeconds) {
        this.billingTimeInSeconds = billingTimeInSeconds;
    }

    /**
     * Calculates total cost of running a VM for given number of seconds
     *
     * @return cost as double
     */
    abstract public double getVmCostFor(double priceForBillingUnit, double runtimeInSeconds);

    abstract public double getRuntimeVmCost(double priceForBillingUnit, double runtimeInSeconds);
    /**
     * Calculates already paid part of a cost of running a VM for given number of seconds
     *
     * @return cost as double
     */
    abstract public double getAlreadyPaidCost(double priceForBillingUnit, double runtimeInSeconds);

    /**
     * Calculates total cost or running a set of VMs for given number of seconds
     *
     * @return cost as double
     */
    abstract public double getAllVMsCost(List<VM> vms);

    abstract public double getRuntimeBasedOnBillingTime(double runtime);

    abstract public double getFullRuntime(double start, double end);

    public double getBillingTimeInSeconds() {
        return billingTimeInSeconds;
    }

}