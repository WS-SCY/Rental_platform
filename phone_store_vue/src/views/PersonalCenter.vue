<template>
  <div class="personalcenter">
    <van-nav-bar title="个人中心"  style="font-size: 22px;padding:5px;" > 
    </van-nav-bar>
    <van-card   
      desc="超级管理员账号"
      title="Ghibli"
      thumb="../static/logo.png" 
      id = "mylogo"
    />
    <van-grid clickable = true :column-num="2">
      <van-grid-item icon="home-o" text="我发布的" to="/myrelease" />
      <van-grid-item icon="star-o" text="我收藏的" to="/mycollection" />
    </van-grid> 
    <van-tabbar v-model="active" placeholder = "true" route = "true">
        <van-tabbar-item replace to="/" icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item replace to="/update" icon="back-top">发布</van-tabbar-item>
        <van-tabbar-item replace to="/personalcenter" icon="user-o">我的</van-tabbar-item>  
      </van-tabbar>
  </div>
</template>
<style scoped> 

</style>

