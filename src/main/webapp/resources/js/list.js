const kind=document.getElementsByClassName("kind");
const k=document.getElementById("k");
const move=document.getElementsByClassName("move");
const page=document.getElementById("page");
const frm=document.getElementById("frm");
// let data='';

// //1.함수를 사용
// function setData(d){
//     data=d;
//     for(let i=0;i<kind.length;i++){
//         if(kind[i].value==data){
//             kind[i].selected=true;
//             break;
//         }
//     }
// }

//2.속성명data-?지정후 값저장한걸 가져오는방법

let data=k.getAttribute("data-kind")
for(let i=0;i<kind.length;i++){
    if(kind[i].value==data){
        kind[i].selected=true;
        break;
    }
}

for(let i=0;i<move.length;i++){
    move[i].addEventListener("click",function(){
        page.value=this.getAttribute("data-num")
        frm.submit();
    });
}

