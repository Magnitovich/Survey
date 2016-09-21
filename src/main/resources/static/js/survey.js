//$(document).ready(function() {
function verificationRadioBtn() {
        var email=$("#emailForSend").val();

    var selectedYachtForDelete = [];
    var i = 0;

    var arrayCheckboxClicked = $('input:checked')

    arrayCheckboxClicked.each(function(){
        var hasNextt = $(this);

        selectedYachtForDelete[i] = hasNextt[0].id;
        i++;
    });
    //selectedYachtForDelete.add(email);
    console.log(selectedYachtForDelete);
    $.ajax({   //тип запроса
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        type:"POST", //это типа method
        data: JSON.stringify(selectedYachtForDelete),

        url: '/deleteYacht/DELETE',
        success: function(data){  //msg - показывает ответ с сервера
            window.location.href = "yesItsAFinish";
            //yesItsAFinish
        }
    });
    //if (fistYes.prop("checked")) {
    //    console.log(fistYes.val());
    //} else {
    //    console.log(fistNo.val());
    //}

}
function RadioValidator()
{
    var email = $("#emailToSendPDF").val();
    var ShowAlert = '';
    var AllFormElements = window.document.getElementById("FormID").elements;
    for (i = 0; i < AllFormElements.length; i++)
    {
        if (AllFormElements[i].type == 'radio')
        {
            var ThisRadio = AllFormElements[i].name;
            var ThisChecked = 'No';
            var AllRadioOptions = document.getElementsByName(ThisRadio);
            for (x = 0; x < AllRadioOptions.length; x++)
            {
                if (AllRadioOptions[x].checked && ThisChecked == 'No')
                {
                    ThisChecked = 'Yes';
                    break;
                }
            }
            var AlreadySearched = ShowAlert.indexOf(ThisRadio);
            if (ThisChecked == 'No' && AlreadySearched == -1)
            {
                ShowAlert = ShowAlert + ThisRadio + ' radio button must be answered\n';
            }
        }
    }
    if (ShowAlert != '')
    {
        alert(ShowAlert);
        return false;

    } else if (email==="") {
        $("#validationEmail").show();
        return false;

    } else if(email !="")
    {
        verificationRadioBtn();

    }
}
function verification() {
    var arrayAnswer = [];
    var questionOneYes = "1. You say YES on answer one ";
    var questionOneNo = "1. You say NO on answer one ";
    var questionTwoYes = "2. You say YES on answer two ";
    var questionTwoNo = "2. You say NO on answer two ";
    var questionThreeYes = "3. You say YES on answer three ";
    var questionThreeNo = "3. You say NO on answer three ";
    var questionFourYes = "4. You say YES on answer four ";
    var questionFourNo = "4. You say NO on answer four ";
    var questionFiveYes = "5. You say YES on answer five ";
    var questionFiveNo = "5. You say NO on answer five ";
//});
    var fistYes = $("#questionOneYes");
    var fistNo = $("#questionOneNo");

    var twoYes = $("#questionTwoYes");
    var twotNo = $("#questionTwoNo");

    var threeYes = $("#questionThreeYes");
    var threeNo = $("#questionThreeNo");

    var fourYes = $("#questionFourYes");
    var fourNo = $("#questionFourNo");

    var fiveYes = $("#questionFiveYes");
    var fiveNo = $("#questionFiveNo");
    var addText;
    switch ("addText"){
        case "questionOneYes": addText = questionOneYes;
        break;
        case "questionOneNo":
            addText = questionOneNo;
            break;
        case "questionTwoYes":
            addText = questionTwoYes;
            break;
        case "questionTwoNo":
            addText = questionTwoNo;
            break;
        case "questionThreeYes":
            addText = questionThreeYes;
            break;
        case "questionThreeNo":
            addText = questionThreeNo;
            break;
        case "questionFourYes":
            addText = questionFourYes;
            break;
        case "questionFourNo":
            addText = questionFourNo;
            break;
        case "questionFiveYes":
            addText = questionFiveYes;
            break;
        case "questionFiveNo":
            addText = questionFiveNo;
            break;

            arrayAnswer.add(addText);
    }
}
//var sixYes = $("#questionSixYes");
//var sixNo = $("#questionSixNo");
//
//var sevenYes = $("#questionSevenYes");
//var sevenNo = $("#questionSevenNo");