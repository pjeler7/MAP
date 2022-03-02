package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import exceptions.RepositoryException;
import model.*;

public class OrderRepositoryFile extends AbstractRepository<Order, Integer> {
    private CakeRepositoryFile cakeRepo;
    private String filename;

    public OrderRepositoryFile(String filename, CakeRepositoryFile cakeRepo) {
        this.filename = filename;
        this.cakeRepo = cakeRepo;
        readFromFile();
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(";");
                if (el.length != 5) {
                    System.err.println("Not a valid number of atributes: " + line);
                    continue;
                }
                try {
                    int Id = Integer.parseInt(el[0]);
                    int cakeID = Integer.parseInt(el[1]);
                    float tp = Float.parseFloat(el[2]);
                    LocalDate l = LocalDate.parse(el[3]);
                    Order o = new Order(Id, cakeID, tp, l, el[4]);
                    super.add(o);
                } catch (NumberFormatException n) {
                    System.err.println("The ID is not a valid number: " + el[0]);
                }
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error reading: " + ex);
        }
    }

    private void writeToFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (Order el : findAll()) {
                String line = el.getID() + ";" + el.getCake() + ";" + el.getTotalPrice() + ";" + el.getDate() + ";" + el.getStatus();
                pw.println(line);
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error writing" + ex);
        }
    }

    @Override
    public void add(Order obj) {
        try {
            super.add(obj);
            writeToFile();
        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn�t added" + e + " " + obj);
        }
    }


    @Override
    public void finish(Order obj) {
        try {
            super.finish(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not finished" + ex + " " + obj);
        }
    }

    public void cancel(Order obj) {
        try {
            super.cancel(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not canceled" + ex + " " + obj);
        }
    }

    @Override
    public void update(Order obj, Integer id) {
        try {
            super.update(obj, id);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not updated" + ex + " " + obj);
        }
    }
}
