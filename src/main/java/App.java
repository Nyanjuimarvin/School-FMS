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

        //New School * passed *
        post("/school/new","application/json",(req,res)->{
            School school = gson.fromJson(req.body(),School.class);
            schoolImplementation.add(school);
            res.status(201);
            return gson.toJson(school);
        });

        //New Bursar * passed *
        post("/bursar/new","application/json",(req,res)->{
            Bursar bursar = gson.fromJson(req.body(),Bursar.class);
            bursarImplementation.add(bursar);
            System.out.println(bursar.type);
            res.status(201);
            return gson.toJson(bursar);
        });

        //New Student *Passed*
        post("students/new","application/json",(req,res)->{
            Student student = gson.fromJson(req.body(),Student.class);
            studentImplementation.add(student);
            res.status(201);
            return gson.toJson(student);
        });

        //Filter
        after((req,res)->{
            res.type("application/json");
        });
    }
}
