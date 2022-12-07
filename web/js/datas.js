

// 表单操作最终版本
//第一个参数是数据, 参数二 编辑地址   参数三 删除地址 参数四根据什么删除
function showListEndPlus(datas,updateUrl,deleteUrl,deleteByWhat,isdrug,params){
    // console.log("进入showlist方法")
    // console.log(datas);
    // console.log(updateUrl);
    // console.log(deleteUrl);
    // console.log(deleteByWhat);
    // console.log(isdrug);
    console.log("params",params);
    //获取表单元素
    var tbody = document.querySelector('tbody');
    //将元素内得所有内容清空
    tbody.innerHTML = "";
    //遍历数据
    for(let i = 0;i<datas.length;i++){
        //创建tr
        var tr = document.createElement('tr');
        tbody.appendChild(tr);
        //行里面创建单元格td
        //遍历字段集合
        for(let pa = 0; pa < params.length; pa++){//遍历对象
            var td = document.createElement('td');
            // console.log(params[pa])
            td.innerHTML=datas[i][params[pa]];//
            //k得到的是属性名 obj[k]得到的是属性值
            tr.appendChild(td);
        }

        //药品的删除
        if (isdrug==true){
            var td =document.createElement('td');
            td.innerHTML= `<a class="del" href="${deleteUrl}?drugID=${datas[i]["drugID"]}&batchNumber=${datas[i]["batchNumber"]}"> 删除 </a>`;
            tr.appendChild(td);
        }
        else
        if(deleteUrl!=null && deleteUrl!=""){
            // console.log(deleteByWhat)
            var td =document.createElement('td');
            td.innerHTML= `<a class="del" href="${deleteUrl}?${deleteByWhat}=${datas[i][deleteByWhat]}"> 删除 </a>`;
            tr.appendChild(td);
        }

        //如果需要生成编辑编辑选项
        if (updateUrl!=null&&updateUrl!=""){
            // 创建编辑
            let td_2 = document.createElement('td');
            let htmlTag = `<a href="${updateUrl}?`;

            //构造参数
            for(let k in datas[i]){//遍历对象
                htmlTag += `${k}=${datas[i][k]}&`
            }

            htmlTag = htmlTag.substr(0, htmlTag.length - 1)
            htmlTag += `">编辑</a>`;

            td_2.innerHTML = htmlTag;
            tr.appendChild(td_2);
        }

    }
}



// 表单操作++
//第一个参数是数据, 参数二 编辑地址   参数三 删除地址 参数四根据什么删除
function showListPlus(datas,updateUrl,deleteUrl,deleteByWhat,isdrug){
    console.log("进入showlist方法")
    console.log(datas);
    console.log(updateUrl);
    console.log(deleteUrl);
    console.log(deleteByWhat);
    console.log(isdrug);
    //获取表单元素
    var tbody = document.querySelector('tbody');
    //将元素内得所有内容清空
    tbody.innerHTML = "";
    //遍历数据
    for(let i = 0;i<datas.length;i++){
        //创建tr
        var tr = document.createElement('tr');
        tbody.appendChild(tr);
        //行里面创建单元格td
        for(let k in datas[i]){//遍历对象
            var td = document.createElement('td');
            td.innerHTML=datas[i][k];//
            //k得到的是属性名 obj[k]得到的是属性值
            tr.appendChild(td);
        }

        //药品的删除
        if (isdrug==true){
            var td =document.createElement('td');
            td.innerHTML= `<a class="del" href="${deleteUrl}?drugID=${datas[i]["drugID"]}&batchNumber=${datas[i]["batchNumber"]}"> 删除 </a>`;
            tr.appendChild(td);
        }
        else
        if(deleteUrl!=null && deleteUrl!=""){
            console.log(deleteByWhat)
            var td =document.createElement('td');
            td.innerHTML= `<a class="del" href="${deleteUrl}?${deleteByWhat}=${datas[i][deleteByWhat]}"> 删除 </a>`;
            tr.appendChild(td);
        }

        //如果需要生成编辑编辑选项
        if (updateUrl!=null&&updateUrl!=""){
            // 创建编辑
            let td_2 = document.createElement('td');
            let htmlTag = `<a href="${updateUrl}?`;

            //构造参数
            for(let k in datas[i]){//遍历对象
                htmlTag += `${k}=${datas[i][k]}&`
            }

            htmlTag = htmlTag.substr(0, htmlTag.length - 1)
            htmlTag += `">编辑</a>`;

            td_2.innerHTML = htmlTag;
            tr.appendChild(td_2);
        }

    }
}


