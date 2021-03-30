package mypkg.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;
import mypkg.entity.Dept;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

/**
 * Deptのサービスクラステスト.
 */
@RunWith(Seasar2.class)
public class DeptServiceTest {

  private TestContext ctx;
  /**
   * Deptのサービスクラス.
   */
  private DeptService deptService;
  /**
   * JDBCによるSQLの実行を管理するクラス.
   */
  private JdbcManager jdbcManager;

  @Before
  public void setUp() throws Exception {
    var jdbc = jdbcManager;
  }

  @After
  public void tearDown() throws Exception {
  }

  /**
   * テーブルを作成.
   */
  private void createTable() {
    // SQL実行
    jdbcManager.callBySqlFile("CreateTable/createDept.sql").execute();
  }

  /**
   * テーブル削除.
   */
  private void dropTable() {
    // SQL実行
    jdbcManager.callBySqlFile("DropTable/dropDept.sql").execute();
  }

  /**
   * テストデータを作成します.
   *
   * @return Deptリスト
   */
  private List<Dept> createDeptList() {
    List<Dept> deptList = new ArrayList<>();
    Dept dept1 = new Dept();
    dept1.deptName = "foo";
    Dept dept2 = new Dept();
    dept2.deptName = "bar";
    deptList.add(dept1);
    deptList.add(dept2);
    return deptList;
  }

  /**
   * 正常系: サービスクラスが利用可能かのテスト.
   */
  @Test
  public void available() {
    assertNotNull(deptService);
  }

  /**
   * 正常系: 全件取得のテスト.
   */
  @Test
  public void testFindAll() {
    // テーブル作成
    createTable();

    // テストデータ投入
    int[] countArray = jdbcManager.insertBatch(createDeptList()).execute();

    // テスト対象
    var results = deptService.findAll();

    // 検証
    assertThat(results, hasSize(2));
    assertThat(results.get(0).deptName, is("foo"));
    assertThat(results.get(1).deptName, is("bar"));

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
    int[] countArray = jdbcManager.insertBatch(createDeptList()).execute();

    // テスト対象
    var results = deptService.findAllOrderById();

    // 検証
    assertThat(results, hasSize(2));
    assertThat(results.get(0).deptName, is("foo"));
    assertThat(results.get(1).deptName, is("bar"));

    // テーブル削除
    dropTable();
  }
}