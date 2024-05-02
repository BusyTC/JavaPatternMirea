package practice_8.iterator;

public interface IAggregate<T> {
    IIterator<T> createIterator();
}
