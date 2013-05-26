package cws.core.experiment;

import org.cloudbus.cloudsim.distributions.ContinuousDistribution;

import cws.core.FailureModel;
import cws.core.VM;
import cws.core.VMStaticParams;
import cws.core.cloudsim.CloudSimWrapper;
import cws.core.jobs.IdentityRuntimeDistribution;
import cws.core.jobs.RuntimeDistribution;

public class VMFactory {

    public static class ZeroDistribution implements ContinuousDistribution {
        @Override
        public double sample() {
            return 0.0d;
        }
    }

    private static ContinuousDistribution provisioningDelayDistribution = new ZeroDistribution();
    private static ContinuousDistribution deprovisioningDelayDistribution = new ZeroDistribution();
    private static RuntimeDistribution runtimeDistribution = new IdentityRuntimeDistribution();
    private static FailureModel failureModel = new FailureModel(0, 0.0);

    public static ContinuousDistribution getProvisioningDelayDistribution() {
        return VMFactory.provisioningDelayDistribution;
    }

    public static void setProvisioningDelayDistribution(ContinuousDistribution distribution) {
        VMFactory.provisioningDelayDistribution = distribution;
    }

    public static ContinuousDistribution getDeprovisioningDelayDistribution() {
        return VMFactory.deprovisioningDelayDistribution;
    }

    public static void setDeprovisioningDelayDistribution(ContinuousDistribution deprovisioningDelayDistribution) {
        VMFactory.deprovisioningDelayDistribution = deprovisioningDelayDistribution;
    }

    public static void setRuntimeDistribution(RuntimeDistribution runtimeDistribution) {
        VMFactory.runtimeDistribution = runtimeDistribution;
    }

    public static RuntimeDistribution getRuntimeDistribution() {
        return runtimeDistribution;
    }

    public static FailureModel getFailureModel() {
        return failureModel;
    }

    public static void setFailureModel(FailureModel failureModel) {
        VMFactory.failureModel = failureModel;
    }

    /**
     * @param cloudSimWrapper - initialized CloudSimWrapper instance. It needs to be inited, because we're creting
     *            storage manager here.
     */
    public static VM createVM(double bandwidth, VMStaticParams vmStaticParams, CloudSimWrapper cloudSimWrapper) {
        // TODO(_mequrel_): change to IoC in the future
        VM vm = new VM(bandwidth, vmStaticParams, cloudSimWrapper);
        vm.setProvisioningDelay(provisioningDelayDistribution.sample());
        vm.setDeprovisioningDelay(deprovisioningDelayDistribution.sample());
        vm.setRuntimeDistribution(runtimeDistribution);
        vm.setFailureModel(failureModel);
        return vm;
    }
}
