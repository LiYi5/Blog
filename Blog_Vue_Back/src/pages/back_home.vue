<template>
  <div class="main_c">
    <!-- 导航 -->
    <Header :cur=1></Header>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
      <form class="ui left aligned segment secondary form">
        <div class="inline fields">
          <div class="field">
            <input  type="text" v-model="title" placeholder="标题">
          </div>
          <div class="field">
            <div class="ui selection dropdown">
              <i class="dropdown icon"></i>
              <div class="default text" ref="curType">分类</div>
              <div class="menu">
                <div class="item" v-for="item in allTypeList" :key="item.id">
                  <div >{{item.name}}</div>
                </div>
              </div>
            </div>
          </div>
          <div class="field">
            <button @click="searchBlog()" class="ui mini teal basic button"><i class="search icon"></i>搜索</button>
          </div>
        </div>
      </form>
      <table class="ui compact teal center table">
        <thead>
          <tr>
            <th></th>
            <th>标题</th>
            <th>类型</th>
            <th>推荐</th>
            <th>更新时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in blogList" :key="item.id">
            <td>{{item.id}}</td>
            <td>{{item.title}}</td>
            <td>{{item.name}}</td>
            <td>{{item.recommend === true?"是":"否"}}</td>
            <td>{{rTime(item.update_time)}}</td>
            <td>
              <a class="ui mini teal basic button" @click="editbtn(item)">编辑</a>
              <a class="ui mini red bsic button" @click="deletebtn(item)">删除</a>
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <th colspan="6">
               <div class="ui pagination menu">
                <a class="item" v-show="this.page > 1" @click="getPreBlogslist">上一页
                </a>
                <div class="item">第 {{page}} 页
                </div>
                <a class="item" v-show="(this.allblognumber-this.page*7)>0" @click="getNextBlogslist">下一页
                </a>
              </div>
              <a class="ui right floated teal basic button" @click="goAddBlog">新增</a>
            </th>
          </tr>
        </tfoot>
      </table>
      </div>
    </div>
    <!-- 底部 -->
    <div>
      <Footer></Footer>
    </div>
        <el-dialog
  :visible.sync="centerDialogVisible"
  width="30%"
  center>
  <span>确认删除吗？</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="deleteBlog">确 定</el-button>
  </span>
</el-dialog>
  </div>
</template>

<script>
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
import $ from 'jquery'
import {getBlogs, getAllTypes, getTotalBlogs, deleteBlogs} from '../mock/index'
export default {
  components: {
    Footer,
    Header
  },
  inject: ['reload'],
  data () {
    return {
      blogList: {},
      page: 1,
      title: '',
      centerDialogVisible: false,
      curType: null,
      allTypeList: {},
      allblognumber: Number,
      deleteBlogId: null
    }
  },
  mounted () {
    this.getBlogList()
    this.getAllTypeList()
    this.showMsg('addBlog', '添加Blog成功')
    this.showMsg('updateBlog', '更新Blog成功')
    this.dropdown()
  },
  methods: {
    showMsg (info, msg) {
      if (localStorage.getItem(info)) {
        this.$message({
          message: msg,
          type: 'success',
          duration: 1000,
          offset: 100,
          center: true
        })
        localStorage.removeItem(info)
      }
    },
    editbtn (item) {
      this.$router.push({path: '/edit', query: {btnTagname: '修改', blogInfo: JSON.stringify(item)}})
    },
    deletebtn (item) {
      this.centerDialogVisible = true
      this.deleteBlogId = item.id
    },
    deleteBlog () {
      deleteBlogs({id: this.deleteBlogId}).then((res) => {
        this.centerDialogVisible = false
        this.reload()
        if (res.code === '1') {
          this.$message({
            message: res.msg,
            type: 'success',
            duration: 1000,
            offset: 100,
            center: true
          })
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
    },
    getSumBlog () {
      getTotalBlogs().then(res => {
        this.allblognumber = res.data
      })
    },
    rTime (date) {
      var d = new Date(date).toJSON()
      return new Date(new Date(d) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
    },
    searchBlog (newpage = this.page) {
      const Type = this.$refs.curType.innerText
      if (this.title === '' && Type === '分类') {
        getBlogs({page: newpage}).then(res => {
          this.blogList = res.data
        })
      }

      if (this.title !== '' && Type === '分类') {
        getBlogs({page: newpage, title: this.title}).then(res => {
          this.blogList = res.data
        })
      }
      if (this.title === '' && Type !== '分类') {
        getBlogs({page: newpage, type: Type}).then(res => {
          this.blogList = res.data
        })
        this.$refs.curType.innerText = null
      }
      if (this.title !== '' && Type !== '分类') {
        getBlogs({page: newpage, title: this.title, type: Type}).then(res => {
          this.blogList = res.data
        })
        this.$refs.curType.innerText = null
      }
    },
    dropdown () {
      $('.ui.dropdown').dropdown()
    },
    getAllTypeList () {
      getAllTypes().then(res => {
        this.allTypeList = res.data
      })
    },
    getBlogList () {
      getBlogs({page: this.page}).then(res => {
        this.blogList = res.data
      })
      this.getSumBlog()
    },
    goAddBlog () {
      this.$router.push({path: '/edit', query: {btnTagname: '新增'}})
    },
    getPreBlogslist () {
      this.searchBlog(--this.page)
    },
    getNextBlogslist () {
      this.searchBlog(++this.page)
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
  padding: 2em 0 !important;
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
