public class VoltageAdapter extends Voltage220 implements Voltage5 {
    @Override
    public int output5V() {
        int src = output220V();
        System.out.println("adapter begin to convert voltage");
        int dst = src/44;
        System.out.println("voltage get from adapter: " + dst);
        return dst;
    }
}
