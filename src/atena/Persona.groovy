
package atena;
import java.sql.DriverManager;
import java.sql.CallableStatement
import java.sql.Connection;
import java.sql.ResultSet;

 class Persona {
    private static final long serialVersionUID = 1L;  
    Integer id;
    String nombre;
    String apellido;
    String telefono;
    String mail;
    String cedula;

    public Persona() {
    }

    public Persona(int id) {
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:postgresql://10.0.0.2:5432/atena","postgres", "postgres");

        def st=connection.createStatement()
        ResultSet rs = st.executeQuery("select * from prsn where prsn__id=${id}")
        while (rs.next()) {
            this.id= rs.getInt("prsn__id")
            this.nombre=rs.getString("prsnnmbr");
            this.apellido=rs.getString("prsnapld");
            this.telefono=rs.getString("prsntelf");
            this.mail=rs.getString("prsnmail");
            this.cedula=rs.getString("prsncdla");
        }
        connection.close();
    }
    
    boolean insert(){
        try{
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:postgresql://10.0.0.2:5432/atena","postgres", "postgres");
        def insert ="insert into prsn values(default,?,?,?,?,?)"      
        CallableStatement stmt =connection.prepareCall(insert);
        stmt.setString(1,this.nombre);
        stmt.setString(2,this.apellido);
        stmt.setString(3,this.telefono);
        stmt.setString(4,this.mail);
        stmt.setString(5,this.cedula);
        stmt.execute();
        def st=connection.createStatement()
        ResultSet rs = st.executeQuery("select prsn__id from prsn order by 1 desc limit 1")
        while (rs.next()) {
            this.id= rs.getInt("prsn__id")
            // println "id "+this.id
        }
        connection.close();  
        return false;
        }catch(e){
            println "error wtf insert peersona "+e
            return true
        }
    }
    boolean save(){
        return this.insert();
    }
    
    
    public Prsn(Integer prsnId) {
        this.id = prsnId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer prsnId) {
        this.id = prsnId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String prsnnmbr) {
        this.nombre = prsnnmbr;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String prsnapld) {
        this.apellido = prsnapld;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String prsntelf) {
        this.telefono = prsntelf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String prsnmail) {
        this.mail = prsnmail;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String prsncdla) {
        this.cedula = prsncdla;
    }
   
    public String toString() {
        return "atena.Prsn[ prsnId=" + id + " ]";
    }
    
}
