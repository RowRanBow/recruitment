var QuestionManage = {

    deleteQuestion: function (id) {
        $.ajax({
            url: "/question/delete/" + id,
            type: "POST",
            success : function (res) {
                if (res.status == 200){
                    alert(res.message);
                    window.location.reload();
                }else {
                    alert("请选择正确题目！");
                    window.location.reload();
                }
            }
        })
    },

    editQuestion: function (id) {
        console.log(id);
        $.ajax({
            url: "/question/"+ id,
            type: "POST",
            success: function (res) {
                console.log(res.object);
                $("#updateQuestionIndex").val(res.object.id);
                $("#updateQuestionContent").val(res.object.content);
                $("#updateOptionA").val(res.object.optionA);
                $("#updateOptionB").val(res.object.optionB);
                $("#updateOptionC").val(res.object.optionC);
                $("#updateOptionD").val(res.object.optionD);
                $("#updateQuestionAnswer").val(res.object.answer);
                $("#updateQuestionScore").val(res.object.score);
                $("#editQuestionModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });
            }
        })
    },
    
    saveQuestionAction: function () {
        var index = $("#updateQuestionIndex").val();
        var content = $('#updateQuestionContent').val();
        var optionA = $('#updateOptionA').val();
        var optionB = $('#updateOptionB').val();
        var optionC = $('#updateOptionC').val();
        var optionD = $('#updateOptionD').val();
        var answer = $('#updateQuestionAnswer').val();
        var score = $('#updateQuestionScore').val();

        $.ajax({
            url: "/question/update/",
            type: "POST",
            contentType : "application/json;charset=UTF-8",
            data: JSON.stringify({
                id: index,
                content: content,
                optionA: optionA,
                optionB: optionB,
                optionC: optionC,
                optionD: optionD,
                answer: answer,
                score: score
            }),
            success: function (res) {
                alert(res.message);
                window.location.reload();
            }
        })
    }
};