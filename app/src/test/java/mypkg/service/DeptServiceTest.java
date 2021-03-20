package mypkg.service;

import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

@RunWith(Seasar2.class)
public class DeptServiceTest {

  private TestContext ctx;
  private DeptService deptService;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void available() {
    assertNotNull(deptService);
//        List<Dept> resultList = deptService.findAll();
//        resultList.forEach(r -> System.out.println(r.id + " " + r.deptName + " " + r.deptNo + " " + r.versionNo));
  }
}