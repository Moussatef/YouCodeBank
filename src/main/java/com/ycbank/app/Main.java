package com.ycbank.app;

import com.ycbank.dao.DAO;
import com.ycbank.dao.DAOFactory;
import com.ycbank.enumeration.AssuranceType;
import com.ycbank.enumeration.CountryType;
import com.ycbank.interfaces.IDAO;
import com.ycbank.model.Student;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // by abstract ------------------------------------------------------------------|

        DAO<Student> studentOp = DAOFactory.getStudentImpl();

        Student student1 = new Student(22123456L,"kamal","bhf","HH222222","bhfkamal@gmail.com",
                "11,bloc 1 Hay Anass", CountryType.MA,152415L, AssuranceType.SAHAM,1000);

        Student student2 = new Student(20997812L,"med","bhf2","HH333333","bhfkamal@gmail.com",
                "11,bloc 1 Hay Anass", CountryType.DZ,152415L, AssuranceType.SAHAM,1500);

        Student student3 = new Student(75367220L,"Imane","bhf 4","HH444444","bhfkamal@gmail.com",
                "11,bloc 1 Hay Anass", CountryType.EG,152415L, AssuranceType.SAHAM,1200);

        student1 = studentOp.create(student1);
        student2 = studentOp.create(student2);
        student3 = studentOp.create(student3);

        if(!Objects.isNull(student1))
            System.out.println("Bonjour "+student1.getFirstname()+" "+student1.getLastname());

        // --------------- CRUD OP -----------------|
        //student1.setFirstname("Ahmed");     //    |
        //student1 = studentOp.update(student1); // |
        //studentOp.delete(student1);         //    |
        // -----------------------------------------|























        // by interface ------------------------------------------------------------------|
        //IDAO<Student> studentOp2 = DAOFactory.getIStudentImpl();
        //Student student2 = studentOp2.create(new Student(3L,"kamal 2","bouhfid","HH255555","bhfkamal@mail.com","11,bloc 1 Hay Anass", CountryType.MA,152415L, AssuranceType.SAHAM,225673));
        //if(!Objects.isNull(student2))
        //    System.out.println("Bonjour "+student2.getFirstname()+" "+student2.getLastname());

        //Student student = studentOp.update(new Student(2L,"kamal","bouhfid edited 2","HH252222","bhfkamal@mail.com","11,bloc 1 Hay Anass", CountryType.MA,152415L, AssuranceType.SAHAM,88));

        //studentOp.delete(new Student(2L,"kamal","bouhfid edited 2","HH222211","bhfkamal@mail.com","11,bloc 1 Hay Anass", CountryType.MA,152415L, AssuranceType.SAHAM,88));
    }
}
