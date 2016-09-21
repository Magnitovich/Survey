function sendBuyInJava() {
    //$('#sendMailInJava').submit(function (e) {
    //    e.preventDefault();

        $.ajax({   //тип запроса
            type: "POST", //это типа method
            url: '/survey/receive',
            data: {
                nameSelectedWhisky: $("#emailForSend").val(),

            },
            success: function (data) {  //msg - показывает ответ с сервера
                window.location.href = "survey";
                console.log(data)
            }
        })
    //})
}
