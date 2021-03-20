<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="content" type="string">
        <h1>${f:h(helloString)}</h1>
        <h1>${f:h(hello)}</h1>
        <tags:hello name="${helloString}" />
    </tiles:put>
</tiles:insert>