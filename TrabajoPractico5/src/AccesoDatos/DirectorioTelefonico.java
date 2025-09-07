/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Entidad.Contacto;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.lang.Long;
import java.util.ArrayList;

/**
 *
 * @author abate
 */
public class DirectorioTelefonico {
    private TreeMap<Long,Contacto> agenda = new TreeMap<>();
    public static final DirectorioTelefonico DIRECTORIO = new DirectorioTelefonico();
    public static final Set<String> CIUDADES = new TreeSet<String>();

    static {
        CIUDADES.add("San Luis");
        CIUDADES.add("Villa Mercedes");
        CIUDADES.add("Mendoza");
        CIUDADES.add("Cordoba");
    }
    
    public boolean agregarContacto(Long telefono,Contacto contacto){
        if (telefono == null || contacto == null) {
            return false;
        }
        if (agenda.containsKey(telefono)) {
            return false;
        }
        agenda.put(telefono, contacto);
        return true;
    }
    
    public Contacto buscarContacto(Long telefono){
        return agenda.get(telefono);
    }
    
    public Set<Long> BuscarTelefonoPorApellido(String apellido){
        Set<Long> numeros = new TreeSet<>();
        if (apellido == null) {
            return numeros;
        }
        for (Map.Entry<Long, Contacto> numero : agenda.entrySet()) {
            if (numero.getValue().getApellido().equalsIgnoreCase(apellido)) {
                numeros.add(numero.getKey());
            }
        }
        return numeros;
    }
    
    public ArrayList<Contacto> buscarContactosPorCiudad(String ciudad) {
        ArrayList<Contacto> list = new ArrayList<>();
        if (ciudad == null){
            return list;
        }
        for (Contacto c : agenda.values()) {
            if (c.getCiudad().equalsIgnoreCase(ciudad)) {
                list.add(c);
            }
        }
        return list;
    }
    
    public boolean borrarContacto(Long telefono) {
    if (agenda.containsKey(telefono)) {
        agenda.remove(telefono);
        return true;
    } else {
        return false;
    }
}
    
}

    

