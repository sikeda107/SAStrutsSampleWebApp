package mypkg.action.params;

import javax.annotation.Resource;
import mypkg.form.params.IndexForm;
import org.apache.log4j.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * IndexAction.
 */
public class IndexAction {
  final Logger logger = Logger.getLogger(IndexAction.class);

  /**
   * IndexForm.
   */
  @Resource
  @ActionForm
  protected IndexForm indexForm;

  /**
   * index.
   * http://localhost:8080/app/params/{id} でアクセス.
   *
   * @return JSPページ
   */
  @Execute(validator = false, urlPattern = "{id}")
  public String index() {
    logger.info("\nid:" + indexForm.id);
    return "index.jsp";
  }
}
