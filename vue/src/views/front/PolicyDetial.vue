<template>
  <div class="main-content">
    <div style="width: 65%; margin: 20px auto">
      <div style="text-align: center">
        <div style="font-size: 22px">{{ policyData.name }}</div>
        <div style="margin-top: 20px; color: #666666">时间：{{ policyData.time }}
          <!--          显示点赞信息，使用div模型将标题和时间树状排序，span模型将点赞与时间横向排列-->
          <span style="margin-left: 30px">点赞：{{ policyData.num }}</span>
        </div>
      </div>
      <div>
        <div v-html="policyData.content" class="w-e-text w-e-text-container" style="margin-top: 30px"></div>
      </div>
    </div>
  </div>
</template>

<script>


export default {

  data() {
    // 使用变量policyId获取网址传过来的id，如
    let policyId = this.$route.query.id
    return {
      //初始化infrmationId参数，使得外部可以调用该参数
      policyId: policyId,
      policyData: {}
    }
  },


  mounted() {
    this.loadPolicy()
  },
  methods: {
    loadPolicy() {
      // 传入获取到的网址的id查询policy数据库信息
      this.$request.get('/policy/selectById/' + this.policyId).then(res => {
        if (res.code === '200') {
          this.policyData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    }
  }
}
import policy from "@/views/manager/Policy.vue";

import policyDetial from "./PolicyDetial.vue";
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
