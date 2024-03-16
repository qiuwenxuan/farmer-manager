<template>
  <div class="main-content">
    <div>
      <!-- 轮播图1，传入图片数组carouselData，圆边border-radius: 5px-->
      <el-carousel :interval="4000" type="card" height="300px">
        <el-carousel-item v-for="item in carouselData" :key="item">
          <img :src="item" alt="" style="width: 100%; height: 300px; border-radius: 5px">
        </el-carousel-item>
      </el-carousel>
    </div>
    <!-- 轮播图2，margin: 20px auto，表示垂直方向上下边距20px,水平自动居中-->
    <div style="width: 80%; margin: 20px auto">
      <div style="display: flex">
        <div style="width: 50%; height: 330px; margin-right: 18px; margin-top: 10px">
          <el-carousel height="330px">
            <el-carousel-item v-for="item in left" :key="item">
              <img :src="item" alt="" style="width: 100%; height: 330px">
            </el-carousel-item>
          </el-carousel>
        </div>
        <div style="width: 50%; height: 330px; margin-left: 18px">
          <el-tabs v-model="activeName">
            <el-tab-pane label="扶贫咨询" name="first">
              <!--              设置display: flex，将其设为弹性布局容器，及内部的<div>共享容器空间，div1为width: 150px，那么剩余的空间归div2所有-->
              <div style="display: flex; line-height: 48px; height: 48px" v-for="item in informationData">
                <!--                class="overflowShow"定义了一个css样式，如果字段过长，使用...隐藏超长的字段,cursor: pointer表示鼠标点击上去显示小手-->
                <!--                navTo()为一个跳转函数，后面接需要跳转的路径并传入item.id-->
                <div style="flex: 1; font-size: 17px; width: 0; cursor: pointer" class="overflowShow"
                     @click="navTo('/front/informationDetial?id='+item.id)">
                  {{ item.name }}
                </div>
                <div style="width: 150px; text-align: right; color: #a9a9b8; font-size: 15px">{{ item.time }}</div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="扶贫政策" name="second">
              <div style="display: flex; line-height: 48px; height: 48px">
                <div style="flex: 1; font-size: 17px; width: 0; cursor: pointer" class="overflowShow">
                  传承井冈山精神 带领村名过上好日子
                </div>
                <div style="width: 150px; text-align: right; color: #a9a9b8; font-size: 15px">2023-12-08</div>
              </div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
      <!--      margin 是一个缩写属性，表示按照顺时针顺序设置上、右、下、左四个方向的外边距。当只有两个值时，第一个值表示上下方向的外边距，第二个值表示左右方向的外边距-->
      <div style="text-align: center; color: #19a14b; font-size: 25px; font-weight: 550;margin: 40px 0">魅力农家乐</div>
      <el-row :gutter="20">
        <el-col :span="8" style="margin-bottom: 50px">
          <img src="@/assets/imgs/lun-1.png" alt="" style="width: 100%; height: 200px; border-radius: 10px">
          <div style="text-align: center; font-size: 16px; font-weight: 530; margin-top: 10px">
            江苏省苏州市【田园绿洲】
          </div>
        </el-col>
        <el-col :span="8" style="margin-bottom: 50px">
          <img src="@/assets/imgs/lun-1.png" alt="" style="width: 100%; height: 200px; border-radius: 10px">
          <div style="text-align: center; font-size: 16px; font-weight: 530; margin-top: 10px">
            江苏省苏州市【田园绿洲】
          </div>
        </el-col>
        <el-col :span="8" style="margin-bottom: 50px">
          <img src="@/assets/imgs/lun-1.png" alt="" style="width: 100%; height: 200px; border-radius: 10px">
          <div style="text-align: center; font-size: 16px; font-weight: 530; margin-top: 10px">
            江苏省苏州市【田园绿洲】
          </div>
        </el-col>
        <el-col :span="8" style="margin-bottom: 50px">
          <img src="@/assets/imgs/lun-1.png" alt="" style="width: 100%; height: 200px; border-radius: 10px">
          <div style="text-align: center; font-size: 16px; font-weight: 530; margin-top: 10px">
            江苏省苏州市【田园绿洲】
          </div>
        </el-col>
        <el-col :span="8" style="margin-bottom: 50px">
          <img src="@/assets/imgs/lun-1.png" alt="" style="width: 100%; height: 200px; border-radius: 10px">
          <div style="text-align: center; font-size: 16px; font-weight: 530; margin-top: 10px">
            江苏省苏州市【田园绿洲】
          </div>
        </el-col>
        <el-col :span="8" style="margin-bottom: 50px">
          <img src="@/assets/imgs/lun-1.png" alt="" style="width: 100%; height: 200px; border-radius: 10px">
          <div style="text-align: center; font-size: 16px; font-weight: 530; margin-top: 10px">
            江苏省苏州市【田园绿洲】
          </div>
        </el-col>
      </el-row>
      <div style="text-align: center; color: #19a14b; font-size: 25px; font-weight: 550">优质农产品</div>
      <div>
        <el-row :gutter="20">
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
          <el-col :span="4" style="margin-top: 30px">
            <img src="@/assets/imgs/荔枝王.jpg" alt=""
                 style="width: 100%; height: 180px; border-radius: 10px; border: 1px solid #cccccc">
            <div style="text-align: left; font-weight: 530; font-size: 16px; margin-top: 10px" class="overflowShow">
              阳光玫瑰
            </div>
            <div style="margin-top: 10px">
              <span style="color: red; margin-right: 30px">￥ 15</span>
              <el-button type="warning" size="mini">购买</el-button>
            </div>
          </el-col>
        </el-row>
      </div>

    </div>
  </div>
</template>

<script>

import information from "@/views/manager/Information.vue";

export default {
  computed: {
    information() {
      return information
    }
  },

  data() {
    return {
      carouselData: [
        require('@/assets/imgs/lun-1.png'),
        require('@/assets/imgs/lun-2.png'),
        require('@/assets/imgs/lun-3.png')
      ],
      left: [
        require('@/assets/imgs/lun-1.png'),
        require('@/assets/imgs/lun-2.png'),
        require('@/assets/imgs/lun-3.png')
      ],
      activeName: 'first',
      informationData: []
    }
  },

  //mounted是钩子函数，当组件被加载到页面上后自动执行的函数，会调用loadInformation方法，自动将informatio表当中的前6个数据显示在扶贫资讯一栏
  mounted() {
    this.loadInformation()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    // 加载扶贫咨询表的前6个数据到扶贫咨询一栏
    loadInformation() {
      this.$request.get('/information/top6').then(res => {
        if (res.code === '200') {
          this.informationData = res.data
        } else {
          this.message.error(res.msg)
        }
      })
    },

    // 跳转函数
    navTo(url) {
      location.href = url;
    }
  }
}
</script>

<!--带有css scoped属性，表示只会影响当前调用它的属性，
定义了一个名为 overflowShow 的样式类，
它会应用于元素，并使得元素内的文本不会换行，超出容器范围的文本部分将被隐藏，同时在被截断时以省略号-->
<style scoped>
.overflowShow {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
