package mypkg.service;

import static mypkg.entity.DeptNames.id;
import static org.seasar.extension.jdbc.operation.Operations.asc;


import java.util.List;
import mypkg.entity.Dept;

/**
 * {@link Dept}のサービスクラスです.
 */
public class DeptService extends AbstractService<Dept> {

  /**
   * 識別子でエンティティを検索します.
   *
   * @param id 識別子
   * @return エンティティ
   */
  public Dept findById(Long id) {
    return select().id(id).getSingleResult();
  }

  /**
   * 識別子とバージョン番号でエンティティを検索します.
   *
   * @param id        識別子
   * @param versionNo バージョン番号
   * @return エンティティ
   */
  public Dept findByIdVersion(Long id, Integer versionNo) {
    return select().id(id).version(versionNo).getSingleResult();
  }

  /**
   * 識別子の昇順ですべてのエンティティを検索します.
   *
   * @return エンティティのリスト
   */
  public List<Dept> findAllOrderById() {
    return select().orderBy(asc(id())).getResultList();
  }
}