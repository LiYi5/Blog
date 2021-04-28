<template>
  <div class="main_c">
    <!-- 导航 -->
    <Header :cur=3></Header>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
      <table class="ui celled center table">
        <thead>
          <tr>
            <th></th>
            <th>分类名称</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item) in tagList" :key="item.name">
            <td>{{item.id}}</td>
            <td>{{item.name}}</td>
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
                <a class="item" v-show="this.page > 1" @click="getPreTagslist">上一页
                </a>
                <div class="item">第 {{page}} 页
                </div>
                <a class="item" v-show="(this.alltagnumber-this.page*7)>0" @click="getNextTagslist">下一页
                </a>
              </div>
              <div class="ui right floated teal basic button" @click="goAddTags">新增</div>
            </th>
          </tr>
        </tfoot>
      </table>
      </div>
    </div>
    <el-dialog
  :visible.sync="centerDialogVisible"
  width="30%"
  center>
  <span>确认删除吗？</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="deleteTag">确 定</el-button>
  </span>
</el-dialog>
    <!-- 底部 -->
    <div>
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import $ from 'jquery'
import Footer from '../components/footer.vue'
import Header from '../components/header.vue'
import {getTags, deleteTags} from '../mock/index'
export default {
  components: {
    Footer,
    Header
  },
  inject: ['reload'],
  data () {
    return {
      tagList: [],
      page: 1,
      centerDialogVisible: false,
      deleteTagId: null,
      alltagnumber: Number
    }
  },
  mounted () {
    this.getTagslist()
    this.dropdown()
    this.showMsg('addTag', '添加标签名称成功')
    this.showMsg('editTag', '修改标签名称成功')
  },
  methods: {
    dropdown () {
      $('.ui.dropdown').dropdown()
    },
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
      this.$router.push({path: '/addTags', query: {btnTagname: '修改', tagname: item.name, tagid: item.id}})
    },
    deletebtn (item) {
      this.centerDialogVisible = true
      this.deleteTagId = item.id
    },
    deleteTag () {
      deleteTags({id: this.deleteTagId}).then((res) => {
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
    goAddTags () {
      this.$router.push({path: '/addTags', query: {btnTagname: '增加'}})
    },
    getTagslist () {
      getTags({page: this.page}).then(res => {
        this.tagList = res.data.content
        this.alltagnumber = res.data.totalElements
      })
    },
    getPreTagslist () {
      getTags({page: --this.page}).then(res => {
        this.tagList = res.data.content
      })
    },
    getNextTagslist () {
      getTags({page: ++this.page}).then(res => {
        this.tagList = res.data.content
      })
    }
  }
}
</script>

<style lang="less" scoped>
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
.foot_b{
  width: 100%;
  position: absolute;
  bottom: 0;
}
</style>
