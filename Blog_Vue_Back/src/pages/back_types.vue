<template>
  <div class="main_c">
    <!-- 导航 -->
    <Header :cur=2></Header>
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
          <tr v-for="(item) in typeList" :key="item.name">
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
                <a class="item" v-show="this.page > 1" @click="getPreTypeslist">上一页
                </a>
                <div class="item">第 {{page}} 页
                </div>
                <a class="item" v-show="(this.alltypenumber-this.page*7)>0" @click="getNextTypeslist">下一页
                </a>
              </div>
              <div class="ui right floated teal basic button" @click="goAddTypes">新增</div>
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
    <el-button type="primary" @click="deleteType">确 定</el-button>
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
import {getTypes, deleteTypes, getTotalTypes} from '../mock/index'
export default {
  components: {
    Footer,
    Header
  },
  inject: ['reload'],
  data () {
    return {
      typeList: {},
      page: 1,
      centerDialogVisible: false,
      deleteTypeId: null,
      alltypenumber: Number
    }
  },
  mounted () {
    this.dropdown()
    this.getTypeslist()
    this.showMsg('addType', '添加分类类型成功')
    this.showMsg('editType', '修改分类类型成功')
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
      this.$router.push({path: '/addTypes', query: {btnTypename: '修改', typename: item.name, typeid: item.id}})
    },
    deletebtn (item) {
      this.centerDialogVisible = true
      this.deleteTypeId = item.id
    },
    deleteType () {
      deleteTypes({id: this.deleteTypeId}).then((res) => {
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
    goAddTypes () {
      this.$router.push({path: '/addTypes', query: {btnTypename: '增加'}})
    },
    getTypeslist () {
      getTypes({page: this.page}).then(res => {
        this.typeList = res.data
      })
      this.getSumTypes()
    },
    getSumTypes () {
      getTotalTypes().then(res => {
        this.alltypenumber = res.data
      })
    },
    getPreTypeslist () {
      getTypes({page: --this.page}).then(res => {
        this.typeList = res.data
      })
    },
    getNextTypeslist () {
      getTypes({page: ++this.page}).then(res => {
        this.typeList = res.data
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
@media screen and (max-width:768px){
 .foot_b{
  width: 100%;
  position: relative;
  bottom: 0;
}
}
</style>
