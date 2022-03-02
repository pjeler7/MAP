package repository;

import model.*;
import java.util.*;

public abstract class AbstractRepository<T extends Identifiable<ID>, ID> implements Repository<T, ID> {
    protected Map<ID, T> elem;

    public AbstractRepository() {
        elem = new HashMap<>();
    }

    public void add(T el) {
        if (elem.containsKey(el.getID()))
            throw new RuntimeException("There is an order with that ID");
        else
            elem.put(el.getID(), el);
    }

    public void cancel(T el) {
        if (elem.containsKey(el.getID())) {
            elem.remove(el.getID());
            System.out.println("Order canceled");
        }
        else
            throw new RuntimeException("Order doesn't exist");
    }


    public void finish(T el) {
        if (elem.containsKey(el.getID())) {
            elem.remove(el.getID());
            System.out.println("Order finished");
        }
        else
            throw new RuntimeException("Order doesn't exist");
    }

    public T findById(ID id) {
        if (elem.containsKey(id))
            return elem.get(id);
        else
            throw new RuntimeException("Element doesn't exist");
    }

    public Iterable<T> findAll() {
        return elem.values();

    }

    public void update(T el,ID id){
        if(elem.containsKey(id))
            elem.put(el.getID(),el);
        else
            throw new RuntimeException("Element doesn�t exist");
    }
}
