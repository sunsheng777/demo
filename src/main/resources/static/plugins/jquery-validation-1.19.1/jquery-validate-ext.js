$(function() {
    /**
     * 全角文字（ひらがな・カタカナ・漢字 etc.）チェック
     */
    $.validator.addMethod("zenkaku", function (value, element, parameter) {
        // 空白の場合、何もしない
        if (value === '') return true;
        // 「\uFF61」〜「\uFF9F」の範囲はUnicodeで半角カナの範囲。
        return (/^[^\x01-\x7E\uFF61-\uFF9F]+$/.test(value)) ? true : false;
    }, "{0}は全角カナ文字を入力してください。");

    /**
     * 半角文字チェック（半角英数符号と半角カナ）
     */
    $.validator.addMethod("hankaku", function (value, element, parameter) {
        // 空白の場合、何もしない
        if (value === '') return true;
        // 「\uFF61」〜「\uFF9F」の範囲はUnicodeで半角カナの範囲。
        return (/^[\x01-\x7E\uFF61-\uFF9F]+$/.test(value)) ? true : false;
    }, "{0}は半角文字を入力してください。");

    /**
     * 半角英数字[a-zA-Z0-9-_]
     */
    $.validator.addMethod("alphaNumSymbol", function(value, element) {
        return this.optional(element) || /^[A-Za-z0-9_-]+$/.test(value);
    }, "{0}は半角英数字を入力してください。");

    /**
     * 半角英数字[a-zA-Z0-9]必須存在
     */
    $.validator.addMethod("hasAlphaNum", function(value, element) {
        // var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[])+$)([^(0-9a-zA-Z)]|[]|[a-zA-Z]|[0-9]){3,20}$/;
        var reg = /^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]+$/;
        return this.optional(element) || reg.test(value);
    },"{0}の入力形式が間違っています。");

    /**
     * picture check
     */
    $.validator.addMethod("checkPicture", function(value,element) {
        if (!value){
            return true;
        }
        var params = ['jpg','jpeg','png','gif'];
        if(value==""){
            return true;
        }
        var filetype=value.substring(value.lastIndexOf('.')+1,value.length);
        for (var i =0;i<params.length;i++){
            if (filetype.toLowerCase() == params[i]) {
                return true;
            }
        }
        scrollTo(0,0);
        return false;
    }, I18n.t('errors.messages.invalid'));

    /**
     * user ユーザー名 の　繰り返しチェック
     */
    $.validator.addMethod("uniqueCheckSignInName", function(value,element) {
        if (value == null || value == ''){
            return true;
        }
        var data = {};
        var id = $("#id").val();
        if (id){
            data = {
                "key":"sign_in_name",
                "value":value,
                "id":id
            };
        } else {
            data = {
                "key":"sign_in_name",
                "value":value
            };
        }
        var flag = false;
            $.ajax({
                url:baseURL + "student/students/check",
                type:'GET',
                data:data,
                async:false,
                success:function (r) {
                    if (r.user !== null){
                        flag = false;
                    }else {
                        flag = true;
                    }
                }
            });
            return flag;
    },I18n.t('errors.messages.taken'));

    /**
     * user メールアドレス の　繰り返しチェック
     */
    $.validator.addMethod("uniqueCheckEmail", function(value,element) {
        if (value == null || value == ''){
            return true;
        }
        var flag = false;
        var data = {};
        var id = $("#id").val();
        if (id){
            data = {
                "key":"email",
                "value":value,
                "id":id
            };
        } else {
            data = {
                "key":"email",
                "value":value
            };
        }
        $.ajax({
            url:baseURL + "student/students/check",
            type:'GET',
            data:data,
            async:false,
            success:function (r) {
                if (r.user !== null){
                    flag = false;
                }else {
                    flag = true;
                }
            }
        });
        return flag;
    },I18n.t('errors.messages.taken'));


    /**
     * unique存在
     */
    $.validator.addMethod("uniqueId", function(value, element) {
        return true
        // var keyId=toLine(element.name);
        // var result = "0";
        // if ($.trim(value) != "") {
        //     $.get(baseURL + "student/students/check", {"key": keyId,"value":value}, function (r) {
        //         result=r.isExist;
        //         if (result === "1") {
        //             console.log(result)
        //             return true;
        //         } else {
        //             console.log(result)
        //             return false;
        //         }
        //     });
        //    
        // }else{
        //     console.log("true")
        //     return true;
        // }
    },I18n.t('errors.messages.taken'));
});
