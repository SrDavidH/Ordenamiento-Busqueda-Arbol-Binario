

package ordenamientodatos;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Documento {
    
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String documento;

    public Documento(String apellido1, String apellido2, String nombre, String documento) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }
    public String getNombreCompleto(){
        return apellido1+" "+apellido2+" "+nombre;
    }
    
   
    public boolean equals(Documento d){
        return getDocumento().equals(d.getDocumento()) && getNombreCompleto().equals(d.getNombreCompleto());
    }
    
    // Metodos y atributos estaticos
    //Almacena la lista de documentos
    public static List<Documento> documentos= new ArrayList();
    public static String[] encabezados;
    
    //Metodo que obtiene los datos desde el archivo CSV
    public static void obtenerDatosDesdeArchivo(String nombreArchivo){
        documentos.clear();
        BufferedReader br=Archivo.abrirArchivo(nombreArchivo);
        if(br!=null){
            
            try{
                String linea = br.readLine();
                encabezados=linea.split(";");
                linea = br.readLine();
                while(linea!=null){
                    String[] textos = linea.split(";");
                    if(textos.length>=4){
                        Documento d=new Documento(textos[0], textos[1], textos[2], textos[3]);
                        documentos.add(d);
                    }
                    linea = br.readLine();
                }
            }catch(Exception ex) {}
        }
        
    }
    
    //metodo para mostrar los datos en una tabla
    public static void mostrarDatos(JTable tbl){
        String[][] datos=null;
        if(documentos.size()>0){
            datos=new String[documentos.size()][encabezados.length];
            for(int i=0;i<documentos.size();i++){
                datos[i][0]=documentos.get(i).apellido1;
                datos[i][1]=documentos.get(i).apellido2;
                datos[i][2]=documentos.get(i).nombre;
                datos[i][3]=documentos.get(i).documento;
            }
        }
        
        DefaultTableModel dtm=new DefaultTableModel(datos, encabezados);
        tbl.setModel(dtm);
    }
    //metodo para intercambiar elementos
    private static void intercambiar(int origen, int destino){
        Documento temporal=documentos.get(origen);
        documentos.set(origen, documentos.get(destino));
        documentos.set(destino, temporal);
    }
    //metodo para verificar si un documento es mayor que otro
    public static boolean esMayor(Documento d1, Documento d2, int criterio){
        if(criterio==0){
            //ordenar primero por nombre completo y luego por tipo de documento
            return((d1.getNombreCompleto().compareTo(d2.getNombreCompleto())>0) || (d1.getNombreCompleto().equals
                   (d2.getNombreCompleto())&& d1.getDocumento().compareTo(d2.getDocumento())>0));
        }
        else{
            //ordenar primero por tipo de documento y luego por nombre completo
            return((d1.getDocumento().compareTo(d2.getDocumento())>0) || (d1.getDocumento().equals
                   (d2.getDocumento())&& d1.getNombreCompleto().compareTo(d2.getNombreCompleto())>0));
        }
    }
    
    public static void ordenarBurbujaRecursivo(int n, int criterio){
        if(n==documentos.size()-1){
            return;
        }else{
            for(int i=n+1;i<documentos.size();i++){
                //System.out.println(n+"vs"+i);
                if (esMayor(documentos.get(n), documentos.get(i), criterio)){
                    intercambiar(n,i);
                }
            }
            ordenarBurbujaRecursivo(n+1, criterio);
        }
        
    }
    
    private static int localizarPivote(int inicio, int fin, int criterio){
        
        int pivote=inicio;
        Documento dP = documentos.get(inicio);
        
        for(int i=inicio+1;i<fin; i++){
            if(esMayor(dP, documentos.get(i), criterio)){
                pivote++;
                if(i!=pivote){
                    intercambiar(i,pivote);
                }
            }
        }
        if(inicio!=pivote){
            intercambiar(inicio, pivote);
        }
        return pivote;
    }
    
    public static void ordenarInsercion(int criterio) {
    int n = documentos.size();
    for (int i = 1; i < n; ++i) {
        Documento key = documentos.get(i);
        int j = i - 1;

        /* Mover los elementos del arreglo documentos[0..i-1], que son
           mayores que la clave, una posición hacia adelante */
        while (j >= 0 && esMayor(documentos.get(j), key, criterio)) {
            documentos.set(j + 1, documentos.get(j));
            j = j - 1;
        }
        documentos.set(j + 1, key);
    }
}
    //metodo que ordena los datos segun el algoritmo Rapido
    public static void ordenarRapido(int inicio, int fin, int criterio){
    //punto de finalizacion
        if(inicio>=fin){
            return;
        }
        //casos recursivos
        int pivote=localizarPivote(inicio, fin, criterio);
        ordenarRapido(inicio,pivote-1,criterio);
        ordenarRapido(pivote+1, fin, criterio);
    }
     public static ArbolBinario obtenerArbolBinario(int criterio) {
        ArbolBinario ab = new ArbolBinario();
        ab.setCriterio(criterio);
        for (int i = 0; i < documentos.size(); i++) {
            Nodo n = new Nodo(documentos.get(i));
            ab.insertarNodo(n);
        }
        return ab;
    }
    
}
