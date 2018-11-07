var url = "http://captain.natappvip.cc";

$(function () {
    getQrCode();
});

function getQrCode() {
    $.ajax({
        url: url+"/v1/alipay/qrCode",
        type: "post",
        dataType: "json",
        // async: false,
        // cache: false,
        success: function (data) {
            console.log(data);
            if(data.success === true){
                jQuery('#output').qrcode({width: 120,height: 120,background: "#ffffff",foreground: "#000000",text: encodeURI(data.url)});
            } else{
                alert("")
                return false;
            }
        }
    })
}

function pay() {
    $.ajax({
        url: url+"/v1/alipay/createOrder?invoiceId="+$("#invoiceId").val(),
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
                alert("")
                return false;
            }
        }
    })
}