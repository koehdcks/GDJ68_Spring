{/* 
<div class="mb-5">
<label for="formPic" class="form-label">사진첨부</label> <input
    type="file" name="photos" id="formPic">
</div> */}

const addFile=document.getElementById("addFile");
const fileList=document.getElementById("fileList");
const delets = document.getElementsByClassName("delets");

let count=0;
if(delets != null){
    count=delets.length;
    alert(count);
}
let idx=0;
let max=5;

for(let i=0;i<delets.length;i++){
    delets[i].addEventListener("click",function(){
        let num = delets[i].getAttribute("data-delete-num");
        let check = confirm("삭제시 복구 불가");
        if(check){
            fetch("./fileDelete?fileNum="+num, {method:'get'})
                .then((result)=>{return result.text()})
                .then((r)=>{
                    if(r.trim()=='1'){
                        this.previousSibling.previousSibling.remove();
                        this.remove();
                        count--;
                    }
                })
        }
    })
}

fileList.addEventListener("click",function(event){
    let cl = event.target.classList;
    if(event.target.classList.contains("df")){
        let deleteId=event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();
        count--;
    }
});


addFile.addEventListener("click",function(){
    if(count<max){
        //div
        let dv = document.createElement("div");//<div></div>
        let atb=document.createAttribute("class");//class=
        atb.value="input-group mb-3";//class="input-group mb-3"
        dv.setAttributeNode(atb);//<div class="input-group mb-3"></div>
        atb = document.createAttribute("id");
        atb.value="file"+idx;
        dv.setAttributeNode(atb);
        //label
        let element = document.createElement("label");//<label></label>
        atb = document.createAttribute("for");//for=
        atb.value="formPic";//for="formPic"
        element.setAttributeNode(atb);//<label for="formPic">
        atb=document.createAttribute("class");//class=
        atb.value="form-label";//class="from-label"
        element.setAttributeNode(atb);//<label for="formPic" class="form-label">
        atb = document.createTextNode("사진첨부");//사진첨부
        element.appendChild(atb);//<label for="formPic" class="form-label">사진첨부</label>
        dv.appendChild(element);
        //<div class="input-group mb-3">
        //  <label for="formPic" class="form-label">사진첨부</label>
        //</div>
        //input
        element=document.createElement("input");//<input></input>
        atb=document.createAttribute("type");//type=
        atb.value="file";//type="file"
        element.setAttributeNode(atb);//<input type="file">
        atb=document.createAttribute("name");//name=
        atb.value="photos";//name="photos"
        element.setAttributeNode(atb);//<input type="file" name="photos">
        atb=document.createAttribute("id");//id=
        atb.value="formPic";//id="formPic"
        element.setAttributeNode(atb);//<input type="file" name="photos" id="formPic">
        dv.appendChild(element);
        //<div class="input-group mb-3">
        //  <label for="formPic" class="form-label">사진첨부</label>
        //  <input type="file" name="photos" id="formPic">
        //</div>
        let s = document.createElement("span");
        let t = document.createTextNode("X");
        s.appendChild(t);
        atb= document.createAttribute("class");
        atb.value="df";
        s.setAttributeNode(atb);
        atb=document.createAttribute("data-id");
        atb.value="file"+idx;
        s.setAttributeNode(atb);
        dv.appendChild(s);
        fileList.appendChild(dv);
        count++;
        idx++;
    }else{
        alert("파일은 5개가 최대");
    }
    
});

