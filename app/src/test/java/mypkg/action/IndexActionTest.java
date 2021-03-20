package mypkg.action;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

@RunWith(Seasar2.class)
public class IndexActionTest {
  private TestContext ctx;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  @Ignore
  public void index() {
    IndexAction action = new IndexAction();
    String result = action.index();

    assertThat(result, is("index.jsp"));
  }
}