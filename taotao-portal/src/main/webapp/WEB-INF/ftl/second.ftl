<html>
<head>
    <title>${title}</title>
</head>
<body>
<#--<label>学号：</label>${student.id}<br>-->
<#--<label>姓名：</label>${student.name}<br>-->
<#--<label>住址：</label>${student.address}<br>-->
学生列表：
<table border="1">
<#list studentList as s>
    <#if s_index==1>
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.address}</td>
        </tr>
    <#else>
        <tr bgcolor="#a52a2a">
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.address}</td>
        </tr>
    </#if>

</#list>
</table>
${cur_time?date}
${cur_time?datetime}
${cur_time?time}
${cur_time?string("yyyy-MM-ss HH:mm:ss")}
</body>
</html>