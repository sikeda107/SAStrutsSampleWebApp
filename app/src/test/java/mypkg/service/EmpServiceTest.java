package mypkg.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.seasar.s2jdbcmock.S2JdbcUnit.addResult;
import static org.seasar.s2jdbcmock.S2JdbcUnit.initS2JdbcUnit;


import java.util.ArrayList;
import java.util.List;
import mypkg.entity.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.unit.Seasar2;

/**
 * Empのサービスクラステスト.
 */
@RunWith(Seasar2.class)
public class EmpServiceTest {

  /**
   * Empのサービスクラス.
   */
  private EmpService empService;
  /**
   * JDBCによるSQLの実行を管理するクラス.
   */
  private JdbcManager jdbcManager;

  @Before
  public void setUp() throws Exception {
    initS2JdbcUnit();
  }

  @After
  public void tearDown() throws Exception {
  }

  /**
   * テストデータを作成します.
   *
   * @return Empリスト
   */
  private List<Emp> createEmpList() {
    var empList = new ArrayList<Emp>();
    var emp1 = new Emp();
    emp1.empName = "foo";
    var emp2 = new Emp();
    emp2.empName = "bar";
    empList.add(emp1);
    empList.add(emp2);
    return empList;
  }

  /**
   * 正常系: サービスクラスが利用可能かのテスト.
   */
  @Test
  public void available() {
    assertNotNull(empService);
  }

  /**
   * 正常系: 表示順で全件取得のテスト.
   */
  @Test
  public void testFindAllOrderById() {
    // JdbcManagerの返却値を設定
    addResult(createEmpList());

    // テスト対象
    var results = empService.findAllOrderById();

    // 検証
    assertThat(results, hasSize(2));
    assertThat(results.get(0).empName, is("foo"));
    assertThat(results.get(1).empName, is("bar"));
  }
}