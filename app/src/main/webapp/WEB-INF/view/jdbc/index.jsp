<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="content" type="string">
    <table border="1">
      <tr>
        <th>ID</th>
        <th>社員番号</th>
        <th>名前</th>
        <th>サラリー</th>
      </tr>
      <c:forEach var="emp" items="${empList}">
        <tr>
          <td>${emp.id}</td>
          <td>${emp.empNo}</td>
          <td>${f:h(emp.empName)}</td>
          <td>${emp.sal}</td>
        </tr>
      </c:forEach>
    </table>
  </tiles:put>
</tiles:insert>
