var DriverManage = {

    deleteDriver: function (did) {
        $.ajax({
            url: "/driver/delete/" + did,
            type: "POST",
            success: function (result) {
                console.log("删除成功");
                alert(result.message);
                window.location.reload();
            }
        })
    },

    approveDriver: function (did) {
        $.ajax({
            url: "/driver/approve/" + did,
            type: "POST",
            success: function (result) {
                alert(result.message);
                window.location.reload();
            }
        })
    },

    getDriverImage: function (id) {
        $.ajax({
            url: "/driver/getImage/" + id,
            success: function (res) {
                console.log(res.object);
                $("#imageBody").html("<img style='width: auto;height: auto;max-height: 100%;max-width: 100%' src='/images/" + res.object.positiveLicenseImg + "'>" +
                    "<img style='width: auto;height: auto;max-height: 100%;max-width: 100%' src='/images/" + res.object.negativeLicenseImg + "'>" +
                    "<img style='width: auto;height: auto;max-height: 100%;max-width: 100%' src='/images/" + res.object.certificateBaseImg + "'>" +
                    "<img style='width: auto;height: auto;max-height: 100%;max-width: 100%' src='/images/" + res.object.certificateHonestImg + "'>");
                $("#imageModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });

            }
        })
    },

    editDriver: function (did) {
        $.ajax({
            url: "/driver/" + did,
            type: "POST",
            success: function (res) {
                console.log(res);
                $("#did").val(res.object.did);
                $("#name").val(res.object.name);
                $("#phone").val(res.object.phone);
                $("#license").val(res.object.license);
                $("#password").val(res.object.password);
                $("#identity").val(res.object.identity);
                $("#editDriverModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });
            }
        })
    },

    saveDriverAction: function () {
        var did = $("#did").val();
        var name = $("#name").val();
        var phone = $("#phone").val();
        var license = $("#license").val();
        var password = $("#password").val();
        var identity = $("#identity").val();

        $.ajax({
            url: "/driver/saveDriver/",
            type: "POST",
            contentType : "application/json;charset=UTF-8",
            data: JSON.stringify({
                did: did,
                name: name,
                phone: phone,
                license: license,
                password: password,
                identity: identity
            }),
            success: function (res) {
                alert(res.message);
                window.location.reload();
            }
        })
    }

};