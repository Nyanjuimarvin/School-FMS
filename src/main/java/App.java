import Models.*;
import Dao.Implementations.*;
import org.sql2o.Connection;
import static spark.Spark.*;
import com.google.gson.*;
import org.sql2o.Sql2o;

public class App {
    public static void main(String[] args) {

        Connection conn;
        SchoolImplementation schoolImplementation;
        BursarImplementation bursarImplementation;
        StudentImplementation studentImplementation;
        String connectionString = "jdbc:postgresql://localhost:5432/school_finance_test";
        Sql2o sql2o = new Sql2o(connectionString,"marvin","nrvnqsr13");
        Gson gson = new Gson();

        schoolImplementation = new SchoolImplementation(sql2o);
        bursarImplementation = new BursarImplementation(sql2o);
        studentImplementation = new StudentImplementation(sql2o);
        conn = sql2o.open();



        /* Get methods */

        //Get School

        //Get bursar

        //Get student

        //Get All Students

        //Delete student

        //Delete students

        /* Update Methods */

        //Update pocketMoney

        //Update feeBalance

        //Update bursar details

        //Update student details



        /* Post methods */

        //New School

        //New Bursar

        //New Student

        //Bursar Login


    }
}
