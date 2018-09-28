function storeOnload1() {
    var search = "";
    var condition = "商店";
    var stStatus = 0;
    // alert(search + "-" + condition + "-" + stStatus);
    $.ajax({
        url: '/store/researchStoreByCondition',
        type: 'post',
        data: {search: search, condition: condition, stStatus: stStatus},
        success: function (result) {
            var s = '';
            $.each(result.data, function (i, v) {
                s += '<tr><td>' + v.stId;
                s += '</td><td>' + v.stName;
                s += '</td><td>' + v.sAccount;
                if (v.stStatus == 0) {
                    s += '</td><td>正常';
                } else {
                    s += '</td><td>违规';
                }
                s += '</td><td>';
                s += '<a href = "seller_message.html?sellerId='+v.sellerId+'">查看商家</a>&nbsp;&nbsp;OR&nbsp;&nbsp;';
                s += '<a href = "seller_message.html?sellerId='+v.sellerId+'">拉黑</a></td></tr>';
            })
            // alert(s);
            $("#storeList").append(s);
        },
        error: function (result) {
            alert(result.message())
        }
    })
}