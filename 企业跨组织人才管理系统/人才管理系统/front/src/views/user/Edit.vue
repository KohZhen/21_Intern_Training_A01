<template>
    <el-dialog title="修改" :visible.sync="param.visible" @close="param.close" :close-on-click-modal="false">
        <r-form ref="myForm" :rules="rules" :form="form" :items="items" :save="save"></r-form>
    </el-dialog>
</template>

<script>
    import {update} from "@/api/user";
    import RForm from "@/components/RForm";
    export default {
        name: "Edit",
        props:{
            param:{
                type:Object,
                default:()=>{}
            }
        },
        components:{RForm},
        data(){
            return{
                form:{
                    id:'',
                    userName:'',
                    name:'',
                    password:'123456',
                },
                rules:{
                    userName:[{required:true,message:'用户名不能为空'}],
                    name:[{required:true,message:'姓名不能为空'}],
                    password:[{required:true,message:'密码不能为空'}],
                },
                items:[
                    {type:'text',label:'用户名',prop:'userName',name:'userName',placeholder:'请录入用户名'},
                    {type:'text',label:'姓名',prop:'name',name:'name',placeholder:'请录入姓名'},
                    {type:'password',label:'用户名',prop:'password',name:'password',placeholder:'请录入密码'},
                ]
            }
        },
        mounted() {
            this.form = JSON.parse(JSON.stringify(this.param.form));
        },
        methods:{
            save(){
                let flag = this.$refs['myForm'].validateForm();
                if(flag){
                    update(this.form).then(res=>{
                        this.$message.success(res.msg);
                        this.param.close();
                        this.param.callback();
                    })
                }
            }
        }
    }
</script>

<style scoped>

</style>