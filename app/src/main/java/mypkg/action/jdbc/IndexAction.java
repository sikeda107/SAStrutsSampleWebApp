package mypkg.action.jdbc;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import mypkg.entity.Dept;
import mypkg.entity.Emp;
import mypkg.service.DeptService;
import mypkg.service.EmpService;
import org.apache.log4j.Logger;
import org.seasar.struts.annotation.Execute;

/**
 * IndexAction.
 */
public class IndexAction {

  final Logger logger = Logger.getLogger(IndexAction.class);
  @Resource
  protected DeptService deptService;
  @Resource
  protected EmpService empService;

  public int totalDeptSize = 0;
  public int totalEmpSize = 0;

  public List<Emp> empList = new ArrayList<>();
  public List<Dept> deptList = new ArrayList<>();


  /**
   * index.
   * http://localhost:8080/app/jdbc/ でアクセス.
   *
   * @return JSPページ
   */
  @Execute(validator = false)
  public String index() {
    empList = empService.findAllOrderById();
    totalEmpSize = empList.size();
    deptList = deptService.findAllOrderById();
    totalDeptSize = deptList.size();
    logger.info("jdbc.IndexAction#index呼び出し");
    return "index.jsp";
  }
}
