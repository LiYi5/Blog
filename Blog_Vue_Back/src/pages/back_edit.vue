<template>
  <div>
    <!-- 导航 -->
    <Header :cur=1></Header>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
      <form class="ui left aligned segment form">
        <div class="field">
        <div class="ui left labeled input center" style="width:300px;">
              <input type="text" v-model="curBlog.title" placeholder="标题">
        </div>
      </div>
         <div class="field">
           <!-- <textarea placeholder="博客内容" name="content"></textarea> -->
           <mavon-editor style="height:400px;z-index:1" v-model="curBlog.content" placeholder="博客内容" />
         </div>
         <div class="two fields">
           <div class="field">
             <div class="ui left labeled input">
               <label class="ui teal basic label compact">分类</label>
                  <div class="ui fluid selection dropdown">
                    <input type="hidden" name="type">
                    <i class="dropdown icon"></i>
                    <div class="default text" ref="type">分类</div>
                    <div class="menu">
                    <div class="item" v-for="item in allTypeList" :key="item.id">
                        <div>{{item.name}}</div>
                      </div>
                    </div>
                  </div>
             </div>
           </div>
           <!-- <div class="field">
             <div class="ui left labeled input">
               <label class="ui teal basic label action">标签</label>
                  <div class="ui selection dropdown fluid search">
                    <input type="hidden" name="tag">
                    <i class="dropdown icon"></i>
                    <div class="default text" ref="type">标签</div>
                    <div class="menu">
                      <div class="item" v-for="item in allTagList" :key="item.id">
                        <div>{{item.name}}</div>
                      </div>
                    </div>
                  </div>
             </div>
           </div> -->
           <div class="field"></div>
         </div>
         <div class="field">
           <div class="ui left labeled input">
             <label class="ui teal basic label">首图</label>
              <input type="text" v-model="curBlog.first_picture" placeholder="首图引用地址">
           </div>
         </div>
         <div>
           <div class="field">
             <div class="ui left labeled input">
               <textarea v-model="curBlog.flag" class="ui input mab"></textarea>
             </div>
           </div>
         </div>
         <div class="ui right aligned container">
           <button class="ui button" type="button" @click="back">返回</button>
           <button class="ui teal button" @click="submitBlog">{{this.$route.query.btnTagname}}</button>
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
import {getAllTypes, postNewBlogs, updateBlogs} from '../mock/index'
import $ from 'jquery'
export default {
  components: {
    Footer,
    Header
  },
  data () {
    return {
      allTypeList: {},
      // allTagList: {},
      curBlog: {}
    }
  },
  mounted () {
    this.dropdown()
    this.getAllTypeList()
    // this.getAllTagList()
    this.moutBlog()
  },
  methods: {
    submitBlog () {
      if (this.curBlog.title === '' || this.curBlog.title === undefined) {
        this.$message({
          message: '标题不能为空',
          type: 'error',
          duration: 1000,
          offset: 100,
          center: true
        })
      } else {
        this.curBlog.userId = localStorage.getItem('userid')
        if (this.$refs.type.innerText !== '分类') {
          this.curBlog.typeId = this.finTypeidByname(this.$refs.type.innerText)
        }
        if (this.$route.query.btnTagname === '修改') {
          updateBlogs(this.curBlog).then(res => {
            if (res.code === '1') {
              this.$router.go(-1)
              localStorage.setItem('updateBlog', true)
            } else {
              this.$message({
                message: res.msg,
                type: 'error',
                duration: 1000,
                offset: 100,
                center: true
              })
            }
          })
        } else if (this.$route.query.btnTagname === '新增') {
          postNewBlogs(this.curBlog).then(res => {
            if (res.code === '1') {
              this.$router.go(-1)
              localStorage.setItem('addBlog', true)
            } else {
              this.$message({
                message: res.msg,
                type: 'error',
                duration: 1000,
                offset: 100,
                center: true
              })
            }
          })
        }
      }
    },
    finTypeidByname (name) {
      for (let i = 0; i < this.allTypeList.length; i++) {
        if (this.allTypeList[i].name === name) {
          return this.allTypeList[i].id
        }
      }
    },
    moutBlog () {
      if (this.$route.query.btnTagname === '修改') {
        this.curBlog = JSON.parse(this.$route.query.blogInfo)
      } else if (this.$route.query.btnTagname === '新增') {
        this.curBlog = {}
      }
    },
    getAllTypeList () {
      getAllTypes().then(res => {
        this.allTypeList = res.data
      })
    },
    // getAllTagList () {
    //   getAllTags().then(res => {
    //     this.allTagList = res.data
    //   })
    // },
    back () {
      window.history.go(-1)
    },
    dropdown () {
      $('.ui.dropdown').dropdown()
    }
  }
}
</script>

<style lang="less" scoped>
.mab{
  margin-bottom: 2em!important;
}
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
