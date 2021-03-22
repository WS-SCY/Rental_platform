<template>
  <div class="update">


    <van-nav-bar title="发布房源" style="font-size: 22px;padding:5px;" > 
    </van-nav-bar>

    <van-radio-group v-model="sharflag" style="margin-top:20px">
      <van-cell-group>
        <van-cell title="租赁类型"> 
        </van-cell>
        <van-cell title="整租" clickable @click="gender_other = '1'">
          <template #right-icon>
            <van-radio name="1" />
          </template>
        </van-cell>
        <van-cell title="合租" clickable @click="gender_other = '2'">
          <template #right-icon>
            <van-radio name="2" />
          </template>
        </van-cell> 
      </van-cell-group>
    </van-radio-group>

    <van-radio-group v-model="gender">
      <van-cell-group>
        <van-cell title="性别限定"> 
        </van-cell>
        <van-cell title="男" clickable @click="gender_other = '1'">
          <template #right-icon>
            <van-radio name="1" />
          </template>
        </van-cell>
        <van-cell title="女" clickable @click="gender_other = '2'">
          <template #right-icon>
            <van-radio name="2" />
          </template>
        </van-cell>
        <van-cell title="都可以" clickable @click="gender_other = '3'">
          <template #right-icon>
            <van-radio name="3" />
          </template>
        </van-cell>
        
      </van-cell-group>
    </van-radio-group>
    

    <!-- 输入任意文本 -->
    <van-field v-model="district" label="地址" placeholder="请输入房源地址（小区名）"/>
    <!-- 输入手机号，调起手机号键盘 -->
    <van-field v-model="storey" type="digit" label="楼层" placeholder="请输入楼层" />
    <!-- 允许输入正整数，调起纯数字键盘 -->
    <van-field v-model="area" type="digit" label="面积" placeholder="请输入房源面积（平方米）" />
    <!-- 允许输入数字，调起带符号的纯数字键盘 -->
    <van-field v-model="price" type="digit" label="价格/月"  placeholder="请输入房源价格（元）"/>
    <!-- 输入密码 --> 
    <!-- 输入任意文本 -->
    <van-field v-model="brifintrouduction" label="首页简述" maxlength="16"  rows="2" placeholder="简单描述一下（16字以内）"/> 
    <!-- 允许输入正整数，调起纯数字键盘 --> 
    <van-field
      v-model="introduction"
      rows="4"
      autosize
      label="基本介绍"
      type="textarea"
      maxlength="180"
      placeholder="请输入介绍"
      show-word-limit
    />  

    <!-- 上传照片 -->
    <van-uploader v-model="fileList"  :after-read="afterRead"  multiple />

    <div>
      <van-button round type="info" size="normal"  @click="UpdateButton">发布信息</van-button>
    </div>
    


    <van-tabbar v-model="active" placeholder = "true" route = "true">
      <van-tabbar-item replace to="/" icon="home-o">首页</van-tabbar-item>
      <van-tabbar-item replace to="/update" icon="back-top">发布</van-tabbar-item>
      <van-tabbar-item replace to="/personalcenter" icon="user-o">我的</van-tabbar-item>  
    </van-tabbar>
  </div>
</template>

<script>

export default{ 
    data() {
      return {
        district:'',
        storey:"",
        area:"",
        price:"",
        homeownerid:"",
        rentedflag:"",
        sharflag:"",
        brifintrouduction:"",
        gender:"",
        icon:"",
        introduction:"",
        fileList: [ 
        ],
 
      }
    },
    created(){ 
    } ,
    methods:{
      UpdateButton(){
         //假装提交
         alert("成功提交");  
      },
      afterRead(file) {
        file.status = 'uploading';
        file.message = '上传中...';

        setTimeout(() => {
          file.status = 'successed';
          file.message = '上传';
        }, 1000);
      },
      
    }
}

</script>

<style scoped>
.van-cell { 
    text-align: left!important; 
}
</style>