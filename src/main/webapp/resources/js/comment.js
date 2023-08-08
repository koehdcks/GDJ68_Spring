const comment = document.getElementById("comment");
let bookNum = comment.getAttribute("data-comment-num");

fetch("/bankbook/comment?bookNum="+bookNum,{
    method:'get'
    })
    .then((response)=>{return response.text()})
    .then((r)=>{
        comment.innerHTML=r;
    })
