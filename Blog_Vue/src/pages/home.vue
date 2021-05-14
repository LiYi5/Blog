<template>
  <div>
    <!-- 导航 -->
    <Header :cur=1></Header>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
        <div class="ui stackable grid">
          <!-- 右边内容 -->
          <div class="eleven wide column">
            <div class="ui top attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column left aligned">
                  <h3 class="ui teal header">博客</h3>
                </div>
                <div class="column right aligned">
                  共
                  <h2 class="ui orange header m-inline-block">{{this.allblognumber}}</h2>
                  篇
                </div>
              </div>
            </div>
            <!-- 中间内容 -->
            <div class="ui attached segment">
                <div class="ui padding-con-lr vertical segment con-po" v-for="item in blogList" :key="item.id">
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
            <!-- 底部-->
            <div class="ui left aligned bottom attached segment">
                  <div class="ui pagination menu">
                <a class="item" v-show="this.page > 1" @click="getPreBlogslist">上一页
                </a>
                <div class="item">第 {{page}} 页
                </div>
                <a class="item" v-show="(this.allblognumber-this.page*4)>0" @click="getNextBlogslist">下一页
                </a>
              </div>
            </div>

          </div>
          <!-- 左边分类 -->
          <div class="five wide column">
            <div class="ui segments">
                <div class="ui secondary segment">
                  <div class="ui two column grid">
                    <div class="left aligned column"><i class="idea icon"></i>分类</div>
                    <div class="right aligned column">
                      <a target="_blank">more </a><i class="angle double right icon"></i>
                    </div>
                  </div>
                </div>
                <div class="ui left aligned teal segment">
                  <div class="ui fluid vertical menu" v-for="item in typeList" :key="item.name">
                    <a class=" item">{{item.name}}
                      <div class="ui label teal left pointing basic">{{item.count}}</div>
                    </a>
                  </div>
                </div>
            </div>
            <!-- 最新推荐 -->
            <div class="ui segments">
                 <div class="ui secondary segment">
                  <div class="ui two column grid">
                    <div class="left aligned column"><i class="bookmark icon"></i>最新推荐</div>
                    <div class="right aligned column">
                    </div>
                  </div>
                 </div>
                  <div class="ui segment left aligned">
                    <a target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
                  <div class="ui segment left aligned">
                    <a target="_blank" class="black-text">用户故事（USer Story）</a>
                  </div>
            </div>
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
import {getBlogs, getTotalBlogs, getTypes} from '../mock/index'
export default {
  components: {
    Footer,
    Header
  },
  data () {
    return {
      blogList: {},
      page: 1,
      allblognumber: Number,
      typeList: {}
    }
  },
  mounted () {
    this.getBloglist()
    this.getTypelist()
  },
  methods: {
    rTime (date) {
      var d = new Date(date).toJSON()
      return new Date(new Date(d) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
    },
    getSumBlog () {
      getTotalBlogs().then(res => {
        this.allblognumber = res.data
      })
    },
    getBloglist () {
      getBlogs({page: this.page}).then(res => {
        this.blogList = res.data
      })
      this.getSumBlog()
    },
    getTypelist () {
      getTypes().then(res => {
        this.typeList = res.data.slice(0, 4)
      })
    },
    getPreBlogslist () {
      getBlogs({page: --this.page}).then(res => {
        this.blogList = res.data
      })
    },
    getNextBlogslist () {
      getBlogs({page: ++this.page}).then(res => {
        this.blogList = res.data
      })
    }
  }
}
</script>

<style lang="less" scoped>
.foot_b{
  width: 100%;
  position: absolute;
  bottom: 0;
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
  padding: 3em 0 !important;
}
.m-padded-tb-mini {
  padding: 0 0.2em;
}
.m-inline-block {
  display: inline-block;
}
@media screen and (max-width:768px){
.foot_b{
  width: 100%;
  position: relative;
  bottom: 0;
}
}
</style>
