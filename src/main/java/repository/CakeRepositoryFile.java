package repository;

import model.*;
import java.io.*;

import exceptions.RepositoryException;

public class CakeRepositoryFile extends AbstractRepository<Cake, Integer>{
    private String filename;
    public CakeRepositoryFile(String filename){
        this.filename=filename;
        readFromFile();
    }

    private void readFromFile(){
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                String[] el=line.split(";");
                if(el.length!=4){
                    System.err.println("Not a valid number of atributes "+line);
                    continue;
                }
                try{
                    int Id=Integer.parseInt(el[0]);
                    float price = Float.parseFloat(el[2]);
                    int weight = Integer.parseInt(el[3]);
                    Cake c = new Cake(Id, el[1], price, weight);
                    super.add(c);
                }
                catch(NumberFormatException n){
                    System.err.println("The ID is not a valid number "+el[0]);
                }
            }
        }
        catch(IOException ex){
            throw new RepositoryException("Error reading"+ex);
        }
    }

    @Override
    public void add(Cake obj) {
        try{
            super.add(obj);
            writeToFile();
        }
        catch(RuntimeException e){
            throw new RepositoryException("Object was not added " + e + " " + obj);
        }
    }

    private void writeToFile() {
        try(PrintWriter pw = new PrintWriter(filename)) {
            for(Cake el : findAll()) {
                String line = el.getID() + ";" + el.getFlavour() + ";" + el.getPrice() + ";" + el.getWeight();
                pw.println(line);
            }
        }
        catch(IOException ex) {
            throw new RepositoryException("Error writing" + ex);
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

