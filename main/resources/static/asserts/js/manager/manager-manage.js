var ManagerManage = {

    editManager: function (mid) {
        console.log(mid);
        $.ajax({
            url: "/manage/manager/" + mid,
            type: "POST",
            success: function (res) {
                console.log(res.object);
                $("#mid").val(res.object.mid);
                $("#username").val(res.object.username);
                $("#editManagerModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });
            },
            fail: function () {
                alert("编辑失败，请重试！")
            }
        })
    },
    deleteManager: function (id) {
        $.ajax({
            url: "/manage/manager/delete/" + id,
            type: "POST",
            success: function (res) {
                alert(res.message);
                window.location.reload();
            }
        })
    },

    saveManagerAction: function () {
        var mid = $("#mid").val();
        var username = $("#username").val();
        var password = $("#password").val();

        $.ajax({
            url: "/manage/manager/update/",
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({
                mid: mid,
                username: username,
                password: password
            }),
            success: function (res) {
                alert(res.message);
                window.location.reload();
            }
        })
    }
};