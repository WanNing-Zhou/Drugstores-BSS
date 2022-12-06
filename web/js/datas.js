// 表单操作
function showlist(datas,htmlTag){
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
function setHref(el, value) {
    //el document实例  value herf值
    //el 如var alib = document.getElementById("test");
    el.setAttribute("href", encodeURI(value));
}