import Models.*;
import Dao.Implementations.*;
import org.sql2o.Connection;
import static spark.Spark.*;
import com.google.gson.*;
import org.sql2o.Sql2o;

import java.lang.reflect.Type;
import java.math.BigDecimal;

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
        get("/school/:id","application/json",(req,res)->{
            int id  = Integer.parseInt(req.params("id"));
            if(schoolImplementation.getById(id) == null) {
                return gson.toJson(String.format("No School with the Id %d exists", id));
            }
            return gson.toJson(schoolImplementation.getById(id));
        });

        //Get bursar * passed *
        get("/bursar/:id","application/json",(req,res)->{
            int id  = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getBursar(id) == null) {
                return gson.toJson(String.format("No bursar at the id %d exists", id));
            }
            return gson.toJson(bursarImplementation.getBursar(id));
        });

        //Get student * passed *
        get("/student/:id","application/json",(req,res)->{
            int id  = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getStudent(id) == null) {
                return gson.toJson(String.format("No Student at the id %d exists", id));
            }
            return gson.toJson(bursarImplementation.getStudent(id));
        });

        //Get All Students
        get("/students/all","application/json",(req,res)->{
            if(studentImplementation.getAll().size() == 0) {
                return gson.toJson("No students yet.Add some to get started");
            }
            return gson.toJson(studentImplementation.getAll());
        });
        //Delete student
        delete("/student/:id/delete","application/json",(req,res)->{
            int id  = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getStudent(id) == null) {
                return gson.toJson(String.format("No student with the id %d exists", id));
            }
            studentImplementation.delete(id);
            return gson.toJson(String.format("Student at id %d has been deleted",id));
        });

        //Delete students * passed *
        delete("/students/all/delete","application/json",(req,res)->{
            studentImplementation.deleteAll();
            return gson.toJson("All Students have been deleted");
        });


        /* Update Methods */

        //Update pocketMoney * passed *
        patch("/student/:id/:pocketMoney/pocketMoney/update","application/json",(req,res)->{
            int id = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getStudent(id) == null) {
                return gson.toJson(String.format("No student at this given id: %d", id));
            }
            double pocketMoney = Double.parseDouble(req.params("pocketMoney"));
            BigDecimal money = new BigDecimal(pocketMoney);
            bursarImplementation.updateStudentPocketMoney(id,money);
            return gson.toJson(String.format("%s's pocket money has been updated",bursarImplementation.getStudent(id).getName()));
        });

        //Update feeBalance * passed *
        patch("/student/:id/:balance/balance/update","application/json",(req,res)->{
            int id = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getStudent(id) == null) {
                return gson.toJson(String.format("No student at this given id: %d", id));
            }
            double money = Double.parseDouble(req.params("balance"));
            BigDecimal newBalance = new BigDecimal(money);
            bursarImplementation.updateStudentFeeBalance(id,newBalance);
            return gson.toJson(String.format("%s's fee balance has been updated",bursarImplementation.getStudent(id).getName()));
        });

        //Update bursar details * passed *
        patch("bursar/:id/update","application/json",(req,res)->{
            int id = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getBursar(id) == null) {
                return gson.toJson(String.format("No bursar at the id %d exists", id));
            }
            Bursar bursar = gson.fromJson(req.body(),Bursar.class);
            bursarImplementation.update(id,bursar.getName(),bursar.getEmail(),bursar.getNationalId(),bursar.getContact(), bursar.getPassword());
            return gson.toJson(String.format("%s's details have been updated", bursarImplementation.getBursar(id).getName()));
        });

        //Update student details * passed *
        patch("student/:id/update","application/json",(req,res)->{
            int id = Integer.parseInt(req.params("id"));
            if (bursarImplementation.getStudent(id) == null) {
                return gson.toJson(String.format("No student at this given id: %d", id));
            }
            Student student = gson.fromJson(req.body(),Student.class);
            System.out.println(student.getName());
            studentImplementation.update(id, student.getName(),student.getClassStream(), student.getAdmissionNumber(),student.getPocketMoney(),student.getFeeBalance());
            return gson.toJson(String.format("%s's details have been updated",bursarImplementation.getStudent(id).getName()));
        });


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
