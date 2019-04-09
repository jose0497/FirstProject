/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import domain.Car;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class VehicleFile {

    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;

    public VehicleFile(File file) throws IOException {
        start(file);
    }

    private void start(File file) throws IOException {
        //almaceno la ruta
        myFilePath = file.getPath();

        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = 140;

        //una validacion basica
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName()
                    + " is an invalid file");
        } else {
            //crear la nueva instancia de randomAccessFile
            randomAccessFile = new RandomAccessFile(file, "rw");

            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int) Math.ceil((double) randomAccessFile.length() / (double) regSize);
        }
    }//fin start    

    /**
     * cierra la conexion de mi programa con el archivo que estoy manipulando
     *
     * @throws IOException
     */
    public void close() throws IOException {
        randomAccessFile.close();
    }

    /**
     * indica la cantidad de registros del archivo actual
     *
     * @return cantidad de registros
     */
    public int fileSize() {
        return regsQuantity;
    }

    /**
     * inserta un nuevo registro pero en una posicion existente
     *
     * @param position
     * @param vehicle
     * @return
     * @throws IOException
     */
    public boolean putValue(int position, Car vehicle) throws IOException {
        //una pequenna validacion antes de insertar
        if (position >= 0 && position <= regsQuantity) {
            if (vehicle.size() > regSize) {
                System.err.print("7001 record size is out of bounds");
                return false;
            } else {

                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeFloat(vehicle.getMileage());
                randomAccessFile.writeBoolean(vehicle.isAmerican());
                randomAccessFile.writeInt(vehicle.getSeries());
                randomAccessFile.writeUTF(vehicle.getName());
                randomAccessFile.writeUTF(vehicle.getBrand());
                randomAccessFile.writeInt(vehicle.getModel());
                randomAccessFile.writeInt(vehicle.getLicensePlate());
                randomAccessFile.writeUTF(vehicle.getColor());

                return true;
            }
        } else {
            System.err.print("7002 position is "
                    + "out of bounds of this file");
            return false;
        }

    }//fin metodo

    /**
     * agrega un registro nuevo pero al final del archivo, por esa razon se
     * incrementa la cantidad de registros
     *
     * @param vehicle
     * @return
     * @throws IOException
     */
    public boolean addEndRecord(Car vehicle) throws IOException {
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, vehicle);

        if (success) {
            ++regsQuantity;
        }
        return success;
    }

    /**
     * obtiene un registro de una persona en la posicion indicada
     *
     * @param position
     * @return objeto de tipo Person con los datos del registro de esa persona
     * @throws IOException
     */
    public Car getVehicle(int position) throws IOException {
        //validacion de la posicion
        if (position >= 0 && position <= regsQuantity) {
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);

            //instancia de person
            Car myVehicle = new Car();

            //llevamos a cabo las lecturas
            myVehicle.setMileage(randomAccessFile.readFloat());
            myVehicle.setAmerican(randomAccessFile.readBoolean());
            myVehicle.setSeries(randomAccessFile.readInt());
            myVehicle.setName(randomAccessFile.readUTF());
            myVehicle.setBrand(randomAccessFile.readUTF());
            myVehicle.setModel(randomAccessFile.readInt());
            myVehicle.setLicensePlate(randomAccessFile.readInt());
            myVehicle.setColor(randomAccessFile.readUTF());

            //si es delete no retorno
            if (myVehicle.getName().equalsIgnoreCase("delete")) {
                return null;
            } else {
                return myVehicle;
            }

        } else {
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo

    /**
     * consulta todos los registros de mi archivo
     *
     * @return una lista de objetos tipo Person
     * @throws IOException
     */
    public List<Car> getAllVehicles() throws IOException {

        //variables a retornar
        List<Car> vehicles = new ArrayList<Car>();

        //recorro todos mis registros y los inserto en la lista
        for (int i = 0; i < regsQuantity; i++) {
            Car vehicleTemp = this.getVehicle(i);

            if (vehicleTemp != null) {
                vehicles.add(vehicleTemp);
            }
        }

        return vehicles;
    }//fin metodo

    public boolean deleteRecord(int serie) throws IOException {
        Car myVehicle;

        //buscar el registro para la eliminacion
        for (int i = 0; i < regsQuantity; i++) {

            //obtengo a la persona de esa posicion
            myVehicle = this.getVehicle(i);

            //pregunto si es la persona que quiero eliminar
            if (myVehicle.getSeries() == serie) {

                //marcar esta persona como eliminada
                myVehicle.setSeries(-666);

                return this.putValue(i, myVehicle);
            }
        }

        //si llega a este punto no encontro a la persona
        return false;
    }

    public boolean exist(int serie) throws IOException {
        Car myVehicle;

        //buscar el registro para la eliminacion
        for (int i = 0; i < regsQuantity; i++) {
            //obtengo a la persona de esa posicion
            myVehicle = this.getVehicle(i);
            //pregunto si es la persona que quiero eliminar
            if (myVehicle.getSeries() == serie) {
                return true;
            }
        }

        //si llega a este punto no encontro a la persona
        return false;
    }

    public boolean existPlate(int serie) throws IOException {
        Car myVehicle;

        //buscar el registro para la eliminacion
        for (int i = 0; i < regsQuantity; i++) {

            //obtengo a la persona de esa posicion
            myVehicle = this.getVehicle(i);

            //pregunto si es la persona que quiero eliminar
            if (myVehicle.getLicensePlate() == serie) {
                return true;
            }
        }

        //si llega a este punto no encontro a la persona
        return false;
    }

    public int getPosition(int serie) throws IOException {
        Car myVehicle;

        //buscar el registro para la eliminacion
        for (int i = 0; i < regsQuantity; i++) {

            //obtengo a la persona de esa posicion
            myVehicle = this.getVehicle(i);

            //pregunto si es la persona que quiero eliminar
            if (myVehicle.getSeries() == serie) {
                return i;
            }
        }

        //si llega a este punto no encontro a la persona
        return -1;
    }

    public Car searchVehicle(int serie) throws IOException {
        Car myVehicle;

        //buscar el registro para la eliminacion
        for (int i = 0; i < regsQuantity; i++) {

            //obtengo a el vehiculo de esa posicion
            myVehicle = this.getVehicle(i);

            //pregunto si es la persona que quiero eliminar
            if (myVehicle.getSeries() == serie) {
                return getVehicle(i);
            }
        }

        //si llega a este punto no encontro al vehiculo
        return null;
    }

}
