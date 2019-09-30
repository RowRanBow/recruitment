var VideoManage = {

    deleteVideo: function (id) {
        console.log(id);
        $.ajax({
            url: "/video/delete/" + id,
            type: "POST",
            success: function (res) {
                alert(res.message);
                window.location.reload();
            }
        })
    },

    editVideo: function (id) {
        $.ajax({
            url: "/video/" + id,
            type: "POST",
            success: function (res) {
                $("#videoTitle").val(res.object.videoTitle);
                $("#videoDuration").val(res.object.videoDuration);
                $("#id").val(res.object.id);
                $("#editVideoModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });
            }
        })
    },

    saveVideoAction: function () {
        var id = $("#id").val();
        var videoDuration = $("#videoDuration").val();
        var videoTitle = $("#videoTitle").val();
        $.ajax({
            url: "/video/update",
            type: "POST",
            data: {
                videoTitle: videoTitle,
                id: id,
                videoDuration: videoDuration
            },
            success: function (res) {
                alert("修改成功");
                window.location.reload();
            }
        })
    }
};