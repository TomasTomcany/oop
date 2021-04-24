package delivery.strategies;

public class NormalTrafficStrategy implements Traffic_strategy{

    @Override
    public int start_moving(int baseTime) {
        return baseTime;
    }
}
