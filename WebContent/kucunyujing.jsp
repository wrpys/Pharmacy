<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common/backend_common.jsp"/>
    <jsp:include page="common/page.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
       	库存预警
    </h1>
</div>
<div class="main-content-inner">
    
    
        <div class="col-xs-12">
            <div class="table-header">
              库存预警表&nbsp;&nbsp;
                
            </div>
            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                           aria-describedby="dynamic-table_info" style="font-size:14px">
                        <thead>
                        <tr role="row">
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                药品编号
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                 药品名字
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                 药品单位
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                 入库总数
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                  出库总数
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                               库存数
                            </th>
                        </tr>
                        </thead>
                        <tbody id="userList"></tbody>
                    </table>
                    <div class="row" id="userPage">
                    </div>
                </div>
            </div>
        </div>
    
</div>



<script id="userListTemplate" type="x-tmpl-mustache">
{{#userList}}
<tr role="row" class="user-name odd" data-id="{{durgsID}}"><!--even -->
    <td>{{yaopingID}}</a></td>
    <td>{{yaopingMingzi}}</td>
    <td>{{yaopingDanwei}}</td>
    <td>{{zongruku}}</td>
    <td>{{zongchuku}}</td>
	<td>{{shengyushu}}</td>
</tr>
{{/userList}}
</script>

<script type="text/javascript">
$(function () {
    
    
    var userListTemplate = $('#userListTemplate').html();
    Mustache.parse(userListTemplate);

    loadUserList();

   

    function loadUserList() {
        var url = "${pageContext.request.contextPath }/cs";
        $.ajax({
        	 url: url,
        	data:{cls:'CangkusheziController',mtd:'findAllMinNumber'},
            
            success: function (result) {
            	
                renderUserListAndPage(result);
            }
        });
    }

    function renderUserListAndPage(result) {            
            	
                var rendered = Mustache.render(userListTemplate, {
                    "userList": result.AllMinNumber});
                $('#userList').html(rendered);
                bindUserClick()
            } 
         
    


  
        
    });
</script>
</body>
</html>
