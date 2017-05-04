package Database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DatabaseConnectTest {

    @Test
    public void bdConnected(){
        Connection con = null;

        try{
            con = DatabaseConnect.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }

        Assert.assertNotNull(con);
    }

}
