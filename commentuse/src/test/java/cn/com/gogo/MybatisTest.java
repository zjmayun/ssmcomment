package cn.com.gogo;

import org.imooc.service.TuserService;
import org.imooc.service.impl.TuserServiceImpl;
import org.junit.Test;

public class MybatisTest {
	
     @Test
     public void testPageHelper() {
           TuserService tuserService=new TuserServiceImpl();
           System.out.println(tuserService.getAll(1, 5));
     }
}
