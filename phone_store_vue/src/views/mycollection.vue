<template>
  <div>

    <!-- 导航 -->
    <van-nav-bar title="我的收藏"  left-text="返回" left-arrow @click-left="onClickLeft"  style="font-size: 22px;padding:5px;" > 
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
          houses: [{"area":35,"brifintroduction":"距离地铁少年宫1106米","created_at":1616106031000,"distric":"星光广场三期","gender":"均可","homeownerid":"2","icon":"../static/88.jpg","id":4,"introduction":"中海凤凰璟园公寓楼型：其他电梯：有电梯起租日期：随时可租可签约至：2023-03-10出租方式：整租看房时间：随时看房区域：滨湖  太湖新城地铁：距离地铁金匮公园1106米地图","price":1300,"rentedflag":false,"sharflag":false,"storey":23,"updated_at":1616122038000},{"area":100,"brifintroduction":"距离地铁江南大学848米","created_at":1616107831000,"distric":"长广溪/大学城·天鹅湖花园A区","gender":"均可","homeownerid":"1","icon":"../static/11.jpg","id":1,"introduction":"小区：天鹅湖花园A区楼型：其他电梯：有电梯起租日期：随时可租可签约至：2024-02-29出租方式：整租看房时间：随时看房区域：滨湖  太湖新城地铁：距离地铁江南大学848米地图","price":2500,"rentedflag":false,"sharflag":false,"storey":24,"updated_at":1616146259000},{"area":35,"brifintroduction":"距离地铁太湖花园1369米","created_at":1616104231000,"distric":"中海凤凰璟园公寓","gender":"男","homeownerid":"3","icon":"../static/99.jpg","id":3,"introduction":"中海凤凰璟园公寓楼型：其他电梯：有电梯起租日期：随时可租可签约至：2023-03-10出租方式：整租看房时间：随时看房区域：滨湖  太湖新城地铁：距离地铁金匮公园1106米地图","price":3400,"rentedflag":false,"sharflag":true,"storey":23,"updated_at":1616121954000}]
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
      },showMore(index){
        // 路由跳转到http://localhost:8080/details?index 
        this.$router.push({path:'/particulars',query: {id:index}})
      }
    }
  }
</script>


<style scoped>

</style>