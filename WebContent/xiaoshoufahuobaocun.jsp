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
       销售出货管理
    </h1>
</div>
<div class="main-content-inner">
    
    
        <div class="col-xs-12">
            <div class="table-header">
                  新增销售出货&nbsp;&nbsp;
               
            </div>
            
        </div>
    
</div>

<div id="dialog-saveuser-form" >
    <form id="saveuserForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
            <tr>
                <td style="width: 80px;"><label for="duties">供应商</label></td>
                <td>
                    <div id="dialog-saveuser-formselete"></div>
                </td>
            </tr>
			<tr>
                <td style="width: 80px;"><label for="duties">客户</label></td>
                <td>
                    <div id="dialog-saveuser-formseletekehuID"></div>
                </td>
            </tr>
             <tr>
                <td><label for="xiaoshoudingdangID">销售订单编号</label></td>
                <input type="hidden" name="cls" id="cls" value="XiaoshoufahuoController"/>
                <input type="hidden" name="mtd" id="mtd" value="save"/>
                <td><input type="text" name="xiaoshoudingdangID" id="xiaoshoudingdangID" value="" class="text ui-widget-content ui-corner-all"></td>
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
			
        </table>
    </form>
    <button type="button" class="btn btn-primary btn-lg user-add">提交</button>
</div>




<script id="Template" type="x-tmpl-mustache">
<select id="deptSelectId" name="gongyingshangID" data-placeholder="选择供应商" style="width: 200px;">
{{#businessList}}
<option value="{{gongyingshangID}}">{{gongyingshangMingzi}}</option>
{{/businessList}}
</select>
</script>

<script id="kehuMingziTemplate" type="x-tmpl-mustache">
<select id="customerSelectId" name="kehuID" data-placeholder="选择客户" style="width: 200px;">
{{#customerList}}
<option value="{{kehuID}}">{{kehuMingzi}}</option>
{{/customerList}}
</select>
</script>
<script type="text/javascript">
$(function () {
    
    


    var Template = $('#Template').html();
    Mustache.parse(Template);
	
	var kehuMingziTemplate = $('#kehuMingziTemplate').html();
    Mustache.parse(kehuMingziTemplate);
    dialogsaveuserformrecursiveRenderDeptSelect();
    dialogsaveuserformrecursiveRendercustomrSelect();
    $(".user-add").click(function () {
    	 $.ajax({
             url: "${pageContext.request.contextPath }/cs",
             data: $("#saveuserForm").serializeArray(),
             type: 'POST',
             success: function () {
             	
             	   $("#dialog-saveuser-form").dialog("close");
             	   loadUserList();
                     
              
             }
         });
    });




  //加载保存弹出框的供应商下拉信息     
    function dialogsaveuserformrecursiveRenderDeptSelect() {
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
  //加载保存弹出框的客户下拉信息   
	    function dialogsaveuserformrecursiveRendercustomrSelect() {
		$.ajax({
			url: "${pageContext.request.contextPath }/cs",
			data:{cls:'KehuController',mtd:'findAll'},
			type: 'POST',
			success: function (result) {
				
				var rendered = Mustache.render(kehuMingziTemplate, {"customerList": result.kehuList});
		         $('#dialog-saveuser-formseletekehuID').html(rendered);
			}
		});
	   
    }
	

 });
</script>
</body>
</html>
