package delivery.strategies;

public class FreeTrafficStartegy implements Traffic_strategy{

    @Override
    public int start_moving(int baseTime) {
        return (int)(baseTime*0.8);
    }
}
