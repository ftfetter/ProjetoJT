package Database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by ilegra0320 on 20/04/2017.
 */
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
