<template>
    <el-aside :width="isCollapse?'64px':'200px'"><!--折叠网站旁边后，宽度会不一样 -->
        <div class="logo">
            <img src="~@/assets/images/PuzzleLogo.png" />
           PUZZLE
        </div>
        <el-menu
            background-color="#22262E"
            text-color="#ffffff"
            active-text-color="dodgerblue"
            style="border: 0px"
            :collapse="isCollapse"
            router
            :default-active="active">
            <el-menu-item @click="handleMenuItem(item)" :index="item.href" v-for="(item,index) in menus" :key="index">
                <i :class="item.icon"></i>
                <span slot="title">{{item.name}}</span>
            </el-menu-item>
        </el-menu>

    </el-aside>
</template>

<script>
    export default {
        name: "Sidebar",
        props:['isCollapse'],
        data(){
            return {
                menus:[],
                active:'',
            }
        },
        created() {
            this.$store.dispatch('getMenus').then(res=>{
                if(res){
                    this.menus = res.data
                    let  selectMenu;
                    if(this.$route.path){
                        this.active = this.$route.name
                        selectMenu =  this.menus.filter(v=>v.href == this.active)[0];
                    }else{
                        this.active = this.menus[0].href
                        selectMenu = this.menus[0]
                    }
                    this.handleMenuItem(selectMenu)
                }
            })
        },
        methods:{
            handleMenuItem(item){
                this.$emit('handleMenuItem',item)
            }
        }
    }
</script>

<style scoped>
.el-aside {
  background-color: black;
 transition: width .3s;
 overflow-x: hidden;
}

.logo{
    height: 60px;
    width: 200px;
    line-height: 60px;
    color: #ffffff;
    font-size: 18px;
    font-weight: 700;
    padding-left: 65px;
    box-sizing: border-box;
}
.logo img{
    position: absolute;
    width: 45px;
    height: 45px;
    left: 10px;
    top: 7px;
}
</style>