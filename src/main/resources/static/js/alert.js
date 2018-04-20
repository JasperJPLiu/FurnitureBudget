(function ($) {
    $.alerts = {
        alert: function (title, message, callback) {
            if (title == null) title = 'Alert';
            $.alerts._show(title, message, null, 'alert', function (result) {
                if (callback) callback(result);
            });
        },

        confirm: function (title, message, callback) {
            if (title == null) title = 'Confirm';
            $.alerts._show(title, message, null, 'confirm', function (result) {
                if (callback) callback(result);
            });
        },

        input: function (title, label, type, placeholder, callback) {
            if (title == null) title = 'Confirm';
            var input = '<div class="form-group">' +
                '<label for="inputConfirm" class="col-sm-6 control-label">' + label + '</label>' +
                '<div class="col-sm-6">' +
                '<input type="' + type + '" class="form-control" id="inputConfirm"' +
                'placeholder="' + placeholder + '">' +
                '</div>' +
                '</div>';
            var _html = "";
            _html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
            _html += '<div id="mb_msg">' + input + '</div><div id="mb_btnbox">';
            _html += '<input id="mb_btn_no" type="button" value="取消" class="btn btn-default"/>';
            _html += '<input id="mb_btn_ok" type="button" value="确定" class="btn btn-primary" style="margin-left: 5px"/>';
            _html += '</div></div>';
            $("body").append(_html);
            GenerateCss();
            $("#mb_btn_ok").click(function () {
                var i=$("#inputConfirm").val();
                $.alerts._hide();
                if (callback) callback(i);
            });
            $("#mb_btn_no").click(function () {
                $.alerts._hide();
                if (callback) callback(false);
            });
            $("#mb_btn_no").focus();
            $("#mb_btn_ok, #mb_btn_no").keypress(function (e) {
                if (e.keyCode == 13) $("#mb_btn_ok").trigger('click');
                if (e.keyCode == 27) $("#mb_btn_no").trigger('click');
            });
        },


        _show: function (title, msg, value, type, callback) {

            var _html = "";

            _html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
            _html += '<div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';
            if (type == "alert") {
                _html += '<input id="mb_btn_ok" type="button" value="确定" class="btn btn-primary"/>';
            }
            if (type == "confirm") {
                _html += '<input id="mb_btn_no" type="button" value="取消" class="btn btn-default"/>';
                _html += '<input id="mb_btn_ok" type="button" value="确定" class="btn btn-primary" style="margin-left: 5px"/>';
            }
            _html += '</div></div>';

            //必须先将_html添加到body，再设置Css样式
            $("body").append(_html);
            GenerateCss();

            switch (type) {
                case 'alert':

                    $("#mb_btn_ok").click(function () {
                        $.alerts._hide();
                        callback(true);
                    });
                    $("#mb_btn_ok").focus().keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) $("#mb_btn_ok").trigger('click');
                    });
                    break;
                case 'confirm':

                    $("#mb_btn_ok").click(function () {
                        $.alerts._hide();
                        if (callback) callback(true);
                    });
                    $("#mb_btn_no").click(function () {
                        $.alerts._hide();
                        if (callback) callback(false);
                    });
                    $("#mb_btn_no").focus();
                    $("#mb_btn_ok, #mb_btn_no").keypress(function (e) {
                        if (e.keyCode == 13) $("#mb_btn_ok").trigger('click');
                        if (e.keyCode == 27) $("#mb_btn_no").trigger('click');
                    });
                    break;
            }
        },
        _hide: function () {
            $("#mb_box,#mb_con").remove();
        }
    };
    // Shortuct functions
    myAlert = function (title, message, callback) {
        $.alerts.alert(title, message, callback);
    };

    myConfirm = function (title, message, callback) {
        $.alerts.confirm(title, message, callback);
    };

    myInput = function (title, label, type, placeholder, callback) {
        $.alerts.input(title,label,type,placeholder,callback);
    };


    //生成Css
    var GenerateCss = function () {

        $("#mb_box").css({
            width: '100%', height: '100%', zIndex: '99999', position: 'fixed',
            filter: 'Alpha(opacity=60)', backgroundColor: 'black', top: '0', left: '0', opacity: '0.6'
        })
        ;

        $("#mb_con").css({
            zIndex: '999999', width: '350px', height: 'auto', position: 'fixed', wordWrap: 'break-all',
            backgroundColor: 'White'
        });

        $("#mb_tit").css({
            display: 'block',
            color: '#444',
            padding: '15px',
            backgroundColor: '#fff',
            borderRadius: '15px 15px 0 0',
            borderBottomColor: '#f4f4f4',
            borderBottom: '1px solid #e5e5e5'
        });

        $("#mb_msg").css({
            padding: '15px', lineHeight: '40px', textAlign: 'center',
            color: '#4c4c4c'
        });

        $("#mb_ico").css({
            display: 'block', position: 'absolute', right: '10px', top: '9px',
            border: '1px solid Gray', width: '18px', height: '18px', textAlign: 'center',
            // lineHeight: '16px', cursor: 'pointer', borderRadius: '12px', fontFamily: '微软雅黑'
        });

        $("#mb_btnbox").css({
            textAlign: 'center', padding: '15px',
            borderTop: '1px solid #e5e5e5',
            borderTopColor: '#f4f4f4',
        });
        // $("#mb_btn_ok,#mb_btn_no").css({
        //     width: '80px',
        //     height: '30px',
        //     color: 'white',
        //     border: 'none',
        //     borderRadius: '4px'
        // });
        // $("#mb_btn_ok").css({backgroundColor: '#41a259'});
        // $("#mb_btn_no").css({backgroundColor: 'gray', marginRight: '40px'});


        //右上角关闭按钮hover样式
        $("#mb_ico").hover(function () {
            $(this).css({backgroundColor: 'Red', color: 'White'});
        }, function () {
            $(this).css({backgroundColor: '#DDD', color: 'black'});
        });

        var _widht = document.documentElement.clientWidth; //屏幕宽
        var _height = document.documentElement.clientHeight; //屏幕高

        var boxWidth = $("#mb_con").width();
        var boxHeight = $("#mb_con").height();

        //让提示框居中
        $("#mb_con").css({top: (_height - boxHeight) / 2 + "px", left: (_widht - boxWidth) / 2 + "px"});
    }


})(jQuery);