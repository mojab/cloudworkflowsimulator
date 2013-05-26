package cws.core;

public class VMStaticParams implements Cloneable {
    /**
     * The processing power of this VM
     */
    public int mips;

    /**
     * The number of cores of this VM
     */
    public int cores;
    /**
     * Price per hour of usage
     */
    public double price;

    public int getMips() {
        return mips;
    }

    public void setMips(int mips) {
        this.mips = mips;
    }

    public int getCores() {
        return cores;
    }

    public double getPrice() {
        return price;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
