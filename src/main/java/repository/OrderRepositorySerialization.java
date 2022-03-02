/*
package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import exceptions.RepositoryException;
import model.*;

public class OrderRepositorySerialization extends AbstractRepository<Order, Integer>{
    private String filename;
    private CakeRepositorySerialization cakeRepo;


    public OrderRepositorySerialization(String filename, CakeRepositorySerialization cakeRepo){
        this.filename=filename;
        cakeRepo = cakeRepo;
        readFromFile();
    }

    private void writeToFile(){
        try(ObjectOutputStream e = new ObjectOutputStream (new FileOutputStream(filename))){
            e.writeObject(elem);
        }
        catch(IOException r){
            throw new RepositoryException("message " + r);
        }
    }

    private void readFromFile (){
        try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename))){
            elem = (Map<Integer, Order>) in.readObject();
        }
        catch(java.io.EOFException er) {

        }
        catch(IOException|ClassNotFoundException err){
            throw new RepositoryException("Error reading from file: " + err);
        }
    }

    @Override
    public void add(Order obj) {
        try{
            super.add(obj);
            writeToFile();
        }
        catch(RuntimeException e){
            throw new RepositoryException("Object wasn�t added" + e + " " + obj);
        }
    }

    @Override
    public void cancel(Order obj){
        try{
            super.cancel(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not canceled"+ex+" "+obj);
        }
    }

    public void finish(Order obj){
        try{
            super.finish(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not finished"+ex+" "+obj);
        }
    }

    @Override
    public void update(Order obj, Integer id){
        try{
            super.update(obj, id);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not updated" + ex + " " + obj);
        }
    }
}
*/
