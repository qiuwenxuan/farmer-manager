<template>
  <div class="main-content">
    <div style="width: 65%; margin: 20px auto">
      <div style="text-align: center">
        <span style="font-size: 22px">{{ informationData.name }}</span>
        <span style="margin-left: 50px; color: #666666">时间：{{ informationData.time }}</span>
      </div>
      <div>
        <div v-html="informationData.content" class="w-e-text w-e-text-container" style="margin-top: 30px"></div>
      </div>
    </div>
  </div>
</template>

<script>


export default {

  data() {
    // 使用变量informationId获取网址传过来的id，如
    let informationId = this.$route.query.id
    return {
      //初始化infrmationId参数，使得外部可以调用该参数
      informationId: informationId,
      informationData: {}
    }
  },


  mounted() {
    this.loadInformation()
  },
  methods: {
    loadInformation() {
      // 传入获取到的网址的id查询information数据库信息
      this.$request.get('/information/selectById/' + this.informationId).then(res => {
        if (res.code === '200') {
          this.informationData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    }
  }
}
import information from "@/views/manager/Information.vue";

import informationDetial from "./InformationDetial.vue";
</script>

<style>
//给p标签等强制加样式，使得页面展示更自然美观
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
