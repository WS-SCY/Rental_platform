<template>
  <div class="Particulars">
    <van-nav-bar   left-text="返回" :title=myhouse.distric fixed = true  left-arrow @click-left="onClickLeft" style="font-size: 22px;padding:5px;"  />

    <h3> {{myhouse.distric}}</h3> 

    <!-- 轮播 -->
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
      <van-swipe-item v-for="i in pics">
          <van-image 
            fit="cover"
            :src="i.pic"
          />
      </van-swipe-item>
    </van-swipe>
<van-grid clickable = true >
      <van-grid-item text="1室1厅1卫" />
      <van-grid-item text="32平方" />
      <van-grid-item text="21层" />
      <van-grid-item text="朝南" />
    </van-grid>
    <!-- 特点 -->
    <div style = "text-align:left;">
      <h4>配套设施</h4>
      <div style="width:100%;margin-top:-20px;">
        <van-image 
          src="../static/IMG_20210319_091048.jpg"
        />  
      </div>
    </div> 

    <div style = "text-align:left;">
      <h4>基本介绍</h4>
      <p style = "margin-top:-20px;"> {{myhouse.introduction}} </p>
    </div>
    <div style = "text-align:left; margin-bottom:80px">
      <h4>房源优点</h4>
      <p style = "margin-top:-20px;"> 1、客厅宽敞舒适、落地阳台，光线充足。2、卧室非常温馨，面积特别合理。3、厨房宽敞，让您和家人有足够的空间展现私家厨艺。4、连接客厅和厨房之间是您和家人享受美味的餐厅，让您热情的招待亲朋好友5、环境优美适宜居住人文素质高物业管理完善。6、小区治安好；安静安全。7、小区属于低密度社区，非常适宜居住。8、小区绿化率极好，让您感受花园一样的家。9、交通便利。出行极简。 </p>
      
    </div>
    
    <van-goods-action >
    <van-goods-action-icon icon="star" text="已收藏" color="#ff5000" />
    <van-goods-action-icon icon="chat-o" text="卖家"  />
    <van-goods-action-icon  text="   " color="#ff5000" />
    <van-goods-action-button
      type="primary"
      text="2500元/月"
      color="#4395FF"
      @click="onClickButton"
    />
</van-goods-action>

    
    <!-- 文本 -->

  </div>
</template> 

<script>
export default{
    data() {
      return {
        houses:"",
        myhouse:{"area":100,"brifintroduction":"距离地铁江南大学848米","created_at":1616107831000,"distric":"天鹅湖花园A区","gender":"均可","homeownerid":"1","icon":"../static/11.jpg","id":1,"introduction":"天鹅湖花园A区,有电梯,随时可租,可签约至2024-02-29,出租方式：整租, 看房时间：随时看房，区域：滨湖  太湖新城，地铁：距离地铁江南大学848米地图","price":2500,"rentedflag":false,"sharflag":false,"storey":24,"updated_at":1616122038000},
        pics:[{pic:"../static/33.jpg"},{pic:"../static/44.jpg"},{pic:"../static/11.jpg"},{pic:"../static/22.jpg"}]
      }
    },
    created(){
      // const _this = this
      // axios.get('http://localhost:9000/allhouse').then(function (resp) {
      //   _this.houses = resp.data
      // })   
      // axios.get('http://localhost:9000/pic/$route.query.id ').then(function (resp) {
      //   _this.pics = resp.data
      // })   
      // for(i in this.houses){
      //   if(i.id == $route.query.id ){
      //     this.myhouse = i;
      //   }
      // }
    } ,
    methods:{
      onClickLeft(){
         this.$router.go(-1)
      },
    }
}
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