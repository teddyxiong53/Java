public class VoltageAdapter implements Voltage5 {
    private Voltage220 mVoltage220;
    public VoltageAdapter(Voltage220 voltage220) {
        mVoltage220 = voltage220;
    }

    @Override
    public int output5V() {
        int src = mVoltage220.output220V();
        System.out.println("adapter begin to convert voltage");
        int dst = src/44;
        System.out.println("voltage get from adapter: " + dst);
        return dst;
    }
}
