package practice_8.iterator;

import java.util.List;

public class IntIterator implements IIterator<Integer> {
    private final List<Integer> list;
    private int i;

    public IntIterator(List<Integer> list) {
        this.list = list;
        i = 0;
    }

    @Override
    public Integer next() {
        if (hasNext())
            return list.get(i++);
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean hasNext() {
        return i + 1 < list.size();
    }
}
