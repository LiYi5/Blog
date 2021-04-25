<template>
  <div>
    <!-- 导航 -->
    <Header :cur=2></Header>
    <div class="ui attached menu">
     <div class="ui container">
       <div class="right menu">
        <a href="" class="item active teal">发布</a>
         <a href="" class="item">列表</a>
       </div>
     </div>
    </div>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
      <form class="ui left aligned segment form">
        <div class="field">
        <div class="ui left  labeled input">
          <div class="ui selection compact teal basic dropdown label">
            <input type="hidden" value="原创">
            <i class="dropdown icon"></i>
            <div class="text">原创</div>
            <div class="menu">
              <div class="item" data-value="原创">原创</div>
              <div class="item" data-value="转载">转载</div>
              <div class="item" data-value="翻译">翻译</div>
            </div>
          </div>
              <input type="text" name="title" placeholder="标题">
        </div>
      </div>
         <div class="field">
           <!-- <textarea placeholder="博客内容" name="content"></textarea> -->
           <mavon-editor style="height:400px;z-index:1" v-model="content" placeholder="博客内容" />
         </div>
         <div class="two fields">
           <div class="field">
             <div class="ui left labeled input">
               <label class="ui teal basic label compact">分类</label>
                  <div class="ui fluid selection dropdown">
                    <input type="hidden" name="type">
                    <i class="dropdown icon"></i>
                    <div class="default text">分类</div>
                    <div class="menu">
                      <div class="item" data-value="1">错误日志</div>
                      <div class="item" data-value="2">开发手册</div>
                    </div>
                  </div>
             </div>
           </div>
           <div class="field">
             <div class="ui left labeled input">
               <label class="ui teal basic label action">标签</label>
                  <div class="ui selection dropdown fluid search multiple ">
                    <input type="hidden" name="tag">
                    <i class="dropdown icon"></i>
                    <div class="default text">标签</div>
                    <div class="menu">
                      <div class="item" data-value="1">java</div>
                      <div class="item" data-value="2">python</div>
                    </div>
                  </div>
             </div>
           </div>
           <div class="field"></div>
         </div>
         <div class="field">
           <div class="ui left labeled input">
             <label class="ui teal basic label">首图</label>
              <input type="text" name="indexPicture" placeholder="首图引用地址">
           </div>
         </div>
         <div class="inline fields">
           <div class="field">
             <div class="ui checkbox">
               <input type="checkbox" id="recommend" name="recommend" checked class="hidden">
               <label for="recommend">推荐</label>
             </div>
           </div>
           <div class="field">
             <div class="ui checkbox">
               <input type="checkbox" id="shareInfo" name="shareInfo" class="hidden">
               <label for="shareInfo">转载</label>
             </div>
           </div>
         </div>
         <div class="ui right aligned container">
           <button class="ui button" type="button" @click="widow.history.go(-1)">返回</button>
           <button class="ui secondary button">保持</button>
           <button class="ui teal button">发布</button>
         </div>
      </form>
      </div>
    </div>
    <!-- 底部 -->
    <div>
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
import $ from 'jquery'
export default {
  components: {
    Footer,
    Header
  },
  mounted () {
    this.dropdown()
  },
  data () {
    return {
      content: ''
    }
  },
  methods: {
    dropdown () {
      $('.ui.dropdown').dropdown()
    }
  }
}
</script>

<style lang="less">
.baw{
  background-color: white!important;
}
.black-text{
  color: #333!important;
}
.margin-con-tp{
  margin: 0.3em 0 !important;
  margin-left: 0.6em!important;
}
.padding-con-lr{
    padding: 1em 1em !important;
}
.m-main-padded-tb {
  padding: 2em 0 !important;
}
.m-padded-tb-mini {
  padding: 0 0.2em;
}
.m-inline-block {
  display: inline-block;
}
</style>
