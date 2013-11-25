package atena;
import atena.Persona
import java.sql.CallableStatement
import java.sql.DriverManager;
import java.sql.Connection
import java.sql.ResultSet;
class Huella {

    int id;
    int fingerNumber;
    int quality
    int impressionType
    int viewNumber
    byte[] data;
    Persona persona;
    boolean connected;
    public Huella(fn,q,imt,vn,data,persona){
        this.fingerNumber=fn;
        this.quality=q;
        this.impressionType=imt;
        this.viewNumber=vn;
        this.data=data;
        this.persona= persona;
    }
    public Huella(){

    }
    public Huella(id){
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:postgresql://10.0.0.2:5432/atena","postgres", "postgres");

        def st=connection.createStatement()
        ResultSet rs = st.executeQuery("select * from hlla where hlla__id=${id}")
        while (rs.next()) {
            this.id= rs.getInt("hlla__id")
            this.fingerNumber=rs.getInt("hlla__id");
            this.quality=rs.getInt("hlla__id");
            this.impressionType=rs.getInt("hlla__id");
            this.viewNumber=rs.getInt("hlla__id");
            this.data=rs.getBinaryStream("hllatmpl").getBytes();
            this.persona= new Persona(rs.getInt("prsn__id"))
        }
        connection.close();
    }

    void get(int id){
        Class.forName("org.postgresql.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:postgresql://10.0.0.2:5432/atena","postgres", "postgres");

        def st=connection.createStatement()
        ResultSet rs = st.executeQuery("select * from hlla where hlla__id=${id}")
        while (rs.next()) {
            this.id= rs.getInt("hlla__id")
            this.fingerNumber=rs.getInt("hlla__id");
            this.quality=rs.getInt("hlla__id");
            this.impressionType=rs.getInt("hlla__id");
            this.viewNumber=rs.getInt("hlla__id");
            this.data=rs.getBinaryStream("hllatmpl").getBytes();
            this.persona= new Persona(rs.getInt("prsn__id"))
        }
        connection.close();
    }

    boolean insert(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:postgresql://10.0.0.2:5432/atena","postgres", "postgres");
            def insert ="insert into hlla values(default,${this.fingerNumber},${this.quality},${this.impressionType},${this.viewNumber},?,${this.persona?.id})"
            // println "insert  "+insert
       
            CallableStatement stmt =connection.prepareCall(insert);
            //ojo antes estaba ByteInputStream
            stmt.setBinaryStream(1, new ByteArrayInputStream(this.data,0,400),400);
            stmt.execute();
            def st=connection.createStatement()
            ResultSet rs = st.executeQuery("select hlla__id from hlla order by 1 desc limit 1")
            while (rs.next()) {
                this.id= rs.getInt("hlla__id")
                // println "id "+this.id
            }
            connection.close();
            return false
        }catch(e){
            println "error wtf insert huella "+e
            return true;            
        }
       
    }
    boolean save(){
        return this.insert();
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    int getFingerNumber() {
        return fingerNumber
    }

    void setFingerNumber(int fingerNumber) {
        this.fingerNumber = fingerNumber
    }

    int getQuality() {
        return quality
    }

    void setQuality(int quality) {
        this.quality = quality
    }

    int getImpressionType() {
        return impressionType
    }

    void setImpressionType(int impressionType) {
        this.impressionType = impressionType
    }

    byte[] getData() {
        return data
    }

    void setData(byte[] data) {
        this.data = data
    }

    int getViewNumber() {
        return viewNumber
    }

    void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber
    }
    String  getNombre(){
        return this.persona.getNombre();
    }
}
