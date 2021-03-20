<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="content" type="string">
        <h1>ID:${f:h(id)}</h1><br/>
    </tiles:put>
</tiles:insert>