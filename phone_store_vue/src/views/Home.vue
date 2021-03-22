<template>
  <div>

    <!-- 导航 -->
    <van-nav-bar title="闪电租房"  style="font-size: 22px;padding:5px;" > 
    </van-nav-bar>

    <!-- 搜索 -->
    <van-search
      v-model="searchvalue"
      show-action
      label="地址"
      placeholder="请输入搜索关键词"
      @search="onSearch"
    >
      <template #action>
        <div @click="onSearch">搜索</div>
      </template>
    </van-search> 

    <!-- 图片轮播 -->
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
      <van-swipe-item>
        <van-image 
          fit="contain"
          src="../static/h1.jpg"
        />
      </van-swipe-item>
      <van-swipe-item>
        <van-image  
          fit="contain"
          src="../static/h2.jpg"
        />
      </van-swipe-item>
      <van-swipe-item>
        <van-image 
          fit="contain"
          src="../static/h3.jpg "
        />
      </van-swipe-item>
      <van-swipe-item>
        <van-image 
          fit="contain"
          src="../static/h4.jpg"
        />
      </van-swipe-item>
    </van-swipe>

    <!-- 下拉菜单 -->
    <van-dropdown-menu active-color="#1989fa"> 

      <van-dropdown-item title="区域" ref="item">
        <van-tree-select
          :items="locationItems"
          :active-id.sync="activeId"
          :main-active-index.sync="activeIndex"
        />
      </van-dropdown-item>


      <van-dropdown-item title="租金" ref="item">
        <div style="height:40px; margin-top:30px;">
          <van-slider v-model="money" range @change="moneyOnChange"  max = 5000 min = 0 />
        </div>
        
      </van-dropdown-item>


      <van-dropdown-item title="筛选" ref="item">
        <div style="text-align : left">

        <van-radio-group v-model="gender_other">
          <van-cell-group>
            <van-cell title="按性别分类"> 
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
            <van-cell title="全部" clickable @click="gender_other = '3'">
              <template #right-icon>
                <van-radio name="3" />
              </template>
            </van-cell>
            <van-cell title="按其他分类">
              <template #right-icon> 
              </template>
            </van-cell>
            <van-cell title="合租" clickable @click="gender_other = '4'">
              <template #right-icon>
                <van-radio name="4" />
              </template>
            </van-cell>
            <van-cell title="整租" clickable @click="gender_other = '5'">
              <template #right-icon>
                <van-radio name="5" />
              </template>
            </van-cell>
            <van-cell title="全部" clickable @click="gender_other = '6'">
              <template #right-icon>
                <van-radio name="6" />
              </template>
            </van-cell>
          </van-cell-group>
        </van-radio-group>
          
          <!-- <van-radio-group v-model="" direction="horizontal">
            <div style="margin-left:30px ">
              <a style=" font-weight:bold">性别 </a>
              <van-radio name="1">全部</van-radio>
              <van-radio name="2">男</van-radio>
              <van-radio name="3">女</van-radio>
            </div> 
            <div style="margin-left:30px "> 
              <a style=" font-weight:bold">类型 </a>
              <van-radio name="4"></van-radio>
              <van-radio name="5"></van-radio>
              <van-radio name="6"></van-radio>
              <van-radio name="7">求合租</van-radio>
              <van-radio name="8">求整租</van-radio> 
              <van-radio name="9">整套出租</van-radio> 
              <van-radio name="10">单间出租</van-radio> 
            </div>
    
          </van-radio-group> -->
        
        </div>  
      </van-dropdown-item> 
    
      <van-dropdown-item v-model="value1" :options="option1" /> 

    </van-dropdown-menu>




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






      <van-tabbar v-model="active" placeholder = true route = true>
        <van-tabbar-item replace to="/" icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item replace to="/update" icon="back-top">发布</van-tabbar-item>
        <van-tabbar-item replace to="/personalcenter" icon="user-o">我的</van-tabbar-item>  
      </van-tabbar>



    

  </div>


</template>

<script>
  import {
    Toast,
    PullRefresh,
    Swipe,
    SwipeItem
  } from 'vant';
  export default {
    comments:{
      [PullRefresh.name]: PullRefresh,
      [Swipe.name]: Swipe,
      [SwipeItem.name]: SwipeItem
    },
    data() {
      return {
        categories: '',
        phones: '',
        houses:'',
        show: true,
        sku: '',
        goods: '',
        searchvalue: "",//查询
        //下拉菜单
        value1: 0, 
        option1: [
          { text: '默认排序', value: 0 },
          { text: '价格最低', value: 1 },
          { text: '时间最新', value: 2 },
          { text: '距离最近', value: 3 }, 

        ],
        locationItems:[ 
          {
            text:"商圈",
            children:[
              {
                text:"崇安区",
                id : 1
              },
              {
                text:"南长区区",
                id : 2
              },
              {
                text:"北塘区",
                id : 3
              },
              {
                text:"新区",
                id : 4
              },
              {
                text:"滨湖区",
                id : 5
              },
              {
                text:"锡山区",
                id : 6
              },
              {
                text:"惠山区",
                id : 7
              },
            ]
          },{
            text:"附近",
            children:[
              {
                text:"不限",
                id:1
              },{
                text:"1KM",
                id:2
              },
              {
                text:"3KM",
                id:3
              },
              {
                text:"5KM",
                id:4
              },
            ]
          },{
            text:"地铁",
            children:[
              {
                text:"一号线",
                id:1
              },{
                text:"二号线",
                id:2
              },
              {
                text:"三号线",
                id:3
              },
              
            ]
          },
        ],
      activeId: 1,
      activeIndex: 0,
      gender_other:'1', 
      money: [1000,3500 ],//价格区间
        
        active: 0,  //下面的切换
      }
    },
    created(){
      
      const _this = this
      axios.get('http://www.wsscy.ltd/api/allhouse').then(function (resp) {
        _this.houses = resp.data
      })  

    },
    methods: {
      onClick(index) {
        const _this = this
        axios.get('http://localhost:8181/phone/findByCategoryType/'+this.categories[index].type).then(function (resp) {
          _this.phones = resp.data.data
        })
      },
      onSearch(val) {
        Toast(val);
      },
      showMore(index){
        // 路由跳转到http://localhost:8080/details?index 
        this.$router.push({path:'/particulars',query: {id:index}})
      },
      onBuyClicked(item){
        this.$store.state.specsId = item.selectedSkuComb.s1
        this.$store.state.quantity = item.selectedNum
        this.$router.push('/addressList')
      },moneyOnChange(money){
        Toast({ 
          message: money[0]+ " - " + money[1],
          position: 'middle',
        }); 
      }
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
  .van-nav-bar__title{
    font-size: 25px!important; 
  }
  .van-card__thumb img {
    border-radius: 2px!important;
  width:150%!important;
}
</style>