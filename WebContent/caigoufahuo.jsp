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
        采购收货单管理
    </h1>
</div>
<div class="main-content-inner">
    
    
        <div class="col-xs-12">
            <div class="table-header">
               采购收货单列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 user-add"></i>
                </a>
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
                                名称
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                               单位 
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                             数量
                            </th>

                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                             总价
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                供应商
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                日期
                            </th>
							<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
      	   采购订单编号
                            </th>
                            <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
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

<div id="dialog-saveuser-form" style="display: none;">
    <form id="saveuserForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
            <tr>
                <td style="width: 80px;"><label for="duties">供应商</label></td>
                <td>
                    <select id="dialog-saveuser-formselete" name="gongyingshangID" data-placeholder="选择供应商" style="width: 200px;"></select>
                </td>
            </tr>
             <tr>
                <td><label for="caigoudingdangID">采购订单编号</label></td>
                <input type="hidden" name="cls" id="cls" value="CaigoufahuoController"/>
                <input type="hidden" name="mtd" id="mtd" value="save"/>
                <td><input type="text" name="caigoudingdangID" id="caigoudingdangID" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="yaopingID">药品编号</label></td>
                <td><input type="text" name="yaopingID" id="yaopingID" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="yaopingMingzi">名称</label></td>               
                <td><input type="text" name="yaopingMingzi" id="yaopingMingzi" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
         
            <tr>
                <td><label for="yaopingDanwei">单位</label></td>
                <td><input type="text" name="yaopingDanwei" id="yaopingDanwei" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>

            <tr>
                <td><label for="shuliang"> 数量</label></td>
                <td><textarea name="shuliang" id="shuliang" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>
             <tr>
                <td><label for="zongjia"> 总价</label></td>
                <td><textarea name="zongjia" id="zongjia" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>
            <tr>
                <td><label for="riqi"> 日期</label></td>
                <td><textarea name="riqi" id="riqi" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>
                                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                状态
                            </th>
        </table>
    </form>
</div>
<div id="dialog-updateuser-form" style="display: none;">
    <form id="updateuserForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
            <tr>
                <td style="width: 80px;"><label for="duties">供应商</label></td>
                <td>
				<select id="dialog-updateuser-formselete" name="gongyingshangID" data-placeholder="选择供应商" style="width: 200px;"></select>
                </td>
            </tr>
             <tr>
                <td><label for="caigoudingdangID">采购订单编号</label></td>
                <input type="hidden" name="cls" id="cls" value="CaigoufahuoController"/>
                <input type="hidden" name="mtd" id="mtd" value="update"/>
				<input type="hidden" name="caigoufahuoID" id="caigoufahuoID"/>
                <td><input type="text" name="caigoudingdangID" id="dialog-updateuser-formcaigoudingdangID" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="yaopingID">药品编号</label></td>
                <td><input type="text" name="yaopingID" id="dialog-updateuser-formyaopingID" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="yaopingMingzi">名称</label></td>               
                <td><input type="text" name="yaopingMingzi" id="dialog-updateuser-formyaopingMingzi" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
         
            <tr>
                <td><label for="yaopingDanwei">单位</label></td>
                <td><input type="text" name="yaopingDanwei" id="dialog-updateuser-formyaopingDanwei" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
     	   <tr>
                <td><label for="drugsStandard">标准</label></td>
                <td><input type="text" name="drugsStandard" id="dialog-updateuser-formdrugsStandard" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="shuliang"> 数量</label></td>
                <td><textarea name="shuliang" id="dialog-updateuser-formshuliang" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>

             <tr>
                <td><label for="zongjia"> 总价</label></td>
                <td><textarea name="zongjia" id="dialog-updateuser-formzongjia" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>
            <tr>
                <td><label for="riqi"> 日期</label></td>
                <td><textarea name="riqi" id="dialog-updateuser-formriqi" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>
            <tr>
                <td style="width: 80px;"><label for="zhiwu">状态</label></td>
                <td>
                    <select id="complete" name="complete" data-placeholder="选择状态" style="width: 200px;">
                    		<option value="0">未审核</option> 
                    		<option value="1">审核</option>                    	
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>

