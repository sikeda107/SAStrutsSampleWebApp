<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="content" type="string">
    <h1>足し算プログラム</h1>
    <s:form>
      <html:text property="arg1" /> + <html:text property="arg2" /> = &#63;
      <br /><br />
      <input type="submit" name="submit" value="サブミット" />
    </s:form>
  </tiles:put>
</tiles:insert>
