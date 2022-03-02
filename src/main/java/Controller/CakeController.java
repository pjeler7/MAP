package Controller;
import java.util.List;

import model.*;
import repository.*;



public class CakeController {
    private CakeRepositoryFile cakeRepo;

    public CakeController() {
        cakeRepo = new CakeRepositoryFile("C:\\Users\\paulj\\eclipse-workspace\\assigment2\\cakeRepoFile.txt");
    }

    public void addCake(Cake c)
    {
        try{
            cakeRepo.add(c);
        }
        catch(RuntimeException e) {
            System.out.println(e);
        }
    }

    public void removeCake(int id) {
        try {
            for(Cake elem: cakeRepo.findAll()) {
                if(elem.getID() == id) {
                    cakeRepo.cancel(elem);
                }
            }
        }
        catch(RuntimeException e){
            System.out.println(e);
        }
    }

    public Iterable<Cake> getAllCakes() {

        return cakeRepo.findAll();
    }



    public Cake findById(int id){

        return cakeRepo.findById(id);
    }

}
