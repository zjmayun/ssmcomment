$(function() {
	common.showMessage($("#message").val());
});



function search(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

function remove(id) {
	if(confirm("确定要删除这条广告吗？")) {
		$("#id").val(id);
		$("#mainForm").attr("action",$("#basePath").val() + "/ad/remove");
		$("#mainForm").submit();
	}
}

 
$("#checkAll").click(function(){
    $(":checkbox[name='select']").prop("checked","checked");
   });

function remo(){
	   var temp="";
	   var each="";
	   var select=document.getElementsByName("select");
	   for(var i=0;i<select.length;i++){
		   if(select[i].checked){
			   each=select[i].value;
			   temp=temp+","+each;
		   }
	   }
	   document.getElementById("subString").value=temp.substring(1,temp.length);
	   $("#mainForm").attr("action",$("#basePath").val() + "/ad/removeBatch");
	   $("#mainForm").submit();
}


function modifyInit(id) {
	$("#id").val(id);
	$("#mainForm").attr("action",$("#basePath").val() + "/ad/modifyInit");
	$("#mainForm").submit();
}