$(function() {
	common.showMessage($("#message").val());
});



function search(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

function remove(id) {
	if(confirm("确定要删除这条学生信息吗？")) {
		$("#id").val(id);
		$("#mainForm").attr("action",$("#basePath").val() + "/student/remove");
		$("#mainForm").submit();
	}
}

$("#checkAll").click(function(){
    $(":checkbox[name='select']").prop("checked","checked");
   });




function modifyInit(id) {
	$("#id").val(id);
	$("#mainForm").attr("action",$("#basePath").val() + "/student/modifyInit");
	$("#mainForm").submit();
}