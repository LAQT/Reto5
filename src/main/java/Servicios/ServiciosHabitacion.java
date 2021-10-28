/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Modelo.Habitacion;
import Repositorio.HabitacionRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosHabitacion {
        @Autowired
    private HabitacionRepositorio metodosCrud;
    
    public List<Habitacion> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Habitacion> getRoom(int idRoom){
        return metodosCrud.getRoom(idRoom);
    }
    
    public Habitacion save(Habitacion room){
        if(room.getId()==null){
            return metodosCrud.save(room);
        }else{
            Optional<Habitacion> evt=metodosCrud.getRoom(room.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(room);
            }else{
                return room;
            }
        }
    }
    public Habitacion update(Habitacion room){
        if(room.getId()!=null){
            Optional<Habitacion> e=metodosCrud.getRoom(room.getId());
            if(!e.isEmpty()){
                if(room.getName()!=null){
                    e.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    e.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    e.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    e.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    e.get().setCategory(room.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }


    public boolean deleteRoom(int roomId) {
        Boolean aBoolean = getRoom(roomId).map(room -> {
            metodosCrud.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
