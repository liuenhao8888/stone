<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="resource/css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resource/js/template.js"></script>
<script type="text/javascript" src="resource/js/descartes.js"></script>
<link href="resource/css/shop-right.css" rel="stylesheet"
	type="text/css" />
<script>
	$(document)
			.ready(
					function() {
						var maxValueOrder = 0;
						var fileCount = 0;

						$("#ctgBtn").click(function() {
							$("#ctgDiv").show();
							loadCtgItems(0);
						});

						var loadCtgItems = function(pid) {
							$.get("category/list.do?pid=" + pid, null,
									function(items) {
										renderCtgItems(items);
									});
						}

						var renderCtgItems = function(items) {
							var html = "";
							for (i in items) {
								// 				if(i%4==0){
								// 					html += "<br/>";
								// 				}
								html += "<div class='ctgItem' id='"+items[i].id+"' pid='"+items[i].pid+"'>"
										+ items[i].name + "</div>";
							}
							$("#ctgDivItems").html(html);
						}

						var renderTmps = function(items) {
							var html = "<table border='1' width='500'>";
							for (i in items) {
								html += "<tr><td width=30%>" + items[i].name
										+ "</td><td>"
										+ $().createFormatElement(items[i])
										+ "</td></tr>";
							}
							html += "</table>";
							$("#tmps").html(html);
						}

						$(".ctgItem")
								.live(
										'click',
										function() {
											var o = $(this);
											var pid = o.attr("id");
											$
													.get(
															"category/list.do?pid="
																	+ pid,
															null,
															function(items) {
																if (items.length > 0) {
																	renderCtgItems(items);
																} else {
																	$
																			.get(
																					"template/getByCid.do?cid="
																							+ pid,
																					null,
																					function(
																							m) {
																						renderTmps(m["list"]);
																						maxValueOrder = m["maxValueOrder"];
																						$(
																								"#ctgName")
																								.text(
																										o
																												.text());
																						$(
																								"#ctgId")
																								.val(
																										pid);
																					});
																}
															});

										});

						$("#ctgDivBack")
								.live(
										'click',
										function() {
											$(".ctgItem")
													.each(
															function() {
																var pid = $(
																		this)
																		.attr(
																				"pid");
																$
																		.get(
																				"category/listSibling.do?id="
																						+ pid,
																				null,
																				function(
																						items) {
																					if (items.length > 0) {
																						renderCtgItems(items);
																					}
																				});
																return false;
															});
										});

						$(".2")
								.live(
										'click',
										function() {
											var map = new Object();
											$("input[name^='std']")
													.each(
															function() {
																var name = $(
																		this)
																		.attr(
																				"name");
																var valueOrder = $(
																		this)
																		.attr(
																				"vo");
																var obj = new Object();
																var val = $(
																		this)
																		.val();
																obj.templateId = name
																		.substring(3);
																obj.value = val;
																obj.valueOrder = valueOrder;
																var item = [ obj ];
																var checked = $(
																		this)
																		.attr(
																				"checked");
																var items = map[name];
																if (checked) {
																	if (items == null) {
																		map[name] = new Array();
																	}
																	map[name]
																			.push(item);
																}
															});
											var typesHtml = "<table border='1'>";
											var records = Descartes
													.descartes(map);
											if (records == null) {
												$("#stds").html("");
												return;
											}

											var stdMap = $
													.getStandardsWithValue();

											for (var i = 0; i < records.length; i++) {
												var std = 'stdList[' + i + ']';
												var arr = records[i];
												typesHtml += '<tr>';
												var valueArr = new Array();
												for (var j = 0; j < arr.length; j++) {
													valueArr[arr[j].valueOrder - 1] = arr[j].value;
													typesHtml += '<td>'
															+ arr[j].value
															+ '</td>';
												}

												for (var j = 0; j < maxValueOrder; j++) {
													if (valueArr[j] == null) {
														valueArr[j] = "";
													}
												}

												var price = 0;
												var stock = 0;
												if (stdMap[valueArr]) {
													if (stdMap[valueArr].price) {
														price = stdMap[valueArr].price;
													}
													if (stdMap[valueArr].stock) {
														stock = stdMap[valueArr].stock;
													}
												}
												typesHtml += '<td class="values" style="display:none;"><input type="hidden" name="'+std+'.values" value="'+valueArr+'"/></td>';
												typesHtml += '<td class="price">价格：<input name="'+std+'.price" type="text" value="'+price+'"/></td><td class="stock">库存：<input name="'+std+'.stock" type="text" value="'+stock+'"/></td></tr>';
											}
											typesHtml += '</table>';
											$("#stds").html(typesHtml);

										});

						$.getStandardsWithValue = function() {
							var stdMap = new Object();
							var arr = $("#myform").serializeArray();
							for (a in arr) {
								var o = arr[a];
								var name = o.name;
								var value = o.value;
								if (name == null || name == "" || value == null
										|| value == "")
									continue;
								var valuesRE = new RegExp(".values$");
								var priceRE = new RegExp(".price$");
								var stockRE = new RegExp(".stock$");
								if (valuesRE.test(name)) {
									var index = name.indexOf(".");
									var stdPrefix = name.substring(0, index);
									if (stdMap[stdPrefix] == null) {
										stdMap[stdPrefix] = new Object();
									}
									stdMap[stdPrefix].values = o.value;
								} else if (priceRE.test(name)) {
									var index = name.indexOf(".");
									var stdPrefix = name.substring(0, index);
									if (stdMap[stdPrefix] == null) {
										stdMap[stdPrefix] = new Object();
									}
									stdMap[stdPrefix].price = o.value;
								} else if (stockRE.test(name)) {
									var index = name.indexOf(".");
									var stdPrefix = name.substring(0, index);
									if (stdMap[stdPrefix] == null) {
										stdMap[stdPrefix] = new Object();
									}
									stdMap[stdPrefix].stock = o.value;
								}
							}

							for ( var k in stdMap) {
								var std = stdMap[k];
								stdMap[std.values] = std;
								delete stdMap[k];
							}

							return stdMap;
						}

						$("#ctgDivCancel").click(function() {
							$("#ctgDiv").hide();
						});

						$(".delFile").live('click', function() {
							var id = $(this).attr("id");
							$("#tr" + id).remove();
						});

						$("#addFile")
								.click(
										function() {
											var s = '<tr id="tr'+fileCount+'"><td><input  name="files" type="file"/></td><td><input id="'+fileCount+'" type="button" value="删除"  class="delFile"/></td></tr>';
											$("#uploadTable").append(s);
											fileCount++;
										});

					});
