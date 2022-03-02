/*
package repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import exceptions.RepositoryException;
import model.*;

public class CakeRepositorySerialization extends AbstractRepository<Cake, Integer>{
    private String filename;

    public CakeRepositorySerialization(String filename){
        this.filename=filename;
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
            elem = (Map<Integer, Cake>) in.readObject();
        }
        catch(IOException|ClassNotFoundException err){
            throw new RepositoryException("Error reading from file: " + err);
        }
    }

    @Override
    public void add(Cake obj) {
        try{
            super.add(obj);
            writeToFile();
        }
        catch(RuntimeException e){
            throw new RepositoryException("Object wasn�t added" + e + " " + obj);
        }
    }

    @Override
    public void finish(Cake obj){
        try{
            super.finish(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not finished"+ex+" "+obj);
        }
    }

    public void cancel(Cake obj){
        try{
            super.cancel(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not canceled"+ex+" "+obj);
        }
    }


    @Override
    public void update(Cake obj, Integer id){
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
