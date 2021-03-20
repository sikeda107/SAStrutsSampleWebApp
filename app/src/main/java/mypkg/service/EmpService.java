package mypkg.service;

import static mypkg.entity.EmpNames.id;
import static org.seasar.extension.jdbc.operation.Operations.asc;


import java.util.List;
import mypkg.entity.Emp;

/**
 * {@link Emp}のサービスクラスです.
 */
public class EmpService extends AbstractService<Emp> {

  /**
   * 識別子でエンティティを検索します.
   *
   * @param id 識別子
   * @return エンティティ
   */
  public Emp findById(Long id) {
    return select().id(id).getSingleResult();
  }

  /**
   * 識別子とバージョン番号でエンティティを検索します.
   *
   * @param id        識別子
   * @param versionNo バージョン番号
   * @return エンティティ
   */
  public Emp findByIdVersion(Long id, Integer versionNo) {
    return select().id(id).version(versionNo).getSingleResult();
  }

  /**
   * 識別子の昇順ですべてのエンティティを検索します.
   *
   * @return エンティティのリスト
   */
  public List<Emp> findAllOrderById() {
    return select().orderBy(asc(id()))
        .getResultList();
  }

  /**
   * 識別子の昇順ですべてのエンティティを検索します.
   *
   * @param limit  表示件数
   * @param offset オフセット
   * @return エンティティのリスト
   */
  public List<Emp> findAllOrderById(int limit, int offset) {
    return select().orderBy(asc(id()))
        .limit(limit)
        .offset(offset)
        .getResultList();
  }
}