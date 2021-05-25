<template>
  <div>
    <Header :cur=2></Header>
   <div class="m-main-padded-tb">
      <div class="ui container">
           <div class="ui top attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column left aligned">
                  <h3 class="ui teal header">分类</h3>
                </div>
                <div class="column right aligned">
                  共
                  <h2 class="ui orange header m-inline-block">{{typeList.length}}</h2>
                  个
                </div>
              </div>
            </div>
            <div class="ui attached segment left aligned">
                <div class="ui labeled button con-m-label" v-for="item in typeList" :key="item.name" @click="toggleType(item)">
                  <a  class="ui basic button" :class="item.name === activeName?'teal':''">{{item.name}}</a>
                  <div class="ui basic label" :class="item.name === activeName?'teal':''">{{item.count}}</div>
                </div>
            </div>
                <div class="ui attached segment">
                <div class="ui padding-con-lr vertical segment showhand" v-for="item in blogList" :key="item.id" @click="goDetail(item)">
                    <div class="ui mobile reversed stackable grid">
                        <div class="eleven wide column">
                            <h3 class="ui header">
                                {{item.title}}
                            </h3>
                            <p>{{item.content}}</p>
                            <div class="ui grid  stackable">
                                <div class="left aligned eleven wide column">
                                    <div class="ui mini horizontal link list">
                                        <div class="item">
                                            <img :src="item.avatar" alt="" class="ui avatar image">
                                            <div class="content"><a class="header">{{item.username}}</a></div>
                                        </div>
                                        <div class="item">
                                            <i class="calendar icon"></i>{{rTime(item.update_time)}}
                                        </div>
                                        <div class="item">
                                            <i class="eye icon"></i>{{item.views}}
                                        </div>
                                    </div>
                                </div>
                                <div class="right aligned five wide column">
                                    <a target="_blank" class="ui teal basic mini label">{{item.name}}</a>
                                </div>
                            </div>
                        </div>
                        <div class="five wide column">
                            <a target="_blank">
                                <img :src=item.first_picture alt="" class="ui rounded image">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
             <div class="ui left aligned bottom attached segment">
               <div class="ui pagination menu">
                <a class="item" v-show="this.page > 1" @click="getPreBlogslist">上一页
                </a>
                <div class="item">第 {{page}} 页
                </div>
                <a class="item" v-show="(this.blogList.length-this.page*3)>0" @click="getNextBlogslist">下一页
                </a>
              </div>
            </div>
    </div>
   </div>
   <!-- 底部 -->
    <div class="foot_b">
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
import {getTypes, postBlogforType} from '../mock/index'
export default {
  components: {
    Footer,
    Header
  },
  data () {
    return {
      blogList: {},
      typeList: {},
      page: 1,
      activeName: String
    }
  },
  mounted () {
    this.getTypelist()
  },
  methods: {
    goDetail (item) {
      this.$router.push({path: '/Detail', query: {blogInfo: JSON.stringify(item), curindex: 2}})
    },
    rTime (date) {
      var d = new Date(date).toJSON()
      return new Date(new Date(d) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
    },
    postBlogs (curname) {
      postBlogforType({name: curname}).then(res => {
        this.blogList = res.data.slice((this.page - 1) * 3, this.page * 3)
      })
    },
    getTypelist () {
      getTypes().then(res => {
        this.typeList = res.data.slice(0)
        this.activeName = this.typeList[0].name
        this.postBlogs(this.activeName)
      })
    },
    toggleType (item) {
      this.activeName = item.name
      this.postBlogs(this.activeName)
    },
    getPreBlogslist () {
      this.page--
    },
    getNextBlogslist () {
      this.page++
    }
  }
}
</script>

<style lang="less" scoped>
.showhand{
  cursor: pointer;
}
.foot_b{
  width: 100%;
  position: absolute;
  bottom: 0;
}
.m-main-padded-tb {
  padding: 3em 0 !important;
}
.padding-con-lr{
    padding: 1em 1em !important;
}
.con-m-label{
  margin: 0 0.5em 1em 0.5em!important;
}
.m-inline-block {
  display: inline-block;
}
.m-padded-tb-mini {
  padding: 0 0.2em;
}
.blank-top {
  margin: 3em auto;
  max-width: 60em !important;
}
@media screen and (max-width:768px){
.foot_b{
  width: 100%;
  position: relative;
  bottom: 0;
}
}
</style>
