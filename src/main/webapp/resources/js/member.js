const input=document.getElementsByClassName("input");
const id=document.getElementById("id");
const btn=document.getElementById("btn");
const pw=document.getElementById("pw");
const pwIn=document.getElementById("pwIn");
const pw2=document.getElementById("pw2");
const pw2In=document.getElementById("pw2In");
const name1=document.getElementById("name1");
const nameIn=document.getElementById("nameIn");
const email=document.getElementById("email");
const emailIn=document.getElementById("emailIn");

email.addEventListener("blur",function(){
    emailIn.innerText="";
    if(email.value==''){
        emailIn.innerText="이메일을 입력하세요";
    }
});


name1.addEventListener("blur",function(){
    nameIn.innerText="";
    if(name1.value==''){
        nameIn.innerText="이름을 입력하세요";
    }
});

pw2.addEventListener("keyup",function(){
    pw2In.innerText="";
    for(let i=0;i<pw2.value.length;i++){
        if(pw2.value[i]!=pw.value[i]){
            pw2In.innerText="틀렸습니다";
        }
    }
    if(pw2.value==''){
        pw2In.innerText="비밀번호를 입력하세요";
    }
});

pw.addEventListener("blur",function(){
    const pwIn=document.getElementById(pw.id+"In");
    if(pw.value.length>5&&pw.value.length<13){
        pwIn.innerText="올바른 패스워드입니다.";
        pwIn.className='s';
    }else{
        pwIn.innerText="pw는 비어있으면 x,6~12글자 사이"
        pwIn.className='f';     
    }
})

id.addEventListener("blur",function(){
    const idIn=document.getElementById(id.id+"In");
    if(id.value == ''||id.value.length>10){
        idIn.innerText="ID는 비어있으면 x, 10글자 미만이어야 한다";
        idIn.className="f";
    }else{
        idIn.innerText="가능한 ID입니다.";
        idIn.className="s";
    }
});

btn.addEventListener("click",function(){
    for(let i=0;i<input.length;i++){
        if(input[i].value==''){
            alert("빈칸을 확인해주세요");
            input[i].focus();
            break;
        }
    }
});


