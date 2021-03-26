package mypkg.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.seasar.s2jdbcmock.S2JdbcUnit.initS2JdbcUnit;
import static org.seasar.s2jdbcmock.S2JdbcUnit.verifySqlByRegExp;


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
   * テーブルを作成.
   */
  private void createTable() {
    // SQL実行
    jdbcManager.callBySqlFile("CreateTable/createEmp.sql").execute();
  }

  /**
   * テーブル削除.
   */
  private void dropTable() {
    // SQL実行
    jdbcManager.callBySqlFile("DropTable/dropEmp.sql").execute();
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
   * 正常系: 全件取得のテスト.
   */
  @Test
  public void testFindAll() {
    // テーブル作成
    createTable();

    // テストデータ投入
    int[] countArray = jdbcManager.insertBatch(createEmpList()).execute();

    // テスト対象
    var results = empService.findAll();

    // 検証
    assertThat(results, hasSize(2));
    assertThat(results.get(0).empName, is("foo"));
    assertThat(results.get(1).empName, is("bar"));

    // テーブル削除
    dropTable();
  }

  /**
   * 正常系: 表示順で全件取得のテスト.
   */
  @Test
  public void testFindAllOrderById() {
    // テーブル作成
    createTable();
    // テストデータ投入
    int[] countArray = jdbcManager.insertBatch(createEmpList()).execute();

    // テスト対象
    var results = empService.findAllOrderById();

    // 検証
    assertThat(results, hasSize(2));
    assertThat(results.get(0).empName, is("foo"));
    assertThat(results.get(1).empName, is("bar"));

    // テーブル削除
    dropTable();
  }

  @Test
  public void testGetEmployeeTx() {
    // テーブル作成
    createTable();
    // サービスのメソッドを実行
    empService.findAll();
    // 正規表現でSQLを検証
    verifySqlByRegExp(0, "SELECT .* FROM EMPLOYEE .* WHERE .*EMP_ID = \\?", 1);
    // テーブル削除
    dropTable();
  }
}