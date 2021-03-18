<template>
  <div>

<!-- 导航 -->
<van-nav-bar title="同城租房"  style="font-size: 22px;" >
  
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
      src="https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00066-3363.jpg"
    />
  </van-swipe-item>
  <van-swipe-item>
    <van-image  
      fit="contain"
      src="https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00066-3363.jpg"
    />
  </van-swipe-item>
  <van-swipe-item>
    <van-image 
      fit="contain"
      src="https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00066-3363.jpg "
    />
  </van-swipe-item>
  <van-swipe-item>
    <van-image 
      fit="contain"
      src="https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00066-3363.jpg"
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
      
      <van-radio-group v-model="gender_other" direction="horizontal">
        <div style="margin-left:30px ">
          <a style=" font-weight:bold">性别 </a>
          <van-radio name="1">全部</van-radio>
          <van-radio name="2">男</van-radio>
          <van-radio name="3">女</van-radio>
        </div> 
        <div style="margin-left:30px "> 
          <a style=" font-weight:bold">类型 </a>
          <van-radio name="4">转租单间</van-radio>
          <van-radio name="5">转租整间</van-radio>
          <van-radio name="6">找室友</van-radio>
          <van-radio name="7">求合租</van-radio>
          <van-radio name="8">求整租</van-radio> 
          <van-radio name="9">整套出租</van-radio> 
          <van-radio name="10">单间出租</van-radio> 
        </div>
 
      </van-radio-group>
     
    </div>  
  </van-dropdown-item> 
    <van-dropdown-item v-model="value1" :options="option1" />
  </van-dropdown-item>


</van-dropdown-menu>




    <van-row>
      <van-col span="24"> 
          <!-- 展示区域 --> 
            <!-- <van-card v-for="(item,index) in phones"
                      :price="item.price"
                      :desc="item.desc"
                      :title="item.title"
                      :thumb="item.thumb"
            >
              <template #tags>
                <van-tag v-for="tag in item.tag" color="#f2826a" style="margin-left: 5px;">{{tag.name}}</van-tag>
              </template>
              <template #footer>
                <van-button round type="info" size="mini" @click="buy(index)">购买</van-button>
              </template>
            </van-card>   -->
      </van-col>
    </van-row>
    

    <van-tabbar v-model="active">
  <van-tabbar-item icon="home-o">首页</van-tabbar-item>
  <van-tabbar-item icon="back-top">发布</van-tabbar-item>
  <van-tabbar-item icon="user-o">我的</van-tabbar-item>  
</van-tabbar>



    <van-sku
            v-model="show"
            :sku="sku"
            :goods="goods"
            :hide-stock="sku.hide_stock"
            @buy-clicked="onBuyClicked"
    >
      <template #sku-actions="props">
        <div class="van-sku-actions">

          <!-- 直接触发 sku 内部事件，通过内部事件执行 onBuyClicked 回调 -->
          <van-button
                  square
                  size="large"
                  type="danger"
                  @click="props.skuEventBus.$emit('sku:buy')"
          >
            买买买
          </van-button>
        </div>
      </template>
    </van-sku>

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
                text:"l",
                id : 1
              },{
                text:"2",
                id : 2
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
                text:"l",
                id:1
              },{
                text:"2",
                id:2
              },
              {
                text:"3",
                id:3
              },
              {
                text:"4",
                id:4
              },
            ]
          },
        ],
      activeId: 1,
      activeIndex: 0,
      gender_other:'1', 
      money: [0,2500 ],//价格区间
        
        active: 0,  //下面的切换
      }
    },
    created(){
      const _this = this
      axios.get('http://localhost:8181/phone/index').then(function (resp) {
        _this.phones = resp.data.data.phones
        _this.categories = resp.data.data.categories
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
      buy(index){
        this.show = true
        const _this = this
        axios.get('http://localhost:8181/phone/findSpecsByPhoneId/'+this.phones[index].id).then(function (resp) {
          _this.goods = resp.data.data.goods
          _this.sku = resp.data.data.sku
        })
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
</style>