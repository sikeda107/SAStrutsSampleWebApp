package mypkg.action;

import javax.annotation.Resource;
import mypkg.form.IndexForm;
import org.apache.log4j.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * IndexAction.
 */
public class IndexAction {

  final Logger logger = Logger.getLogger(IndexAction.class);
  public String helloString;

  /**
   * アクションフォーム.
   */
  @Resource
  @ActionForm
  protected IndexForm indexForm;

  /**
   * index.
   *
   * @return JSPページ
   */
  @Execute(validator = false)
  public String index() {
    helloString = "Hello Seasar2 !!";
    indexForm.hello = "Hello Seasar2 !! from IndexForm";
    logger.info("IndexAction#indexが呼び出されました helloString⇛" + helloString);
    return "index.jsp";
  }
}
