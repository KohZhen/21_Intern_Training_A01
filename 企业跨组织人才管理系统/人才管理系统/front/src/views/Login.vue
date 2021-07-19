<template>
  <div>
    <div class="login-header">
      <div class="login-main">
        <div class="system-title">
         企业跨组织人才管理系统网站
        </div>
      </div>
    </div>
    <div class="login-container">
      <div class="login-main">
        <div class="show"><img src="~@/assets/images/theme.png"></div>
        <div class="box">
          <div class="title">系统登录</div>
          <el-form ref="loginForm" :model="form" :rules="rules">
            <el-form-item prop="account">
              <el-input v-model="form.account" class="login-user" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input type="password" v-model="form.password" class="login-pwd" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-select v-model="form.type" placeholder="请选择类型">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="login" class="login-btn" :loading="false">登录</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
    <!--<div class="login-footer">
      本网站信息未经书面许可不得转载 浏览器推荐使用Chrome、FireFox、IE8.0以上版本
    </div>-->
  </div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return {
      form:{
        account:'admin',
        password:'123456',
        type:0,
      },
      options:[{label:'管理员',value:0},{label:'企业',value:1},{label:'普通用户',value:2}],
      rules:{
        account:[{required:true,message:"用户名不能为空!"}],
        password:[{required:true,message:"密码不能为空!"}],
      }
    }
  },
  methods:{
    login(){
      this.$refs['loginForm'].validate(valid=> {
        if (valid) {
          //用户登录操作
          this.$store.dispatch('login', this.form).then(res => {
            if (res.code == 200) {
              this.$router.push('/index');
            }
          })


        }
      });
    }
  }
}

</script>

<style scoped>
.login-header{
  height: 30%;
  width: 100%;
  position: absolute;
  top: 0px;
  background-color: white;

}
.login-container{
  width: 100%;
  position: absolute;
  top: 30%;
  bottom: 20%;
  background-color: white;


}
.login-main{
  width: 1200px;
  height: 100%;
  margin: auto;

}
.system-title{
  font-size: 40px;
  margin-top: 10%;
  font-style: italic;
  font-weight: bold;
  color: dodgerblue;
  background-color: white;
}
.show{
  float: left;
  position: absolute;
  bottom: 0;
  left: 70px;
  top: 0;
  padding-top: 60px;
  width: 750px;

}
.show img{
  height: 100%;
  display: block;
  margin: 0 auto;
}

.box{
  width: 30%;
  padding: 20px 40px;
  margin: 60px 0 20px;
  float: right;
  background-color: white;
  border-radius: 5px;
  border-style: solid;
  border-color: lightgrey;


}
.box .title{
  font-size: 26px;
  margin-bottom: 20px;
}
.login-btn{
  width: 100%;
  background-color: dodgerblue;
  border: 0px;
}
.login-btn:hover{
  width: 100%;
  background-color: deepskyblue;
  border: 0px;
}
.login-user >>> .el-input__inner{
  background: url('~@/assets/images/user.png') no-repeat center left;
  padding-left: 20px;
}
.login-pwd >>> .el-input__inner{
  background: url('~@/assets/images/password.png') no-repeat center left;
  padding-left: 20px;
}
.login-footer{
  position: absolute;
  bottom: 0px;
  height: 30%;
  width: 100%;
  text-align: center;
  color: #999999;
  padding-top: 20px;
  font-size: 14px;
  box-sizing: border-box;
  background-color: white;
}

</style>