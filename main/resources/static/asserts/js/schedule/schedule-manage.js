var GradeManage = {

    editGrade: function (id) {
        console.log(id);
        $.ajax({
            url: "/schedule/" + id,
            type: "POST",
            success: function (res) {
                console.log(res.object);
                $("#id").val(res.object.id);
                $("#DriverName").val(res.object.name);
                $("#score").val(res.object.score);
                $("#editScoreModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });
            }
        })
    },

    saveScoreAction: function () {
        var id = $("#id").val();
        var score = $("#score").val();

        $.ajax({
            url: "/schedule/update/",
            type: "POST",
            data: {
                id: id,
                score: score
            },
            success: function (res) {
                alert("修改成功");
                window.location.reload();
            }
        })
    },

    generate: function (driverId, year, month) {
        $.ajax({
            url: "/schedule/generateCertify/",
            type: "POST",
            data: {
                driverId: driverId,
                year: year,
                month: month
            },
            success: function (res) {
                console.log(res);
                window.open("study?Certification="+res);
            }
        })
    }
};