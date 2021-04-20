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
/**
 * 图片压缩，默认同比例压缩
 * @param {Object} path 
 *   pc端传入的路径可以为相对路径，但是在移动端上必须传入的路径是照相图片储存的绝对路径
 * @param {Object} obj
 *   obj 对象 有 width， height， quality(0-1)
 * @param {Object} callback
 *   回调函数有一个参数，base64的字符串数据
 */

function dealImage(mybase64, obj){
  var img = new Image();
  img.src = mybase64; 
  var w = img.width,
  h = img.height,
  scale = w / h;
  w = obj.width || w;
  h = obj.height || (w / scale);
  var quality = 0.7;  // 默认图片质量为0.7
  //生成canvas
  var canvas = document.createElement('canvas');
  var ctx = canvas.getContext('2d');
  // 创建属性节点
  var anw = document.createAttribute("width");
  anw.nodeValue = w;
  var anh = document.createAttribute("height");
  anh.nodeValue = h;
  canvas.setAttributeNode(anw);
  canvas.setAttributeNode(anh); 
  ctx.drawImage(img, 0, 0, w, h);
  // 图像质量
  if(obj.quality && obj.quality <= 1 && obj.quality > 0){
    quality = obj.quality;
  }
  // quality值越小，所绘制出的图像越模糊
  var base64 = canvas.toDataURL('image/jpg', quality );
  // 回调函数返回base64的值
  return base64; 
}
function dataURLtoFile(base64Str, fileName) {
    var arr = base64Str.split(','),
    mime = arr[0].match(/:(.*?);/)[1], //base64解析出来的图片类型
    bstr = atob(arr[1]), //对base64串进行操作，去掉url头，并转换为byte   atob为window内置方法
    len = bstr.length,
    ab = new ArrayBuffer(len), //将ASCII码小于0的转换为大于0
    u8arr = new Uint8Array(ab); //
    while (len--) {
        u8arr[len] = bstr.charCodeAt(len)
    };
    // 创建新的 File 对象实例[utf-8内容，文件名称或者路径，[可选参数，type：文件中的内容mime类型]]
    return new File([u8arr], fileName, {
        type: mime
    })
};
 

export default{ 
    data() {
      return {
        district:'',
        storey:"",
        area:"",
        price:"",
        homeownerid:"", 
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
        // let myfile = this.fileList[0].file;
        // let param = new FormData(); 
        // param.set("distric", this.district );
        // param.set("storey", this.storey );
        // param.set("area",this.area  );
        // param.set("price", this.price );
        // param.set("homeownerid", this.homeownerid );
        // param.set("shareflag", this.sharflag ); 
        // param.set("brifintroduction", this.brifintrouduction );
        // param.set("gender", this.gender );
        // param.set("icon", this.icon);
        // param.set("introduction", this.introduction ); 
        // param.set("file", myfile);   

        // var myfile = dataURLtoFile(this.fileList[0].content,Date.now() + '.png')  //jpg   

        // console.log(myfile);
        // console.log(myfile.height);
        // console.log(myfile.width);
        
        
        // // 缩放图片需要的canvas
        // var canvas = document.createElement('canvas');
        // var context = canvas.getContext('2d');
        // var img = new Image();
        // img.src=this.fileList[0].content ;

        // var originWidth = img.width;
        // var originHeight = img.height;
        // // 最大尺寸限制
        // var maxWidth = 800, maxHeight = 800;
        // // 目标尺寸
        // var targetWidth = originWidth, targetHeight = originHeight;
        // // 图片尺寸超过400x400的限制
        // if (originWidth > maxWidth || originHeight > maxHeight) {
        //     if (originWidth / originHeight > maxWidth / maxHeight) {
        //         // 更宽，按照宽度限定尺寸
        //         targetWidth = maxWidth;
        //         targetHeight = Math.round(maxWidth * (originHeight / originWidth));
        //     } else {
        //         targetHeight = maxHeight;
        //         targetWidth = Math.round(maxHeight * (originWidth / originHeight));
        //     }
        // }
        // canvas.width = targetWidth;
        // canvas.height = targetHeight;
        // // 清除画布
        // context.clearRect(0, 0, targetWidth, targetHeight);
        // // 图片压缩
        // context.drawImage(img, 0, 0, targetWidth, targetHeight);
        
        // let myCanvas =$("#myCanvas").get(0); 
        // myCanvas.getContext('2d').drawImage(img,0,0);
        // myCanvas.getContext('2d').fillText("hh",50,50);
        // myCanvas.toDataURL('image/png')
/**
 * 图片压缩，默认同比例压缩
 * @param {Object} path 
 *   pc端传入的路径可以为相对路径，但是在移动端上必须传入的路径是照相图片储存的绝对路径
 * @param {Object} obj
 *   obj 对象 有 width， height， quality(0-1)
 * @param {Object} callback
 *   回调函数有一个参数，base64的字符串数据
 */
        var myRules = new Object();
        myRules.width = 800;
        myRules.height = 600;
        myRules.quality = 0.6;

        axios({ 
          url: 'http://www.wsscy.ltd/api/upload', 
          // url: 'http://localhost:9000/api/upload', 
          method: 'post',   
          data: { 
            distric:this.district,
            storey:this.storey,
            area:this.area,
            price:this.price,
            homeownerid:this.homeownerid, 
            shareflag:this.sharflag,
            brifintroduction:this.brifintrouduction,
            gender:this.gender, 
            introduction:this.introduction,  
            // file:  this.fileList[0].content ,
            file: dealImage(this.fileList[0].content,myRules)
            
          },   
          // data:param,
          transformRequest: [
              function (data) {
                let ret = ''
                for (let it in data) {
                    ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
                }
                ret = ret.substring(0, ret.lastIndexOf('&'));
                return ret
              }
            ],
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(
          res => {
            // 进行一些操作
            alert("添加数据完成！");
          }
        )
        // let file = this.fileList[0]; 
        // let formData = new window.FormData();
        // formData.append('file', file);
        // axios({
        //     method: "POST",
        //     // url: "http://www.wsscy.ltd/api/upload",
        //     url: "http://localhost:9000/api/upload",
        //     headers: {
        //         'Content-Type': 'multipart/form-data' //注意这里
        //     },
        //     data: formData
        // }).then((res) => {
        //     //这里返回保存的文件名
        //     app.saveFileName = res.data;
        // }).catch((err) => {
        //     console.log(err)
        // });  
        //  alert("成功提交");  
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