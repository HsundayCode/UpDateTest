package Test;
import com.Hsunday.dao.StudentDao;
import com.Hsunday.dao.Students;
import org.junit.Test;

import java.util.List;

public class updateTest {

    @Test
    public void daotest(){

        StudentDao studentDao = new StudentDao();

        List<Students>stu =  studentDao.Pageshow(1);

        System.out.println(stu.get(0));
    }


}
