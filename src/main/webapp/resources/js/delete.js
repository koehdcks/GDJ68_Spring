let del = document.getElementById("del");
const c1 = document.getElementsByClassName("c1");
const frm = document.getElementById("frm");
const comm = document.getElementById("comm");


for(c of c1){
    c.addEventListener("click", function(){
        let url=this.getAttribute("data-url");
        if(url=='delete'){
            let result = confirm("삭제 할거냐???");
            if(!result){
                return;
            }
            frm.method='post';
        }
        frm.action=url;
        frm.submit();
    });
}

let bookNum;
//1. 함수 사용
function setBookNum(num){
    bookNum=num;
}


// del.addEventListener("click",function(){
// 	let result=confirm("삭제하시겠습니까?");
//     bookNum=del.getAttribute("data-delete-num");
//     let parameterName=del.getAttribute("data-delete-name");
// 	if(result){
// 	    location.href="./delete?"+parameterName+"="+bookNum;
// 	}
// });