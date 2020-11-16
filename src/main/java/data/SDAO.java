package data;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import service.HibernateUtil;

public class SDAO {

    private static final Logger LOGGER = Logger.getLogger(SDAO.class);

    public List<Student> getAllStudent() {
        List<Student> getAllStudent;
        Session s = HibernateUtil.getSESSIONFACTORY().openSession();
        getAllStudent = s.createQuery("FROM Student").list();
        s.close();
        LOGGER.info("Get all student: " + getAllStudent);
        return getAllStudent;
    }

}
