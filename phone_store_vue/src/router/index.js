import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import AddressList from '../views/AddressList'
import AddressNew from '../views/AddressNew'
import AddressEdit from '../views/AddressEdit'
import Detail from '../views/Detail'
import Particulars from '../views/Particulars'
import Success from '../views/Success'
import Info from '../views/Info'
import Update from '../views/Update'
import Login from '../views/Login'
import PersonalCenter from '../views/PersonalCenter'
import Myrelease from '../views/myrelease'
import Mycollection from '../views/mycollection'


Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/mycollection',
      name: 'Mycollection',
      component: Mycollection
    },
  {
    path: '/update',
    name: 'Update', 
    component: Update
  },
  {
    path: '/myrelease',
    name: 'Myrelease', 
    component: Myrelease
  },
  {
    path: '/login',
    name: 'Login', 
    component: Login
  },
  {
    path: '/particulars',
    name: 'Particulars', 
    component: Particulars
  },
  {
    path: '/personalcenter',
    name: 'PersonalCenter', 
    component: PersonalCenter
  },
  {
    path: '/addressList',
    name: '地址列表',
    component: AddressList
  },
  {
    path: '/addressNew',
    name: '新增地址',
    component: AddressNew
  },
  {
    path: '/addressEdit',
    name: '编辑地址',
    component: AddressEdit
  },
  {
    path: '/detail',
    name: '订单详情',
    component: Detail
  },
  {
    path: '/success',
    name: '付款成功',
    component: Success
  },
  {
    path: '/info',
    name: '订单信息',
    component: Info
  }
]

const router = new VueRouter({
  
  base: process.env.BASE_URL,
  // base : '/',
  routes, 
  mode: 'history',
}) 

router.beforeEach((to, from, next) => { 
  if (to.path == '/login') return next();// 访问路径为登录
  // 获取flag 
  const idFlag = sessionStorage.getItem("id");// session取值
  if (!idFlag && to.path == '/personalcenter') return next('/login');// 没登录去登录 
  next();
})

export default router// 暴露出去
