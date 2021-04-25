<template>
    <div class="ui inverted attached segment m-padded-tb-mini m-shadow-s">
      <div class="ui container">
        <div class="ui inverted secondary menu stackable">
          <h2 class="ui teal header item">管理后台</h2>
          <a class="item" :class="{'active':+this.$props.cur == 1, 'mobile-hid': menuClick === true}" @click="goHome"><i class="home icon" ></i>博客</a>
          <a class="item" :class="{'active':+this.$props.cur == 2, 'mobile-hid': menuClick === true}" @click="goTypes"><i class="idea icon" ></i>分类</a>
          <a class="item" :class="{'active':+this.$props.cur == 3, 'mobile-hid': menuClick === true}" @click="goTags"><i class="tags icon"></i>标签</a>
          <div class="right menu" :class="menuClick?'mobile-hid':''">
           <div class="ui labeled dropdown item">
             <img class="ui avatar image" src="../assets/logo.png"  alt="">
                 课程
              <i class="dropdown icon"></i>
              <div class="menu">
                  <div class="item" id="logout" @click="logout">注销</div>
              </div>
          </div>
          </div>
        </div>
      </div>
      <a href="#" class="ui black button m-right-top mobile-show" @click="showlist()"><i class="sidebar icon"></i></a>
    </div>
</template>

<script>
import {getLogout} from '../mock/index'
export default {
  props: {
    cur: Number
  },
  data () {
    return {
      menuClick: true
    }
  },
  methods: {
    showlist () {
      this.menuClick = !this.menuClick
    },
    logout () {
      getLogout().then(res => {
        console.log(res)
        if (res.code === '1') {
          this.$router.replace({path: '/'})
          history.pushState(null, null, document.URL)
          window.addEventListener('popstate', function (e) {
            history.pushState(null, null, document.URL)
          }, false)
        }
      })
    },
    goHome () {
      this.$router.push({path: '/home'})
    },
    goTypes () {
      this.$router.push({path: '/types'})
    },
    goTags () {
      this.$router.push({path: '/tags'})
    }
  }
}
</script>

<style lang="less">
.m-shadow-s{
  -webkit-box-shadow:0 4px 8px rgba(0,0, 0, 0.2)!important;
  box-shadow: 0 4px 8px rgba(0,0, 0, 0.2)!important;
}
.m-right-top{
  position: absolute;
  top: 0;
  right: 0;
}
.mobile-show{
  display: none!important;
}
@media screen and (max-width:768px){
  .mobile-hid{
    display: none!important;
  }
  .mobile-show{
    display: block!important;
  }
}
</style>
