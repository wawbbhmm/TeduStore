<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 商城</title>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="left.jsp"></jsp:include>
    <!-- 右边栏-->
    <div class="rightsidebar_box rt">
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        	<form method="post" action="" id="form_address">
				<!--隐藏表单域：用来存储id值-->
				<input type="hidden" name="id" id="id">
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="receiverName" id="receiverName"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span><select data-province="---- 选择省 ----" name="receiverState" id="receiverState" onchange="getCity(this.value,-1,-1)"></select>
					  城市：<select data-city="---- 选择市 ----" name="receiverCity" id="receiverCity" onchange="getArea(this.value,-1)"></select>
					  区/县：<select data-district="---- 选择区 ----" name="receiverDistrict" id="receiverDistrict"></select>
				</div> 
	            
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="receiverAddress" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="receiverMobile" name="receiverMobile"/>固定电话：<input type="text" name="receiverPhone" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="receiverZip" id="receiverZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="addressName"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div class="save_recipient">
	                保存收货人信息
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage">
            </div>
        </div>
    </div>
</div>


<!-- 页面底部-->
<jsp:include page="footer.jsp"></jsp:include>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/distpicker.data.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/distpicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/personal.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
<script type="text/javascript">
    $(function () {
        // 页面加载完毕，调用getProvince函数
        getProvince(-1,-1,-1);
        getAllAddress();
    });
    // 删除收货人地址
	function del(id) {
        if(confirm("确认要删除吗?")){
            $.ajax({
                url:"${pageContext.request.contextPath}/address/deleteAddress.do",
                data:"id="+id,
                type:"GET",
                dataType:"json",
                success:function(obj){
                    if(obj.state==1){
                        getAllAddress();
                    }
                }
            });
        }
    }
    // 显示修改页面
	function goUpdate(id) {
        // 发送异步请求
        $.ajax({
            url:"${pageContext.request.contextPath}/address/goUpdate.do",
            data:"id="+id,
            type:"GET",
            dataType:"json",
            // 请求的响应成功
            success:function(obj){
                if(obj.state==1){
                    //1.显示文本框内容(6个框)
                    $("#receiverName").val(obj.data.recvUsername);
                    $("#receiverAddress").val(obj.data.recvAddress);
                    $("#receiverMobile").val(obj.data.recvPhone);
                    $("#receiverPhone").val(obj.data.recvTel);
                    $("#receiverZip").val(obj.data.recvZip);
                    $("#addressName").val(obj.data.recvTag);
                    $("#id").val(obj.data.id);
                    //2.显示省市区下拉列表
                    getProvince(obj.data.recvProvinceCode, obj.data.recvCityCode, obj.data.recvAreaCode);
                    // 修改div的字符串内容，表单中的用val，此处是div用html
                    $(".save_recipient").html("修改");
                }
            }
        });
    }
    // 显示收货人地址
    function getAllAddress() {
        $.ajax({
            url:"${pageContext.request.contextPath}/address/getAddressByUid.do",
            data:"",
            type:"GET",
            dataType:"json",
            success:function(obj){
                if(obj.state==1){
                    var header = '<div class="aim_title">' +
						'<span class="dzmc dzmc_title">地址名称</span>' +
						'<span class="dzxm dzxm_title">姓名</span>' +
						'<span class="dzxq dzxq_title">地址详情</span>' +
						'<span class="lxdh lxdh_title">联系电话</span>' +
						'<span class="operation operation_title">操作</span></div>';
                    $(".address_information_manage").html(header);
                    for(i=0; i<obj.data.length; i++){
                        //1.默认地址
                        if(obj.data[i].isDefault==1){
                            var str1 = '<div class="aim_content_one aim_active">'+
                                '<span class="dzmc dzmc_active">'+obj.data[i].recvTag+'</span>'+
                                '<span class="dzxm dzxm_normal">'+obj.data[i].recvUsername+'</span>'+
                                '<span class="dzxq dzxq_normal">'+obj.data[i].recvDistrict+
                                obj.data[i].recvAddress+'</span>'+
                                '<span class="lxdh lxdh_normal">'+obj.data[i].recvPhone+'</span>'+
                                '<span class="operation operation_normal">'+
                                '<span class="aco_change" onclick="goUpdate(\'+obj.data[i].id+\')">修改</span>|<span class="aco_delete" onclick="del('+obj.data[i].id+')">删除</span>'+
                                '</span>'+
                                '<span class="swmr swmr_normal" id="'+obj.data[i].id+'"></span>'+
                                '</div>';
                            $(".address_information_manage").append(str1);
                        }else{
                            //2.非默认地址
                            var str2='<div class="aim_content_two">'+
                                '<span class="dzmc dzmc_normal">'+obj.data[i].recvTag+'</span>'+
                                '<span class="dzxm dzxm_normal">'+obj.data[i].recvUsername+'</span>'+
                                '<span class="dzxq dzxq_normal">'+obj.data[i].recvDistrict+
                                obj.data[i].recvAddress+'</span>'+
                                '<span class="lxdh lxdh_normal">'+obj.data[i].recvPhone+'</span>'+
                                '<span class="operation operation_normal">'+
                                '<span class="aco_change" onclick="goUpdate('+obj.data[i].id+')">修改</span>|<span class="aco_delete" onclick="del('+obj.data[i].id+')">删除</span>'+
                                '</span>'+
                                '<span class="swmr swmr_normal" id="'+obj.data[i].id+'">设为默认</span>'+
                                '</div>';
                            $(".address_information_manage").append(str2);
                        }

                    }
                    // 设置为默认事件
                    $(".swmr_normal").click(function(){
                        // 设置默认（数据库）
                        $.ajax({
                            url:"${pageContext.request.contextPath}/address/setDefault.do",
                            data:"id="+$(this).attr("id"),
                            type:"GET",
                            dataType:"json",
                            success:function(){
								// 数据库发生变化了
                            }
                        });
						// 设置默认（页面）
                        setDefault(this);
                    })
                }
            }
        });
    }
    // 显示省列表信息的函数
    function getProvince(provinceCode,cityCode,areaCode){
        $.ajax({
            url:"${pageContext.request.contextPath}/dict/getProvince.do",
            data:"",
            type:"GET",
            dataType:"json",
            success:function(obj){
                if(obj.state==1){
                    $("#receiverState").html("<option>...请选择...</option>");
                    for(i=0; i<obj.data.length; i++){
                        var op = new Option(
                            obj.data[i].provinceName,
                            obj.data[i].provinceCode);
                        $("#receiverState").append(op);
                    }
                    if(provinceCode != -1){
                        $("#receiverState").val(provinceCode);
                    }
                }
            }
        });
        getCity(provinceCode,cityCode,areaCode);
    }
    // 显示城市列表信息的函数
    function getCity(provinceCode,cityCode,areaCode){
        $.ajax({
            url:"${pageContext.request.contextPath}/dict/getCity.do",
            data:"provinceCode="+provinceCode,
            type:"GET",
            dataType:"json",
            success:function(obj){
                $("#receiverCity").html(
                    "<option>...请选择...</option>");
                for(i=0; i<obj.data.length; i++){
                    var op = new Option(
                        obj.data[i].cityName,
                        obj.data[i].cityCode);
                    $("#receiverCity").append(op);
                }
                if(cityCode != -1){
                    $("#receiverCity").val(cityCode);
                }
            }
        });
        getArea(cityCode,areaCode);
    }
    // 显示区域列表信息的函数
    function getArea(cityCode,areaCode){
        $.ajax({
            url:"${pageContext.request.contextPath}/dict/getArea.do",
            data:"cityCode="+cityCode,
            type:"GET",
            dataType:"json",
            success:function(obj){
                $("#receiverDistrict").html(
                    "<option>...请选择...</option>");
                for(i=0; i<obj.data.length; i++){
                    var op = new Option(
                        obj.data[i].areaName,
                        obj.data[i].areaCode);
                    $("#receiverDistrict").append(op);
                }
                if(areaCode != -1){
                    $("#receiverDistrict").val(areaCode);
                }
            }
        });
        // getArea();
    }
</script>

<!-- 处理侧边栏 -->
<script type="text/javascript">
    $(function(){
        //把所有的dd隐藏
        $("#leftsidebar_box dd").hide();
        //设置账号管理的列表显示
        $("#leftsidebar_box .address dd").show();
        //设置所有的图片为 myOrder2.png
        $("#leftsidebar_box dt img").attr("src","${pageContext.request.contextPath}/images/myOrder/myOrder2.png");
        //设置账号管理的图片为myOrder1.png
        $("#leftsidebar_box .address").find('img').attr("src","${pageContext.request.contextPath}/images/myOrder/myOrder1.png");

    });
</script>

</html>