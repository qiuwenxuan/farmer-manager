<template>
  <div class="main-content">
    <div style="width: 65%; margin: 20px auto">
      <div style="text-align: center">
        <!--        获取agritainmentData数组的name和time属性作为跳转的农家乐详情的标题内容，agritainmentData数组是通过初始化调用mounted内的loadAgritainment方法自动赋值的-->
        <div style="font-size: 22px">{{ agritainmentData.name }}</div>
        <div style="margin-top: 20px; color: #666666">时间：{{ agritainmentData.time }}
        </div>
      </div>
      <div>
        <!--        获取agritainmentData内容作为文章内容-->
        <div v-html="agritainmentData.content" class="w-e-text w-e-text-container" style="margin-top: 30px"></div>
      </div>
    </div>
  </div>
</template>

<script>


export default {

  data() {
    // 使用变量agritainmentId获取网址传过来的id，如/front/agritainmentDetial?id=5
    let agritainmentId = this.$route.query.id
    return {
      //初始化agritainmentId参数，使得外部可以调用该参数
      agritainmentId: agritainmentId,
      agritainmentData: {}
    }
  },


  mounted() {
    this.loadAgritainment()
  },
  methods: {
    loadAgritainment() {
      // 传入获取到的网址的id查询agritainment数据库信息
      this.$request.get('/agritainment/selectById/' + this.agritainmentId).then(res => {
        if (res.code === '200') {
          this.agritainmentData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    }
  }
}

</script>

<style>
//给p标签等强制加美化样式，使得页面展示更自然美观
p {
  color: #3a3c40 !important;
  line-height: 30px !important;
}

ol {
  color: #3a3c40 !important;
  line-height: 30px !important;
  font-size: 15px !important;
}
</style>