</script>
</head>
<body>
	<center>

		<%@ include file="menu.jsp"%>


		<div id="right">
			<p>商品添加</p>

			<div id="ctgDiv">
				<h2>选择商品分类</h2>
				<div id="ctgDivItems"></div>
				<div id="proBtnDiv">
					<input id='ctgDivBack' type="button" value="返回" /> <input
						id='ctgDivCancel' type="button" value="关闭" />
				</div>
			</div>

			<FORM id="myform" METHOD="POST" enctype="multipart/form-data"
				ACTION="sho/product/add.do">
				<table border="1" width="500">
					<tr>
						<td width=30%>类别</td>
						<td><span id="ctgName"></span> <INPUT id="ctgBtn"
							TYPE="button" value="选择"></td>
					</tr>
					<tr>
						<td>名称</td>
						<td><INPUT TYPE="text" NAME="title" value=""></td>
					</tr>
					<tr>
						<td>价格</td>
						<td><INPUT TYPE="text" NAME="price" value=""></td>
					</tr>
				</table>
				<table id="uploadTable" border="1" width="500">
					<tr>
						<td><input type="file" name="files"></td>
						<td><input type="button" id="addFile" value="添加"></td>
					</tr>
				</table>

				<table border="1" width="500">
					<tr>
						<td>描述</td>
						<td><textarea name="introduction" rows="3" cols="20"></textarea>
						</td>
					</tr>
				</table>

				<div id="tmps"></div>
				<div id="stds"></div>
				<p>
					<INPUT TYPE="submit" value="确定">
				</p>
				<br> <input type="hidden" name="status" value="0" /> <input
					type="hidden" name="shopId" value="0" /> <input id="ctgId"
					type="hidden" name="cid" value="0" />
			</FORM>
		</div>
	</center>
</body>
</html>