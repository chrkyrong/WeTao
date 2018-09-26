/*显示商品类型*/
function sonSel(){//第一个下拉框调用此方法
    var second=$("#second");
    var cafather=$("#caFather").val();//获得第一个下拉框的值
    /*  alert(cafather);//测试是否获得*/
    if(cafather!=null&&cafather!=""&&cafather!=-1){
        //通过ajax将cafather传入后台处理
        $.post("findCafather",{cafather:cafather},function (data) {
            var option = "<option value=''>该类别</option>";
            for(var i=0;i<data.length;i++){
                var catagoryId=data[i].caId;//获取它的id值
                /* alert(data.length);//测试*/
                option+="<option value='"+catagoryId+"'>" +data[i].caName +" </option>";
            }
            second.html(option);
            second.selectpicker('refresh');
            second.selectpicker('render');

        })
    }
    else
    {
        var option = "<option value=''></option>";
        second.html(option);
        second.selectpicker('refresh');
        second.selectpicker('render');
    }
}

function loadpicture() {
    $('.js-zoom-images').magnificPopup({
        type: 'image',
        mainClass: 'mfp-with-zoom', // this class is for CSS animation below
        zoom: {
            enabled: true,
            duration: 300,
            easing: 'ease-in-out',
            opener: function(openerElement) {
                return openerElement.is('img') ? openerElement : openerElement.find('img');
            }
        }
    });
}
