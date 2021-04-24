package delivery.strategies;

public class JammedTrafficStrategy implements Traffic_strategy{

    @Override
    public int start_moving(int baseTime) {
        return (int)(baseTime * 1.5);
    }
}
