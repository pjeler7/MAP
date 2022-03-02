package repository;


public interface Repository<T, Tid> {
    void add(T elem);

    void cancel(T elem);

    void finish(T elem);

    T findById(Tid id);

    Iterable<T> findAll();

    void update(T el, Integer id);

}