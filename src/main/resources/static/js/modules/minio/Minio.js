var vm = new Vue({
    el:"#vvm",
    created:function () {
        this.gettime();
        // this.getlist();
    },
    data:{
        time:0,
        onelist:[],
        list:[]
    },
    methods:{
        gettime:function(){
            $.ajax({
                type: "GET",
                url: "/minio/bucket/all",
                // contentType: "application/json",
                success: function (r) {
                    console.log("-------------------------------------" + r);

                    // vm.time = r.time;
                    // console.log(vm.time);
                    // var date = new Date(vm.time);
                    // $("#nowtime").replaceWith("<h1>" + date + "</h1>");
                }
            });
        },
        getlist:function(){
            $.ajax({
                type: "GET",
                url: "../../admin/list",
                // contentType: "application/json",
                success: function (r) {
                    vm.list = r.list;
                    for (var i = 0; i < r.list.length; i++) {
                        $("#tabletext").append(
                            "<tr><td class=\"td\">"+r.list[i].id+"</td><td class=\"td\">"+r.list[i].name+"</td><td class=\"td\">"+r.list[i].password+"</td></tr>"
                        );
                    }
                    // console.log(r.onelist);
                }
            });
        },
    }
});
console.log("miniotest")