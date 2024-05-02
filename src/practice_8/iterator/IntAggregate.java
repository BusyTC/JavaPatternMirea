package practice_8.iterator;

import java.util.ArrayList;
import java.util.List;

public class IntAggregate implements IAggregate<Integer> {
    private final List<Integer> list = new ArrayList<>();
    @Override
    public IIterator<Integer> createIterator() {
        return new IntIterator(list);
    }

    public void add(Integer integer) {
        list.add(integer);
    }
}
