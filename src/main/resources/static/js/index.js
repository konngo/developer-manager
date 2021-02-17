var mainMenu=Vue.extend({
    name:'main-menu',
    props:{item:{}},
    data(){
        return {
            flag:''
        }
    },
    template:[
        '<li @click="this.flag=item.id;" :class="flag==item.id?\'active\':\'\'"   >' +
        '   <a href="#" @click="changemenu(item)">' +
        '       <i  v-if="item.icon != null" :class="item.icon"></i> {{item.name}}' +
        '   </a>' +
        '</li>'
    ].join(),
    methods: {
        changemenu(data){
            this.$emit("changemenu",data)
        }
    }
})


var subMenu=Vue.extend({
    name:'sub-menu',
    props:{item:{}},
    template: [
        '<ul class="list-unstyled" :data-link="item.id">' +
        '    <li v-for="sub in item.list">' +
        '           <a href="#" @click="changemenu(sub.src)">' +
        '             <i :class="sub.icon"></i> <span class="d-inline-block">{{sub.name}}</span>' +
        '          </a>' +
        '     </li>' +
        '</ul>'
    ].join(),
    methods:{
        changemenu(item){
            this.$emit("changemenu",item)
        }
    }
})


//注册菜单组件
//Vue.component('main-menu',mainMenu);
//Vue.component('sub-menu',subMenu);

var vm=new Vue({
    el:'#kapp',
    data(){
        return {
            menulist: [
                {id: 'main', name: '首页', icon: 'iconsminds-shop-4'},
                {id: 'users/page', name: '员工', icon: 'simple-icon-user-female'},
                {id: 'roles/page', name: '岗位', icon: 'iconsminds-bus-2'},
                {id: 'labels/page', name: '标签', icon: 'iconsminds-air-balloon-1'},
                {id: 'skills', name: '技能', icon: 'iconsminds-roof', sub: 'true'},
                {id: 'bugresolve/page', name: 'BUG解决方案', icon: 'iconsminds-sunglasses-w-3'},
                {id: 'worklog/page', name: '工作日志', icon: 'iconsminds-sunglasses-w-3'},
            ],
            submenus: [
                // {id:"dashboard",list:[{src:'Dashboard.Default.html',icon:'simple-icon-rocket',name:'default'}]}
                {
                    id: "skills", list: [
                        {src: 'skilltype/page', icon: 'simple-icon-rocket', name: '技能分类'},
                        {src: 'skills/page', icon: 'simple-icon-rocket', name: '技能'}
                    ]
                }
            ],
            main: 'main',
            users: {},
            target: []
        }
    },
    methods:{
        chooseTarget(choose){
            var flag = false;
            for (var i = 0 ; i < this.target.length ; i++ ){
                if (this.target[i].name.indexOf(choose) != -1) {
                    if (this.target[i].add == true || this.target[i].update == true || this.target[i].delete == true){
                        flag = true
                    }
                }
            }
            return flag;
        },
        changemenu(item){
            this.main=item;
        },
        logout(){
            window.location.href="logout";
        },
        profile(){
            this.main="profile";
        },
        skills(){
            this.main="skills";
        },
        menuinit(){

        },
        getPermissionByRoles()
        {
            var self = this
            $.ajax({
                type: 'POST',
                url: host + "permissions/nowuser",
                data: { },
                success: function (response) {
                    if (response.code == 0) {
                        var permissions = response.aaData
                        self.target = initPermission(permissions)
                    }
                }
            });
        },
        initUser(){
            // 默认头像
            this.users.avatar='http://ftp.konngo.cn/demo011701/3c2f6c0f-8b1f-4726-a234-d30ddf8998b8.jpg';
            let self=this;
            $.ajax({
                type: 'POST',
                url: host+"users/nowuser",
                data: {},
                success: function (response){
                    if(response.code==0){
                        self.users=response.entity;
                        console.log(self.users)
                       // self.menuinit();
                    }
                }
            });
        }
    },created(){
        this.initUser();
        this.getPermissionByRoles();
    }
});


//iframe自适应
$(window).on('resize', function() {
    var $content = $('.content');
    $content.height($(this).height() );
    $content.find('iframe').each(function() {
        $(this).height($content.height());
    });
}).resize();
//main自适应
$(window).on('resize', function() {
    var $content = $('main');
    $content.height($(this).height() );
    $content.find('iframe').each(function() {
        $(this).height($content.height());
    });
}).resize();

