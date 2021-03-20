package mypkg.action;

import javax.annotation.Resource;
import mypkg.form.AddForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * AddAction.
 * 参考：http://sastruts.seasar.org/tutorial.html#add
 */
public class AddAction {

  /**
   * AddForm.
   */
  @Resource
  @ActionForm
  protected AddForm addForm;
  public Integer result = 0;

  /**
   * index.
   *
   * @return JSP
   */
  @Execute(validator = false)
  public String index() {
    return "input.jsp";
  }

  /**
   * echo.
   *
   * @return JSP
   */
  @Execute(validator = true, input = "input.jsp")
  public String submit() {
    result = Integer.parseInt(addForm.arg1) + Integer.parseInt(addForm.arg2);
    return "result.jsp";
  }
}
