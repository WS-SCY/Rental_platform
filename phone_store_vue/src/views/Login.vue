<template>
  <div class="Login">
    <van-nav-bar title="登录"  fixed = true style = "padding:5px;"  />

    <van-form @submit="onSubmit" style = "margin-top:45%; margin-bottom:40%">
        <van-field
            v-model="username"
            name="login_tel"
            label="用户名"
            placeholder="用户名"
            :rules="[{ required: true, message: '请填写用户名' }]"
        />
        <van-field
            v-model="password"
            type="密码"
            name="login_password"
            label="密码"
            placeholder="密码"
            :rules="[{ required: true, message: '请填写密码' }]"
        />
        <div style="margin: 60px;">
            <van-button round block type="info" native-type="submit">登录</van-button>
            <van-button round block type="info" native-type="submit" style="margin-top: 20px;">注册</van-button>
        </div>
    </van-form>
    
    <van-tabbar v-model="active" placeholder = "true" route = "true">
        <van-tabbar-item replace to="/" icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item replace to="/update" icon="back-top">发布</van-tabbar-item>
        <van-tabbar-item replace to="/personalcenter" icon="user-o">我的</van-tabbar-item>  
    </van-tabbar>
  </div>
</template> 

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    onSubmit(values) {
        console.log('submit', values);
        const _this = this 
        const formData = new FormData() 
        formData.append('login_tel', values.login_tel) 
        formData.append('login_password', values.login_password)
        axios({
                url: 'http://www.wsscy.ltd/api/login', 
                method: 'post',  
                data:formData
            }).then(function (resp) { 
            sessionStorage.setItem("id", resp.data.id);
            _this.$router.push('/personalCenter')
        })  
        
    },
  },
};
</script>



<style> 
  .my-swipe .van-swipe-item {
    color: #fff;
    font-size: 20px;
    line-height: 10px;
    text-align: center;
    background-color: #ffffff;
  }

  .van-grid-item__text {
    color: #646566;
    font-size: 15px!important;
    line-height: 3.5!important;
    word-break: break-all;
}
</style>