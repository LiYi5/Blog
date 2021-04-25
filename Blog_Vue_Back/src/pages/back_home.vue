<template>
  <div class="main_c">
    <!-- 导航 -->
    <Header :cur=1></Header>
    <!-- 中间内容 -->
    <div class="m-main-padded-tb">
      <div class="ui container">
      <form class="ui left aligned segment form">
        <div class="inline fields">
          <div class="field">
            <input  type="text" name="title" placeholder="标题">
          </div>
          <div class="field">
            <div class="ui selection dropdown">
              <input type="hidden" name="type">
              <i class="dropdown icon"></i>
              <div class="default text">分类</div>
              <div class="menu">
                <div class="item" data-velue="1">错误日志</div>
                <div class="item" data-velue="2">开发者手册</div>
              </div>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <input type="checkbox" id="recommend" name="recommend">
              <label for="recommend">推荐</label>
            </div>
          </div>
          <div class="field">
            <button class="ui mini teal basic button"><i class="search icon"></i>搜索</button>
          </div>
        </div>
      </form>
      <table class="ui celled center table">
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
          <tr>
            <td>1</td>
            <td>练习</td>
            <td>认值</td>
            <td>是</td>
            <td>2021-04-06 09：45</td>
            <td>
              <a class="ui mini teal basic button">编辑</a>
              <a class="ui mini red bsic button">删除</a>
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <th colspan="6">
              <div class="ui pagination menu">
                <a class="item">上一页
                </a>
                <a class="item">下一页
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
  data () {
    return {
    }
  },
  mounted () {
    this.dropdown()
  },
  methods: {
    dropdown () {
      $('.ui.dropdown').dropdown()
    },
    goAddBlog () {
      this.$router.push({path: '/edit'})
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
</style>
