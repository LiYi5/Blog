<template>
  <div class="m-container-small">
    <div class="ui container maxw">
      <div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <div class="content">
        管理后台登陆
      </div>
    </h2>
    <form class="ui large form">
      <div class="ui segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="username" v-model="username" placeholder="用户名">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" v-model="password" placeholder="密码">
          </div>
        </div>
        <div class="ui fluid large teal submit button" @click="login">Login</div>
      </div>
      <div class="ui error message"></div>
    </form>
  </div>
</div>
    </div>
  </div>
</template>

<script>
import {postLogin} from '../mock/index'
import $ from 'jquery'

export default {
  data () {
    return {
      // username: null,
      // password: null
      username: 'lire',
      password: 123456
    }
  },
  mounted () {
    this.dropdown()
  },
  methods: {
    dropdown () {
      $('.ui.dropdown').dropdown()
    },
    login () {
      if (this.username === null || this.password === null) {
        this.$message({
          message: '请输入用户名和密码',
          type: 'warning',
          duration: 1000,
          offset: 50
        })
      } else {
        let obj = {}
        obj.username = this.username
        obj.password = this.password
        postLogin(obj).then(res => {
          if (res.code === '1') {
            localStorage.setItem('user', res.data)
            this.$router.push({path: '/home'})
          } else {
            this.$message({
              message: res.msg,
              type: 'error',
              duration: 1000,
              offset: 50
            })
          }
        })
      }
    }
  }
}
</script>

<style lang="less" scoped>
.m-container-small{
  width: 100%;
  height: 100%;
  display: flex;
  // align-items: center;
  justify-content: center;
}
.maxw{
  margin-top: 12%;
  max-width: 30em !important;
}
</style>>
