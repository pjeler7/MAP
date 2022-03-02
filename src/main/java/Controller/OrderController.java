package Controller;
import java.util.List;

import model.*;
import repository.*;
import java.util.*;



public class OrderController {
    private OrderRepositoryFile orderRepo;
    private CakeRepositoryFile _cakeRepo = new CakeRepositoryFile("C:\\Users\\paulj\\eclipse-workspace\\assigment2\\cakeRepoFile.txt");

    public OrderController() {
        orderRepo = new OrderRepositoryFile("C:\\Users\\paulj\\eclipse-workspace\\assigment2\\orderRepoFile.txt", _cakeRepo);
    }

    public void addOrder(Order obj)
    {
        try{
            orderRepo.add(obj);
        }
        catch(RuntimeException e) {
            System.out.println(e);
        }
    }

    public void cancelOrder(int id) {
        try {
            for(Order elem: orderRepo.findAll()) {
                if(elem.getID() == id) {
                    orderRepo.cancel(elem);
                }
            }
        }
        catch(RuntimeException e){
            System.out.println(e);
        }
    }

    public Iterable<Order> getAllOrders() {

        return orderRepo.findAll();
    }

    public Order findByID(int id){

        return orderRepo.findById(id);
    }

    public void getByDate(String Date){
    }

    public void getUnfinished() {
        List<Order> lst = new ArrayList<Order>();
        for (Order elem : orderRepo.findAll()) {
            lst.add(elem);
        }
        lst.stream()
                .filter(o -> o.getStatus().equals("0"))
                .forEach(System.out::println);
    }
}
