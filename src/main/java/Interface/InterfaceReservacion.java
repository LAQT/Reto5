/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import Modelo.Reservacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Luis Alberto Quintero
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer>{
  
    
 // **** R E T O  5  ******
 
    public List<Reservacion> findAllByStatus (String status);     // reto 5  creamos los tres metodos 
    
    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservacion AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
    
}
