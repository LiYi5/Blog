<template>
    <div class="ui inverted attached segment m-padded-tb-mini">
      <div class="ui container">
        <div class="ui inverted secondary menu stackable">
          <h2 class="ui teal header item">Blog</h2>
          <a href="#" class="item" :class="menuClick?'mobile-hid':''"><i class="home icon"></i> 首页</a>
          <a href="#" class="item" :class="menuClick?'mobile-hid':''"> <i class="idea icon"></i>分类</a>
          <a href="#" class="item" :class="menuClick?'mobile-hid':''"><i class="tags icon"></i>标签</a>
          <div class="middle item right input" :class="menuClick?'mobile-hid':''">
            <div class="ui icon inverted input">
              <input type="text" placeholder="Search...." />
              <i class="search icon link"></i>
            </div>
          </div>
        </div>
      </div>
      <a href="#" class="ui black button m-right-top mobile-show" @click="showlist()"><i class="sidebar icon"></i></a>
    </div>
</template>

<script>
export default {
  data () {
    return {
      menuClick: true
    }
  },
  methods: {
    showlist () {
      console.log(1)
      this.menuClick = !this.menuClick
    }
  }
}
</script>

<style lang="less">
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
