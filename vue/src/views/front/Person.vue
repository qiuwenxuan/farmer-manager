<template>
  <div class="main-content">
    <el-card style="width: 50%; margin: 30px auto">
      <div style="text-align: right; margin-bottom: 20px">
        <el-button type="primary" @click="updatePassword">修改密码</el-button>
        <el-button type="warning" @click="rechargeInit">充 值</el-button>
      </div>
      <el-form :model="user" label-width="80px" style="padding-right: 20px">
        <div style="margin: 15px; text-align: center">
          <el-upload
              class="avatar-uploader"
              :action="$baseUrl + '/files/upload'"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
          >
            <img v-if="user.avatar" :src="user.avatar" class="avatar"/>
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </div>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="user.username" placeholder="用户名" disabled></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="user.phone" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="user.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <!--        添加个人中心“余额”一栏，将其改为disable不可更改状态-->
        <el-form-item label="余额" prop="account">
          <el-input v-model="user.account" placeholder="余额" disabled></el-input>
        </el-form-item>
        <div style="text-align: center; margin-bottom: 20px">
          <el-button type="primary" @click="update">保 存</el-button>
        </div>
      </el-form>
    </el-card>
    <el-dialog title="修改密码" :visible.sync="dialogVisible" width="30%" :close-on-click-modal="false"
               destroy-on-close>
      <el-form :model="user" label-width="80px" style="padding-right: 20px" :rules="rules" ref="formRef">
        <el-form-item label="原始密码" prop="password">
          <el-input show-password v-model="user.password" placeholder="原始密码"></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="newPassword">
          <el-input show-password v-model="user.newPassword" placeholder="新密码"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword">
          <el-input show-password v-model="user.confirmPassword" placeholder="确认密码"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
    <!--    充值窗口-->
    <el-dialog title="充值信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form label-width="100px" style="padding-right: 50px">
        <el-form-item prop="account" label="充值金额">
          <el-input v-model="account" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="type" label="支付方式">
          <!--          支付方式为一个单选框-->
          <el-radio v-model="type" label="微信">微信</el-radio>
          <el-radio v-model="type" label="支付宝">支付宝</el-radio>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="recharge">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请确认密码'))
      } else if (value !== this.user.newPassword) {
        callback(new Error('确认密码错误'))
      } else {
        callback()
      }
    }
    return {
      // 获取浏览器的本地存储的名为xm-user的数据并解析为JavaScript对象user
      //  1、JSON.parse(...) 用于将获取到的数据解析为 JavaScript 对象。
      //  2、|| '{}' 表示如果从本地存储中获取的数据为 null 或 undefined，则使用空对象 {} 作为默认值，避免解析错误。
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      // 小窗口的控制开关
      dialogVisible: false,
      // 充值小窗口
      fromVisible: false,
      // 支付金额
      account: null,
      // 默认支付方式
      type: "支付宝",
      rules: {
        password: [
          {required: true, message: '请输入原始密码', trigger: 'blur'},
        ],
        newPassword: [
          {required: true, message: '请输入新密码', trigger: 'blur'},
        ],
        confirmPassword: [
          {validator: validatePassword, required: true, trigger: 'blur'},
        ],
      }
    }
  },
  created() {  // 在组件实例被创建之后执行一些初始化逻辑
    // 初始化更新个人中心信息
    this.getPerson()
  },
  methods: {
    // 更新user的数据
    getPerson() {
      this.$request.get('/user/selectById/' + this.user.id).then(res => {
        if (res.code === '200') {
          this.user = res.data
          // 这里会出现一个问题：user获取到的data里面没有Token信息，当更新缓存之后前端页面没有Token会导致退出登录，因此我们需要在selectById接口给返回值user重新添加Token
          localStorage.setItem("xm-user", JSON.stringify(this.user))
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    // 充值
    recharge() {
      // 首先更新账户余额为原本的account+充值的account
      this.user.account = parseFloat(this.user.account) + parseFloat(this.account)
      // 调用user的update接口更新余额
      this.$request.put('/user/update', this.user).then(res => {
        if (res.code === '200') {
          this.$message.success('充值成功')
          /*这里需要注意的一点，account金额正确更新在数据库中且页面显示正确，但刷新之后页面account数据又变回去了。
          原因是页面上的account是登录时候的初始值，虽然更新了数据库但是页面数据未能同步*/
          // 方法一、及时同步数据库上的数据
          // 方法二、写一个函数getByUserId()将数据库真实的数据拿到并更新到界面
          localStorage.setItem("xm-user", JSON.stringify(this.user))
          // 关闭充值窗口
          this.fromVisible = false
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    // 初始化充值窗口
    rechargeInit() {
      // 默认支付金额为100
      this.account = 100;
      this.fromVisible = true
    },
    update() {
      // 保存当前的用户信息到数据库
      this.$request.put('/user/update', this.user).then(res => {
        if (res.code === '200') {
          // 成功更新
          this.$message.success('保存成功')
          // 更新浏览器缓存里的用户信息
          localStorage.setItem('xm-user', JSON.stringify(this.user))

          // 触发父级的数据更新
          this.$emit('update:user')
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    handleAvatarSuccess(response, file, fileList) {
      // 把user的头像属性换成上传的图片的链接
      this.$set(this.user, 'avatar', response.data)
    },
    // 修改密码
    updatePassword() {
      this.dialogVisible = true
    },
    save() {
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          this.$request.put('/updatePassword', this.user).then(res => {
            if (res.code === '200') {
              // 成功更新
              this.$message.success('修改密码成功')
              this.$router.push('/login')
            } else {
              this.$message.error(res.msg)
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>
/deep/ .el-form-item__label {
  font-weight: bold;
}

/deep/ .el-upload {
  border-radius: 50%;
}

/deep/ .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  border-radius: 50%;
}

/deep/ .avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 120px;
  height: 120px;
  line-height: 120px;
  text-align: center;
  border-radius: 50%;
}

.avatar {
  width: 120px;
  height: 120px;
  display: block;
  border-radius: 50%;
}
</style>