const hostURL = "http://localhost:8080"

//获取域名地址
function getHostURl(){
    return hostURL;
}



// 表单操作
function showlist(datas,url){
    var tbody = document.querySelector('tbody');
    tbody.innerHTML = "";
    for(var i = 0;i<datas.length;i++){
        //创建tr
        var tr = document.createElement('tr');
        tbody.appendChild(tr);
        //行里面创建单元格td
        for(var k in datas[i]){//遍历对象
            var td = document.createElement('td');
            td.innerHTML=datas[i][k];//
            //k得到的是属性名 obj[k]得到的是属性值
            tr.appendChild(td);
             }

            var td =document.createElement('td');
            td.innerHTML= '<a class="del" herf=""> 删除 </a>';
            tr.appendChild(td);
            // 创建编辑
            var td_2 = document.createElement('td');
            var htmlTag = document.createElement('a');

            td_2.innerHTML = htmlTag;
            tr.appendChild(td_2);
    }
}



//没有编辑与删除
function staffShowList(datas) {
    var tbody = document.querySelector('tbody');
    tbody.innerHTML = "";
    for(var i = 0;i<datas.length;i++){
        //创建tr
        var tr = document.createElement('tr');
        tbody.appendChild(tr);
        //行里面创建单元格td
        for(var k in datas[i]){//遍历对象
            var td = document.createElement('td');
            td.innerHTML=datas[i][k];//
            //k得到的是属性名 obj[k]得到的是属性值
            tr.appendChild(td);
            }
    }
}


//完全没有用
function showlistWithoutDel(datas,htmlTag) {
    var tbody = document.querySelector('tbody');
    tbody.innerHTML = "";
    for(var i = 0;i<datas.length;i++){
        //创建tr
        var tr = document.createElement('tr');
        tbody.appendChild(tr);
        //行里面创建单元格td
        for(var k in datas[i]){//遍历对象
            var td = document.createElement('td');
            td.innerHTML=datas[i][k];//
            //k得到的是属性名 obj[k]得到的是属性值
            tr.appendChild(td);
             }
            // 创建编辑
            var td_2 = document.createElement('td');
            td_2.innerHTML = htmlTag;
            tr.appendChild(td_2);
    }
}

//url获取、
function getURLParams() { //获取url中的参数,并以键值对的形式保存到对象中,返回一个对象

    const url = location.search; //获取url中"?"串
    let obj = {};
    if (url.indexOf('?') != -1) {

        let str = url.substr(1);
        let strs = str.split('&');
        for (let i = 0; i < strs.length; i++) {
            let key = strs[i].split('=')[0];
            let value = strs[i].split('=')[1];
            obj[key] = decodeURI(value);
        }
    }
    return obj;
}

//为a标签添加编码后的herf属性,来解决中文乱码问题
function setHref(el, value) {
    //el document实例  value herf值
    //el 如var alib = document.getElementById("test");
    el.setAttribute("href", encodeURI(value));
}


//get请求
// 获取数据, utl传入请求地址
// function getDate(Requesturl,updateUrl,deleteUrl,deleteByWhat,isDrug){
//     fetch(Requesturl,{
//         //使用get方法
//         method: 'GET',
//     })
//         .then((resp) => resp.json())
//         .then((resp) => {
//             showListPlus(resp,updateUrl,deleteUrl,deleteByWhat,isDrug);
//         })
//         .catch((error) => {
//             alert(error)
//         })
// }


//get请求
// 获取数据, utl传入请求地址
function getDate(Requesturl,updateUrl,deleteUrl,deleteByWhat,isDrug,params){
    fetch(Requesturl,{
        //使用get方法
        method: 'GET',
    })
        .then((resp) => resp.json())
        .then((resp) => {
            showListEndPlus(resp,updateUrl,deleteUrl,deleteByWhat,isDrug,params);
        })
        .catch((error) => {
            alert(error)
        })
}


function EXITFN(){
    fetch("/exit",{
        method:'GET'
    }).then((resp)=>{
        location.replace("../login/login.html")
    }).catch(error=>{
        console.log(error)
    })


}