<script id="userListTemplate" type="x-tmpl-mustache">
{{#userList}}
<tr role="row" class="user-name odd" data-id="{{caigoufahuoID}}"><!--even -->
    <td>{{yaopingID}}</td>
    <td>{{yaopingMingzi}}</td>
    <td>{{yaopingDanwei}}</td>
   
	<td>{{shuliang}}</td>
	<td>{{zongjia}}</td>
	<td>{{gongyingshangMingzi}}</td>
	<td>{{riqi}}</td>
	<td>{{caigoudingdangID}}</td>
	<td>{{#bold}}{{complete}}{{/bold}}</td>	
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green user-edit" href="#" data-id="{{caigoufahuoID}}"
												data-yaopingID="{{yaopingID}}"
												data-yaopingDanwei="{{yaopingDanwei}}"
												data-yaopingMingzi="{{yaopingMingzi}}"
											
												data-shuliang="{{shuliang}}"	
												data-zongjia="{{zongjia}}"
												data-riqi="{{riqi}}"
												data-caigoudingdangID="{{caigoudingdangID}}">
                <i class="ace-icon fa fa-pencil bigger-100"></i>
            </a>
             <a class="red user-delete" href="#" data-id="{{caigoufahuoID}}" >
                    <i class="ace-icon fa fa-trash-o bigger-100"></i>
             </a>
        </div>
    </td>
</tr>
{{/userList}}
</script>


<script id="Template" type="x-tmpl-mustache">

{{#businessList}}
<option value="{{gongyingshangID}}">{{gongyingshangMingzi}}</option>
{{/businessList}}

</script>

<script type="text/javascript">
$(function () {
    
    
    var userListTemplate = $('#userListTemplate').html();
    Mustache.parse(userListTemplate);

    var Template = $('#Template').html();
    Mustache.parse(Template);
    loadUserList();
    // 加载信息,并渲染
    function loadUserList() {
        var url = "${pageContext.request.contextPath }/cs";
        $.ajax({
        	url: url,
        	data:{cls:'CaigoufahuoController',mtd:'findAll'},            
            success: function (result) {            	
                renderUserListAndPage(result);
            }
        });
    }

    function renderUserListAndPage(result) {   
		 var rendered = Mustache.render(userListTemplate, {"userList": result.caigoufahuoList,
			 "bold": function () { // 对展示做特殊处理
                 return function (text, render) {
                     var status = render(text); // 获取出渲染后的值
                     if (status == '1') {
                         return "<span class='label label-sm label-success'>审核</span>";
                     }else if (status == '0') {
                         return "<span class='label label-sm label-success'>未审核</span>";
                     } 
             }
             }});
         $('#userList').html(rendered);
         bindUserClick()
    } 
         
    $(".user-add").click(function () {
        $("#dialog-saveuser-form").dialog({
            modal: true,
            title: "新增采购收货单",
            open: function (event, ui) {
                $(".ui-dialog-titlebar-close", $(this).parent()).hide(); // 点开时隐藏关闭按钮
               
                saveuserrecursiveRenderDeptSelect();
                $("#saveuserForm")[0].reset();
            },
            buttons: {
                "添加": function (e) {                    
                    save();
                },
                "取消": function () {
                    $("#dialog-saveuser-form").dialog("close");
                }
            }
        });
    });



    // 绑定相关点击事件
    function bindUserClick() {
    	
        // 处理点击按钮
        $(".user-edit").click(function (e) {
            var caigoufahuoID = $(this).attr("data-id"); // 选中的id
			var yaopingID = $(this).attr("data-yaopingID"); 
			var yaopingDanwei = $(this).attr("data-yaopingDanwei"); 
			var yaopingMingzi = $(this).attr("data-yaopingMingzi"); 
			
			var shuliang = $(this).attr("data-shuliang"); 
			var zongjia = $(this).attr("data-zongjia"); 
			var riqi = $(this).attr("data-riqi"); 
			var caigoudingdangID = $(this).attr("data-caigoudingdangID"); 
            $("#dialog-updateuser-form").dialog({
                modal: true,
                title: "编辑用户",
                open: function (event, ui) {
                	updateuserrecursiveRenderDeptSelect();
                    $("#updateuserForm")[0].reset();
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide(); // 点开时隐藏关闭按钮
                   $("#dialog-updateuser-formyaopingID").val(yaopingID);
				   $("#dialog-updateuser-formyaopingDanwei").val(yaopingDanwei);
				   $("#dialog-updateuser-formyaopingMingzi").val(yaopingMingzi);
		
				   $("#dialog-updateuser-formshuliang").val(shuliang);
				   $("#dialog-updateuser-formzongjia").val(zongjia);
				   $("#dialog-updateuser-formriqi").val(riqi);
				   $("#dialog-updateuser-formcaigoudingdangID").val(caigoudingdangID);
				   $("#caigoufahuoID").val(caigoufahuoID);
				  
                    
                },
                buttons: {
                    "更新": function (e) {
                        update();
                    },
                    "取消": function () {
                        $("#dialog-updateuser-form").dialog("close");
                    }
                }
            });
        });

		            // 处理点击[删除]按钮
        $(".user-delete").click(function (e) {
            e.preventDefault();
            e.stopPropagation(); // 此处必须要取消冒泡,因为是个递归结构,冒泡的话会让一个点击被响应多个
            var caigoufahuoID = $(this).attr("data-id");
            if (confirm("确定要删除吗?")) {
                $.ajax({
                    url: "${pageContext.request.contextPath }/cs",
                    data: {
                    	cls:'CaigoufahuoController',mtd:'delete',
                    	caigoufahuoID: caigoufahuoID
                    },
                    success: function () {
                        
                            loadUserList();
                        
                    }
                });
            }
        });
    }

    function save() {
        $.ajax({
            url: "${pageContext.request.contextPath }/cs",
            data: $("#saveuserForm").serializeArray(),
            type: 'POST',
            success: function () {
            	
            	   $("#dialog-saveuser-form").dialog("close");
            	   loadUserList();
                    
             
            }
        });
    }
    
    function update() {
        $.ajax({
            url: "${pageContext.request.contextPath }/cs",
            data: $("#updateuserForm").serializeArray(),
            type: 'POST',
            success: function () {
            	
            	   $("#dialog-updateuser-form").dialog("close");
            	   loadUserList();
                    
             
            }
        });
    }
  //加载保存和修改弹出框的供应商下拉信息       
    function saveuserrecursiveRenderDeptSelect() {
		$.ajax({
			url: "${pageContext.request.contextPath }/cs",
			data:{cls:'GongyingshangController',mtd:'findAll'},
			type: 'POST',
			success: function (result) {
				
				var rendered = Mustache.render(Template, {"businessList": result.gongyingshang});
		         $('#dialog-saveuser-formselete').html(rendered);
			}
		});
	   
    }    
  
  //加载保存和修改弹出框的供应商下拉信息       
    function updateuserrecursiveRenderDeptSelect() {
		$.ajax({
			url: "${pageContext.request.contextPath }/cs",
			data:{cls:'GongyingshangController',mtd:'findAll'},
			type: 'POST',
			success: function (result) {
				
				var rendered = Mustache.render(Template, {"businessList": result.gongyingshang});
		         $('#dialog-updateuser-formselete').html(rendered);
			}
		});
	   
    }    
 });
</script>
</body>
</html>
