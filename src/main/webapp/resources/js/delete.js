let del = document.getElementById("del");

let bookNum;
//1. 함수 사용
function setBookNum(num){
    bookNum=num;
}

del.addEventListener("click",function(){
	let result=confirm("삭제하시겠습니까?");
    bookNum=del.getAttribute("data-delete-num");
    let parameterName=del.getAttribute("data-delete-name");
	if(result){
	    location.href="./delete?"+parameterName+"="+bookNum;
	}
});