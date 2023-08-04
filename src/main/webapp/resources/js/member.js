const input=document.getElementsByClassName("input");
const id=document.getElementById("id");
const btn=document.getElementById("btn");
const pw=document.getElementById("pw");
const pw2=document.getElementById("pw2");
const name1=document.getElementById("name1");
const email=document.getElementById("email");
const birth=document.getElementById("birth");
const frm=document.getElementById("frm");
//check결과
let idCheckResult=false;
let pwCheckResult=false;
let pw2CheckResult=false;
let nameCheckResult=false;
let emailCheckResult=false;

let checkResults=[false, false, false, false, false, false];


//비어있는지 체크하는 함수
function emptyCheck(element){
    if(element.value==null||element.value.length==0){
        return true;
    }else{
        return false;
    }
}

birth.addEventListener("change",function(){
    let check = emptyCheck(birth);
    const birthIn=document.getElementById("birthIn");
    birthIn.innerHTML="비어있으면 X";
    birthIn.className="f";
    checkResults[5]=false;
    if(!check){
        birthIn.innerHTML="OK";
        birthIn.className="s";
        checkResults[5]=true;
    }
})

email.addEventListener("blur",function(){
    let check = emptyCheck(email);
    const emailIn=document.getElementById("emailIn");
    emailIn.innerHTML="비어있으면 X";
    emailIn.className="f";
    checkResults[4]=false;
    if(!check){
        emailIn.innerHTML="OK";
        emailIn.className="s";
        checkResults[4]=true;
    }
});


name1.addEventListener("blur",function(){
    let check = emptyCheck(name1);
    const nameIn=document.getElementById("nameIn");
    nameIn.innerHTML="비어있으면 X";
    nameIn.className="f";
    checkResults[3]=false;
    if(!check){
        nameIn.innerHTML="OK";
        nameIn.className="s";
        checkResults[3]=true;
    }
});

pw2.addEventListener("keyup",function(){
    const pw2In=document.getElementById("pw2In");
    if(pw2.value==pw.value){
        pw2In.innerText="비밀번호가 같다"
        pw2In.className="s"
        checkResults[2]=true;
    }else{
        pw2In.innerText="비밀번호가 틀리다"
        pw2In.className="f"
        checkResults[2]=false; 
    }
});
pw.addEventListener("change",function(){
    pw2.value="";
    checkResults[2]=false;
    pw2In.innerText="";
});

pw.addEventListener("blur",function(){
    const pwIn=document.getElementById(pw.id+"In");
    if(pw.value.length>5&&pw.value.length<13){
        pwIn.innerText="올바른 패스워드입니다.";
        pwIn.className='s';
        checkResults[1]=true;
    }else{
        pwIn.innerText="pw는 비어있으면 x,6~12글자 사이"
        pwIn.className='f';
        checkResults[1]=false;     
    }
})

id.addEventListener("blur",function(){
    const idIn=document.getElementById(id.id+"In");
    if(id.value == ''||id.value.length>10){
        idIn.innerText="ID는 비어있으면 x, 10글자 미만이어야 한다";
        idIn.className="f";
        checkResults[0]=false;
    }else{
        idIn.innerText="가능한 ID입니다.";
        idIn.className="s";
        checkResults[0]=true;
    }
});

btn.addEventListener("click",function(){
   let c = checkResults.includes(false);
   if(!c){
    //form전송
        // frm.submit();
   }else{
    alert("필수 항목 확인")
   }
});


