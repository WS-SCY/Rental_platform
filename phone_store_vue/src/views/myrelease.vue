<template>
  <div>

    <!-- 导航 -->
    <van-nav-bar title="我的发布"  left-text="返回" left-arrow @click-left="onClickLeft"  style="font-size: 22px;padding:5px;" > 
    </van-nav-bar>
  


      <van-row>
        <van-col span="24"> 
            <!-- 展示区域 -->  
              <van-card v-for="(item) in houses"
                        :price="item.price"
                        :desc="item.brifintroduction"
                        :title="item.distric"
                        :thumb="item.icon"
                        style=" border-radius: 2px!improtant;"
              >
                <template #tags style="marg">
                  <!-- <van-tag v-for="tag in item.tag" color="#f2826a" style="margin-left: 5px;">{{tag.name}}</van-tag> -->
                  <van-tag type="primary" style="margin: 5px;">面积：{{item.area}}</van-tag>
                  <van-tag type="primary" style="margin: 5px;">{{item.storey}}楼</van-tag>
                  
                  <div v-if = "item.sharflag==false"> <van-tag type="primary" style="margin-left: 5px;">合租</van-tag> </div>
                  <div v-else = "item.sharflag==false"> <van-tag type="primary" style="margin-left: 5px;">整租</van-tag> </div>
                  
                </template>
                <template #footer> 
                  <van-button round type="info" size="mini" @click="showMore(item.id)">详情</van-button>
                  <van-button round type="info" size="mini" @click="change()">编辑</van-button>
                </template>
              </van-card>  
        </van-col>
      </van-row> 


  </div>


</template>

<script> 
  export default { 
    data() {
      return {
          houses:[{"area":35,"brifintroduction":"距离地铁金匮公园1106","created_at":1613688631000,"distric":"东亭·恒大绿洲四期","gender":"女","homeownerid":"4","icon":"../static/33.jpg","id":2,"introduction":"\r\n小区：恒大绿洲四期楼型：其他电梯：无电梯起租日期：随时可租可签约至：2022-03-12出租方式：整租看房时间：随时看房区域：锡山  东亭地铁：距离地铁太湖花园1369米地图","price":3200,"rentedflag":false,"sharflag":true,"storey":23,"updated_at":1616121939000}],
      }
    },
    created(){
    //   const _this = this
    //   axios.get('http://localhost:9000/allhouse').then(function (resp) {
    //     _this.houses = resp.data
    //   })  
        // houses = [{"area":35,"brifintroduction":"距离地铁金匮公园1106","created_at":1613688631000,"distric":"东亭·恒大绿洲四期","gender":"女","homeownerid":"4","icon":"../static/33.jpg","id":2,"introduction":"\r\n小区：恒大绿洲四期楼型：其他电梯：无电梯起租日期：随时可租可签约至：2022-03-12出租方式：整租看房时间：随时看房区域：锡山  东亭地铁：距离地铁太湖花园1369米地图","price":3200,"rentedflag":false,"sharflag":true,"storey":23,"updated_at":1616121939000},{"area":35,"brifintroduction":"距离地铁金匮公园1106","created_at":1613688631000,"distric":"东亭·恒大绿洲四期","gender":"女","homeownerid":"4","icon":"../static/33.jpg","id":2,"introduction":"\r\n小区：恒大绿洲四期楼型：其他电梯：无电梯起租日期：随时可租可签约至：2022-03-12出租方式：整租看房时间：随时看房区域：锡山  东亭地铁：距离地铁太湖花园1369米地图","price":3200,"rentedflag":false,"sharflag":true,"storey":23,"updated_at":1616121939000}]
    },
    methods: {
      onClickLeft() {
        this.$router.push({path:'/personalcenter'})
      },
      showMore(index){
        // 路由跳转到http://localhost:8080/details?index 
        this.$router.push({path:'/particulars',query: {id:index}})
      },change(){
          console.log("功能未开放")
      }
    }
  }
</script>


<style scoped>

</style>