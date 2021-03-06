var url = "http://captain.natappvip.cc";

$(function () {
    getQrCode();
});

function getQrCode() {
    $.ajax({
        url: url+"/version1/pay/pay/qrCode",
        type: "post",
        dataType: "json",
        // async: false,
        // cache: false,
        success: function (data) {
            console.log(data);
            if(data.success === true){
                jQuery('#output').qrcode({width: 120,height: 120,background: "#ffffff",foreground: "#000000",text: encodeURI(data.alipay_url)});
                jQuery('#output1').qrcode({width: 120,height: 120,background: "#ffffff",foreground: "#000000",text: encodeURI(data.wechat_url)});
            } else{
                alert("")
                return false;
            }
        }
    })
}

function pay() {
    $.ajax({
        url: url+"/version1/pay/pay/createOrder?invoiceId="+$("#invoiceId").val(),
        type: "post",
        dataType: "json",
        // async: false,
        // cache: false,
        success: function (data) {
            console.log(data);
            if(data.success === true){
                $("#btn_div").remove();
                $("#form_div").append(data.content);
            } else{
                alert("");
                return false;
            }
        }
    })
}